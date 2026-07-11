import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Appointment> appointment = new ArrayList<Appointment>();
    public static Scanner sc = new Scanner(System.in);


public static void addAppointment() {

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
        int choise = sc.nextInt();
        if(choise == 1) {

        }
        else if(choise == 2) {
            
        }
        else if(choise == 3) {
            
        }
        else if(choise == 4) {
            
        }
        else if(choise == 5) {
            
        }
        else if(choise == 6) {
            
        }
        else if(choise == 7) {
            
        }
        else {
            System.out.println("Invalid option. Choose a number from 1 to 7!");
        }
    }
}

}
