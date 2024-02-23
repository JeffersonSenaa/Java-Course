import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        boolean sucess = new File(sourceFolderStr + "/out").mkdir();

        String targetFileStr = sourceFolderStr + "/out/summary.csv";        

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
            String line = br.readLine();
            while (line != null){
                String[] data = line.split(",");
                String name = data[0];
                float value = Float.parseFloat(data[1]);
                int items = Integer.parseInt(data[2]);
                float amount = value*items;

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr, true))){
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
            finally{
                sc.close();
            }
        } 
        


    }
