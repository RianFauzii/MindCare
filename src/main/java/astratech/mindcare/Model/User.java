package astratech.mindcare.Model;


import javax.persistence.*;

@Entity
@Table(name = "non_mahasiswa", uniqueConstraints = @UniqueConstraint(columnNames = "NIP_nm"))
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_nm", nullable = false)
    private Integer id_user_nm;
    private String  role;
    @Column(name = "NIP_nm")
    private String NIP;
    private String nama_nm;

    private String jenis_kelamin_nm;

    private String alamat_nm;

    @Column(name = "password_nm")
    private String password;

    private  int status;

    public User(Integer id_user_nm, String role, String NIP, String nama_nm, String jenis_kelamin_nm, String alamat_nm, String password, int status) {
        this.id_user_nm = id_user_nm;
        this.role = role;
        this.NIP = NIP;
        this.nama_nm = nama_nm;
        this.jenis_kelamin_nm = jenis_kelamin_nm;
        this.alamat_nm = alamat_nm;

        this.password = password;
        this.status = status;
    }

    public User() {

    }

    public Integer getId_user_nm() {
        return id_user_nm;
    }

    public void setId_user_nm(Integer id_user_nm) {
        this.id_user_nm = id_user_nm;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getNama_nm() {
        return nama_nm;
    }

    public void setNama_nm(String nama_nm) {
        this.nama_nm = nama_nm;
    }

    public String getJenis_kelamin_nm() {
        return jenis_kelamin_nm;
    }

    public void setJenis_kelamin_nm(String jenis_kelamin_nm) {
        this.jenis_kelamin_nm = jenis_kelamin_nm;
    }

    public String getAlamat_nm() {
        return alamat_nm;
    }

    public void setAlamat_nm(String alamat_nm) {
        this.alamat_nm = alamat_nm;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // Constructor, getter, setter, dan metode lainnya
}

