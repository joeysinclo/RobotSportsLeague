package robotSportsLeague.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/robotTeammates")
public class RobotTeammatesController {

    @GetMapping
    public String robotTeammates(){
        return "robotTeammates";
    }
}
