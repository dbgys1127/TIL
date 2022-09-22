package spring.securityBasic.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void index_anonymous() throws Exception {
        mockMvc.perform(get("/").with(anonymous()))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void index_user() throws Exception {
        mockMvc.perform(get("/").with(user("dbgys").roles("USER")))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void index_user_access() throws Exception {
        mockMvc.perform(get("/admin").with(user("dbgys").roles("USER")))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
    @Test
    public void index_admin_access() throws Exception {
        mockMvc.perform(get("/admin").with(user("admin").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
