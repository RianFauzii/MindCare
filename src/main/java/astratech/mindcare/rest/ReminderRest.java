package astratech.mindcare.rest;

import astratech.mindcare.Model.Reminder;
import astratech.mindcare.Service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reminder")
public class ReminderRest {

    @Autowired
    ReminderService reminderService;

    @GetMapping("/alldata")
    public List<Reminder> getAllData(){
        List<Reminder> list = reminderService.getAllData();
        return list;
    }

    @GetMapping("/data")
    public Reminder getData(@RequestParam("id") int id){
        Reminder obj = reminderService.findById(id);
        return obj;
    }

    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_konten") String tambah_konten
            , @RequestParam(value="tambah_tipe") String tambah_tipe){
        Reminder obj = new Reminder();
        obj.setReminder_konten(tambah_konten);
        obj.setReminder_tipe(tambah_tipe);

        obj.setStatus("Aktif");

        reminderService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/reminder/daftar")).build();

    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id") int edit_id
            , @RequestParam(value="edit_konten") String edit_konten
            , @RequestParam(value="edit_tipe") String edit_tipe
           ){
        Reminder obj = reminderService.findById(edit_id);
        obj.setReminder_konten(edit_konten);
        obj.setReminder_tipe(edit_tipe);


        reminderService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/reminder/daftar")).build();

    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_reminder") int id){
        Reminder obj = reminderService.findById(id);
        reminderService.delete(obj.getReminder_id());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/reminder/daftar")).build();
    }

}
