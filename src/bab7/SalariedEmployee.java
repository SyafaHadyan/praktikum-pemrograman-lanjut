import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, String noKTP, LocalDate birthDate, double weeklySalary) {
        super(name, noKTP, birthDate);
        setWeeklySalary(weeklySalary);
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    public double earnings() {
        double result = getWeeklySalary();
        if (isBirthMonthEqual()) {
            return result + getBonusBirthMonth();
        }
        return result;
    }

    public String toString() {
        return String.format("Salaried Employee:\n" + super.toString() + "\nWeekly Salary: " + getWeeklySalary());
    }
}
