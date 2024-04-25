package thgeri17.hockeypuck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thgeri17.hockeypuck.entity.Team;
import thgeri17.hockeypuck.value.Role;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModel {

    private Long id;

    private String playerName;

    private LocalDate dateOffBirth;

    private Role role;

    private String description;

    private Team team;
    }
