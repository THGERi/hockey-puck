package thgeri17.hockeypuck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thgeri17.hockeypuck.entity.Team;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MatchUpdateModel {

    private Long id;

    private String homeVSaway;

    private LocalDate startDate;

    private LocalDate endDate;
    private List<Team> teams;
}
