package Students;

import java.util.Comparator;

public class StudentComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student f, Student s) {
        return f.getName().compareTo(s.getName());
    }
}
