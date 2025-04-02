import java.time.LocalDate;

public class ProductionEmployeeMain {
    public static void main(String[] args) {
        ProductionEmployee[] productionEmployee = new ProductionEmployee[5];
        productionEmployee[0] = new ProductionEmployee("Full Name First", "123", LocalDate.of(2000, 01, 01), 23523,
                0.25);
        productionEmployee[1] = new ProductionEmployee("Full Name Second", "124", LocalDate.of(2000, 02, 01), 183248,
                0.40);
        productionEmployee[2] = new ProductionEmployee("Full Name Third", "125", LocalDate.of(2000, 03, 01), 9233,
                0.50);
        productionEmployee[3] = new ProductionEmployee("Full Name Fourth", "126", LocalDate.of(2000, 04, 01), 5432,
                0.35);
        productionEmployee[4] = new ProductionEmployee("Full Name Fifth", "127", LocalDate.of(2001, 05, 01), 623532482,
                0.30);

        for (ProductionEmployee currentProductionEmployee : productionEmployee) {
            System.out.println(currentProductionEmployee);
            System.out.printf("Earnings : $%,.2f\n", currentProductionEmployee.earnings());
            System.out.printf("Month Match: %b\n\n", currentProductionEmployee.isBirthMonthEqual());
        }
    }
}
