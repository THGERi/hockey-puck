package thgeri17.footievault.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thgeri17.footievault.entity.Player;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchModel {

    private Long id;

    private String homeVSaway;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<Player> players;
}
