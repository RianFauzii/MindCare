package astratech.mindcare.rest;

import astratech.mindcare.Model.Pengguna;
import astratech.mindcare.Service.PenggunaService;
import astratech.mindcare.vo.PenggunaResult;
import astratech.mindcare.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class PenggunaRes {
    @Autowired
    PenggunaService mPenggunaService;

    @GetMapping("/pengguna")
    public Pengguna getPengguna(@RequestParam("id_pengguna") int id){
        Pengguna pengguna = mPenggunaService.getPengguna(id);
        return pengguna;
    }

    @GetMapping("/penggunas")
    public List<Pengguna> getPenggunas(){
        List<Pengguna> penggunaList = mPenggunaService.getPenggunas();
        return penggunaList;
    }

    @PostMapping("/pengguna")
    public Object savePengguna(HttpServletResponse response, @RequestBody Pengguna userParam){
        Pengguna pengguna = new Pengguna(userParam.getId(), userParam.getNIM(), userParam.getNama(),  userParam.getPassword(), userParam.getAlamat(), userParam.getStatus(), userParam.getJenis_kelamin());
        boolean isSuccess = mPenggunaService.savePengguna(pengguna);

        if (isSuccess){
            return new Result(200, "Success");
        }else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @PutMapping("/pengguna")
    public Object modifyPengguna(HttpServletResponse response, @RequestBody Pengguna userParam){
        Pengguna pengguna = new Pengguna(userParam.getId(), userParam.getNIM(), userParam.getNama(),  userParam.getPassword(), userParam.getAlamat(), userParam.getJenis_kelamin(), userParam.getStatus());
        boolean isSuccess = mPenggunaService.updatePengguna(pengguna);

        if (isSuccess){
            return new Result(200, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @DeleteMapping("/pengguna")
    public Object deleteUser(HttpServletResponse response, @RequestParam("id_pengguna") int id){
        boolean isSuccess = mPenggunaService.deletePengguna(id);

        if(isSuccess){
            return new Result(200, "success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }
    //login di android
    @PostMapping("/login")
    public Object getSpec(@RequestParam("NIM") String NIM, @RequestParam("password") String password ) {
        Pengguna pengguna = mPenggunaService.findPengguna(NIM, password);
        if(pengguna!=null){
            return new PenggunaResult(200, "Success", pengguna);
        }else{
            return new PenggunaResult(500,"Fail", null);
        }
    }
}
