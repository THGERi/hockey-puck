package thgeri17.footievault.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thgeri17.footievault.value.Role;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;


    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate birthOfDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
