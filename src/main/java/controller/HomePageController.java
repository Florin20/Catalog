package controller;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProfessorService;
import service.StudentService;

@Controller
public class HomePageController {

    ProfessorService ps = new ProfessorService();
    StudentService ss = new StudentService();

    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String hello() {
        ps.initialize();
        return "homepage";
    }
    @RequestMapping(value="/student", method=RequestMethod.GET)
    public String studentLogin(){
        return "studentLogin";
    }
    @RequestMapping(value="/professor", method=RequestMethod.GET)
    public String professorLogin(){
        return "professorLogin";
    }
    @RequestMapping(value="/studentCheckCredentials", method=RequestMethod.POST)
    public String studentHomePage(@RequestParam(name="id")String id, @RequestParam(name="password")String password, Model model){
        String jspName = "invalid";
        Student student = ss.checkCredentials(id, password);
        if(student != null){
            jspName = "studentPage";
            model.addAttribute("student", student);
        }
        return jspName;
    }


}