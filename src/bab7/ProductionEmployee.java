import java.time.LocalDate;

public class ProductionEmployee extends Employee {
    private int weeklyProduction;
    private double productionRate;

    public ProductionEmployee(String name, String noKTP, LocalDate birthDate, int weeklyProduction,
            double productionRate) {
        super(name, noKTP, birthDate);
        setWeeklyProduction(weeklyProduction);
        setProductionRate(productionRate);
    }

    public void setWeeklyProduction(int weeklyProduction) {
        this.weeklyProduction = weeklyProduction;
    }

    public void setProductionRate(double productionRate) {
        this.productionRate = productionRate;
    }

    public int getWeeklyProduction() {
        return this.weeklyProduction;
    }

    public double getProductionRate() {
        return this.productionRate;
    }

    public double earnings() {
        double result = getWeeklyProduction() * getProductionRate();
        if (isBirthMonthEqual()) {
            return result + getBonusBirthMonth();
        }
        return result;
    }

    public String toString() {
        return String.format("Production Employee:\n" + super.toString() + "\nWeekly Production: "
                + getWeeklyProduction() + "\nProduction Rate: " + getProductionRate());
    }

}
