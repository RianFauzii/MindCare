package astratech.mindcare.Service;

import astratech.mindcare.Model.Reminder;
import astratech.mindcare.Repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    @Autowired
    ReminderRepository reminderRepository;

    public List<Reminder> getAllData(){
        List<Reminder> reminderList = (List<Reminder>) reminderRepository.findReminderByStatus("Aktif");
        return reminderList;
    }

    public void save(Reminder reminder){
        reminder.setStatus("Aktif");
        reminderRepository.save(reminder);
    }

    public Reminder findById(int id){
        Reminder reminder = reminderRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        return reminder;
    }

    public void delete(int id){
        Reminder tempReminder = reminderRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempReminder.setStatus("Tidak Aktif");
        reminderRepository.save(tempReminder);
    }

    public void update(int id,Reminder reminder){
        Reminder tempReminder = reminderRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempReminder.setReminder_konten(reminder.getReminder_konten());
        tempReminder.setReminder_tipe(reminder.getReminder_tipe());
        reminderRepository.save(tempReminder);
    }

}
