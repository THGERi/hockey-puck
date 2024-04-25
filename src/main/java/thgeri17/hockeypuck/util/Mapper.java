package thgeri17.hockeypuck.util;

import thgeri17.hockeypuck.entity.Match;
import thgeri17.hockeypuck.entity.Player;
import thgeri17.hockeypuck.entity.Team;
import thgeri17.hockeypuck.model.*;

public class Mapper {
    public static PlayerModel mapPlayerEntitytoPlayerModel(Player player) {
        PlayerModel playermodel = new PlayerModel();
        playermodel.setId(player.getId());
        playermodel.setPlayerName(player.getPlayerName());
        playermodel.setDateOffBirth(player.getBirthOfDate());
        playermodel.setRole(player.getRole());
        playermodel.setDescription(player.getDescription());
        playermodel.setTeam(player.getTeam());

        return playermodel;
    }
    public static Player mapPlayerCreatModelToPlayerEntity(PlayerCreateModel model) {
        Player player = new Player();
        player.setPlayerName(model.getPlayerName());
        player.setBirthOfDate(model.getDateOffBirth());
        player.setRole(model.getRole());
        player.setDescription(model.getDescription());
        player.setTeam(model.getTeam());

        return player;
    }

    public static TeamModel mapTeamEntitytoTeamModel(Team team) {
        TeamModel teammodel = new TeamModel();
        teammodel.setId(team.getId());
        teammodel.setLocation(team.getLocation());
        teammodel.setTeamName(team.getTeamName());
        teammodel.setPlayers(team.getPlayers());

        return teammodel;

    }

    public static Team mapTeamCreatModelToTeamEntity(TeamCreateModel model) {
        Team team = new Team();
        team.setLocation(model.getLocation());
        team.setTeamName(model.getTeamName());

        return team;

    }

    public static MatchModel mapMatchEntitytoMatchModel(Match match) {
        MatchModel matchmodel = new MatchModel();
        matchmodel.setId(match.getId());
        matchmodel.setHomeVSaway(match.getHomeVSaway());
        matchmodel.setStartDate(match.getStartDate());
        matchmodel.setEndDate(match.getEndDate());

        return matchmodel;
    }

    public static Match mapMatchCreatModelToMatchEntity(MatchCreateModel model) {
        Match currentMatch = new Match();
        currentMatch.setHomeVSaway(model.getHomeVSaway());
        currentMatch.setStartDate(model.getStartDate());
        currentMatch.setEndDate(model.getEndDate());

        return currentMatch;
    }

    private Mapper(){

    }
}
