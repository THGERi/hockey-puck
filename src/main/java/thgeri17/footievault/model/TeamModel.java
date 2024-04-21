package thgeri17.footievault.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thgeri17.footievault.entity.Player;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamModel {

    private Long id;

    private String teamName;

    private String location;

    private List<Player> players;
}
