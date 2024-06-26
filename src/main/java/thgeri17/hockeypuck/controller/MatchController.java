package thgeri17.hockeypuck.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thgeri17.hockeypuck.entity.Match;
import thgeri17.hockeypuck.model.MatchCreateModel;
import thgeri17.hockeypuck.model.MatchModel;
import thgeri17.hockeypuck.model.MatchUpdateModel;
import thgeri17.hockeypuck.service.MatchService;

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
    public ResponseEntity<MatchModel> createMatch(@RequestBody MatchCreateModel matchCreateModel) {
        return ResponseEntity.status(201).body(matchService.createMatch(matchCreateModel));
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
