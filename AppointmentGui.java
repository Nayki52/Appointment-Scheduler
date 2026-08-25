import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentGui {
    public static ArrayList<Appointment> appointment = new ArrayList<Appointment>();
    public static Scanner sc = new Scanner(System.in);
    public static String fileName = "Appointments.txt";

    public static void main(String[] args) {

        JFrame frame = new JFrame("Appointment-Scheduler");

        frame.setSize(900, 500);

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

        JPanel buttonsPanel = new JPanel();

        JButton addButton = new JButton("Add Appointmet");
        buttonsPanel.add(addButton);
        JButton updateButton = new JButton("Update Appointment");
        buttonsPanel.add(updateButton);
        JButton removeButton = new JButton("Remove Appointment");
        buttonsPanel.add(removeButton);
        JButton loadButton = new JButton("Load Appointments");
        buttonsPanel.add(loadButton);
        JButton saveButton = new JButton("Save Appointments");
        buttonsPanel.add(saveButton);

        frame.add(buttonsPanel, BorderLayout.SOUTH);

        addButton.addActionListener(event -> {
            JFrame addPanel = new JFrame();

            JLabel idLabel = new JLabel("ID:");
            JTextField idField = new JTextField();
            JLabel titleLabel = new JLabel("Title:");
            JTextField titleField = new JTextField();
            JLabel descriptionLabel = new JLabel("Description:");
            JTextField descriptionField = new JTextField();
            JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
            JTextField dateField = new JTextField();
            JLabel startTimeLabel = new JLabel("Start Time (HH:MM):");
            JTextField startTimeField = new JTextField();
            JLabel endTimeLabel = new JLabel("End Time (HH:MM):");
            JTextField endTimeField = new JTextField();
            JLabel locationLabel = new JLabel("Location:");
            JTextField locationField = new JTextField();
            JButton okeyButton = new JButton("OK");

            okeyButton.addActionListener(e -> {
                String idText = idField.getText().trim();
                String title = titleField.getText().trim();
                String description = descriptionField.getText().trim();
                String dateText = dateField.getText().trim();
                String startTimeText = startTimeField.getText().trim();
                String endTimeText = endTimeField.getText().trim();
                String location = locationField.getText().trim();

                if (idText.isEmpty() && title.isEmpty() && description.isEmpty() && dateText.isEmpty()
                        && startTimeText.isEmpty() && endTimeText.isEmpty() && location.isEmpty()) {
                    JOptionPane.showMessageDialog(addPanel, "Please fill in all fields", "Invalid input",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int id = Integer.parseInt(idText);

                    if (id > 0) {

                        LocalDate date = LocalDate.parse(dateText);
                        LocalTime startTime = LocalTime.parse(startTimeText);
                        LocalTime endTime = LocalTime.parse(endTimeText);

                        Appointment newAppointment = new Appointment(id, title, description, date, startTime, endTime,
                                location);
                        appointment.add(newAppointment);
                        ListModel.addElement(newAppointment.toString());

                        addPanel.dispose();
                    }

                } catch (Exception exception) {

                    JOptionPane.showMessageDialog(addPanel,
                            "Please check numbers, date (YYYY-MM-DD) or time (HH:MM) format", "Invalid input",
                            JOptionPane.ERROR_MESSAGE);
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(e -> {
                addPanel.dispose();
            });

            addPanel.setLayout(new GridLayout(8, 2));
            addPanel.add(idLabel);
            addPanel.add(idField);
            addPanel.add(titleLabel);
            addPanel.add(titleField);
            addPanel.add(descriptionLabel);
            addPanel.add(descriptionField);
            addPanel.add(dateLabel);
            addPanel.add(dateField);
            addPanel.add(startTimeLabel);
            addPanel.add(startTimeField);
            addPanel.add(endTimeLabel);
            addPanel.add(endTimeField);
            addPanel.add(locationLabel);
            addPanel.add(locationField);
            addPanel.add(okeyButton);
            addPanel.add(cancelButton);

            addPanel.setSize(300, 350);

            addPanel.setVisible(true);
        });
        updateButton.addActionListener(event -> {

            int selectedIndex = allAppointmentsList.getSelectedIndex();

            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(frame, "Please select an appointment to update", "No selection",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Appointment selectedAppointment = appointment.get(selectedIndex); // или appointment.get(selectedIndex) в
                                                                              // зависимости от коллекции

            JFrame updatePanel = new JFrame("Update Appointment");

            JLabel idLabel = new JLabel("ID:");
            JTextField idField = new JTextField(String.valueOf(selectedAppointment.getId())); // Заполняем текущим ID
            JLabel titleLabel = new JLabel("Title:");
            JTextField titleField = new JTextField(selectedAppointment.getTitle()); // Заполняем текущим Title
            JLabel descriptionLabel = new JLabel("Description:");
            JTextField descriptionField = new JTextField(selectedAppointment.getDescription());
            JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
            JTextField dateField = new JTextField(selectedAppointment.getDate().toString());
            JLabel startTimeLabel = new JLabel("Start Time (HH:MM):");
            JTextField startTimeField = new JTextField(selectedAppointment.getStartTime().toString());
            JLabel endTimeLabel = new JLabel("End Time (HH:MM):");
            JTextField endTimeField = new JTextField(selectedAppointment.getEndTime().toString());
            JLabel locationLabel = new JLabel("Location:");
            JTextField locationField = new JTextField(selectedAppointment.getLocation());
            JButton okeyButton = new JButton("OK");

            okeyButton.addActionListener(e -> {
                String idText = idField.getText().trim();
                String title = titleField.getText().trim();
                String description = descriptionField.getText().trim();
                String dateText = dateField.getText().trim();
                String startTimeText = startTimeField.getText().trim();
                String endTimeText = endTimeField.getText().trim();
                String location = locationField.getText().trim();

                if (idText.isEmpty() && title.isEmpty() && description.isEmpty() && dateText.isEmpty()
                        && startTimeText.isEmpty() && endTimeText.isEmpty() && location.isEmpty()) {
                    JOptionPane.showMessageDialog(updatePanel, "Please fill in all fields", "Invalid input",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int id = Integer.parseInt(idText);

                    if (id > 0) {
                        LocalDate date = LocalDate.parse(dateText);
                        LocalTime startTime = LocalTime.parse(startTimeText);
                        LocalTime endTime = LocalTime.parse(endTimeText);

                        selectedAppointment.setId(id);
                        selectedAppointment.setTitle(title);
                        selectedAppointment.setDescription(description);
                        selectedAppointment.setDate(date);
                        selectedAppointment.setStartTime(startTime);
                        selectedAppointment.setEndTime(endTime);
                        selectedAppointment.setLocation(location);

                        ListModel.set(selectedIndex, selectedAppointment.toString());

                        updatePanel.dispose();
                    }

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(updatePanel,
                            "Please check numbers, date (YYYY-MM-DD) or time (HH:MM) format", "Invalid input",
                            JOptionPane.ERROR_MESSAGE);
                }
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(e -> {
                updatePanel.dispose();
            });

            updatePanel.setLayout(new GridLayout(8, 2));
            updatePanel.add(idLabel);
            updatePanel.add(idField);
            updatePanel.add(titleLabel);
            updatePanel.add(titleField);
            updatePanel.add(descriptionLabel);
            updatePanel.add(descriptionField);
            updatePanel.add(dateLabel);
            updatePanel.add(dateField);
            updatePanel.add(startTimeLabel);
            updatePanel.add(startTimeField);
            updatePanel.add(endTimeLabel);
            updatePanel.add(endTimeField);
            updatePanel.add(locationLabel);
            updatePanel.add(locationField);
            updatePanel.add(okeyButton);
            updatePanel.add(cancelButton);

            updatePanel.setSize(300, 350);
            updatePanel.setVisible(true);
        });

        removeButton.addActionListener(event -> {
            int selectedIndex = allAppointmentsList.getSelectedIndex();
            if (selectedIndex < 0 || selectedIndex >= appointment.size()) {
                JOptionPane.showMessageDialog(frame, "Make a selction first", "Selection neccessary",
                        JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                int result = JOptionPane.showConfirmDialog(frame, "Procied with delition?", "Confirmation",
                        JOptionPane.YES_NO_OPTION);

                // реакция на то, что пользователь выбрал в окне
                if (result == JOptionPane.YES_OPTION) {
                    appointment.remove(selectedIndex);
                    ListModel.remove(selectedIndex);
                }
            }
        });
        loadButton.addActionListener(event -> {
            try {
                File file = new File(fileName);

                if (!file.exists()) {
                    JOptionPane.showMessageDialog(frame, "File " + fileName + " Doesnt exist", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();

                        String[] parts = line.split(";");

                        if (parts.length == 7) {
                            int id = Integer.parseInt(parts[0]);
                            String title = parts[1];
                            String description = parts[2];
                            LocalDate date = LocalDate.parse(parts[3]);
                            LocalTime startTime = LocalTime.parse(parts[4]);
                            LocalTime endTime = LocalTime.parse(parts[5]);
                            String location = parts[6];

                            Appointment s = new Appointment(id, title, description, date, startTime, endTime, location);
                            ListModel.addElement(s.toString());
                            appointment.add(s);
                        }

                    }
                }
            } catch (Exception e) {
                System.out.println("Error while loading appointment");
            }
        });
        saveButton.addActionListener(event -> {
            try {
                File file = new File(fileName);
                FileWriter writer = new FileWriter(file);

                for (Appointment s : appointment) {

                    String line = s.getId() + ";" + s.getTitle() + ";" + s.getDescription() + ";" + s.getDate() + ";"
                            + s.getStartTime() + ";" + s.getEndTime() + ";" + s.getLocation();
                    writer.write(line + "\n");
                }

                writer.close();

                JOptionPane.showMessageDialog(frame, "Appointment saved successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                System.out.println("Error while saving appointment");
            }
        });

        frame.setVisible(true);

    }
}
