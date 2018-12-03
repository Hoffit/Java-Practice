import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    /**
     * Main. Command Line Interface. This application is used to manipulate bitmap images via transforms in Bitmap.java.
     * This application requires three arguments:
     * 1. The path and file of an image to transform.
     * 2. The path and file name to write transformed image.
     * 3. The type of transform to perform.
     *
     * The following transforms are supported:
     * 1. black_and_white
     * 2. flip_horizontal
     * 3. flip_vertical
     * 4. randomize
     * @param args Input args.
     */
    public static void main(String[] args) {
        // 1. Read in the args, handle input issues
        if (args.length != 3) {
            System.out.println("Invalid input arguments. Application requires 3 arguments.\nExample:" +
                    "resources/Randomize_Test.bmp resources/Randomize_Output.bmp randomize");
            return;
        }
        Path sourceFile = Paths.get(args[0]);
        Path targetFile = Paths.get(args[1]);
        String transformArg = args[2];
        Bitmap.Transform transform;
        try {
            transform = Bitmap.Transform.valueOf(transformArg.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid transform specified: " + transformArg + "\n" + "Valid transforms are:\n");
            for (Bitmap.Transform t : Bitmap.Transform.values()) {
                System.out.println(t);
            }
            return;
        }

        // 2. Create a bitmap based on input file arg
        Bitmap bitmap;
        try {
            bitmap = new Bitmap(sourceFile);
        } catch (IOException e) {
            System.out.println("Error: unable to read from source file. Check the path and file name.");
            return;
        }

        // 3. Process the requested transform
        bitmap.transform(transform);

        // 4. Write to output file
        try {
            bitmap.saveToFile(targetFile);
            System.out.println("Image transformation success!");
        } catch (IOException e) {
            System.out.println("Error: unable to write to a target file. Check the path.");
        }
    }
}
