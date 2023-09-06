import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testFullName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("Jane", "Smith", "54321", "Mrs.", 1990);
        assertEquals("Mrs. Jane Smith", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("Alice", "Johnson", "67890", "Ms.", 1975);
        assertEquals("48", person.getAge(2023));
    }

    @Test
    public void testToCSVDataRecord() {
        Person person = new Person("Bob", "Brown", "98765", "Dr.", 1985);
        assertEquals("98765,Bob,Brown,Dr.,1985", person.toCSVDataRecord());
    }
}
