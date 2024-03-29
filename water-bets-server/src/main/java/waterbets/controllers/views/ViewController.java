package waterbets.controllers.views;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    @RequestMapping({
            "",
            "/",
            "/login",
            "/home",
            "/how-to-play",
            "/group-search",
            "/create-water-bet",
            "/leaderboard",
            "/closed-bets"
    })
    public String view() {
        return "index";
    }

}