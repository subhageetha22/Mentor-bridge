import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void displayStudent() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            s.displayStudent();
        }
    }

    public Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public boolean updateStudent(int id, String name, int age, String course) {
        Student s = getStudentById(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Student s = getStudentById(id);
        return s != null && students.remove(s);
    }
}

public class core_java_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student\n2. View All Students\n3. View Student by ID\n4. Update Student\n5. Delete Student\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    manager.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Student s = manager.getStudentById(searchId);
                    if (s != null)
                        s.displayStudent();
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();
                    if (manager.updateStudent(uid, newName, newAge, newCourse))
                        System.out.println("Student updated successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    if (manager.deleteStudent(delId))
                        System.out.println("Student deleted.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
