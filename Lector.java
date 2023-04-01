import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lector {
	static File file = new File("emails.csv");
	public void ejecutar(int id){
        try {
            read(id);
		} catch (IOException e) {
            e.printStackTrace();
		}
	}
    public static void read(int id) throws IOException{
        Path fileName = Path.of(file.getPath());
        String str = Files.readString(fileName);
        String[] split = str.split("\n|\\,");
        String[][] matrix = new String[5173][3002];
        int b = 0;
        for (int j = 0; j <= 5172; j++) {
            for (int i = 0; i <= 3001; i++) {
                matrix[j][i] = split[b];
                b++;
            }
        }
        String str1 = Integer.toString(id);
        int ID = Integer.parseInt(str1.substring(3, 6));
        String path = Integer.toString(id) + ".data";
        File file1 = new File(path);
        FileWriter fileWriter = new FileWriter(file1);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int j = 1; j <= 3000; j++) {
            printWriter.print(matrix[0][j]);
            int temp = 0;
            for (int i = ID; i <= (ID+49); i++) {
                temp += Integer.parseInt(matrix[i][j]); 
            }
            printWriter.print(", " + temp);
            printWriter.println();
        }
        printWriter.close();
        Path fileName1 = Path.of(file1.getPath());
        String str2 = Files.readString(fileName1);
        System.out.println(str2);
    }
}