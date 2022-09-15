package com.codestates.slice.controller.member;

import com.codestates.member.dto.MemberDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
//    @WebMvcTest(controllers = MemberController.class)
//    @MockBean(JpaMetamodelMappingContext.class)
class MemberControllerTest1 {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

//    @MockBean
//    private MemberService memberService;

//    @MockBean
//    private MemberMapper mapper;

    @Test
    void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com",
                                                        "홍길동",
                                                    "010-1234-5678");
        String content = gson.toJson(post);


        // when
        ResultActions actions =
                mockMvc.perform(
                                    post("/v11/members")
                                        .accept(MediaType.APPLICATION_JSON)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(content)
                                );

        // then
        MvcResult result = actions
                                .andExpect(status().isCreated())
                                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}