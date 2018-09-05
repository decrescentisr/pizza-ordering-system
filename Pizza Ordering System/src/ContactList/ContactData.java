package ContactList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import helpers.DatabaseHelpers;

public class ContactData {

    private static String userName = "5354";
    private static String password = "devry_student";

    public static boolean saveContactData(Contact contact) {
        Boolean success = false;
        PreparedStatement statement = null;
        StringBuilder sqlStr = new StringBuilder();

        try {
            success = openDataBaseConnection();
            if(success)
            {
                //build the SQL query string
                sqlStr.append("INSERT INTO ");
                sqlStr.append("Contact");
                sqlStr.append(" (FullName, PhoneNumber)");
                sqlStr.append(" values(?, ?, ?)");

                //get the connection and set the statement to connect to the database/table
                statement = DatabaseHelpers.getConnection().prepareStatement(sqlStr.toString());
                statement.setString(1, contact.getFullName());
                statement.setString(2, contact.getPhoneNumber());

                //execute the query
                statement.executeUpdate();
                success = true;
            }


        }
        catch  (SQLException e) {
            success = false;
        }
        finally {
            closeDataBaseConnection();
        }
        return success;
    }

    public static ArrayList<Contact> readContacts() {
        Boolean success = false;
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        PreparedStatement statement = null;
        String sqlStr = "SELECT FullName, PhoneNumber FROM Contact";

        try {
            success = openDataBaseConnection();
            if(success)
            {
              //get the connection and set the statement to connect to the database/table
                statement = DatabaseHelpers.getConnection().prepareStatement(sqlStr);

                //build ArrayList to return
                ResultSet rs = statement.executeQuery();
                while(rs.next())
                {
                    Contact c = new Contact(rs.getString(1),rs.getString(2));

                    contactList.add(c);
                }
                success = true;
            }


        }
        catch  (SQLException e) {
            success = false;
        }
        finally {
            closeDataBaseConnection();
        }
        return contactList;
    }

    private static boolean openDataBaseConnection()
    {
        Boolean success = false;
        success = DatabaseHelpers.setConnection(userName, password);
        return success;
    }
    private static void closeDataBaseConnection()
    {
        try {
            DatabaseHelpers.closeConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
