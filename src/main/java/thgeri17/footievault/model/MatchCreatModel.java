package thgeri17.footievault.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MatchCreatModel {

    private Long id;

    private String homeVSaway;

    private LocalDate startDate;

    private LocalDate endDate;
}
