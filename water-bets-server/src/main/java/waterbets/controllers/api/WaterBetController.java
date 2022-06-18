package waterbets.controllers.api;

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

    @GetMapping("/user/{id}/{waterBetRetrievalStrategy}")
    public ResponseEntity<List<WaterBet>> selectWaterBetsByStrategy(@PathVariable int id, @PathVariable WaterBetRetrievalStrategy waterBetRetrievalStrategy) {
        return ResponseEntity.ok(waterBetService.selectWaterBetsByStrategy(waterBetRetrievalStrategy, id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createAndSaveNewWaterBet(@RequestBody WaterBet waterBet) {
        waterBetService.saveNewWaterBet(waterBet.initializer().initializeNewWaterBet());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{waterBetId}")
    public ResponseEntity<Void> rescindByWaterBetId(@PathVariable int waterBetId) {
        //TODO -> validate user owns bid and in right state aka not Accepted already
        waterBetService.rescindByWaterBetId(waterBetId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/acknowledge/{waterBetId}")
    public ResponseEntity<Void> acknowledge(@PathVariable int waterBetId, @RequestParam boolean accept) {
        //TODO -> logic that would update the DB with AcceptanceStatus
        waterBetService.acknowledgeWaterBet(waterBetId, accept, 1);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}