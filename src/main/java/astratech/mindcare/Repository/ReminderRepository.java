package astratech.mindcare.Repository;

import astratech.mindcare.Model.Reminder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReminderRepository extends CrudRepository<Reminder, Integer> {

    @Query("SELECT l from Reminder l where l.status =:status")
    public Iterable<Reminder> findReminderByStatus(@Param("status") String status);
}
