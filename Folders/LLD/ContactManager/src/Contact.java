public class Contact {
    private String name;
    private String phoneNumber;

//    Contact() {
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String newName) {
        name = newName;
        System.out.println("Name successfully changed.");
    }

    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
        System.out.println("Phone number successfully changed.");
    }

    public String toString() {
        return "Name: " + name + ",Phone number: " + phoneNumber;
    }
}
