package waterbets.controllers;

import org.springframework.http.HttpStatus;
import waterbets.models.WaterBet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waterbets.models.enums.WaterBetRetrievalStrategy;
import waterbets.servies.WaterBetService;

import java.util.List;

@RestController
@RequestMapping("/api/water-bets")
public class WaterBetController {

    private final WaterBetService waterBetService;

    public WaterBetController(WaterBetService waterBetService) {
        this.waterBetService = waterBetService;
    }

    @GetMapping("/user/{userId}/{waterBetRetrievalStrategy}")
    public ResponseEntity<List<WaterBet>> betsByUser(@PathVariable int userId, @PathVariable WaterBetRetrievalStrategy waterBetRetrievalStrategy) {
        return ResponseEntity.ok(waterBetService.selectWaterBetsByStrategy(waterBetRetrievalStrategy, userId));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createWaterBet(@RequestBody WaterBet waterBet) {
        waterBetService.createAndSaveNewWaterBet(waterBet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/rescind/{waterBetId}")
    public ResponseEntity<Void> rescind(@PathVariable int waterBetId) {
        //TODO -> logic that would update the DB with rescind Status
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/acknowledge/{waterBetId}")
    public ResponseEntity<Void> acknowledge(@PathVariable int waterBetId, @RequestParam boolean accept) {
        //TODO -> logic that would update the DB with AcceptanceStatus
        waterBetService.acknowledgeWaterBet(waterBetId, accept, 1);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}