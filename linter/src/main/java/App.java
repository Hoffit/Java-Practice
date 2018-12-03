import java.io.BufferedReader;
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
        Path aPath = Paths.get("resources/gates.js");
        javaScriptLinter(aPath);
    }

    private static void javaScriptLinter(Path sourceFile) {
        try (BufferedReader reader = Files.newBufferedReader(sourceFile)) {
            String currentLine = "";
            int lineNumber = 0;
            while (currentLine != null) {
                if (!currentLine.isEmpty() && !currentLine.endsWith("{") && !currentLine.endsWith("}")
                        && !currentLine.contains("if") && !currentLine.contains("else")
                        && !currentLine.endsWith(";")) {
                    System.out.println("Line " + lineNumber + ": Missing semicolon");
                }
                lineNumber++;
                currentLine = reader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
