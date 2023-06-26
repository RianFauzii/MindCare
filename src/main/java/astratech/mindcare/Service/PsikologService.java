package astratech.mindcare.Service;

import astratech.mindcare.Model.Psikolog;
import astratech.mindcare.Model.Reminder;
import astratech.mindcare.Repository.PsikologRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsikologService {
    @Autowired
    PsikologRepository psikologRepository;

    public List<Psikolog> getAllPsikolog() {
        List<Psikolog> psikologList = (List<Psikolog>) psikologRepository.findAll();
        return psikologList;
    }
    public Psikolog findById(int id) {
        Psikolog psikolog = psikologRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + id));
        return psikolog;
    }
    public void save(Psikolog psikolog) {
        psikologRepository.save(psikolog);
    }
    public void delete(int id) {
        Psikolog tempPsikolog = psikologRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + id));
        psikologRepository.save(tempPsikolog);
    }
    public void update(int id, Psikolog psikolog) {
        Psikolog tempPsikolog = psikologRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id: " + id));
        tempPsikolog.setNama_psi(psikolog.getNama_psi());
        tempPsikolog.setLokasi(psikolog.getLokasi());
        tempPsikolog.setAlamat_psi(psikolog.getAlamat_psi());
        psikologRepository.save(tempPsikolog);
    } 

}
