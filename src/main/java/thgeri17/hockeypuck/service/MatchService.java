package thgeri17.hockeypuck.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thgeri17.hockeypuck.entity.Match;
import thgeri17.hockeypuck.model.MatchCreateModel;
import thgeri17.hockeypuck.model.MatchModel;
import thgeri17.hockeypuck.model.MatchUpdateModel;
import thgeri17.hockeypuck.repository.MatchRepository;
import thgeri17.hockeypuck.util.Mapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class MatchService {

    private final MatchRepository matchRepository;

    public List<MatchModel> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(Mapper::mapMatchEntitytoMatchModel)
                .collect(Collectors.toList());
    }

    public Match findMatchById(Long id) {
        return matchRepository.findMatchById(id)
                .orElseThrow(() -> {
                    String message = String.format("Match with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }
    public MatchModel createMatch(MatchCreateModel matchCreateModel) {
        return Mapper.mapMatchEntitytoMatchModel(matchRepository.save(Mapper.mapMatchCreatModelToMatchEntity(matchCreateModel)));
    }

    public void deleteMatch(Long id) {
        findMatchById(id);
        matchRepository.deleteById(id);
    }

    public Match updateMatch(Long id, MatchUpdateModel matchUpdateModel) {
        Match match = findMatchById(id);
        match.setHomeVSaway(matchUpdateModel.getHomeVSaway());
        match.setStartDate(matchUpdateModel.getStartDate());
        match.setEndDate(matchUpdateModel.getEndDate());
        match.setTeams(matchUpdateModel.getTeams());

        return matchRepository.save(match);
    }

}
