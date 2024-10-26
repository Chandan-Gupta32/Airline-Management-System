/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

/**
 *
 * @author adrianadewunmi
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mainframe extends JFrame {

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }

    public Mainframe() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    private void initialize() {

        setForeground(Color.CYAN);
        setLayout(null);

        JLabel NewLabel = new JLabel("");
        NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg")));
        NewLabel.setBounds(0, 0, 1268, 654);
        add(NewLabel);

        JLabel AirlineManagementSystem = new JLabel("CKG Airlines Welcomes YOU");
        JLabel DevelopedBy = new JLabel("<html>Developed By<br>Chandan Kumar Gupta</html>");
        AirlineManagementSystem.setForeground(Color.BLUE);

        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
        AirlineManagementSystem.setBounds(400, 60, 1000, 55);

        DevelopedBy.setFont(new Font("Tahoma", Font.BOLD, 16));
        DevelopedBy.setBounds(1050, 550, 200, 55);

        NewLabel.add(AirlineManagementSystem);
        NewLabel.add(DevelopedBy);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("FLIGHT_INFO");
        AirlineSystem.add(FlightDetails);

        JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
        AirlineSystem.add(ReservationDetails);

        JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
        AirlineSystem.add(PassengerDetails);

        JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");
        AirlineSystem.add(SectorDetails_1);

        JMenuItem Cancellation = new JMenuItem("CANCELLATION");
        AirlineSystem.add(Cancellation);

        JMenu exit = new JMenu("Logout");
        exit.setForeground(Color.RED);
        menuBar.add(exit);

        JMenuItem logout = new JMenuItem("Logout");
        exit.add(logout);

        FlightDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Flight_Info();
            }
        });

        ReservationDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Add_Customer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        PassengerDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        SectorDetails_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new Payment_Details();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Cancellation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Cancel();
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });

        setSize(1950, 1090);
        setVisible(true);
    }
}
