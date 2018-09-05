package ContactList;

public class Contact {
    private String fullName;
    private String phoneNumber;

    public Contact() {
        this("","");
    }

    public Contact(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public void setFullName(String fullName) {
        if(fullName.isEmpty()) {
            this.fullName = "";
        } else {
            this.fullName = fullName;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.isEmpty()) {
            this.phoneNumber = "";
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return "Name: " + getFullName() + "\nPhone Number: " + getPhoneNumber();
    }
}
