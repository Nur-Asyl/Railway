package menu.UserMenu;

import java.sql.*;
import java.util.Scanner;

public class UserMenu {

    public void showMenu() {

        Connection conn = null;
        try {
            String url = "jdbc:postgresql://127.0.0.1:2077/Passengers";
            String user = "postgres";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            Scanner sc = new Scanner(System.in);
            int choice;
            while (true) {
                System.out.println("----------------------------------\n" +
                        "Choose option:\n" +
                        "1) Users \n" +
                        "2) Trains");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("----------------------------------\n" +
                                "\t|Choose option:\n" +
                                "\t|1) passengers \n" +
                                "\t|2) sell tickets \n" +
                                "\t|3) return ticket \n" +
                                "\t|4) change tickets \n" +
                                "\t|5) change train in the ticket \n" +
                                "\t|6) change car in the ticket");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                Read(conn);
                                System.out.println("----------------------------------\n" +
                                        "\t|Choose passenger's id to edit:\n");
                                Update(conn, sc.nextInt());
                                break;
                        }
                        break;
                }

            }

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                //rs.close();
                //stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
    public void Read (Connection conn) throws SQLException {
        String sql = "SELECT * FROM passengers";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("Id") + "| Name: " + rs.getString("name") +
                    " | Age: " + rs.getInt("age") +
                    " | Disable: " + rs.getString("disable") +
                    " | Ticket: " + rs.getString("ticket_number"));
        }
        rs.close();
        stmt.close();
    }

    public void Update (Connection conn,int id) throws SQLException {
        String sql = "SELECT * FROM passengers";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("Id") + "| Name: " + rs.getString("name") +
                    " | Age: " + rs.getInt("age") +
                    " | Disable: " + rs.getString("disable") +
                    " | Ticket: " + rs.getString("ticket_number"));
        }
        rs.close();
        stmt.close();
    }
}
