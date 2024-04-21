package thgeri17.footievault.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thgeri17.footievault.entity.Match;
import thgeri17.footievault.model.MatchCreatModel;
import thgeri17.footievault.model.MatchModel;
import thgeri17.footievault.model.MatchUpdateModel;
import thgeri17.footievault.repository.MatchRepository;
import thgeri17.footievault.util.Mapper;

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
    public MatchModel creatMatch(MatchCreatModel matchCreatModel) {
        return Mapper.mapMatchEntitytoMatchModel(matchRepository.save(Mapper.mapMatchCreatModelToMatchEntity(matchCreatModel)));
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
