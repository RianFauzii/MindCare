package astratech.mindcare.Repository;
import astratech.mindcare.Model.Psikolog;
import astratech.mindcare.Model.Reminder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PsikologRepository  extends CrudRepository<Psikolog, Integer> {

    @Query("SELECT ha from Psikolog     ha where ha.id_psikolog =:id_psikolog")
    public Iterable<Psikolog> findPsikologById(@Param("id_psikolog") int id_psikolog);
}
