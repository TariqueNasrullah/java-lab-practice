import java.io.*;

public class Student implements Serializable {
    // Create a Student class containing three member data name, id and marks.
    private String id, name;
    private double []marks;

    public void set_data(String id, String name, double []marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public static void record_info(Student s) {
        try {
            FileOutputStream f = new FileOutputStream(new File("student_info.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(s);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public static void highest_info() {
        try {
            FileInputStream fi = new FileInputStream(new File("student_info.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Student student = (Student) oi.readObject();

            if (student == null) {
                System.out.println("null");
            } else {
                double max = 0;
                for (double element: student.marks) {
                    if (max < element) {
                        max = element;
                    }
                }

                System.out.printf("Id: %s \n", student.id);
                System.out.printf("Name: %s\n" , student.name);
                System.out.printf("Highest Mark: %f\n" , max);
            }

            oi.close();
            fi.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String []args) {
        Student st = new Student();
        st.set_data("1", "tarique", new double[]{100.1, 33.33, 95.0, 10.5});

        Student.record_info(st);

        Student.highest_info();
    }

}
