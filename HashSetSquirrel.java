import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashSetSquirrel {
    public static void main(String[] args) {
        File file = new File("squirrels.csv");
        try {
            Scanner scanner = new Scanner(file);
            HashSet<String> set = new HashSet<>();
            while (scanner.hasNextLine()) {
                String squirrel = scanner.nextLine();
                set.add(squirrel);
            }
            scanner.close();
            System.out.println("HashSet contains " + set.size() + " elements");
            for (String squirrel : set) {
                System.out.println(squirrel);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}