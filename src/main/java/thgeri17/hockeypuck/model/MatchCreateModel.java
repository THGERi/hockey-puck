package thgeri17.hockeypuck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MatchCreateModel {

    private Long id;

    private String homeVSaway;

    private LocalDate startDate;

    private LocalDate endDate;
}
