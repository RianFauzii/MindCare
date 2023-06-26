package astratech.mindcare.Model;


import javax.persistence.*;

@Entity
public class Psikolog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_psikolog", nullable = false)
    private Integer id_psikolog;
    private Integer nama_psi;
    private String lokasi;
    private String alamat_psi;

    public Psikolog(Integer id_psikolog, Integer nama_psi, String lokasi, String alamat_psi) {
        this.id_psikolog = id_psikolog;
        this.nama_psi = nama_psi;
        this.lokasi = lokasi;
        this.alamat_psi = alamat_psi;
    }

    public Psikolog() {

    }

    public Integer getId_psikolog() {
        return id_psikolog;
    }

    public void setId_psikolog(Integer id_psikolog) {
        this.id_psikolog = id_psikolog;
    }

    public Integer getNama_psi() {
        return nama_psi;
    }

    public void setNama_psi(Integer nama_psi) {
        this.nama_psi = nama_psi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getAlamat_psi() {
        return alamat_psi;
    }

    public void setAlamat_psi(String alamat_psi) {
        this.alamat_psi = alamat_psi;
    }

}
