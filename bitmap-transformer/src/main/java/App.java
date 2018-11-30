import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    /**
     * Main.
     * @param args Input args.
     */
    public static void main(String[] args) {
        //Read the args
        //TODO handle missing args
        //TODO bad path/file resource
        Path sourceFile = Paths.get(args[0]);
        Path targetFile = Paths.get(args[1]);
        //TODO create reader on file and handle exceptions
        Bitmap.Transform transform = null;
        try {
            transform = Bitmap.Transform.valueOf(args[2].toUpperCase());
        }
        catch (Exception e) {
            System.out.println(e);
        }

        //Extract the bitmap data structure from file
        //TODO
        try {
            byte[] bytes = Files.readAllBytes(sourceFile);
            System.out.println(bytes);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        int[][] pixels = {{0, 255},{255, 0}};

        //TODO Create and invoke Bitmap per args
        Bitmap bitmap = new Bitmap(pixels);

        // TODO handle
        if (transform != null)
        switch (transform) {
            case RANDOMIZE:
                bitmap.performRandomizeTransform();

            case BLACK_AND_WHITE:
                bitmap.performBlackAndWhiteTransform();

            case FLIP_VERTICAL:
                bitmap.performFlipVerticalTransform();

            case FLIP_HORIZONTAL:
                bitmap.performFlipHorizontalTransform();
        }

    }
}
