package astratech.mindcare.Controller;

import astratech.mindcare.Model.User;
import astratech.mindcare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/logout";
        }
        model.addAttribute("user",session.getAttribute("user"));

        List<User> list = userService.getAllData();
        model.addAttribute("list",list);

        return "user/daftar";
    }
}
