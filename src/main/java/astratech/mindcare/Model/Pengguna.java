package astratech.mindcare.Model;

import javax.persistence.*;

@Entity
@Table(name = "mahasiswa", uniqueConstraints = @UniqueConstraint(columnNames = "NIM"))
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;
    private Integer NIM;
    private String nama;
    private String jenis_kelamin;
    private String alamat;

    private String password;

    private String status;


    public Pengguna(Integer id, Integer NIM, String nama, String jenis_kelamin, String alamat, String password, String status) {
        this.id = id;
        this.NIM = NIM;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.password = password;
        this.status = status;
    }

    public Pengguna() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNIM() {
        return NIM;
    }

    public void setNIM(Integer NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
