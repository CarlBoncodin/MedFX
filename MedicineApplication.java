package ph.edu.dlsu.lbycpei.finalprojectjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ph.edu.dlsu.lbycpei.finalprojectjavafx.objects.*;

import java.io.*;
import java.util.Scanner;

public class MedicineApplication extends Application {

    public static MedicineDatabase mDatabase;
    public static AppointmentDatabase aDatabase;
    public static Cart cart = new Cart();

    public void start(Stage stage) throws Exception {
        importDatabases();
        FXMLLoader mainLoader = new FXMLLoader(MedicineApplication.class.getResource("MainMenu.fxml"));
        Scene mainMenu = new Scene(mainLoader.load());
        stage.setTitle("Medicine/Appointment Interface");
        stage.setScene(mainMenu);
        stage.show();
    }

    public void importDatabases(){
        String filename = "database.txt";

        File databaseFile = new File("assets/"+filename);
        try{
            Scanner fileInput = new Scanner(databaseFile);
            mDatabase = new MedicineDatabase();
            int medicineStorage = fileInput.nextInt();
            for(int counter = 0; counter < medicineStorage; counter++){
                String n = fileInput.next();
                String c = fileInput.next();
                double p = fileInput.nextDouble();
                int s = fileInput.nextInt();
                mDatabase.addMedicine(n, c, p, s);
            }
            aDatabase = new AppointmentDatabase();
            int appointmentStorage = fileInput.nextInt();
            for(int counter = 0; counter < appointmentStorage; counter++){
                String d = fileInput.next();
                String t = fileInput.next();
                boolean s = fileInput.nextBoolean();
                String fn = fileInput.next();
                String ln = fileInput.next();
                String nu = fileInput.next();
                aDatabase.addAppointment(d, t , s, fn, ln, nu);
            }
        }
        catch (FileNotFoundException e){
            return;
        }
    }

    public static void exportDatabases() {

        String filename = "database.txt";
        try {
            FileWriter exportFile = new FileWriter("assets/" + filename, false);
            exportFile.write(mDatabase.getMedicineCount() + "\n");
            for (int counter = 0; counter < mDatabase.getMedicineCount(); counter++){
                exportFile.write(mDatabase.getMedicine(counter).getName() + " " +
                                mDatabase.getMedicine(counter).getCategory() + " " +
                                mDatabase.getMedicine(counter).getPrice() + " " +
                                mDatabase.getMedicine(counter).getStock() + "\n"
                                );
            }
            exportFile.write("\n" + aDatabase.getAppointmentCount() + "\n");
            for (int counter = 0; counter < aDatabase.getAppointmentCount(); counter++){
                exportFile.write(aDatabase.getAppointment(counter).getDate() + " " +
                        aDatabase.getAppointment(counter).getTime() + " " +
                        aDatabase.getAppointment(counter).isScheduled() + "\n" +
                        aDatabase.getAppointment(counter).getFirstName() + " " +
                        aDatabase.getAppointment(counter).getLastName() + " " +
                        aDatabase.getAppointment(counter).getNumber() + "\n"
                        );
            }
            exportFile.close();
        } catch (IOException e) {
            return;
        }
    }

    public MedicineDatabase getMedDatabase() {
        return mDatabase;
    }

    public AppointmentDatabase getAppointDatabase() {
        return aDatabase;
    }

//    public void appointMenu(){
//        int choice;
//        do {
//            println("""
//
//                    Select an option:
//                    1. Add an appointment.
//                    2. Take an appointment.
//                    3. View appointment schedule.
//                    0. Return to Main Menu.
//
//                    """);
//            choice = readInt();
//            switch(choice){
//                case 1 -> {
//                    println("Please enter date: <MM/DD/YYYY>");
//                    String d = readLine();
//                    println("Please enter time: <HH:MM>");
//                    String t = readLine();
//                    aDatabase.addAppointmentSchedule(d, t);
//                    println("Appointment added.");
//                }
//                case 2 -> {
//                    println("Please enter date of appointment: <MM/DD/YYYY>");
//                    String searchDate = readLine();
//                    println("Please enter time of appointment: <HH:MM>");
//                    String searchTime = readLine();
//
//                    Appointment foundAppoint = aDatabase.searchAppointment(searchDate, searchTime);
//                    if (foundAppoint != null){
//                        println("Enter first name: ");
//                        String fn = readLine();
//                        println("Enter last name: ");
//                        String ln = readLine();
//                        println("Enter contact number: ");
//                        String nu = readLine();
//
//                        aDatabase.takeAppointment(foundAppoint, fn, ln, nu);
//                        println("Appointment set.");
//                    }
//                    else println("Appointment not found.");
//                }
//                case 3 -> {
//                    for(int counter = 0; counter < aDatabase.getAppointmentCount(); counter++){
//                        viewAppointment(aDatabase.getAppointment(counter));
//                    }
//                }
//            }
//        } while (choice != 0);
//    }
//
//    public void viewAppointment(Appointment a){
//        println("Date: "+ a.getDate());
//        println("Time: "+ a.getTime());
//        if (a.isScheduled()){
//            println("Scheduled Person:");
//            println("First Name: "+ a.getFirstName());
//            println("Last Name: "+ a.getLastName());
//            println("Contact Number:" + a.getNumber());
//        }
//        else println("Appointment not taken yet.");
//        println();
//    }
}
