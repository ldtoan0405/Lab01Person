import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void generatePersonsToFile(String fileName) {
        ArrayList<Person> persons = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter Person data until they want to stop
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        boolean done = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getRangedInt(in, "Enter year of birth", 1000, 9999);

            Person person = new Person(firstName, lastName, ID, title, YOB);
            persons.add(person);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);


        // Write the Person data to the specified file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : persons) {
                String csvDataRecord = person.toCSVDataRecord();
                writer.write(csvDataRecord);
                writer.newLine();
            }
            System.out.println("Person data written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while writing to the file.");
        }
    }

    public static void main(String[] args) {
        // Specify the file name where you want to write the product data
        String fileName = "PersonTestData.txt";

        // Call the generateProductsToFile method to generate and write products
        generatePersonsToFile(fileName);
    }
}
