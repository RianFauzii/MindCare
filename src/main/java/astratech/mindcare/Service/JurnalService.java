package astratech.mindcare.Service;

import astratech.mindcare.Model.Jurnal;
import astratech.mindcare.Repository.JurnalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurnalService {

    @Autowired
    JurnalRepository jurnalRepository;

    public List<Jurnal> getAllData(){
        List<Jurnal> jurnalList = (List<Jurnal>) jurnalRepository.findJurnalByStatus("Aktif");
        return jurnalList;
    }

    public void save(Jurnal jurnal){
        jurnal.setStatus("Aktif");
        jurnalRepository.save(jurnal);
    }

    public Jurnal findById(int id){
        Jurnal jurnal = jurnalRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        return jurnal;
    }

    public void delete(int id){
        Jurnal tempJurnal = jurnalRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempJurnal.setStatus("Tidak Aktif");
        jurnalRepository.save(tempJurnal);
    }

    public void update(int id,Jurnal jurnal){
        Jurnal tempJurnal = jurnalRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempJurnal.setId_user(jurnal.getId_user());
        tempJurnal.setKonten(jurnal.getKonten());
        tempJurnal.setTanggal_jurnal(jurnal.getTanggal_jurnal());
        jurnalRepository.save(tempJurnal);
    }
    
}
