package thgeri17.footievault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thgeri17.footievault.entity.Match;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findMatchById(Long id);
}
