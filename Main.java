import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Appointment> appointment = new ArrayList<Appointment>();
    public static Scanner sc = new Scanner(System.in);

public static void addAppointment() {
    System.out.print("Enter the id : ");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter the title : ");
    String title = sc.nextLine();

    System.out.print("Enter the description : ");
    String description = sc.nextLine();

    LocalDate date = readFutureDate("Enter date in format yyyy-MM-dd : ");
    LocalTime startTime = readTime("Enter start time HH:mm : ");
    LocalTime endTime = readEndTime("Enter end time HH:mm", startTime);
    System.out.print("Enter the location");
    String location = sc.nextLine();

    Appointment a = new Appointment(id, title, description, date, startTime, endTime, location);
    appointment.add(a);
    System.out.print("Appointment added sucesfuly!");
}


public static LocalDate readFutureDate(String message) {
    while (true) {
        LocalDate date = readDate(message);

        if (!date.isBefore(LocalDate.now())) {
            return date;
        }

        System.out.print("Appointment date cannot be in the past");
    }
}

public static LocalDate readDate(String message) {
    while (true) {
        System.out.print(message);
        String input = sc.nextLine();

        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use yyyy-MM-dd.");
        }
    }
}

public static LocalTime readTime(String message) {
    while (true) {
        System.out.print(message);
        String input = sc.nextLine();

        try {
            return LocalTime.parse(input);
        } catch (DateTimeParseException e) {
            System.out.print("Invalid time format. Use HH:mm.");
        }
    }
}

public static LocalTime readEndTime(String message, LocalTime startTime) {
    while (true) {
        LocalTime endTime = readTime(message);

        if (endTime.isAfter(startTime) ) {
            return endTime;
        }

        System.out.print("End time must be after start time");
    }
}

public static void showAppointment() {
    for(int i = 0; i < appointment.size(); i++) {
        System.out.println("index :" + i);
        appointment.get(i).showInfo();
        System.out.println("\n");
    }
}
public static void showAppointmenByID(int id) {
    for(int i = 0; i < appointment.size(); i++) {
        if(appointment.get(i).getId() == id) {
            appointment.get(i).showInfo();
            return;
        }
    }
}
public static void removeAppointment() {
    if (appointment.isEmpty()) {
        System.out.println("The list is empty. Nothing to remove."); 
        return;
    }
    System.out.println("\n ---Current Appointment---");
    showAppointment();

    System.out.println("Enter the index of the appointment you want to remove");
    int index = sc.nextInt();

    if (index >= 0 && index < appointment.size()) {
        appointment.remove(index);
        System.out.println("Appointment at index " + index + " successfully removed!");
    }
    else {
        System.out.println("Error: Invalid idex! There is no appointment whith this index.");
    }
}
public static void showAppointmentByDate(LocalDate date) {
    for (int i = 0; i < appointment.size(); i++) {
        if (appointment.get(i).getDate().equals(date)) {
            appointment.get(i).showInfo();
        }
    }
}

public static void ShowMenu() {
    System.out.println("1. Add appointment");
    System.out.println("2. View all appointments");
    System.out.println("3. View appointment by ID");
    System.out.println("4. Update appointment");
    System.out.println("5. Delete appointment");
    System.out.println("6. View appointments by date");
    System.out.println("7. Exit");
}

public static void main(String [] args) {
    while(true) {
        ShowMenu();
        System.out.print("Your choise");
        int choise = sc.nextInt();
        if(choise == 1) {
            addAppointment();
        }
        else if(choise == 2) {
            showAppointment();
        }
        else if(choise == 3) {
            System.out.println("Enter id for the appointment you want to see");
            int id = sc.nextInt();
            showAppointmenByID(id);
        }
        else if(choise == 4) {
            
        }
        else if(choise == 5) {
            removeAppointment();
        }
        else if(choise == 6) {
            LocalDate date = readDate("Enter the date yyyy-MM-dd");
            showAppointmentByDate(date);
        }
        else if(choise == 7) {
            System.out.println("Thanks for using our app");
            break;
        }
        else {
            System.out.println("Invalid option. Choose a number from 1 to 7!");
        }
    }
}

}
