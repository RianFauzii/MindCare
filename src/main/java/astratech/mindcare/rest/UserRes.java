package astratech.mindcare.rest;

import astratech.mindcare.Model.User;
import astratech.mindcare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRes {

    @Autowired
    UserService akunService;


    @GetMapping("/alldata")
    public List<User> getAllData(){
        List<User> list = akunService.getAllData();
        return list;
    }

    @GetMapping("/data")
    public User getData(@RequestParam("id") int id){
        User obj = akunService.findById(id);
        return obj;
    }


    //value harus sama dengan nama element di html
    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg
            , @RequestParam(value="tambah_NIP") String tambah_NIP
            , @RequestParam(value="tambah_role") String tambah_role
            , @RequestParam(value="tambah_jenis_kelamin") String tambah_jenis_kelamin

            , @RequestParam(value="tambah_password") String tambah_password
            , @RequestParam(value="tambah_nama") String tambah_nama
            , @RequestParam(value="tambah_alamat") String tambah_alamat){
        User obj = new User();
        obj.setNIP(tambah_NIP);
        obj.setJenis_kelamin_nm(tambah_jenis_kelamin);
        obj.setRole(tambah_role);

        obj.setPassword(tambah_password);
        obj.setNama_nm(tambah_nama);
        obj.setAlamat_nm(tambah_alamat);
        obj.setStatus(1);

        akunService.save(obj);





        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/akun/daftar")).build();

    }

    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg
            , @RequestParam(value="edit_id") int edit_id
            , @RequestParam(value="edit_NIP") String edit_NIP
            , @RequestParam(value="edit_role") String edit_role
            , @RequestParam(value="edit_jenis_kelamin") String edit_jenis_kelamin

            , @RequestParam(value="edit_password") String edit_password
            , @RequestParam(value="edit_nama") String edit_nama
            , @RequestParam(value="edit_alamat") String edit_alamat){
        User obj = akunService.findById(edit_id);

        obj.setNIP(edit_NIP);
        obj.setJenis_kelamin_nm(edit_jenis_kelamin);
        obj.setRole(edit_role);

        if(edit_password != ""){obj.setPassword(edit_password);}
        obj.setNama_nm(edit_nama);
        obj.setAlamat_nm(edit_alamat);

        akunService.save(obj);


        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/akun/daftar")).build();

    }

    @PostMapping("/hapus")
    public  ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value="id_user_nm") int id_user_nm){
        User obj = akunService.findById(id_user_nm);
        akunService.delete(obj.getId_user_nm());
        flashmsg.addFlashAttribute("type","berhasil");
        flashmsg.addFlashAttribute("msg","Data berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/akun/daftar")).build();
    }

}
