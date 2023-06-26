package astratech.mindcare.rest;

import astratech.mindcare.Model.Psikolog;
import astratech.mindcare.Repository.PsikologRepository;
import astratech.mindcare.Service.PsikologService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/psikolog")
public class PsikologRest {
    @Autowired

    PsikologService psikologService;
    PsikologRepository psikologRepository;

    @GetMapping("/alldata")
    public List<Psikolog> getAllData(){
        List<Psikolog> list = psikologService.getAllPsikolog();
        return list;
    }

    @GetMapping("/data")
    public Psikolog getData(@RequestParam("id") int id){
        Psikolog obj = psikologService.findById(id);
        return obj;
    }

    @GetMapping("/tambah")
    public ResponseEntity<Void> tambah(RedirectAttributes flashmsg,
                                       @RequestParam(value = "tambah_nama_psi") Integer tambah_nama_psi,
                                       @RequestParam(value = "tambah_lokasi") String tambah_lokasi,
                                       @RequestParam(value = "tambah_alamat_psi") String tambah_alamat_psi) {
        Psikolog obj = new Psikolog();
        obj.setNama_psi(tambah_nama_psi);
        obj.setLokasi(tambah_lokasi);
        obj.setAlamat_psi(tambah_alamat_psi);

        psikologRepository.save(obj);

        flashmsg.addFlashAttribute("type", "berhasil");
        flashmsg.addFlashAttribute("msg", "Data Psikolog berhasil ditambahkan!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/psikolog/daftar")).build();
    }
    @GetMapping("/edit")
    public ResponseEntity<Void> edit(RedirectAttributes flashmsg,
                                     @RequestParam(value = "edit_id_psikolog") Integer edit_id_psikolog,
                                     @RequestParam(value = "edit_nama_psi") Integer edit_nama_psi,
                                     @RequestParam(value = "edit_lokasi") String edit_lokasi,
                                     @RequestParam(value = "edit_alamat_psi") String edit_alamat_psi) {
        Psikolog obj = psikologRepository.findById(edit_id_psikolog).orElse(null);
        if (obj == null) {
            // Jika Psikolog tidak ditemukan, Anda bisa mengatur respons sesuai kebutuhan
            return ResponseEntity.notFound().build();
        }

        obj.setNama_psi(edit_nama_psi);
        obj.setLokasi(edit_lokasi);
        obj.setAlamat_psi(edit_alamat_psi);

        psikologRepository.save(obj);

        flashmsg.addFlashAttribute("type", "berhasil");
        flashmsg.addFlashAttribute("msg", "Data Psikolog berhasil diedit!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/psikolog/daftar")).build();
    }
    @PostMapping("/hapus")
    public ResponseEntity<Void> delete(RedirectAttributes flashmsg, @RequestParam(value = "id_psikolog") int id) {
        Psikolog obj = psikologRepository.findById(id).orElse(null);
        if (obj == null) {
            // Jika Psikolog tidak ditemukan, Anda bisa mengatur respons sesuai kebutuhan
            return ResponseEntity.notFound().build();
        }

        psikologRepository.delete(obj);

        flashmsg.addFlashAttribute("type", "berhasil");
        flashmsg.addFlashAttribute("msg", "Data Psikolog berhasil dihapus!");

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/psikolog/daftar")).build();
    }
}
