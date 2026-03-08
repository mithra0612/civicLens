import java.util.*;

public class ContactService {
    private Map<Character, List<Contact>> contacts;

    ContactService() {
        contacts = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            contacts.put((char) ('A' + i), new ArrayList<>());
        }
        System.out.println("Contact Book Created.");
    }

    public void addContact() {
        Contact contact = new Contact();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.next();

        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);

        contacts.get(name.charAt(0)).add(contact);

        System.out.print("Added contact: ");
        System.out.println(contact);
    }

    public void deleteContact(String name) {
        char key = name.charAt(0);
        List<Contact> contactsList = contacts.get(key);

        boolean found = false;

        for (Contact contact : contactsList) {
            if (contact.getName().equals(name)) {
                contactsList.remove(contact);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Contact Details Deleted.");
        }
    }

    public void displayContacts() {
        for (Character key : contacts.keySet()) {
            System.out.println(key);
            List<Contact> contactsList = contacts.get(key);

            for (Contact contact : contactsList) {
                System.out.println(contact);
            }
        }
    }

    public void updateContact(String name) {
        char key = name.charAt(0);
        List<Contact> contactsList = contacts.get(key);

        boolean found = false;

        for (Contact contact : contactsList) {
            if (contact.getName().equals(name)) {

                Scanner sc = new Scanner(System.in);

                System.out.print("Update Name? (yes/no) ");
                String nameUpdate = sc.next();

                if (nameUpdate.equals("yes")) {
                    System.out.print("Enter updated name: ");
                    String newName = sc.next();
                    contact.setName(newName);
                }

                System.out.print("Update Phone Number? (yes/no) ");
                String numberUpdate = sc.next();

                if (numberUpdate.equals("yes")) {
                    System.out.print("Enter updated phone number: ");
                    String newNumber = sc.next();   // changed to String
                    contact.setPhoneNumber(newNumber);
                }

                System.out.println("Updated contact: " + contact);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Contact Details Updated.");
        }
    }
}