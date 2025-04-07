package recap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWorks {
    public static void main(String[] args) throws IOException {
        File f = new File("data\\coords");
        File[] moreData = f.listFiles();
        System.out.println(f.exists());
        System.out.println(f.getPath());
        List<String> lines;
        for (File file : moreData){
            System.out.println(file);
            if (file.toString().endsWith("txt")){
                System.out.println(file);
                System.out.println(file.toPath());
                lines = Files.readAllLines(file.toPath());
            }
        }
        System.out.println("---");

        String filePathBase = "data\\coords\\coords";
        for (int i = 0; i < 20; i++) {
            System.out.println(Files.readAllLines(Paths.get(filePathBase + i + ".txt")));
        }


        String[] parts;
        //pouze kladne souradnice A vypise je do noveho souboru posCoords.txt
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("posCoords.txt")));
        for (int i = 0; i < 20; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(filePathBase + i + ".txt"));
            String line;
            while((line = reader.readLine()) != null){
                parts = line.split(",");
                if ((Double.parseDouble(parts[0]) > 0 && Double.parseDouble(parts[1]) > 0)){
                    System.out.println(line);
                    pw.println(line);
                }
            }
            reader.close();
        }
        pw.close();
    }
}
