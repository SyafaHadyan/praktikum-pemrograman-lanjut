import java.time.LocalDate;

public abstract class Employee {
    private String name;
    private String noKTP;
    private LocalDate birthDate;
    private final double BONUS_BIRTH_MONTH = 100;

    public Employee(String name, String noKTP, LocalDate birthDate) {
        this.name = name;
        this.noKTP = noKTP;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public String getNoKTP() {
        return this.noKTP;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public double getBonusBirthMonth() {
        return this.BONUS_BIRTH_MONTH;
    }

    public boolean isBirthMonthEqual() {
        if (this.birthDate.getMonth() == LocalDate.now().getMonth()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("Name: " + getName() + "\nNo: " + getNoKTP() + "\nBirth Date: " + getBirthDate());
    }

    public abstract double earnings();
}
