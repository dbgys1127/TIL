package com.codestates.slice.controller.member;

import com.codestates.helper.MemberControllerTestHelper;
import com.codestates.helper.StubData;
import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest4 implements MemberControllerTestHelper {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private MemberService memberService;

    @Autowired
    private MemberMapper mapper;

    @Test
    void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = (MemberDto.Post) StubData.MockMember.getRequestBody(HttpMethod.POST);
        Member member = StubData.MockMember.getMultiResponseBody(1L);

        // Stubbing by Mockito
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(member);

        String content = toJsonContent(post);
        URI uri = getURI();

        // when
        ResultActions actions = mockMvc.perform(postRequestBuilder(uri, content));

        // then
        MvcResult result = actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(post.getName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
                .andReturn();

//        System.out.println(result.getResponse().getContentAsString());
    }

    //@Test
    void patchMemberTest() throws Exception {
        // given
        long memberId = 1L;
        Map<String, String> updatedInfo = new HashMap<>();
        updatedInfo.put("phone", "010-2222-2222");

        MemberDto.Patch patch = (MemberDto.Patch) StubData.MockMember.getRequestBody(HttpMethod.PATCH);
        Member member = StubData.MockMember.getMultiResponseBody(memberId, updatedInfo);


        // Stubbing by Mockito
        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(member);

        String content = toJsonContent(patch);
        URI uri = getURI(memberId);

        // when
        ResultActions actions = mockMvc.perform(patchRequestBuilder(uri, content));

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.phone").value(member.getPhone()));
    }

    @Test
    void getMemberTest() throws Exception {
        // given
        long memberId = 1L;
        Member member = StubData.MockMember.getMultiResponseBody(memberId);

        // Stubbing by Mockito
        given(memberService.findMember(Mockito.anyLong())).willReturn(member);

        URI uri = getURI(memberId);

        // when
        ResultActions actions = mockMvc.perform(getRequestBuilder(uri));

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.email").value(member.getEmail()))
                .andExpect(jsonPath("$.data.name").value(member.getName()))
                .andExpect(jsonPath("$.data.phone").value(member.getPhone()));
    }

    @Test
    void getMembersTest() throws Exception {
        // given
        Page<Member> members = StubData.MockMember.getMultiResponseBody();

        // Stubbing by Mockito
        given(memberService.findMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(members);

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", String.valueOf(1));
        queryParams.add("size", String.valueOf(10));

        URI uri = getURI();

        // when
        ResultActions actions = mockMvc.perform(getRequestBuilder(uri, queryParams));

        // then
        MvcResult result = actions
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.data").isArray())
                                .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");

        assertThat(list.size(), is(2));
    }

    @Test
    void deleteMemberTest() throws Exception {
        // given
        long memberId = 1L;

        // Stubbing by Mockito
        doNothing().when(memberService).deleteMember(memberId);

        // when
        ResultActions actions = mockMvc.perform(deleteRequestBuilder(getURI(memberId)));

        // then
        actions.andExpect(status().isNoContent());
    }
}
