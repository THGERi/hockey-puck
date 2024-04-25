package thgeri17.hockeypuck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TeamUpdateModel {

    private Long id;

    private String teamName;

    private String location;
}
