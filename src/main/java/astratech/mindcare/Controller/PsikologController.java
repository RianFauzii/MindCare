package astratech.mindcare.Controller;
import astratech.mindcare.Model.Psikolog;
import astratech.mindcare.Service.PsikologService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/psikolog")
public class PsikologController {
    @Autowired
    private PsikologService psikologService;

    @RequestMapping("/daftar")
    public String daftar(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/logout";
        }
        model.addAttribute("user", session.getAttribute("user"));

        List<Psikolog> list = psikologService.getAllPsikolog();
        model.addAttribute("list", list);
        return "psikolog/daftar";
    }

}
