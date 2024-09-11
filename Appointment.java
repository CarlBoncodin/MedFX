package ph.edu.dlsu.lbycpei.finalprojectjavafx.objects;

public class Appointment {
    public String date;
    public String time;
    public boolean scheduled;
    private String firstName;
    private String lastName;
    private String number;

    public Appointment(String d, String t, boolean s, String fn, String ln, String nu){
        date = d;
        time = t;
        scheduled = s;
        firstName = fn;
        lastName = ln;
        number = nu;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setScheduled(boolean scheduled) {
        this.scheduled = scheduled;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
