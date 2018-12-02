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

    Bitmap(Path bitmapPath) {
        try {
            this.bitmap = ImageIO.read(bitmapPath.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void transform(Transform transform) {
        switch (transform) {
            case RANDOMIZE:
                performRandomizeTransform();
            case BLACK_AND_WHITE:
                performBlackAndWhiteTransform();
            case FLIP_VERTICAL:
                performFlipVerticalTransform();
            case FLIP_HORIZONTAL:
                performFlipHorizontalTransform();
        }
    }

    void saveToFile(Path targetPath) {

        try {
            ImageIO.write(bitmap, "bmp", targetPath.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private void performFlipVerticalTransform() {
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight() / 2; y++) {
                int swap = bitmap.getRGB(x, y);
                bitmap.setRGB(x, y, bitmap.getRGB(x, bitmap.getHeight() - y - 1));
                bitmap.setRGB(x, bitmap.getHeight() - y - 1, swap);
            }
        }
    }

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
