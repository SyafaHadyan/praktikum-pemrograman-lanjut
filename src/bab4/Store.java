import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        customer.initializeAccount();
        while (true) {
            System.out.println(
                    "\n1 (New transaction)\n2 (Increase cash balance / top up)\n3 (Display your information)\n4 (Exit)\n");
            System.out.print("Enter: ");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                double cost = 0d;
                int pin = 0;
                try {
                    System.out.print("Enter cost: ");
                    cost = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter pin: ");
                    pin = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input\n");
                }

                customer.newTransaction(cost, pin);
            } else if (option.equals("2")) {
                double amount = 0d;
                int pin = 0;
                try {
                    System.out.print("Enter cost: ");
                    amount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter pin: ");
                    pin = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input\n");
                }

                customer.deposit(amount, pin);
            } else if (option.equals("3")) {
                System.out.println();
                customer.displayUserInfo();
            } else if (option.equals("4")) {
                System.out.println("Quitting...");
                break;
            } else {
                System.err.println("Invalid input\n");
            }
        }
        scanner.close();
    }
}
