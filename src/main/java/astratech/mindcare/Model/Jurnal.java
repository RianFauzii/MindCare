package astratech.mindcare.Model;

import org.apache.commons.beanutils.PropertyUtilsBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jurnal")
public class Jurnal {
    //untuk primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jurnal;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Pengguna id_user;

    private Date tanggal_jurnal;

    private String konten;

    private String status;

    public Jurnal(int id_jurnal, Pengguna id_user, Date tanggal_jurnal, String konten, String status) {
        this.id_jurnal = id_jurnal;
        this.id_user = id_user;
        this.tanggal_jurnal = tanggal_jurnal;
        this.konten = konten;
        this.status = status;
    }

    public Jurnal(){

    }

    public int getId_jurnal() {
        return id_jurnal;
    }

    public void setId_jurnal(int id_jurnal) {
        this.id_jurnal = id_jurnal;
    }

    public Pengguna getId_user() {
        return id_user;
    }

    public void setId_user(Pengguna id_user) {
        this.id_user = id_user;
    }

    public Date getTanggal_jurnal() {
        return tanggal_jurnal;
    }

    public void setTanggal_jurnal(Date tanggal_jurnal) {
        this.tanggal_jurnal = tanggal_jurnal;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
