import java.io.*;

public class MainReader {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        System.out.println(readFromFile("test.text"));
    }

    public static String readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        FileReader fr = null;
        BufferedReader br = null;
        try (
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(LINE_SEPARATOR);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.err.println(String.format("%s not found", fileName));
            return null;
        } catch (IOException e) {
            System.err.println(String.format("failed to read %s", fileName));
            return null;
        }
    }
}
