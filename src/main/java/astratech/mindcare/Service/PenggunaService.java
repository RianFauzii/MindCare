package astratech.mindcare.Service;

import astratech.mindcare.Model.Pengguna;
import astratech.mindcare.Model.User;
import astratech.mindcare.Repository.PenggunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class PenggunaService {
    @Qualifier("PenggunaJpaRepository")
    @Autowired
    PenggunaRepository mPenggunaJpaRepository;

    public Pengguna getPengguna(int id_user){
        Pengguna pengguna = mPenggunaJpaRepository.getPenggunaById(id_user);

        return pengguna;
    }

    public List<Pengguna> getPenggunas(){
        List<Pengguna> penggunaList = mPenggunaJpaRepository.findAllByOrderByIdAsc();
        return penggunaList;
    }

    public boolean savePengguna(Pengguna pengguna){
        pengguna.setStatus("Aktif");
        Pengguna result = mPenggunaJpaRepository.save(pengguna);
        boolean isSuccess = true;

        if(result == null){
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean updatePengguna(Pengguna pengguna){
        Pengguna result = mPenggunaJpaRepository.getPenggunaById(pengguna.getId());

        if(result == null){
            return false;
        }

        if (StringUtils.hasLength(pengguna.getNama())){
            result.setNama(pengguna.getNama());
        }

        mPenggunaJpaRepository.save(result);
        return true;
    }

    public boolean deletePengguna(int id_user){
        Pengguna result = mPenggunaJpaRepository.getPenggunaById(id_user);
        if(result == null){
            return false;
        }
        mPenggunaJpaRepository.delete(result);
        return true;
    }

    public Pengguna findPengguna(String NIM, String password) {
        Pengguna detail = mPenggunaJpaRepository.findPengguna(NIM, password);
        return detail;
    }

    public Pengguna findById(int id_user) {
       Pengguna pengguna = mPenggunaJpaRepository.findById(id_user).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id_user));
        return pengguna;
    }

}