public class RgbColor8Bit extends RgbColor {
    public RgbColor8Bit(int red, int green, int blue) {
        super(8, red, green, blue);
        // valid = [0, 2^8 - 1]
        if (!(red >= 0 && red <= IntMath.powerOfTwo(8) - 1)) {
            ExceptionUtil.unsupportedOperation("Red out of bounds!");
        }
        // valid = [0, 2^8 - 1]
        if (!(green >= 0 && green <= IntMath.powerOfTwo(8) - 1)) {
            ExceptionUtil.unsupportedOperation("Green out of bounds!");
        }
        // valid = [0, 2^8 - 1]
        if (!(blue >= 0 && blue <= IntMath.powerOfTwo(8) - 1)) {
            ExceptionUtil.unsupportedOperation("Blue out of bounds!");
        }
    }

    public String toString() {
      return super.toString();
    }

    public RgbColor8Bit toRgbColor8Bit() {
        return this;
    }
}