import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    /**
     * Main.
     * @param args Input args.
     */
    public static void main(String[] args) {
        //TODO: testing should focus on the transform methods, not file io.
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
            System.out.println(e.getMessage());
        }

        //TODO Create and invoke Bitmap per args
        Bitmap bitmap = new Bitmap(sourceFile);

        // TODO handle
        bitmap.transform(transform);
        bitmap.saveToFile(targetFile);

    }
}
