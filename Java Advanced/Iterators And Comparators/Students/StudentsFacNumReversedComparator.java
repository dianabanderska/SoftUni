package Students;

import java.util.Comparator;

public class StudentsFacNumReversedComparator implements Comparator<Student> {

    @Override
    public int compare(Student f, Student s) {
        return Integer.compare(s.getFacNumber(), f.getFacNumber());
    }
}
