package astratech.mindcare.Repository;

import astratech.mindcare.Model.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("PenggunaJpaRepository")
public interface PenggunaRepository extends JpaRepository<Pengguna, Serializable> {

    Pengguna getPenggunaById(int id_pengguna);

    List<Pengguna> findAllByOrderByIdAsc();

    @Query("SELECT a from Pengguna a where a.NIM=:NIM AND a.password=:password")
    Pengguna findPengguna(String NIM, String password);
}