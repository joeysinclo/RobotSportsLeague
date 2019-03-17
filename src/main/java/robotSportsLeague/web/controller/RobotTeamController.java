package robotSportsLeague.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import robotSportsLeague.db.RobotTeamRepository;
import robotSportsLeague.web.model.RobotTeam;

@Slf4j
@Controller
@RequestMapping("/robotTeam")
public class RobotTeamController {

    private RobotTeamRepository robotTeamRepo;

    @Autowired
    RobotTeamController(RobotTeamRepository robotTeamRepo){
        this.robotTeamRepo = robotTeamRepo;
    }

    @GetMapping
    public String robotTeam(Model model, RobotTeam robotTeam){
        model.addAttribute("teams", robotTeamRepo.findAll());
        return "robotTeam";
    }

    @PostMapping
    public String createRobotTeam(RobotTeam robotTeam){
        robotTeamRepo.save(robotTeam);
        return "redirect:/robotTeam";
    }
}
