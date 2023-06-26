package astratech.mindcare.rest;

import astratech.mindcare.Model.Jurnal;
import astratech.mindcare.Model.Pengguna;
import astratech.mindcare.Model.User;
import astratech.mindcare.Service.JurnalService;
import astratech.mindcare.Service.PenggunaService;
import astratech.mindcare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jurnal")
public class JurnalRest {

    @Autowired
    JurnalService jurnalService;

    @Autowired
    PenggunaService penggunaService;

    @GetMapping("/alldata")
    public List<Jurnal> getAllData(){
        List<Jurnal> list = jurnalService.getAllData();
        return list;
    }

    @GetMapping("/data")
    public Jurnal getData(@RequestParam("id") int id){
        Jurnal obj = jurnalService.findById(id);
        return obj;
    }

    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_id_user") int tambah_id_user

            , @RequestParam(value="tambah_konten") String tambah_konten
            , @RequestParam(value="tambah_tanggal_jurnal") Date tambah_tanggal_jurnal){
        Jurnal obj = new Jurnal();
        //jika fk maka hubungkan dengan service lainnya
        Pengguna mahasiswaservice = penggunaService.findById(tambah_id_user);


        obj.setId_user(mahasiswaservice);
        obj.setKonten(tambah_konten);
        obj.setTanggal_jurnal(tambah_tanggal_jurnal);

        obj.setStatus("Aktif");

        jurnalService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/jurnal/daftar")).build();

    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id_jurnal") int edit_id_jurnal
            , @RequestParam(value="edit_id_user") int edit_id_user
            , @RequestParam(value="edit_konten") String edit_konten

            , @RequestParam(value="edit_tanggal_jurnal") Date edit_tanggal_jurnal
    ){
        Jurnal obj = jurnalService.findById(edit_id_jurnal);

        //jika fk maka hubungkan dengan service lainnya
        Pengguna mahasiswaservice = penggunaService.findById(edit_id_user);


        obj.setId_user(mahasiswaservice);
        obj.setKonten(edit_konten);
        obj.setTanggal_jurnal(edit_tanggal_jurnal);


        jurnalService.save(obj);

        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/jurnal/daftar")).build();

    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_jurnal") int id){
        Jurnal obj = jurnalService.findById(id);
        jurnalService.delete(obj.getId_jurnal());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/jurnal/daftar")).build();
    }

}
