package home.sabapathy.guestbook.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import home.sabapathy.guestbook.controller.dto.CommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GuestBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void readNoEntry() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/guestbook")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();
        String commentDtoString = mvcResult.getResponse().getContentAsString();
        assertThat(commentDtoString, is("[]"));
    }

    @Test
    public void readOneEntry() throws Exception {
        CommentDto commentDto = new CommentDto("Selva", "Great site");
        mockMvc.perform(post("/guestbook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(commentDto))
        ).andExpect(status().isCreated());

        MvcResult mvcResult = mockMvc.perform(get("/guestbook")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();
        String commentDtoString = mvcResult.getResponse().getContentAsString();
        List<CommentDto> retrievedCommentDtos = mapper.readValue(commentDtoString, new TypeReference<ArrayList<CommentDto>>() {});
        assertThat(retrievedCommentDtos.size(), is(1));
        assertThat(retrievedCommentDtos.get(0), is(commentDto));
    }

    @Test
    public void addEntry() throws Exception {
        CommentDto commentDto = new CommentDto("Selva", "Great site");
        MvcResult mvcResult = mockMvc.perform(post("/guestbook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(commentDto))
        )
                .andExpect(status().isCreated())
                .andReturn();
        String commentDtoString = mvcResult.getResponse().getContentAsString();
        CommentDto savedCommentDto = mapper.readValue(commentDtoString, CommentDto.class);
        assertThat(savedCommentDto, is(commentDto));
    }
}
