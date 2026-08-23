import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

public class AppointmentGui {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Appointment-Scheduler");

        frame.setSize(500, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        DefaultListModel<String> ListModel = new DefaultListModel<>();

        JList<String> allAppointmentsList = new JList<>(ListModel);
        JPanel allAppointmentsPanel = new JPanel();
        allAppointmentsPanel.setLayout(new BoxLayout(allAppointmentsPanel, BoxLayout.Y_AXIS));
        JLabel allSpendingsLable = new JLabel("All Appointments", SwingConstants.CENTER);
        JScrollPane horizontalPane = new JScrollPane(allAppointmentsList);
        frame.add(allSpendingsLable, BorderLayout.NORTH);
        allAppointmentsPanel.add(horizontalPane);
        frame.add(allAppointmentsPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }
}
