import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DummyData {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ams";  // Database URL
        String user = "root";                    // Database username
        String password = "Ckg@2003";                // Database password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Dummy data for each table
            String[] insertCancellation = {
                "INSERT INTO cancellation VALUES ('PNR001', 'CNL001', '2024-10-26', 'F001');",
                "INSERT INTO cancellation VALUES ('PNR002', 'CNL002', '2024-10-27', 'F002');",
                "INSERT INTO cancellation VALUES ('PNR003', 'CNL003', '2024-10-28', 'F003');",
                "INSERT INTO cancellation VALUES ('PNR004', 'CNL004', '2024-10-29', 'F004');",
                "INSERT INTO cancellation VALUES ('PNR005', 'CNL005', '2024-10-30', 'F005');"
            };

            String[] insertFlight = {
                "INSERT INTO flight VALUES ('F001', 'FlightA', 'MUMBAI', 'BANGALORE');",
                "INSERT INTO flight VALUES ('F002', 'FlightB', 'BANGALORE', 'HYDERABAD');",
                "INSERT INTO flight VALUES ('F003', 'FlightC', 'CHENNAI', 'MUMBAI');",
                "INSERT INTO flight VALUES ('F004', 'FlightD', 'DELHI', 'CHENNAI');",
                "INSERT INTO flight VALUES ('F005', 'FlightE', 'HYDERABAD', 'DELHI');"
            };

            String[] insertLogin = {
                "INSERT INTO login VALUES ('user1', 'pass1');",
                "INSERT INTO login VALUES ('user2', 'pass2');",
                "INSERT INTO login VALUES ('user3', 'pass3');",
                "INSERT INTO login VALUES ('user4', 'pass4');",
                "INSERT INTO login VALUES ('user5', 'pass5');"
            };

            String[] insertPassenger = {
                "INSERT INTO passenger VALUES ('PNR001', 'Address1', 'Delhi', 'John Doe', 'Male', '1234567890', 'P001', 'F001');",
                "INSERT INTO passenger VALUES ('PNR002', 'Address2', 'Chandigarh', 'Jane Smith', 'Female', '1234567891', 'P002', 'F002');",
                "INSERT INTO passenger VALUES ('PNR003', 'Address3', 'Bhubaneswar', 'Emily Johnson', 'Female', '1234567892', 'P003', 'F003');",
                "INSERT INTO passenger VALUES ('PNR004', 'Address4', 'Mumbai', 'Chris Lee', 'Male', '1234567893', 'P004', 'F004');",
                "INSERT INTO passenger VALUES ('PNR005', 'Address5', 'Ambala', 'Emma Brown', 'Female', '1234567894', 'P005', 'F005');"
            };

            String[] insertPayment = {
                "INSERT INTO payment VALUES ('PNR001', '1234567890', 'CHK001', 'CARD001', '1000', '2024-10-26');",
                "INSERT INTO payment VALUES ('PNR002', '1234567891', 'CHK002', 'CARD002', '1200', '2024-10-27');",
                "INSERT INTO payment VALUES ('PNR003', '1234567892', 'CHK003', 'CARD003', '1500', '2024-10-28');",
                "INSERT INTO payment VALUES ('PNR004', '1234567893', 'CHK004', 'CARD004', '2000', '2024-10-29');",
                "INSERT INTO payment VALUES ('PNR005', '1234567894', 'CHK005', 'CARD005', '2500', '2024-10-30');"
            };

            String[] insertReservation = {
                "INSERT INTO reservation VALUES ('PNR001', 'TICKET001', 'F001', '2024-11-01', '10:00', 'MUMBAI', 'BANGALORE');",
                "INSERT INTO reservation VALUES ('PNR002', 'TICKET002', 'F002', '2024-11-02', '12:00', 'BANGALORE', 'HYDERABAD');",
                "INSERT INTO reservation VALUES ('PNR003', 'TICKET003', 'F003', '2024-11-03', '14:00', 'CHENNAI', 'MUMBAI');",
                "INSERT INTO reservation VALUES ('PNR004', 'TICKET004', 'F004', '2024-11-04', '16:00', 'DELHI', 'CHENNAI');",
                "INSERT INTO reservation VALUES ('PNR005', 'TICKET005', 'F005', '2024-11-05', '18:00', 'HYDERABAD', 'DELHI');"
            };

            String[] insertSector = {
                "INSERT INTO sector VALUES ('F001', '200', 'C01', 'Economy');",
                "INSERT INTO sector VALUES ('F002', '150', 'C02', 'Business');",
                "INSERT INTO sector VALUES ('F003', '180', 'C03', 'First Class');",
                "INSERT INTO sector VALUES ('F004', '220', 'C04', 'Premium Economy');",
                "INSERT INTO sector VALUES ('F005', '250', 'C05', 'Economy');"
            };

            // Inserting data into each table
            insertData(stmt, insertCancellation);
            insertData(stmt, insertFlight);
            insertData(stmt, insertLogin);
            insertData(stmt, insertPassenger);
            insertData(stmt, insertPayment);
            insertData(stmt, insertReservation);
            insertData(stmt, insertSector);

            System.out.println("Dummy data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Statement stmt, String[] queries) throws SQLException {
        for (String query : queries) {
            stmt.executeUpdate(query);
        }
    }
}
