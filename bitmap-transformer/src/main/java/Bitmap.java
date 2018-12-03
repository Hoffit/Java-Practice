import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

class Bitmap {

    private BufferedImage bitmap;

    public enum Transform {
        RANDOMIZE, BLACK_AND_WHITE,
        FLIP_VERTICAL, FLIP_HORIZONTAL
    }

    /**
     * Constructor
     * @param bitmapPath The image file.
     */
    Bitmap(Path bitmapPath) throws IOException {
        this.bitmap = ImageIO.read(bitmapPath.toFile());
    }

    /**
     *
     * @param transform The type of transform to perform.
     */
    void transform(Transform transform) {
        switch (transform) {
            case RANDOMIZE:
                performRandomizeTransform();
                break;
            case BLACK_AND_WHITE:
                performBlackAndWhiteTransform();
                break;
            case FLIP_VERTICAL:
                performFlipVerticalTransform();
                break;
            case FLIP_HORIZONTAL:
                performFlipHorizontalTransform();
                break;
        }
    }

    /**
     *
     * @param targetPath The Path object to which to write this bitmap object.
     */
    void saveToFile(Path targetPath) throws IOException {
        ImageIO.write(bitmap, "bmp", targetPath.toFile()); //TODO Why is this printing to console?
    }

    /**
     *
     */
    private void performRandomizeTransform() {
        Random r = new Random();
        Color newColor;
        int newRed;
        int newGreen;
        int newBlue;
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                newRed = r.nextInt(256);
                newGreen = r.nextInt(256);
                newBlue = r.nextInt(256);
                newColor = new Color(newRed, newGreen, newBlue);
                bitmap.setRGB(x, y, newColor.getRGB());
            }
        }
    }

    /**
     *
     */
    private void performBlackAndWhiteTransform() {
        int rgbSum;
        Color color;
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                color = new Color(bitmap.getRGB(x,y));
                rgbSum = color.getBlue() + color.getGreen() + color.getRed();
                if (rgbSum < 382) {
                    bitmap.setRGB(x, y, Color.white.getRGB());
                }
                else {
                    bitmap.setRGB(x, y, Color.black.getRGB());
                }
            }
        }
    }

    /**
     *
     */
    private void performFlipVerticalTransform() {
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight() / 2; y++) {
                int swap = bitmap.getRGB(x, y);
                bitmap.setRGB(x, y, bitmap.getRGB(x, bitmap.getHeight() - y - 1));
                bitmap.setRGB(x, bitmap.getHeight() - y - 1, swap);
            }
        }
    }

    /**
     *
     */
    private void performFlipHorizontalTransform() {
        for (int y = 0; y < bitmap.getHeight(); y++) {
            for (int x = 0; x < bitmap.getWidth() / 2; x++) {
                int swap = bitmap.getRGB(x, y);
                bitmap.setRGB(x, y, bitmap.getRGB(bitmap.getWidth() - x - 1, y));
                bitmap.setRGB(bitmap.getWidth() - x - 1, y, swap);
            }
        }
    }
}
