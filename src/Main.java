import model.GroceryList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroceryList groceryList = new GroceryList();
        int choice;
        do{
            System.out.println("Yapılmak istenen operasyonu seçin(0: quit, 1: ekleme, 2: çıkarma):");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("eklenmesi istediğiniz elemanları giriniz: (birden fazlaysa virgül kullanınız)");
                    String itemsToAdd = scanner.nextLine();
                    groceryList.addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("silinmesini istediğiniz elemanları giriniz: (birden fazlaysa virgül kullanınız)");
                    String itemsToRemove = scanner.nextLine();
                    groceryList.removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("0,1,2 arasında değer seçmeniz gerekiyor");
                    break;
            }
            groceryList.printSorted();
        }while (choice !=0);
        scanner.close();
    }
}