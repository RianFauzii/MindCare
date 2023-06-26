package astratech.mindcare.Controller;

import astratech.mindcare.Model.User;
import astratech.mindcare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String login(HttpSession session, Model model){
        if(session.getAttribute("user") != null){
            return "redirect:/home";
        }
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }


    @PostMapping("/aksilogin")
    public String aksilogin(RedirectAttributes flashmsg, HttpServletRequest request, User user){
        request.getSession().invalidate();
        if(userService.login(user)){
            user = userService.getUserByNIPAndPassword(user.getNIP(),user.getPassword());

            if ("DKA".equals(user.getRole())) {
                return "redirect:/HomeDKA";
            } else if ("PIC Kemahasiswaan".equals(user.getRole())) {
                return "redirect:/HomePIC";
            } else if ("Wali Akademik".equals(user.getRole())) {
                return "redirect:/HomeWali";
            }
            request.getSession().setAttribute("user",user);
        }
        flashmsg.addFlashAttribute("type","gagal");
        flashmsg.addFlashAttribute("msg","Gagal login ! , User tidak ditemukan.");
        return "redirect:/";
    }

    @GetMapping("/HomeDKA")
    public String showDKABoard(Model model){

        return "HomeDKA";
    }

    @GetMapping("/HomePIC")
    public String showPICBoard(Model model){

        return "HomePIC";
    }

    @GetMapping("/HomeWali")
    public String showWaliBoard(Model model){
        return "HomeWali";
    }

    
}
