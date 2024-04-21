package thgeri17.footievault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thgeri17.footievault.entity.Team;

import java.util.Optional;

@Repository
public interface TeamRepository  extends JpaRepository<Team, Long> {
    Optional<Team> findTeamById(Long id);
}

