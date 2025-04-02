import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Daniel", "135", LocalDate.of(2000, 02, 01), 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karina", "234", LocalDate.of(2000, 03, 01), 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Keanu", "145", LocalDate.of(2000, 04, 01),
                100000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bondan", "234",
                LocalDate.of(2000, 05, 01), 5000,
                .04, 300);
        ProductionEmployee productionEmployee = new ProductionEmployee("Full Name", "123", LocalDate.of(2000, 06, 01),
                23523, 0.25);

        System.out.println("Employees diproses secara terpisah:\n");
        System.out.printf("%s\n%s: $%,.2f\nMonth Match: %b\n\n",
                salariedEmployee, "Pendapatan",
                salariedEmployee.earnings(),
                salariedEmployee.isBirthMonthEqual());
        System.out.printf("%s\n%s: $%,.2f\nMonth Match: %b\n\n",
                hourlyEmployee, "Pendapatan",
                hourlyEmployee.earnings(),
                hourlyEmployee.isBirthMonthEqual());
        System.out.printf("%s\n%s: $%,.2f\nMonth Match: %b\n\n",
                commissionEmployee, "Pendapatan",
                commissionEmployee.earnings(),
                commissionEmployee.isBirthMonthEqual());
        System.out.printf("%s\n%s: $%,.2f\nMonth Match: %b\n\n",
                basePlusCommissionEmployee, "earned",
                basePlusCommissionEmployee.earnings(),
                basePlusCommissionEmployee.isBirthMonthEqual());
        System.out.printf("%s\n%s: $%,.2f\nMonth Match: %b\n\n",
                productionEmployee, "earned",
                productionEmployee.earnings(),
                productionEmployee.isBirthMonthEqual());

        Employee[] employees = new Employee[5];
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = productionEmployee;

        System.out.println("Employees diproses secara terpisah:\n");
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                employee.setBaseSalary(1.10 * employee.getBaseSalary());
                System.out.printf("Gaji pokok setelah dinaikkan 10%% :$%.2f\n", employee.getBaseSalary());
            }
            System.out.printf("Pendapatan: $%,.2f\n", currentEmployee.earnings());
            System.out.printf("Month Match: %b\n\n", currentEmployee.isBirthMonthEqual());
        }

        for (int i = 0; i < employees.length; i++) {
            System.out.printf("Employee %d = %s\n", i, employees[i].getClass().getName());
        }
    }
}
