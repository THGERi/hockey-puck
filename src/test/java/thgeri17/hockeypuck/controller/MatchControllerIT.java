package thgeri17.hockeypuck.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import thgeri17.hockeypuck.model.MatchCreateModel;
import thgeri17.hockeypuck.model.MatchModel;
import thgeri17.hockeypuck.service.MatchService;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MatchController.class)
@ContextConfiguration(classes = {MatchController.class})
@ExtendWith(MockitoExtension.class)
@DisplayName("Match Controller - Integration test")
class MatchControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MatchService matchService;

    @Test
    @DisplayName("Given a valid match details when creating a match then match is created")
    public void givenValidMatchDetails_whenCreatingMatch_thenMatchIsCreated() throws Exception {
        MatchCreateModel matchCreateModel
                = new MatchCreateModel(1L, "home", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));


        MatchModel createdMatch = new MatchModel(matchCreateModel.getId(), matchCreateModel.getHomeVSaway(), matchCreateModel.getStartDate(), matchCreateModel.getEndDate(), new ArrayList<>());
        when(matchService.createMatch(any(MatchCreateModel.class))).thenReturn(createdMatch);

        MvcResult result = mockMvc.perform(post("/api/matches")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(matchCreateModel)))
                .andExpect(status().isCreated())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();

        assertThat(responseContent).isNotEmpty();
        assertThat(responseContent).isNotBlank();
        assertThat(responseContent).isEqualTo(objectMapper.writeValueAsString(createdMatch));
        assertThat(responseContent).contains(createdMatch.getHomeVSaway());
    }
}