package astratech.mindcare.Service;

import astratech.mindcare.Model.User;
import astratech.mindcare.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public List<User> getAllData(){
        List<User> userList = (List<User>) userRepository.findUserByStatus(1);
        return userList;
    }

    public void save(User user){
        user.setStatus(1);
        userRepository.save(user);
    }

    public User findById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id));
        return user;
    }

    public void delete(int id) {
        User tempUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id));
        tempUser.setStatus(0);
        userRepository.save(tempUser);
    }

    public void update(int id, User user) {
        User tempUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + id));
        if (user.getPassword() != "") {
            tempUser.setPassword(user.getPassword());
        }
        tempUser.setRole(user.getRole());
        tempUser.setNama_nm(user.getNama_nm());
        tempUser.setNIP(user.getNIP());
        tempUser.setAlamat_nm(user.getAlamat_nm());
        tempUser.setJenis_kelamin_nm(user.getJenis_kelamin_nm());
        userRepository.save(tempUser);
    }

    public boolean login(User user) {
        if (userRepository.login(user.getNIP(), user.getPassword())) {
            return true;
        }
        return false;
    }

    public User getUserByNIPAndPassword(String NIP, String password) {
        User user = userRepository.getUserByNIPAndPassword(NIP, password);
        return user;
    }
}


