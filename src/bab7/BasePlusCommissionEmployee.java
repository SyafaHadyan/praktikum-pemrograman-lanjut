import java.time.LocalDate;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String name, String noKTP, LocalDate birthDate, double grossSales,
            double commissionRate,
            double baseSalary) {
        super(name, noKTP, birthDate, grossSales, commissionRate);
        setBaseSalary(baseSalary);
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public double earnings() {
        double result = getBaseSalary() + super.earnings();
        if (isBirthMonthEqual()) {
            return result + getBonusBirthMonth();
        }
        return result;
    }

    public String toString() {
        return String.format("Base-Salaried:\n" + super.toString() + "\nBase Salary: " + getBaseSalary());
    }
}
