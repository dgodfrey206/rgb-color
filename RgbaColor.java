public class RgbaColor extends RgbColor {
    private final int alpha;
    private final int bitDepth;

    public RgbaColor(int bitDepth, int red, int green, int blue, int alpha) {
        super(bitDepth, red, green, blue);
        this.alpha = alpha;
        this.bitDepth = bitDepth;

        // valid range [0, 2^bitDepth - 1]
        if (!(alpha >= 0 && alpha <= IntMath.powerOfTwo(bitDepth) - 1)) {
            // alpha out of range
            ExceptionUtil.unsupportedOperation("Alpha out of bounds!");
        }
    }

    public int getAlpha() {
        return alpha;
    }

    public RgbColor8Bit toRgbColor8Bit() {
        // alpha must equal max
        if (alpha != IntMath.powerOfTwo(bitDepth) - 1) {
            ExceptionUtil.unsupportedOperation("alpha must equal INT-MAX");
        }
        // call base class overload to do conversion
        return super.toRgbColor8Bit();
    }
}