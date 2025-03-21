public class MainEmployee {
    public static void main(String[] args) {
        ManagerExample boss = new ManagerExample("Steven", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        Employee staff = new Employee("Donni", 50000, 1989, 10, 1);
        ManagerExample testManagerExample = new ManagerExample("Full Name");
        System.out.println("Nama boss : " + boss.getName() + ", salary = " + boss.getSalary());
        System.out.println("Nama staff : " + staff.getName() + ", salary = " + staff.getSalary());
        System.out.println(
                "Nama test : " + testManagerExample.getName() + ", salary = " + testManagerExample.getSalary());
    }
}
