package astratech.mindcare.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reminder_id;

    private String reminder_tipe;

    private String reminder_konten;

    private String status;


    public Reminder(int reminder_id, String reminder_tipe, String reminder_konten, String status) {
        this.reminder_id = reminder_id;
        this.reminder_tipe = reminder_tipe;
        this.reminder_konten = reminder_konten;
        this.status = status;
    }

    public Reminder() {

    }

    public int getReminder_id() {
        return reminder_id;
    }

    public void setReminder_id(int reminder_id) {
        this.reminder_id = reminder_id;
    }

    public String getReminder_tipe() {
        return reminder_tipe;
    }

    public void setReminder_tipe(String reminder_tipe) {
        this.reminder_tipe = reminder_tipe;
    }

    public String getReminder_konten() {
        return reminder_konten;
    }

    public void setReminder_konten(String reminder_konten) {
        this.reminder_konten = reminder_konten;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
