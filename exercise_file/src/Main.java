import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "/home/jefferson/ws-java/Java-Course/exercise_file/teste/source_file.csv";
        String pathFolder = "/home/jefferson/ws-java/Java-Course/exercise_file/teste/";
        String outPath = pathFolder + "summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while (line != null){
                String[] data = line.split(",");
                String name = data[0];
                float value = Float.parseFloat(data[1]);
                int items = Integer.parseInt(data[2]);
                float amount = value*items;

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(outPath, true))){
                    bw.write(name + "," + Float.toString(amount));
                    bw.newLine();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
                line = br.readLine();

                }

            } catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }

        } 


    }
