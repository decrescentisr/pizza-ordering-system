package ContactList;
import helpers.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ContactList {
    public static void main(String args[]) {
    	
    	ApplicationHelpers.displayApplicationInformation("Contact List", "Week 6", "Swing and Database Connection");
        Contact contact = new Contact();
        contact.setFullName(getInput("Name:"));
        contact.setPhoneNumber(StringHelpers.formattedPhone(getInput("Phone Number:")));
        if(ContactData.saveContactData(contact))
            OutputHelpers.showStandardDialog("Client information has been written to file.", "Contacts");
        else
            OutputHelpers.showExceptionDialog("Unable to save contact.","Error");
        ArrayList<Contact> contactList = ContactData.readContacts();
        displayDatabaseContacts(contactList);

    }

    public static void displayDatabaseContacts(ArrayList<Contact> cl) {
        if(!cl.isEmpty()) {
            for (Contact c : cl) {
                System.out.println(c);
            }
        } else {
            System.out.println("No contacts found.");
        }
    }

    public static String getInput(String input)
    {

        String stringInput = "";
        stringInput = JOptionPane.showInputDialog(" Enter your " + input);

        return stringInput;

    }
}