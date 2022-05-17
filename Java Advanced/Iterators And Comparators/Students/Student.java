package Students;

public class Student implements Comparable<Student>{ 
    private int facNumber;
    private String name;
    private int age;

    public Student(int facNumber, String name, int age) {
        this.facNumber = facNumber;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getFacNumber() {
        return facNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "facNumber=" + facNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.getFacNumber(), other.getFacNumber());
    }
}
