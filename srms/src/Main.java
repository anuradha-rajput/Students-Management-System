import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println(" STUDENT RECORD MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                String id = sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                Student student = new Student(
                    id, name, age, email,
                    phone, course, address
                );

                service.addStudent(student);
            } else if (choice == 2) {
                service.viewStudents();
            } else if (choice == 3) {
                System.out.print("Enter Student ID: ");
                String searchId = sc.nextLine();

                Student found = service.findStudent(searchId);

                if (found != null) {
                    found.displayStudent();
                } else {
                    System.out.println("Student not found!");
                }
            } else if (choice == 4) {
                System.out.print("Enter Student ID: ");
                String updateId = sc.nextLine();

                if (service.findStudent(updateId) == null) {
                    System.out.println("Student not found!");
                } else {
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter New Address: ");
                    String newAddress = sc.nextLine();

                    service.updateStudent(
                        updateId, newName, newAge,
                        newEmail, newPhone,
                        newCourse, newAddress
                    );
                }
            } else if (choice == 5) {
                System.out.print("Enter Student ID: ");
                String deleteId = sc.nextLine();

                service.deleteStudent(deleteId);
            } else if (choice == 0) {
                System.out.println("Thank you for using SRMS!");
            } else {
                System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}