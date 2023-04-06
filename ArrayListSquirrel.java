import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ArrayListSquirrel {

    public static void main(String[] args) {

        String csvFile = "squirrels.csv"; // path to your CSV file
        String line = "";
        String delimiter = ","; // or "\t" if it's a tab-separated file
        ArrayList<String[]> squirrelData = new ArrayList<>(); //Put whatever data strcuture you want here

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] row = line.split(delimiter);
                squirrelData.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // print the csvData array list
        for (String[] row : squirrelData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

    }

}
