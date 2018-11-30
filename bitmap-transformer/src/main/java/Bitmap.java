public class Bitmap {

    private int[][] pixels;

    public enum Transform {
        RANDOMIZE, BLACK_AND_WHITE,
        FLIP_VERTICAL, FLIP_HORIZONTAL
    }

    public Bitmap(int[][] pixels) {
        this.pixels = pixels;
    }

    public void performRandomizeTransform() {

    }

    public void performBlackAndWhiteTransform() {

    }

    public void performFlipVerticalTransform() {

    }

    public void performFlipHorizontalTransform() {

    }
}
