import java.util.Scanner;

public class Customer {
    Scanner scanner = new Scanner(System.in);

    private final String SILVER_ID = "38";
    private final String GOLD_ID = "56";
    private final String PLATINUM_ID = "74";
    private final int SILVER_CODE = 0;
    private final int GOLD_CODE = 1;
    private final int PLATINUM_CODE = 2;
    private final int SILVER_ID_CODE = 38;
    private final int GOLD_ID_CODE = 56;
    private final int PLATINUM_ID_CODE = 74;
    private final int USER_ID_LENGTH = 10;
    private final int MAXIMUM_RETRIES = 3;
    private final int PIN_LENGTH = 6;
    private final double MINIMUM_TRANSACT_DISCOUNT = 1000000d;
    private final double MINIMUM_ACCOUNT_BALANCE = 10000d;
    private final double SILVER_CASHBACK_PERCENTAGE = 5d;
    private final double GOLD_CASHBACK_PERCENTAGE = 7d;
    private final double PLATINUM_CASHBACK_PERCENTAGE = 10d;
    private final double SILVER_CASHBACK_RETURN_PERCENTAGE = 0d;
    private final double GOLD_CASHBACK_RETURN_PERCENTAGE = 2d;
    private final double PLATINUM_CASHBACK_RETURN_PERCENTAGE = 5d;

    private boolean isActive;
    private boolean isAccountInitialized;
    private String ID;
    private String name;
    private int retries;
    private int pin;
    private double balance;

    private int getAccountType() {
        if (this.ID.length() != USER_ID_LENGTH) {
            return -1;
        } else if (this.ID.startsWith(SILVER_ID)) {
            return SILVER_CODE;
        } else if (this.ID.startsWith(GOLD_ID)) {
            return GOLD_CODE;
        } else if (this.ID.startsWith(PLATINUM_ID)) {
            return PLATINUM_CODE;
        } else {
            return -1;
        }
    }

    private double[] calculateCashback(double cost) {
        int accountType = getAccountType();

        if (cost < MINIMUM_TRANSACT_DISCOUNT) {
            return new double[] { 0d, 0d };
        } else if (accountType == SILVER_CODE) {
            return new double[] { SILVER_CASHBACK_PERCENTAGE / 100d * cost,
                    SILVER_CASHBACK_RETURN_PERCENTAGE / 100d * cost };
        } else if (accountType == GOLD_CODE) {
            return new double[] { GOLD_CASHBACK_PERCENTAGE / 100d * cost,
                    GOLD_CASHBACK_RETURN_PERCENTAGE / 100d * cost };
        } else if (accountType == PLATINUM_CODE) {
            return new double[] { PLATINUM_CASHBACK_PERCENTAGE / 100d * cost,
                    PLATINUM_CASHBACK_RETURN_PERCENTAGE / 100d * cost };
        } else {
            System.err.println("\nInvalid user id\n");
            return new double[] { 0d, 0d };
        }
    }

    private boolean validatePin(int pin) {
        if (!this.isActive) {
            System.err.println("\nTransaction failed\nReason: account blocked\n");
            return false;
        }

        if (this.pin != pin) {
            System.err.println("\nTransaction failed\nReason: invalid pin\n");
            retries++;
            if (retries == MAXIMUM_RETRIES) {
                this.isActive = false;
            }
            return false;
        }

        return true;
    }

    private boolean checkAccountInitializationStatus() {
        if (isAccountInitialized) {
            return false;
        }

        return true;
    }

    private void createUserID() {
        int accountType = 0;
        String remainingUserID = "";

        while (true) {
            try {
                System.out.println("Account types:\n" + "0 (Silver)\n" + "1 (Gold)\n" + "2 (Platinum)\n");
                System.out.print("Enter account type (number): ");
                accountType = Integer.parseInt(scanner.nextLine());
                if (!(accountType == SILVER_CODE || accountType == GOLD_CODE || accountType == PLATINUM_CODE)) {
                    System.err.println("\nInvalid account type\n");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.err.println("\nInvalid account type\n");
            }
        }

        switch (accountType) {
            case SILVER_CODE:
                accountType = SILVER_ID_CODE;
                break;
            case GOLD_CODE:
                accountType = GOLD_ID_CODE;
                break;
            case PLATINUM_CODE:
                accountType = PLATINUM_ID_CODE;
                break;
        }

        for (int i = 0; i < USER_ID_LENGTH - 2; i++) {
            int temp = (int) (Math.random() * 10);
            remainingUserID = remainingUserID.concat(String.valueOf(temp));
        }

        this.ID = String.valueOf(accountType).concat(String.valueOf(remainingUserID));
    }

    private void createPin() {
        String pin = "";

        while (true) {
            try {
                System.out.print("Enter pin (" + PIN_LENGTH + " digits): ");
                pin = scanner.nextLine();
                if (pin.length() != PIN_LENGTH) {
                    System.err.println("\nInvalid pin\n");
                    continue;
                }
                System.out.print("Enter pin again: ");
                if (!scanner.nextLine().equals(pin)) {
                    System.err.println("\nInvalid pin\n");
                    continue;
                }

                Integer.parseInt(pin);

                break;
            } catch (NumberFormatException e) {
                System.err.println("\nInvalid pin\n");
                continue;
            }
        }

        this.pin = Integer.parseInt(pin);
    }

    private void enterName() {
        System.out.print("Enter full name: ");
        this.name = scanner.nextLine();
    }

    private void initializeAccountBalance() {
        double balance = 0d;

        while (true) {
            try {
                System.out.print("Enter initial account balance (Min: " + MINIMUM_ACCOUNT_BALANCE + "): ");
                balance = Double.parseDouble(scanner.nextLine());
                if (balance < MINIMUM_ACCOUNT_BALANCE) {
                    System.err.println("\nInvalid balance\n");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.err.println("\nInvalid balance\n");
            }
        }

        this.balance = balance;
    }

    private void finalizeAccountInitialization() {
        this.isActive = true;
        this.isAccountInitialized = true;
    }

    public void initializeAccount() {
        if (checkAccountInitializationStatus()) {
            createUserID();
            createPin();
            enterName();
            initializeAccountBalance();
            finalizeAccountInitialization();
        }
    }

    public void newTransaction(double cost, int pin) {
        if (!validatePin(pin)) {
            return;
        }

        double[] discountCalculationResult = calculateCashback(cost);
        double finalCost = cost - discountCalculationResult[0];
        double cashback = discountCalculationResult[1];

        if (this.balance - finalCost < MINIMUM_ACCOUNT_BALANCE) {
            System.err.println("\nTransaction failed\nReason: invalid minimum account balance\n");
            return;
        }

        this.balance -= finalCost;
        this.balance += cashback;

        System.out.println("Transaction success");
    }

    public void deposit(double amount, int pin) {
        if (!validatePin(pin)) {
            return;
        }

        this.balance += amount;
        System.out.println("Transaction success");
        return;
    }

    public void displayUserInfo() {
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        // System.out.println("Pin: " + this.pin);
        System.out.println("Balance: " + this.balance);
    }
}
