import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> studentA = new TreeSet<Integer>();
        Set<Integer> studentB = new TreeSet<Integer>();
        Set<Integer> studentC = new TreeSet<Integer>();
        Set<Integer> uniao = new TreeSet<Integer>();

        System.out.print("How many students for course A: ");
        int numberStudentsA = sc.nextInt();
        for(int i=0; i<numberStudentsA; i++){
            int studentCode = sc.nextInt();
            studentA.add(studentCode);
        }
        System.out.print("How many students for course B: ");
        int numberStudentsB = sc.nextInt();
        for(int i=0; i<numberStudentsB; i++){
            int studentCode = sc.nextInt();
            studentB.add(studentCode);
        }
        System.out.print("How many students for course C: ");
        int numberStudentsC = sc.nextInt();
        for(int i=0; i<numberStudentsC; i++){
            int studentCode = sc.nextInt();
            studentC.add(studentCode);
        }
        uniao.addAll(studentA);
        uniao.addAll(studentB);
        uniao.addAll(studentC);

        System.out.println("Total students: " + uniao.size());

        sc.close();
    }
}
