package CodingTracker;

import java.io.Serializable;

public class Reflection implements Serializable {

    private static final String nickName = "Pinguin";
    public String name;
    protected String webAddress;
    String email;
    private int zip;

    public Reflection() {
        this.setName("Java");
        this.setWebAddress("oracle.com");
        this.setEmail("mail@oracle.com");
        this.setZip(1407);
    }

    private Reflection(String name, String webAddress, String email) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    protected Reflection(String name, String webAddress, String email, int zip) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    @Author(name = "George")
    public final String getName() {
        return name;
    }

    @Author(name = "Petar")
    private void setName(String name) {
        this.name = name;
    }

    @Author(name = "Ivan")
    protected String getWebAddress() {
        return webAddress;
    }

    @Author(name = "Maria")
    private void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Author(name = "Ivana")
    public String getEmail() {
        return email;
    }

    @Author(name = "Stanislava")
    public void setEmail(String email) {
        this.email = email;
    }

    @Author(name = "Stoyan")
    protected final int getZip() {
        return zip;
    }

    @Author(name = "Kaloyan")
    private void setZip(int zip) {
        this.zip = zip;
    }

    public String toString() {
        String result = "Name: " + getName() + "\n";
        result += "WebAddress: " + getWebAddress() + "\n";
        result += "email: " + getEmail() + "\n";
        result += "zip: " + getZip() + "\n";
        return result;
    }

    public static void print() {
        System.out.println("Print static method");
    }
}
