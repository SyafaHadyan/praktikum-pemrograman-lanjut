import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        // Student anna = new Student();
        // anna.setName("Anna");
        // anna.setAddress("Malang");
        // anna.setAge(20);
        // anna.setMath(100);
        // anna.setScience(89);
        // anna.setEnglish(80);
        // anna.displayMessage();

        // System.out.println("===================");
        // Student chris = new Student("Chris", "Kediri", 21);
        // chris.setMath(70);
        // chris.setScience(60);
        // chris.setEnglish(90);
        // chris.displayMessage();

        // System.out.println("===================");
        // anna = new Student("anna", "Batu", 18);
        // anna.displayMessage();

        // System.out.println("===================");
        // chris.setAddress("Surabaya");
        // chris.setMath(70);
        // chris.setScience(70);
        // chris.setEnglish(90);
        // chris.setAge(22);
        // chris.displayMessage();

        // System.out.println("===================");
        // Student name = new Student(20, 32, 43);
        // name.setName("Name");
        // name.setAddress("Malang");
        // name.setAge(100);
        // name.displayMessage();
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah siswa: ");
        Student[] student = new Student[Integer.parseInt(input.nextLine())];
        for (int i = 0; i < student.length; i++) {
            Student current = new Student(input.nextLine(), input.nextLine(), input.nextInt(), input.nextInt(),
                    input.nextInt(), input.nextInt());
            input.nextLine();
            student[i] = current;
        }
        input.close();
        for (int i = 0; i < student.length; i++) {
            student[i].displayMessage();
        }
        student[0].jumlahObjek();
    }
}
