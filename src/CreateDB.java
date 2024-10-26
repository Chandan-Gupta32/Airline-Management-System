
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public static void main(String[] args) {
        // Database connection variables
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root"; // replace with your database username
        String password = "Ckg@2003"; // replace with your database password

        // SQL commands
        String createDatabase = "CREATE DATABASE IF NOT EXISTS ams;";
        String useDatabase = "USE ams;";
        
        String createCancellationTable = """
            CREATE TABLE IF NOT EXISTS cancellation (
                pnr_no VARCHAR(255),
                cancellaton_no VARCHAR(255),
                cancellation_data VARCHAR(255),
                fli_code VARCHAR(255)
            );
        """;

        String createFlightTable = """
            CREATE TABLE IF NOT EXISTS flight (
                f_code VARCHAR(255),
                f_name VARCHAR(255),
                src VARCHAR(255),
                dst VARCHAR(255)
            );
        """;

        String createLoginTable = """
            CREATE TABLE IF NOT EXISTS login (
                username VARCHAR(255),
                password VARCHAR(255)
            );
        """;

        String createPassengerTable = """
            CREATE TABLE IF NOT EXISTS passenger (
                pnr_no VARCHAR(255),
                address VARCHAR(255),
                nationality VARCHAR(255),
                name VARCHAR(255),
                gender VARCHAR(255),
                ph_no VARCHAR(255),
                passport_no VARCHAR(255),
                fl_code VARCHAR(255)
            );
        """;

        String createPaymentTable = """
            CREATE TABLE IF NOT EXISTS payment (
                pnr_no VARCHAR(255),
                ph_no VARCHAR(255),
                cheque_no VARCHAR(255),
                card_no VARCHAR(255),
                paid_amt VARCHAR(255),
                pay_date VARCHAR(255)
            );
        """;

        String createReservationTable = """
            CREATE TABLE IF NOT EXISTS reservation (
                pnr_no VARCHAR(255),
                ticket_id VARCHAR(255),
                f_code VARCHAR(255),
                jny_date VARCHAR(255),
                jny_time VARCHAR(255),
                src VARCHAR(255),
                dst VARCHAR(255)
            );
        """;

        String createSectorTable = """
            CREATE TABLE IF NOT EXISTS sector (
                flight_code VARCHAR(255),
                capacity VARCHAR(255),
                class_code VARCHAR(255),
                class_name VARCHAR(255)
            );
        """;

        String insertLogin = "INSERT INTO login (username, password) VALUES ('admin', '12345');";

        try (Connection conn = DriverManager.getConnection(url, user, password); 
             Statement stmt = conn.createStatement()) {

            // Create database and switch to it
            stmt.executeUpdate(createDatabase);
            stmt.execute(useDatabase);

            // Create tables
            stmt.executeUpdate(createCancellationTable);
            stmt.executeUpdate(createFlightTable);
            stmt.executeUpdate(createLoginTable);
            stmt.executeUpdate(createPassengerTable);
            stmt.executeUpdate(createPaymentTable);
            stmt.executeUpdate(createReservationTable);
            stmt.executeUpdate(createSectorTable);

            // Insert initial login value
            stmt.executeUpdate(insertLogin);

            System.out.println("Database and tables created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
