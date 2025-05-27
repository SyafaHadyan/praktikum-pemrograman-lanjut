import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

class ProductRepository {
    private static List<Product> productList;

    private ProductRepository() {
    }

    public static List<Product> getInstance() {
        if (productList == null) {
            productList = new ArrayList<>();
        }

        return productList;
    }

    public static Iterator<Product> getIterator() {
        return productList.iterator();
    }

    public static void addProduct(Product... products) {
        for (Product product : products) {
            if (product != null) {
                productList.add(product);
            }
        }
    }
}

class Product {
    private UUID ID;
    private String name;
    private LocalDateTime createdAt;

    public Product(String name) {
        setID(UUID.randomUUID());
        setName(name);
        setCreatedAt(LocalDateTime.now());
    }

    private void setID(UUID ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String toString() {
        return String.format(
                "Name:\t\t%s\nID:\t\t%s\nCreated At:\t%s\n",
                getName(),
                getID(),
                getCreatedAt());
    }
}

class App {
    class ProductHandler {
        public static void add() {
            String name = getInput("Name: ");

            ProductRepository.addProduct(new Product(name));
        }

        public static void modify() {
            List<Product> productList = ProductRepository.getInstance();

            UUID query;

            try {
                query = UUID.fromString(getInput("ID: "));
            } catch (IllegalArgumentException e) {
                query = UUID.randomUUID();
            }

            String newName = getInput("New name: ");

            for (int i = 0; i < productList.size(); i++) {
                Product currentProduct = productList.get(i);

                if (currentProduct.getID().equals(query)) {
                    currentProduct.setName(newName);

                    productList.remove(i);

                    productList.add(currentProduct);

                    return;
                }
            }
        }

        public static void delete() {
            List<Product> productList = ProductRepository.getInstance();

            UUID query;

            try {
                query = UUID.fromString(getInput("ID: "));
            } catch (IllegalArgumentException e) {
                query = UUID.randomUUID();
            }

            for (int i = 0; i < productList.size(); i++) {
                Product currentProduct = productList.get(i);

                if (currentProduct.getID().equals(query)) {
                    productList.remove(i);

                    return;
                }
            }
        }

        public static void search() {
            Iterator<Product> productIterator = ProductRepository.getIterator();

            UUID query;

            try {
                query = UUID.fromString(getInput("ID: "));
            } catch (IllegalArgumentException e) {
                query = UUID.randomUUID();
            }

            while (productIterator.hasNext()) {
                Product currentProduct = productIterator.next();

                if (currentProduct.getID().equals(query)) {
                    System.out.println(currentProduct);

                    return;
                }
            }
        }

        public static void display() {
            Iterator<Product> productIterator = ProductRepository.getIterator();

            while (productIterator.hasNext()) {
                System.out.println(productIterator.next());
            }
        }
    }

    private static final List<String> COMMAND_LIST = new ArrayList<>(
            Arrays.asList(
                    "Add product",
                    "Update product",
                    "Delete product",
                    "Search product",
                    "Display list",
                    "Quit"));

    private static Scanner scanner;

    public static void start() {
        init();
        startMasterRoutine();
    }

    public static void shutdown() {
        scanner.close();
    }

    private static void init() {
        scanner = new Scanner(System.in);
        ProductRepository.getInstance();
        ProductRepository.getIterator();
    }

    private static String getInput() {
        return getInput("$ ");
    }

    private static String getInput(String prefix) {
        System.out.print(prefix);

        return scanner.nextLine();
    }

    private static void startMasterRoutine() {
        int option;

        while (true) {
            for (int i = 0; i < COMMAND_LIST.size(); i++) {
                System.out.printf(
                        "[%d] %s\n",
                        i,
                        COMMAND_LIST.get(i));
            }

            try {
                option = Integer.parseUnsignedInt(getInput());
            } catch (NumberFormatException e) {
                option = -1;
            }

            switch (option) {
                case 0:
                    ProductHandler.add();
                    break;
                case 1:
                    ProductHandler.modify();
                    break;
                case 2:
                    ProductHandler.delete();
                    break;
                case 3:
                    ProductHandler.search();
                    break;
                case 4:
                    ProductHandler.display();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }
}

public class Shop {
    public static void main(String[] args) {
        App.start();
        App.shutdown();
    }
}
