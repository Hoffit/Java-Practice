import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test public void testBlackAndWhiteTransform() throws IOException {
        Path blackWhiteImgSourcePath = Paths.get("resources/Black_And_White_Test.bmp");
        BufferedImage blackWhiteImgSource = ImageIO.read(blackWhiteImgSourcePath.toFile());
        Bitmap blackWhiteBitmap = new Bitmap(blackWhiteImgSourcePath);
        blackWhiteBitmap.transform(Bitmap.Transform.BLACK_AND_WHITE);
        Path blackWhiteImgOutputPath = Paths.get("resources/Black_And_White_Test_Output.bmp");
        blackWhiteBitmap.saveToFile(blackWhiteImgOutputPath);
        BufferedImage blackWhiteImgOut = ImageIO.read(blackWhiteImgOutputPath.toFile());

        // check one pixel in each quadrant

        //should flip to black
        Color c1 = new Color(blackWhiteImgOut.getRGB(5,5));
        assertTrue(c1.equals(Color.black));

        //should flip to white
        Color c2 = new Color(blackWhiteImgOut.getRGB(25,75));
        assertTrue(c2.equals(Color.white));

        //should flip to black
        Color c3 = new Color(blackWhiteImgOut.getRGB(120,120));
        assertTrue(c3.equals(Color.black));

        //should flip to black
        Color c4 = new Color(blackWhiteImgOut.getRGB(75,25));
        assertTrue(c4.equals(Color.black));
    }

    @Test public void testFlipHorizontalTransform() throws IOException {
        Path flipHorizontalImgSourcePath = Paths.get("resources/Flip_Horizontal_Test.bmp");
        BufferedImage flipHorizontalImgSource = ImageIO.read(flipHorizontalImgSourcePath.toFile());
        Bitmap flipHorizontalBitmap = new Bitmap(flipHorizontalImgSourcePath);
        flipHorizontalBitmap.transform(Bitmap.Transform.FLIP_HORIZONTAL);
        Path flipHorizontalImgOutputPath = Paths.get("resources/Flip_Horizontal_Test_Output.bmp");
        flipHorizontalBitmap.saveToFile(flipHorizontalImgOutputPath);
        BufferedImage flipHorizontalImgOut = ImageIO.read(flipHorizontalImgOutputPath.toFile());

        // check one pixel in each quadrant
        int sourceRGB = flipHorizontalImgSource.getRGB(5,5);
        int targetRGB = flipHorizontalImgOut.getRGB(flipHorizontalImgSource.getWidth() - 5 - 1,5);
        assertTrue(sourceRGB == targetRGB);

        sourceRGB = flipHorizontalImgSource.getRGB(25,75);
        targetRGB = flipHorizontalImgOut.getRGB(flipHorizontalImgSource.getWidth() - 25 - 1,75);
        assertTrue(sourceRGB == targetRGB);

        sourceRGB = flipHorizontalImgSource.getRGB(120,120);
        targetRGB = flipHorizontalImgOut.getRGB(flipHorizontalImgSource.getWidth() - 120 - 1,120);
        assertTrue(sourceRGB == targetRGB);

        sourceRGB = flipHorizontalImgSource.getRGB(75,25);
        targetRGB = flipHorizontalImgOut.getRGB(flipHorizontalImgSource.getWidth() - 75 - 1,25);
        assertTrue(sourceRGB == targetRGB);
    }

    @Test public void testFlipVerticalTransform() throws IOException {
        Path flipVerticalImgSourcePath = Paths.get("resources/Flip_Vertical_Test.bmp");
        BufferedImage flipVerticalImgSource = ImageIO.read(flipVerticalImgSourcePath.toFile());
        Bitmap flipVerticalBitmap = new Bitmap(flipVerticalImgSourcePath);
        flipVerticalBitmap.transform(Bitmap.Transform.FLIP_VERTICAL);
        Path flipVerticalImgOutputPath = Paths.get("resources/Flip_Vertical_Test_Output.bmp");
        flipVerticalBitmap.saveToFile(flipVerticalImgOutputPath);
        BufferedImage flipVerticalImgOut = ImageIO.read(flipVerticalImgOutputPath.toFile());

        // check one pixel in each quadrant
        int sourceRGB = flipVerticalImgSource.getRGB(5,5);
        int targetRGB = flipVerticalImgOut.getRGB(flipVerticalImgSource.getHeight() - 5 - 1,5);
        assertTrue(sourceRGB == targetRGB);

        sourceRGB = flipVerticalImgSource.getRGB(25,75);
        targetRGB = flipVerticalImgOut.getRGB(25,flipVerticalImgSource.getHeight() - 75 - 1);
        assertTrue(sourceRGB == targetRGB);

        sourceRGB = flipVerticalImgSource.getRGB(120,120);
        targetRGB = flipVerticalImgOut.getRGB(120,flipVerticalImgSource.getHeight() - 120 - 1);
        assertTrue(sourceRGB == targetRGB);

        sourceRGB = flipVerticalImgSource.getRGB(75,25);
        targetRGB = flipVerticalImgOut.getRGB(75,flipVerticalImgSource.getHeight() - 25 - 1);
        assertTrue(sourceRGB == targetRGB);
    }

    @Test public void testRandomTransform() throws IOException {
        Path RandomImgSourcePath = Paths.get("resources/Randomize_Test.bmp");
        BufferedImage RandomImgSource = ImageIO.read(RandomImgSourcePath.toFile());
        Bitmap RandomBitmap = new Bitmap(RandomImgSourcePath);
        RandomBitmap.transform(Bitmap.Transform.FLIP_VERTICAL);
        Path RandomImgOutputPath = Paths.get("resources/Randomize_Test_Output.bmp");
        RandomBitmap.saveToFile(RandomImgOutputPath);
        BufferedImage RandomImgOut = ImageIO.read(RandomImgOutputPath.toFile());

        // Check four pixels. Note - this one is almost impossible to test since random.
        // So - check four pixels to make sure at least one changed. The probability of four values
        // randomly generating to be the same value in range of 0-255 is lottery level improbable.

        int sourceRGB = RandomImgSource.getRGB(5,5);
        int targetRGB = RandomImgOut.getRGB(5,5);
        int sourceRGB2 = RandomImgSource.getRGB(25,75);
        int targetRGB2 = RandomImgOut.getRGB(25,75);
        int sourceRGB3 = RandomImgSource.getRGB(120,120);
        int targetRGB3 = RandomImgOut.getRGB(120,120);
        int sourceRGB4 = RandomImgSource.getRGB(75,25);
        int targetRGB4 = RandomImgOut.getRGB(75,25);
        assertTrue(sourceRGB != targetRGB || sourceRGB2 != targetRGB2 ||
                sourceRGB3 != targetRGB3 || sourceRGB4 != targetRGB4);
    }
}
