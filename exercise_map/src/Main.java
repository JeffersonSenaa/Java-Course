import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    String sourceFile = "/home/jefferson/ws-java/Java-Course/exercise_map/src/registros_de_votacao.csv";
    try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))){
        Map<String, Integer> map = new TreeMap<String, Integer>();
        String line = br.readLine();

        while(line != null){
            String[] data = line.split(",");
            String name = data[0];
            int voting = Integer.parseInt(data[1]);

            if(map.containsKey(name)){
                int totalVoting = map.get(name);
                map.put(name, totalVoting + voting);
            }
            else {
                map.put(name, voting);
            }
            line = br.readLine();
        }

        for(String key : map.keySet()){
            System.out.println(key + " : " + map.get(key));
        }
    }
    catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
    }
}