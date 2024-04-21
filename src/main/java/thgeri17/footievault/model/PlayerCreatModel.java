package thgeri17.footievault.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thgeri17.footievault.entity.Team;
import thgeri17.footievault.value.Role;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PlayerCreatModel {

    private Long id;

    private String playerName;

    private LocalDate dateOffBirth;

    private Role role;

    private String description;

    private Team team;
}
