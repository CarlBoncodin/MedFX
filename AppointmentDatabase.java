package ph.edu.dlsu.lbycpei.finalprojectjavafx.objects;

import java.util.ArrayList;

public class AppointmentDatabase {

    public int appointmentCount = 0;
    public ArrayList<Appointment> appointmentArray;

    public AppointmentDatabase(){
        appointmentArray = new ArrayList<Appointment>();
    }

    public void addAppointment(String d, String t, boolean s, String fn, String ln, String nu){
        appointmentArray.add(new Appointment(d, t, s, fn, ln, nu));
        appointmentCount++;
    }

    public void addAppointmentSchedule(String d, String t){
        appointmentArray.add(new Appointment(d, t, false, "Null", "Null", "Null"));
        appointmentCount++;
    }

    public void takeAppointment(Appointment a, String fn, String ln, String nu){
        a.setScheduled(true);
        a.setFirstName(fn);
        a.setLastName(ln);
        a.setNumber(nu);
    }

    public int getAppointmentCount() {
        return appointmentCount;
    }

    public Appointment searchAppointment(String d, String t){
        for (int counter = 0; counter < appointmentCount; counter++){
            if (appointmentArray.get(counter).getDate().equalsIgnoreCase(d)){
                if (appointmentArray.get(counter).getTime().equalsIgnoreCase((t))){
                    return appointmentArray.get(counter);
                }
            }
        }
        return null;
    }

    public Appointment getAppointment(int index){
        return appointmentArray.get(index);
    }

}
