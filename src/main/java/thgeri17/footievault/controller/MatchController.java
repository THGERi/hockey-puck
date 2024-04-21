package thgeri17.footievault.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thgeri17.footievault.entity.Match;
import thgeri17.footievault.model.MatchCreatModel;
import thgeri17.footievault.model.MatchModel;
import thgeri17.footievault.model.MatchUpdateModel;
import thgeri17.footievault.service.MatchService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class MatchController {

    private final MatchService matchService;

    @GetMapping("/matches")
    public ResponseEntity<List<MatchModel>> renderAllMatches() {
        return ResponseEntity.status(200).body(matchService.getAllMatches());
    }

    @GetMapping("/matches/{id}")
    public ResponseEntity<Match> renderMatchById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(matchService.findMatchById(id));
    }

    @PostMapping("/matches")
    public ResponseEntity<MatchModel> creatMatch(@RequestBody MatchCreatModel matchCreatModel) {
        return ResponseEntity.status(200).body(matchService.creatMatch(matchCreatModel));
    }
    @DeleteMapping("/matches/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.status(204).build();
    }
    @PatchMapping("/matches/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody MatchUpdateModel matchUpdateModel) {
        return ResponseEntity.status(200).body(matchService.updateMatch(id, matchUpdateModel));
    }
}
