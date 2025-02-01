package EMS;



public class Student {
    private int regno;
    private String name;
    private double cgpa;
    private String address;
    private String phone;

    public Student(int regno, String name, double cgpa, String address, String phone) {
        this.regno = regno;
        this.name = name;
        this.cgpa = cgpa;
        this.address = address;
        this.phone = phone;
    }

    public int getRegno() {
        return regno;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "RegNo: " + regno + ", Name: " + name + ", CGPA: " + cgpa + ", Address: " + address + ", Phone: " + phone;
    }
}

