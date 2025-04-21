import java.util.Scanner;

class InvoiceStruct {
    String productName;
    int quantity;
    int pricePerItem;
}

class EmployeeStruct {
    String name;
    int registrationNumber;
    int salaryPerMonth;
    Invoice[] invoices;
}

interface Payable {
    public double getPayableAmount();
}

class Invoice implements Payable {
    private String productName;
    private int quantity;
    private int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        setProductName(productName);
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    public Invoice(InvoiceStruct invoiceStruct) {
        setProductName(invoiceStruct.productName);
        setQuantity(invoiceStruct.quantity);
        setPricePerItem(invoiceStruct.pricePerItem);
    }

    public void setProductName(String productName) {
        if (!productName.isEmpty()) {
            this.productName = productName;
        } else {
            this.setProductName("Default Product Name");
        }
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    public void setPricePerItem(int pricePerItem) {
        if (pricePerItem > 0) {
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 1000;
        }
    }

    public String getProductName() {
        return this.productName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getPricePerItem() {
        return this.pricePerItem;
    }

    @Override
    public double getPayableAmount() {
        return getQuantity() * getPricePerItem();
    }

    public String toString() {
        return String.format("- Product Name: %s\n- Quantity: %d\n- Price per Item: %d\n- Total Price: %.3f\n",
                getProductName(),
                getQuantity(),
                getPricePerItem(),
                getPayableAmount());
    }
}

class Employee implements Payable {
    private String name;
    private int registrationNumber;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(String name, int registrationNumber, int salaryPerMonth, Invoice... invoices) {
        setName(name);
        setRegistrationNumber(registrationNumber);
        setSalaryPerMonth(salaryPerMonth);
        setInvoices(invoices);
    }

    public Employee(EmployeeStruct employeeStruct) {
        setName(employeeStruct.name);
        setRegistrationNumber(employeeStruct.registrationNumber);
        setSalaryPerMonth(employeeStruct.salaryPerMonth);
        setInvoices(employeeStruct.invoices);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setSalaryPerMonth(int salaryPerMonth) {
        if (salaryPerMonth > 0) {
            this.salaryPerMonth = salaryPerMonth;
        } else {
            this.salaryPerMonth = 3000000;
        }
    }

    public void setInvoices(Invoice... invoices) {
        this.invoices = invoices;
    }

    public String getName() {
        return this.name;
    }

    public int getRegistrationNumber() {
        return this.registrationNumber;
    }

    public int getSalaryPerMonth() {
        return this.salaryPerMonth;
    }

    public Invoice[] getInvoices() {
        return this.invoices;
    }

    @Override
    public double getPayableAmount() {
        double result = getSalaryPerMonth();

        for (Invoice i : this.invoices) {
            result -= i.getPayableAmount();
        }

        return result;
    }

    public String toString() {
        return String.format(
                "\nName: %s\nRegistration Number: %d\nSalary per Month: %d\n",
                getName(),
                getRegistrationNumber(),
                getSalaryPerMonth());
    }
}

public class Company {
    private static Scanner scanner = new Scanner(System.in);

    private static Invoice[] newInvoice(int count) {
        Invoice[] invoices = new Invoice[count];

        for (int i = 0; i < count; i++) {
            InvoiceStruct invoiceStruct = new InvoiceStruct();

            System.out.print("- Product Name: ");
            invoiceStruct.productName = scanner.nextLine();

            System.out.print("- Quantity: ");
            invoiceStruct.quantity = Integer.parseUnsignedInt(scanner.nextLine());

            System.out.print("- Price per Item: ");
            invoiceStruct.pricePerItem = Integer.parseUnsignedInt(scanner.nextLine());

            invoices[i] = new Invoice(invoiceStruct);
        }

        return invoices;
    }

    private static Employee[] newEmployee(int count) {
        Employee[] employees = new Employee[count];

        for (int i = 0; i < count; i++) {
            EmployeeStruct employeeStruct = new EmployeeStruct();

            System.out.print("Name: ");
            employeeStruct.name = scanner.nextLine();

            System.out.print("Registration Number: ");
            employeeStruct.registrationNumber = Integer.parseUnsignedInt(scanner.nextLine());

            System.out.print("Salary per Month: ");
            employeeStruct.salaryPerMonth = Integer.parseUnsignedInt(scanner.nextLine());

            System.out.println("Start Invoice Input: ");
            System.out.print("- Count: ");
            employeeStruct.invoices = newInvoice(Integer.parseUnsignedInt(scanner.nextLine()));

            employees[i] = new Employee(employeeStruct);
        }

        return employees;
    }

    private static void displayInfo(Employee... employees) {
        int invoiceCount = 0;
        double initialSalarySummary = 0d;
        double finalSalarySummary = 0d;
        double invoiceSummary = 0d;

        for (Employee i : employees) {
            System.out.println(i);
            initialSalarySummary += i.getSalaryPerMonth();
            finalSalarySummary += i.getPayableAmount();

            Invoice[] invoices = i.getInvoices();

            System.out.println("Invoice");
            double totalInvoice = 0d;
            for (Invoice j : invoices) {
                System.out.println(j);
                totalInvoice += j.getPayableAmount();
                invoiceSummary += j.getPayableAmount();
                invoiceCount++;
            }

            System.out.printf(
                    "Total Invoice: %.3f\n",
                    totalInvoice);

            System.out.printf(
                    "Final Salary: %.3f\n",
                    i.getPayableAmount());
        }

        System.out.printf(
                "\nSummary:\n- Employee Count: %d\n- Invoice Count: %d\n" +
                        "- Initial Salary: %.3f\n- Final Salary: %.3f\n" +
                        "- Invoice Summary: %.3f\n",
                employees.length,
                invoiceCount,
                initialSalarySummary,
                finalSalarySummary,
                invoiceSummary);
    }

    public static void main(String[] args) {
        System.out.print("Employee count: ");
        int count = Integer.parseUnsignedInt(scanner.nextLine());

        displayInfo(newEmployee(count));

        scanner.close();
    }
}
