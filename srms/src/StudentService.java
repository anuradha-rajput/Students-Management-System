import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {

        if (findStudent(student.getId()) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View All Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search Student
    public Student findStudent(String id) {

        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }

        return null;
    }

    // Update Student
    public void updateStudent(String id, String name,
            int age, String email, String phone,
            String course, String address) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setEmail(email);
        student.setPhone(phone);
        student.setCourse(course);
        student.setAddress(address);

        System.out.println("Student updated successfully!");
    }

    // Delete Student
    public void deleteStudent(String id) {

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully!");
    }
}