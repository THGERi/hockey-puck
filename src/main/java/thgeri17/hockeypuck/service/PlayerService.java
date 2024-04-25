package thgeri17.hockeypuck.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thgeri17.hockeypuck.entity.Player;
import thgeri17.hockeypuck.model.PlayerCreateModel;
import thgeri17.hockeypuck.model.PlayerModel;
import thgeri17.hockeypuck.model.PlayerUpdateModel;
import thgeri17.hockeypuck.repository.PlayerRepository;
import thgeri17.hockeypuck.util.Mapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<PlayerModel> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(Mapper::mapPlayerEntitytoPlayerModel)
                .collect(Collectors.toList());
    }
    public Player findPlayerById(Long id) {

        return playerRepository.findPlayerById(id)
                .orElseThrow(() -> {
                    String message =  String.format("Player with id %d was not found", id);
                    log.info(message);
                    return  new NoSuchElementException(message);
                });
    }

    public PlayerModel creatPlayer(PlayerCreateModel playerCreateModel) {
        return Mapper.mapPlayerEntitytoPlayerModel(playerRepository.save(Mapper.mapPlayerCreatModelToPlayerEntity(playerCreateModel)));
    }

    public void deletePlayers(Long id) {
        findPlayerById(id);
        playerRepository.deleteById(id);
    }

    public Player updatePlayer(Long id, PlayerUpdateModel model) {
        Player player = findPlayerById(id);
        player.setPlayerName(model.getPlayerName());
        player.setBirthOfDate(model.getDateOffBirth());
        player.setRole(model.getRole());
        player.setDescription(model.getDescription());
        player.setTeam(model.getTeam());
        return playerRepository.save(player);
    }

}
