package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TrollerX
 */
public class Employees {

    private List<Person> persons;

    public Employees() {
        this.persons = new ArrayList<Person>();
    }

    public void add(Person person) {
        persons.add(person);
    }

    public void add(List<Person> persons) {
        for (Person person : persons) {
            persons.add(person);
        }
    }

    public void print() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public void print(Education education) {
        Iterator<Person> iterator = persons.iterator();
        
        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();
            if (nextPerson.getEducation().equals(education)) {
                System.out.println(nextPerson);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = persons.iterator();
        
        while (iterator.hasNext()) {
            if (iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }
    }
}
