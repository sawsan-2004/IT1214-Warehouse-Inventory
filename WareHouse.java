import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n===== Warehouse Menu =====");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    Item item = new Item(id, name, qty, price);
                    inventory.addItem(item);
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    inventory.removeItem(scanner.nextLine());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();

                    inventory.updateQuantity(updateId, newQty);
                    break;

                case 4:
                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by Name");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    if (option == 1) {
                        System.out.print("Enter ID: ");
                        Item result = inventory.searchById(scanner.nextLine());
                        if (result != null) {
                            System.out.println(result);
                        } else {
                            System.out.println("Item not found!");
                        }
                    } else {
                        System.out.print("Enter Name: ");
                        inventory.searchByName(scanner.nextLine());
                    }
                    break;

                case 5:
                    inventory.displayAll();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}