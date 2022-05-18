package Inheritance;

public class Student extends Person{
    private String school;

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public double getGrade() {
        return 6.00;
    }

    @Override
    public void sleep() {
        System.out.println("Student never sleep");
    }
}
