package thgeri17.hockeypuck.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thgeri17.hockeypuck.entity.Team;
import thgeri17.hockeypuck.model.TeamCreateModel;
import thgeri17.hockeypuck.model.TeamModel;
import thgeri17.hockeypuck.model.TeamUpdateModel;
import thgeri17.hockeypuck.repository.TeamRepository;
import thgeri17.hockeypuck.util.Mapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class TeamService {

    private final TeamRepository teamRepository;

    public List<TeamModel> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(Mapper::mapTeamEntitytoTeamModel)
                .collect(Collectors.toList());
    }

    public TeamModel addTeam(TeamCreateModel teamCreateModel) {
        return Mapper.mapTeamEntitytoTeamModel(teamRepository.save(Mapper.mapTeamCreatModelToTeamEntity(teamCreateModel)));
    }

    public Team findTeamById(Long id) {
        return teamRepository.findTeamById(id)
                .orElseThrow(() -> {
                   String message = String.format("Team with id %d was not found",id);
                   log.info(message);
                   return new NoSuchElementException(message);
                });
    }

    public void deleteTeam(Long id) {
        findTeamById(id);
        teamRepository.deleteById(id);
    }

    public Team updateTeam (Long id, TeamUpdateModel teamUpdateModel) {
        Team team = findTeamById(id);
        team.setTeamName(teamUpdateModel.getTeamName());
        team.setLocation(teamUpdateModel.getLocation());
        return teamRepository.save(team);
    }
}
