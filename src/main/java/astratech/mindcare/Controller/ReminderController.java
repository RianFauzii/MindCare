package astratech.mindcare.Controller;

import astratech.mindcare.Model.Reminder;
import astratech.mindcare.Service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/reminder")
public class ReminderController {

    @Autowired
    ReminderService reminderService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model){
        if(session.getAttribute("user") == null){
            return "redirect:/logout";
        }
        model.addAttribute("user",session.getAttribute("user"));

        List<Reminder> list = reminderService.getAllData();
        model.addAttribute("list",list);
        return "reminder/daftar";
    }



}
