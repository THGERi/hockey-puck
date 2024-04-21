package thgeri17.footievault.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import thgeri17.footievault.model.MatchCreateModel;
import thgeri17.footievault.model.MatchModel;
import thgeri17.footievault.repository.MatchRepository;
import thgeri17.footievault.util.Mapper;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Match service test - unit test")
class MatchServiceTest {

    @Mock
    private MatchRepository matchRepository;

    @InjectMocks
    private MatchService matchService;

    @Test
    @DisplayName("Given a valid match create model when creating a match then returns the match model")
    public void givenAValidMatchCreateModel_whenCreatingAMatch_thenReturnsTheMatchModel() {
        MatchCreateModel createModel = new MatchCreateModel();
        createModel.setHomeVSaway("home");
        createModel.setStartDate(LocalDate.of(2024, 1, 1));
        createModel.setEndDate(LocalDate.of(2024, 1, 2));

        MatchModel expectedModel = new MatchModel();
        expectedModel.setId(1L);
        expectedModel.setPlayers(new ArrayList<>());
        when(matchRepository.save(any())).thenReturn(Mapper.mapMatchCreatModelToMatchEntity(createModel));

        MatchModel createdMatchModel = matchService.createMatch(createModel);


        then(createdMatchModel.getHomeVSaway()).isEqualTo(createModel.getHomeVSaway());
        then(createdMatchModel.getStartDate()).isEqualTo(createModel.getStartDate());
        then(createdMatchModel.getEndDate()).isEqualTo(createModel.getEndDate());
        verify(matchRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Given null match model when try to create then throws illegal argument exception")
    public void givenNullMatchModel_whenCreateMatch_thenThrowsIllegalArgumentException() {

        MatchCreateModel matchCreateModel = null;


        assertThatThrownBy(() -> matchService.createMatch(matchCreateModel))
                .isInstanceOf(NullPointerException.class);

        verify(matchRepository, never()).save(any());
    }

}