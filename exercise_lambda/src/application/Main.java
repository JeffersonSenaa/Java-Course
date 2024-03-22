package application;

import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;
    import java.util.stream.Collectors;

import model.entities.Employee;

    public class Main {
        public static void main(String[] args) {
            String source = "/home/jefferson/ws-java/Java-Course/exercise_lambda/src/input.csv";

            try(BufferedReader br = new BufferedReader(new FileReader(source))){
                String line = br.readLine();
                List<Employee> list = new ArrayList<Employee>();

                while(line != null){
                    String data[] = line.split(",");
                    String name = data[0];
                    String email = data[1];
                    float salary = Float.parseFloat(data[2]);
                    list.add(new Employee(name, email, salary));
                    line = br.readLine();
                }
                //Mostrar em ordem alfabetica os email's com salario maior que 2000
                float salaryEx = 2000.00f;

                List<String> st = list.stream()
                        .filter(employee -> employee.getSalary() > 2000)
                        .map(Employee::getEmail)
                        .sorted(Comparator.naturalOrder())
                        .collect(Collectors.toList());
                System.out.println(Arrays.toString(st.toArray()));

                float sum = list.stream()
                        .filter(employee -> employee.getName().startsWith("M"))
                        .map(Employee::getSalary)
                        .reduce(0.0f, Float::sum);

                System.out.println("Sum: " + sum);

            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }