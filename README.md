# 📅 Appointment Scheduler

A simple Java desktop application for creating and managing appointments.

## 📸 Screenshots

### Main Window

<!-- Insert main window screenshot here -->

<img width="1012" height="612" alt="Знімок екрана 2026-08-27 о 21 06 31" src="https://github.com/user-attachments/assets/b9e0650b-40ca-428e-8ffb-b950a88c3067" />


The main window displays all appointments and provides access to the main appointment management functions.

---

## ⚙️ Features

### ➕ Add Appointment

<!-- Insert screenshot here -->

<img width="412" height="462" alt="Знімок екрана 2026-08-27 о 21 06 36" src="https://github.com/user-attachments/assets/211e769d-9b93-456d-9eb7-b535c20f378f" />


Create a new appointment by entering the **ID, title, description, date, start time, end time, and location**.
Press **OK** to add the appointment or **Cancel** to close the window.

### ✏️ Update Appointment

<!-- Insert screenshot here -->

<img width="412" height="462" alt="Знімок екрана 2026-08-27 о 21 06 53" src="https://github.com/user-attachments/assets/6ff00638-d417-4e31-a3d0-a77f1fa157a8" />


Select an appointment from the list and press **Update Appointment**.
The existing information is loaded into the form and can be changed before saving.

### 🗑️ Remove Appointment

<!-- Insert screenshot here -->

<img width="385" height="285" alt="Знімок екрана 2026-08-27 о 21 06 58" src="https://github.com/user-attachments/assets/01bda4fc-22a2-4066-b748-62b49d747242" />


Select an appointment and press **Remove Appointment**.
A confirmation window appears before the appointment is permanently removed.

### 📂 Load Appointments

<!-- Insert screenshot here -->

<img width="1012" height="612" alt="Знімок екрана 2026-08-27 о 21 07 05" src="https://github.com/user-attachments/assets/5c242f99-0750-47f6-8b4a-31782460c4ec" />


Load previously saved appointments from the `Appointments.txt` file.

### 💾 Save Appointments

<!-- Insert screenshot here -->

<img width="459" height="285" alt="Знімок екрана 2026-08-27 о 21 07 09" src="https://github.com/user-attachments/assets/723dc0fb-9037-42f2-9370-69709909ec69" />


Save all current appointments to the `Appointments.txt` file for later use.

---

## 🛠️ Technologies

* Java
* Java Swing
* ArrayList
* LocalDate & LocalTime
* File I/O
* Object-Oriented Programming

## 📂 Project Structure

```text
Appointment-Scheduler/
├── Appointment.java
├── AppointmentGui.java
├── Main.java
├── Appointments.txt
└── README.md
```

## 🚀 How to Run

```bash
git clone https://github.com/Nayki52/Appointment-Scheduler.git
cd Appointment-Scheduler
javac *.java
java Main
```

## 👨‍💻 Author

**Nayki52**

Created as a Java CRUD project for learning and portfolio purposes.
