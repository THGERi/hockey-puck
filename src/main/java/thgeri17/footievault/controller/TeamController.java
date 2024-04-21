package thgeri17.footievault.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thgeri17.footievault.entity.Team;
import thgeri17.footievault.model.TeamCreatModel;
import thgeri17.footievault.model.TeamModel;
import thgeri17.footievault.model.TeamUpdateModel;
import thgeri17.footievault.service.TeamService;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class TeamController {

    private final TeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<List<TeamModel>> renderAllTeam() {
        return ResponseEntity.status(200).body(teamService.getAllTeams());
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> renderTeamById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(teamService.findTeamById(id));
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamModel> creatTeam(@RequestBody TeamCreatModel teamCreatModel) {
        return ResponseEntity.status(200).body(teamService.addTeam(teamCreatModel));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/teams/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody TeamUpdateModel teamUpdateModel) {
        return teamService.updateTeam(id, teamUpdateModel);
    }
}
