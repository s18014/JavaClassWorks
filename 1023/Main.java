import java.io.*;

public class Main {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        final String fileName = "Test.txt";
        final String content = readFromFile("Main.java");
        if (writeToFile(fileName, content)) {
            System.out.println(String.format("ファイルへの書き込みに成功しました: %s", fileName));
        } else {
            System.out.println(String.format("ファイルへの書き込みに失敗しました", fileName));
        }
    }

    private static boolean writeToFile(String fileName, String context) {
        File file = new File(fileName);
        try (
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        ) {
            pw.println(context);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static String readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        try (
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
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
