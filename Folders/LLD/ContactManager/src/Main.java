import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactService user1 = new ContactService();
        boolean cont = true;
        while (cont) {
            System.out.println("-----CONTACT MANAGER-----");
            System.out.println("1.Add Contact\n" +
                    "2.Delete Contact\n" +
                    "3.Update Contact\n" +
                    "4.Display Contact\n" +
                    "5.Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    user1.addContact();
                    break;
                case 2:
                    System.out.print("Enter name:");
                    String name = sc.next();
                    user1.deleteContact(name);
                    break;
                case 3:
                    System.out.print("Enter name:");
                    String updateName = sc.next();
                    user1.updateContact(updateName);
                    break;
                case 4:
                    user1.displayContacts();
                    break;
                case 5:
                    cont = false;
                    System.out.println("----Exiting app----");
                    break;
            }
        }
        sc.close();
    }
}