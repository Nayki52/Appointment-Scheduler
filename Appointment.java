import java.time.LocalDate;
import java.time.LocalTime;


class Appointment {

    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;



    public Appointment(int id, String title, String description, LocalDate date, LocalTime starTime, LocalTime endTime, String location) {
        this.id =  id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = starTime;
        this.endTime = endTime;
        this.location = location;
    }

    int getId() {
        return id;
    }

    void setId (int id) {
        this.id = id;
    }
    
     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter and Setter for startTime
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    // Getter and Setter for endTime
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void showInfo() {
    System.out.println("Appointment ID: " + id);
    System.out.println("Title: " + title);
    System.out.println("Description: " + description);
    System.out.println("Date: " + date);
    System.out.println("Start Time: " + startTime);
    System.out.println("End Time: " + endTime);
    System.out.println("Location: " + location);
    }
}
