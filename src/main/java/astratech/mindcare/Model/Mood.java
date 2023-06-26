package astratech.mindcare.Model;

import org.apache.commons.beanutils.PropertyUtilsBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mood")
public class Mood {
    //untuk primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mood;

    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Pengguna id_user;

    private Date tanggal;

    private int nilai;


    public Mood(int id_mood, Pengguna id_user, Date tanggal, int nilai) {
        this.id_mood = id_mood;
        this.id_user = id_user;
        this.tanggal = tanggal;
        this.nilai = nilai;
    }

    public Mood(){

    }

    public int getId_mood() {
        return id_mood;
    }

    public void setId_mood(int id_mood) {
        this.id_mood = id_mood;
    }

    public Pengguna getId_user() {
        return id_user;
    }

    public void setId_user(Pengguna id_user) {
        this.id_user = id_user;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}

