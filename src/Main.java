import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Läs in en fil som lagrat information om personer på formatet:
        //   Namn Adress
        //   Ålder Längd(cm) vikt(kg)
        //
        // Filtrera ut de personer som har BMI > 30 och spara deras information i en ny fil
        // BMI = vikt(kg) / (längden(m) * längden(m))

        BufferedReader inFile = new BufferedReader(new FileReader("persons.txt"));
        PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter("bmi.txt")));

        while (true) {
            String row1 = inFile.readLine();
            if (row1 == null) {
                break;
            }
            String row2 = inFile.readLine();
            Scanner rowReader = new Scanner(row2);
            int age = rowReader.nextInt();
            double height = rowReader.nextInt() / 100.0;
            double weight = rowReader.nextDouble();

            double bmi = weight / (height * height);
            if (bmi > 30) {
                outFile.println(row1);
                outFile.println(row2);
            }
        }
        inFile.close();
        outFile.close();
    }
}