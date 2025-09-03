import java.util.Scanner;

class InventoryManage {

    final int MAX_ITEMS = 100;
    int itemCount = 0;
    String name[];
    int id[];
    int quantity[];
    int buyPrice[];
    int sellPrice[];

    public InventoryManage() {

        name = new String[MAX_ITEMS];
        id = new int[MAX_ITEMS];
        quantity = new int[MAX_ITEMS];
        buyPrice = new int[MAX_ITEMS];
        sellPrice = new int[MAX_ITEMS];
    }

    public void addInventory(String name, int id, int quantity, int buyPrice, int sellPrice) {

        if (itemCount >= MAX_ITEMS) {

            System.out.println("Inventory is full!");
            return;
        }

        this.name[itemCount] = name;
        this.id[itemCount] = id;
        this.quantity[itemCount] = quantity;
        this.buyPrice[itemCount] = buyPrice;
        this.sellPrice[itemCount] = sellPrice;

        itemCount++;

        System.out.println("Item added to storage");
    }

    public void displayInventory() {

        for (int j = 0; j < itemCount; j++) {

            System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.println("Id : " + id[j]);
            System.out.println("Name : " + name[j]);
            System.out.println("Quantity : " + quantity[j]);
            System.out.println("Buying Price : " + buyPrice[j]);
            System.out.println("Selling Price : " + sellPrice[j]);
            System.out.println("-----------------------------------------------");
            System.out.println();
        }
    }
}

public class MedicalIn {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryManage inventoryManager = new InventoryManage();
        boolean flag = true;

        while (flag) {

            System.out.println("1. Adding new items.");
            System.out.println("2. Displaying all item");
            System.out.print("-> ");

            int userChoice;
            try {

                userChoice = Integer.parseInt(sc.nextLine());
                if (userChoice != 1 && userChoice != 2 && userChoice != 3) {

                    System.out.println("Invalid number!");
                    continue;
                }
            } catch (NumberFormatException e) {
                
                System.out.println("Invalid choice! Please enter a number.");
                continue;
            }

            if (userChoice == 1) {

                System.out.println();

                System.out.print("Enter Id of Item : ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Name of Item : ");
                String name = sc.nextLine();

                System.out.print("Enter Quantity of Item : ");
                int quantity = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Buying Price of Item : ");
                int buyPrice = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Selling Price of Item : ");
                int sellPrice = Integer.parseInt(sc.nextLine());

                System.out.println();

                inventoryManager.addInventory(name, id, quantity, buyPrice, sellPrice);
            } 
            else if (userChoice == 2){

                inventoryManager.displayInventory();
            }
            else {
                flag = false;
                sc.close();
            }
        }
    }
}