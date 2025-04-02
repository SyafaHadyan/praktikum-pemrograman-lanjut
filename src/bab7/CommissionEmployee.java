import java.time.LocalDate;

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String name, String noKTP, LocalDate birthDate, double grossSales,
            double commissionRate) {
        super(name, noKTP, birthDate);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public double earnings() {
        double result = getCommissionRate() * getGrossSales();
        if (isBirthMonthEqual()) {
            return result + getBonusBirthMonth();
        }
        return result;
    }

    public String toString() {
        return String.format("Commission Employee:\n" + super.toString() + "\nGross Sales: " + getGrossSales()
                + "\nCommission Rate: " + getCommissionRate());
    }
}
