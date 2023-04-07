import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ArrayListSquirrel {

    public static void main(String[] args) {

        String csvFile = "squirrels.csv"; // path to your dataset
        String line = "";
        ArrayList<Squirrel> squirrelData = new ArrayList<>(); //Put whatever data strcuture you want here, in this case its an ArrayList

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String squirrelID = columns[2];
                String dateFound = columns[5];
                String color = columns[10];
                Squirrel squirrel = new Squirrel(squirrelID,dateFound,color);
                squirrelData.add(squirrel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Squirrel squirrel : squirrelData) {
            System.out.println(squirrel.getSquirrelID() + "\t\t " + squirrel.getDateFound() + "\t\t " + squirrel.getColor());
        }
    }
}
