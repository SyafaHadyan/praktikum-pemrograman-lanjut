import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;

    HourlyEmployee(String name, String noKTP, LocalDate birthDate, double hourlyWage, double hoursWorked) {
        super(name, noKTP, birthDate);
        setHourlyWage(hourlyWage);
        setHoursWorked(hoursWorked);
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return this.hourlyWage;
    }

    public double getHoursWorked() {
        return this.hoursWorked;
    }

    public double earnings() {
        double result;
        if (getHoursWorked() <= 40) {
            result = getHourlyWage() * getHoursWorked();
            if (isBirthMonthEqual()) {
                return result + getBonusBirthMonth();
            }
            return result;
        } else {
            result = 40 * getHourlyWage() + (getHoursWorked() - 40) * getHourlyWage() * 1.5;
            if (isBirthMonthEqual()) {
                return result + getBonusBirthMonth();
            }
            return result;
        }
    }

    public String toString() {
        return String.format("Hourly Employee:\n" + super.toString() + "\nHourly Wage: " + getHourlyWage()
                + "\nHours Worked: " + getHoursWorked());
    }

}
