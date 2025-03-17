public class Student {
    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;
    private static int counter;

    public Student() {
        this.name = "";
        this.address = "";
        this.age = 0;
        counter++;
    }

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
        counter++;
    }

    public Student(int mathGrade, int englishGrade, int scienceGrade) {
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.scienceGrade = scienceGrade;
        counter++;
    }

    public Student(String name, String address, int age, int mathGrade, int englishGrade, int scienceGrade) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.scienceGrade = scienceGrade;
        counter++;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAddress(String a) {
        address = a;
    }

    public void setAge(int ag) {
        age = ag;
    }

    public void setMath(int math) {
        mathGrade = math;
    }

    public void setEnglish(int english) {
        englishGrade = english;
    }

    public void setScience(int science) {
        scienceGrade = science;
    }

    private double getAverage() {
        double result = 0;
        result = (mathGrade + scienceGrade + englishGrade) / 3;
        this.average = result;
        return result;
    }

    public boolean statusAkhir() {
        if (this.average <= 60) {
            return true;
        }
        return false;
    }

    public void jumlahObjek() {
        System.out.println("Jumlah objek: " + counter);
    }

    public void displayMessage() {
        System.out.println("Siswa dengan nama " + name);
        System.out.println("Beralamat di " + address);
        System.out.println("Berumur " + age);
        System.out.println("Mempunyai nilai rata rata " + getAverage());
        System.out.println("Remidi: " + statusAkhir());
    }
}
