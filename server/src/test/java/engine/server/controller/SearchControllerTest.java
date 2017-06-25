package engine.server.controller;

import engine.server.config.ServiceConfig;
import engine.server.controller.SearchController;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SearchController.class, secure = false)
@Import(value = ServiceConfig.class)
public class SearchControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldFindSimpleWords() throws Exception {
        mvc.perform(get("/search?query=Lisp Common"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items").isArray())
                .andExpect(jsonPath("$.items[0].name").value("Common Lisp"))
                .andExpect(jsonPath("$.items[0].type").isNotEmpty())
                .andExpect(jsonPath("$.items[0].designedBy").isNotEmpty());
    }

    @Test
    public void shouldFindExactWords() throws Exception {
        mvc.perform(get("/search?query=Interpreted \"Thomas Eugene\""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items").isArray())
                .andExpect(jsonPath("$.items[1]").doesNotExist())
                .andExpect(jsonPath("$.items[0].name").value("BASIC"))
                .andExpect(jsonPath("$.items[0].type").value(Matchers.containsString("Interpreted")))
                .andExpect(jsonPath("$.items[0].designedBy").value(Matchers.containsString("Thomas Eugene")));
    }

    @Test
    public void shouldFindNegativeWords() throws Exception {
        mvc.perform(get("/search?query=john -array"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items").isArray())
                .andExpect(jsonPath("$.items").value(Matchers.hasSize(4)))
                .andExpect(jsonPath("$.items[0].name").value("BASIC"))
                .andExpect(jsonPath("$.items[1].name").value("Haskell"))
                .andExpect(jsonPath("$.items[2].name").value("Lisp"))
                .andExpect(jsonPath("$.items[3].name").value("S-Lang"));
    }
}
