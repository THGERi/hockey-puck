package thgeri17.hockeypuck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thgeri17.hockeypuck.entity.Team;

import java.util.Optional;

@Repository
public interface TeamRepository  extends JpaRepository<Team, Long> {
    Optional<Team> findTeamById(Long id);
}

