package astratech.mindcare.Repository;

import astratech.mindcare.Model.Jurnal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JurnalRepository extends CrudRepository<Jurnal, Integer> {

    @Query("SELECT l from Jurnal l where l.status =:status")
    public Iterable<Jurnal> findJurnalByStatus(@Param("status") String status);
}
