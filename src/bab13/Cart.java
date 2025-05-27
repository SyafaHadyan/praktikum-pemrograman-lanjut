import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ProductStruct {
    static String name;
    static int quantity;
}

class ProductRepository {
    private static List<Product> products;

    private ProductRepository() {
    }

    public static List<Product> getInstance() {
        if (products == null) {
            products = new ArrayList<>();
        }

        return products;
    }

    public static void addProduct(Product... objects) {
        for (int i = 0; i < objects.length; i++) {
            products.add(objects[i]);
        }
    }
}

class Product {
    private String name;
    private int quantity;

    public Product() {
        setName(ProductStruct.name);
        setQuantity(ProductStruct.quantity);
    }

    public Product(String name, int quantity) {
        setName(name);
        setQuantity(quantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "%-25s%s\n%-25s%d",
                "Name",
                "Quantity",
                getName(),
                getQuantity());
    }
}

public class Cart {
    class RoutineHandler {
        public static int scanUnsignedInteger() throws NumberFormatException {
            System.out.print("\n$ ");

            return Integer.parseUnsignedInt(scanner.nextLine());
        }

        public static String scanString() {
            System.out.print("\nQuery: $ ");

            return scanner.nextLine();
        }

        public static void addProduct() {
            System.out.print("Name: ");
            ProductStruct.name = scanner.nextLine();

            System.out.print("Quantity: ");
            int quantity;
            try {
                quantity = Integer.parseUnsignedInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                quantity = 0;
            }

            ProductStruct.quantity = quantity;
            System.out.println();

            ProductRepository.addProduct(new Product());
        }

        public static void removeProduct() {
            try {
                System.out.print("Index: ");
                ProductRepository.getInstance().remove(Integer.parseUnsignedInt(scanner.nextLine()));
            } catch (IndexOutOfBoundsException e) {
            }
        }

        public static void searchProduct() {
            List<Product> products = ProductRepository.getInstance();
            int option;

            for (int i = 0; i < SEARCH_OPTIONS.size(); i++) {
                System.out.printf(
                        "[%d] %s\n",
                        i,
                        SEARCH_OPTIONS.get(i));
            }

            while (true) {
                try {
                    option = RoutineHandler.scanUnsignedInteger();
                } catch (NumberFormatException e) {
                    option = -1;
                }

                if (option >= 0 &&
                        option < SEARCH_OPTIONS.size()) {
                    break;
                }
            }

            if (option == 0) {
                int index;

                try {
                    index = RoutineHandler.scanUnsignedInteger();
                } catch (NumberFormatException e) {
                    index = 0;
                }

                try {
                    System.out.printf(
                            "\n%s\n\n",
                            products.get(index));
                } catch (IndexOutOfBoundsException e) {
                }

            } else if (option == 1) {
                String query = RoutineHandler.scanString();

                for (int i = 0; i < products.size(); i++) {
                    Product product = products.get(i);

                    if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                        System.out.printf(
                                "\n%s\n\n",
                                product);
                    }
                }
            }
        }

        public static void displayProductList() {
            List<Product> products = ProductRepository.getInstance();
            int totalQuantity = 0;

            System.out.printf(
                    "\n%-25s%s\n\n",
                    "Name",
                    "Quantity");

            for (Product product : products) {
                System.out.printf(
                        "%-25s%d\n",
                        product.getName(),
                        product.getQuantity());

                totalQuantity += product.getQuantity();
            }

            System.out.printf(
                    "\nTotal product: %d\nTotal quantity: %d\n\nPress enter to continue\n",
                    products.size(),
                    totalQuantity);

            scanner.nextLine();
        }
    }

    private static final List<String> OPTION_LIST = new ArrayList<>(
            Arrays.asList(
                    "Add product",
                    "Remove product",
                    "Search product",
                    "Display product list",
                    "Quit"));
    private static final List<String> SEARCH_OPTIONS = new ArrayList<>(
            Arrays.asList(
                    "index",
                    "name"));

    private static Scanner scanner;

    private static void init() {
        scanner = new Scanner(System.in);
        ProductRepository.getInstance();
    }

    private static void startMasterRoutine() {
        int option;

        while (true) {
            for (int i = 0; i < OPTION_LIST.size(); i++) {
                System.out.printf(
                        "[%d] %s\n",
                        i,
                        OPTION_LIST.get(i));
            }

            try {
                option = RoutineHandler.scanUnsignedInteger();
            } catch (NumberFormatException e) {
                option = -1;
            }

            switch (option) {
                case 0:
                    RoutineHandler.addProduct();
                    break;
                case 1:
                    RoutineHandler.displayProductList();
                    RoutineHandler.removeProduct();
                    break;
                case 2:
                    RoutineHandler.searchProduct();
                    break;
                case 3:
                    RoutineHandler.displayProductList();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    private static void shutdown() {
        scanner.close();
    }

    public static void main(String[] args) {
        init();
        startMasterRoutine();
        shutdown();
    }
}
