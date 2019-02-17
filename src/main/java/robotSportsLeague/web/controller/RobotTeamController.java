package robotSportsLeague.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import robotSportsLeague.db.RobotTeamRepository;
import robotSportsLeague.web.model.RobotTeam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/robotTeam")
public class RobotTeamController {

    RobotTeamRepository robotTeamRepo;

    RobotTeamController(RobotTeamRepository robotTeamRepo){
        this.robotTeamRepo = robotTeamRepo;
    }

    @GetMapping
    public String robotTeam(Model model){
        List<RobotTeam> robotTeam = new ArrayList<>();
        robotTeamRepo.findAll().forEach(r -> robotTeam.add(r));
        model.addAttribute("teams", robotTeam);
        return "robotTeam";
    }
}
