import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class PersonReader {
    public static ArrayList<Person> readFromFile() {
        ArrayList<Person> persons = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
        fileChooser.setDialogTitle("Select Person Data File");

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Split the CSV line into individual fields
                    String[] fields = line.split(",");
                    if (fields.length == 5) {
                        String firstName = fields[0].trim();
                        String lastName = fields[1].trim();
                        String ID = fields[2].trim();
                        String title = fields[3].trim();
                        int YOB = Integer.parseInt(fields[4].trim());

                        // Create a Person object and add it to the ArrayList
                        Person person = new Person(firstName, lastName, ID, title, YOB);
                        persons.add(person);
                    } else {
                        System.out.println("Invalid data format: " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }

        return persons;
    }

    public static void main(String[] args) {
        ArrayList<Person> persons = readFromFile();

        // Now you have the ArrayList of Person objects for further processing
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
