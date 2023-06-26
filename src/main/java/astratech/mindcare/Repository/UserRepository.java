package astratech.mindcare.Repository;

import astratech.mindcare.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("SELECT u from User u where u.status =:status")
    public Iterable<User> findUserByStatus(@Param("status") Integer status);

    @Query("SELECT CASE WHEN COUNT(u.id_user_nm) > 0 THEN TRUE ELSE FALSE END from User u where u.NIP =:NIP and u.password =:password")
    public boolean login(@Param("NIP") String NIP, @Param("password") String password);

    @Query("SELECT u from User u where u.NIP =:NIP  and u.password =:password")
    public User getUserByNIPAndPassword(@Param("NIP") String NIP, @Param("password") String password);

}
