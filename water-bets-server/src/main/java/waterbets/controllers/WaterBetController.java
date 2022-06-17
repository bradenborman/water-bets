package waterbets.controllers;

import waterbets.models.WaterBet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waterbets.servies.WaterBetService;

import java.util.List;

@RestController
@RequestMapping("/api/water-bets")
public class WaterBetController {

    private final WaterBetService waterBetService;

    public WaterBetController(WaterBetService waterBetService) {
        this.waterBetService = waterBetService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WaterBet>> betsByUser(@PathVariable int userId) {
        return ResponseEntity.ok(waterBetService.getWaterBetsByUser(userId));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Yes");
    }

}