public class RgbColor {
    // Declaring attributes -> have to make them private & final
    private final int red;
    private final int green;
    private final int blue;
    private final int bitDepth;
    private final int MAX8Bit = IntMath.powerOfTwo(8) - 1;

    // Constructor
    public RgbColor(int bitDepth, int red, int green, int blue) {
        this.bitDepth = bitDepth;
        this.red = red;
        this.green = green;
        this.blue = blue;

        // depth follows integer bit range
        if (!(bitDepth > 0 && bitDepth <= 31)) {
            ExceptionUtil.unsupportedOperation("Bitdepth out of bounds");
        }
        // range = [0, 2^bitDepth - 1]
        if (!(red >= 0 && red <= IntMath.powerOfTwo(bitDepth) - 1)) {
            ExceptionUtil.unsupportedOperation("Red out of bounds");
        }
        // range = [0, 2^bitDepth - 1]
        if (!(green >= 0 && green <= IntMath.powerOfTwo(bitDepth) - 1)) {
            ExceptionUtil.unsupportedOperation("Green out of bounds");
        }
        // range = [0, 2^bitDepth - 1]
        if (!(blue >= 0 && blue <= IntMath.powerOfTwo(bitDepth) - 1)) {
            ExceptionUtil.unsupportedOperation("Blue out of bounds");
        }
    }

    // Getter colour red
    public int getRed() {
        return red;
    }
    // Getter colour green
    public int getGreen() {
        return green;
    }
    // Getter colour blue
    public int getBlue() {
        return blue;
    }
    // Getter BitDepth
    public int getBitDepth() {
        return bitDepth;
    }

    // reduces the color value to the 8-bit range
    private int reduce(int color, int diffPow) {
        // divide by max
        color = color / diffPow;
        // get last bit
        int letzteBit = color % 2;
        // divide again by 2 then add
        color = (color / 2) + letzteBit;
        // in case of overflow return MAX
        return Math.min(color, MAX8Bit);
    }

    public String toString() {
      return "depth = " + bitDepth + "\n" +
      "red = " + red + "\n" +
      "green = " + green + "\n" +
      "blue = " + blue + "\n";
    }

    public RgbColor8Bit toRgbColor8Bit() {
        if (bitDepth == 8) {
          return new RgbColor8Bit(red, green, blue);
        }
        // values to change
        int[] values = {
            red,
            green,
            blue
        };
        // results will be stored in this array
        int[] result = new int[3];
        int difference = Math.abs(bitDepth - 8);
        int diffPow = IntMath.powerOfTwo(difference - 1);
        
        if (bitDepth > 8) {
            result[0] = reduce(values[0], diffPow);
            result[1] = reduce(values[1], diffPow);
            result[2] = reduce(values[2], diffPow);
        }
        
        if (bitDepth < 8) {
            for (int i = 0; i < 3; i++) {
                // create an alternating pattern with the bits of values[i] using
                // "difference" bits and append them to values[i]. Store the result in result[i]
                result[i] = alternateN(values[i], bitDepth, difference);
            }
        }

        return new RgbColor8Bit(result[0], result[1], result[2]);
    }

    // converts an integer to binary and returns it as a string
    private String toBinary(int x) {
        StringBuilder bin = new StringBuilder();
        while (x != 0) {
            bin.append(x % 2);
            x /= 2;
        }
        return bin.reverse().toString();
    }

    // alternates the bits of "value" with n bits and appends them to value. Returns the result as an integer
    private int alternateN(int value, int depth, int n) {
        // binary rep
        String bin = toBinary(value);
        // leading zeros to add
        int diff = depth - bin.length();
        StringBuilder head = new StringBuilder();
        // leading zeros
        for (int i = 0; i < diff; i++) {
            head.append('0');
        }

        bin = head.append(bin.toString()).toString();
        int j = 0;
        // loop over bin n times and add values to end of value
        for (int i = 0; i < n; i++, j++) {
            value = value * 2 + (bin.charAt(j % bin.length()) - '0');
        }
        return value;
    }
}