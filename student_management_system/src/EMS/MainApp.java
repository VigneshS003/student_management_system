package EMS;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n======= Student Management System =======");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter RegNo: ");
                    int regno = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter CGPA: ");
                    double cgpa = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.next();
                    
                    dao.addStudent(new Student(regno, name, cgpa, address, phone));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        System.out.println("\nStudent List:");
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter RegNo to update: ");
                    int updateRegNo = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.next();
                    System.out.print("Enter New CGPA: ");
                    double newCgpa = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter New Phone: ");
                    String newPhone = scanner.next();
                    
                    dao.updateStudent(updateRegNo, newName, newCgpa, newAddress, newPhone);
                    break;

                case 4:
                    System.out.print("Enter RegNo to delete: ");
                    int deleteRegNo = scanner.nextInt();
                    dao.deleteStudent(deleteRegNo);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for using Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
