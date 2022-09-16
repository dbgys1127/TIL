package com.codestates.homework;

import com.codestates.helper.MemberControllerTestHelper;
import com.codestates.helper.StubData;
import com.codestates.member.controller.MemberController;
import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.stamp.Stamp;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 리팩토링 수행 전 버젼
 */
@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MemberControllerDocumentationHomeworkTest_V1 implements MemberControllerTestHelper {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;

    @Autowired
    private Gson gson;
    @Test
    public void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com","홍길동",
                                                                "010-1111-1111");
        String content = gson.toJson(post);

        MemberDto.Response responseBody = new MemberDto.Response(1L,
                                                            "hgd@gmail.com",
                                                            "홍길동",
                                                            "010-1111-1111",
                                                            Member.MemberStatus.MEMBER_ACTIVE,
                                                            new Stamp());

        // willReturn()이 최소한 null은 아니어야 한다.
        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseBody);

        // when
        ResultActions actions =
                mockMvc.perform(
                        RestDocumentationRequestBuilders.post("/v11/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content));

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(post.getName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
                .andDo(document("post-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호")
                                )
                        ),
                        responseFields(
                                Arrays.asList(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING)
                                                .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }

    @Test
    public void patchMemberTest() throws Exception {
        // given
        long memberId = 1L;
        MemberDto.Patch patch = new MemberDto.Patch(1,
                                                "홍길동",
                                            "010-1111-1111",
                                                Member.MemberStatus.MEMBER_ACTIVE);
        String content = gson.toJson(patch);

        MemberDto.Response responseDto = new MemberDto.Response(1L,
                                                            "hgd@gmail.com",
                                                            "홍길동",
                                                            "010-1111-1111",
                                                            Member.MemberStatus.MEMBER_ACTIVE,
                                                            new Stamp());

        // willReturn()이 최소한 null은 아니어야 한다.
        given(mapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());

        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        // when
        ResultActions actions = mockMvc.perform(
                                                RestDocumentationRequestBuilders
                                                        .patch("/v11/members/{member-id}", memberId)
                                                        .accept(MediaType.APPLICATION_JSON)
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .content(content));

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andExpect(jsonPath("$.data.name").value(patch.getName()))
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(patch.getMemberStatus().getStatus()))
                .andDo(document("patch-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                        ),
                        requestFields(
                                List.of(
                                    fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자").ignored(),
                                    fieldWithPath("name").type(JsonFieldType.STRING).description("이름").optional(),
                                    fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호").optional(),
                                    fieldWithPath("memberStatus").type(JsonFieldType.STRING)
                                            .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)")
                                            .optional()
                                )
                        ),
                        responseFields(
                                Arrays.asList(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING)
                                                .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }

    @Test
    public void getMemberTest() throws Exception {
        // given
        long memberId = 1L;
        MemberDto.Response response = new MemberDto.Response(1L,
                                                        "hgd@gmail.com",
                                                        "홍길동",
                                                        "010-1111-1111",
                                                        Member.MemberStatus.MEMBER_ACTIVE,
                                                        new Stamp());
        given(memberService.findMember(Mockito.anyLong())).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/v11/members/{member-id}", memberId)
                                                .accept(MediaType.APPLICATION_JSON));

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(memberId))
                .andExpect(jsonPath("$.data.name").value(response.getName()))
                .andDo(
                    document("get-member",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                        ),
                        responseFields(
                                Arrays.asList(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING)
                                                .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }

    @Test
    public void getMembersTest() throws Exception {
        // given
        String page = "1";
        String size = "10";

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        Member member1 = new Member("hgd1@gmail.com", "홍길동1", "010-1111-1111");
        member1.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
        member1.setStamp(new Stamp());

        Member member2 = new Member("hgd2@gmail.com", "홍길동2", "010-2222-2222");
        member2.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
        member2.setStamp(new Stamp());

        Page<Member> members = new PageImpl<>(List.of(member1, member2),
                                            PageRequest.of(0, 10, Sort.by("memberId").descending()), 2);
        List<MemberDto.Response> responses = StubData.MockMember.getMultiResponseBody();

        // Stubbing
        given(memberService.findMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(members);
        given(mapper.membersToMemberResponses(Mockito.anyList())).willReturn(responses);

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/v11/members")
                                                .params(queryParams)
                                                .accept(MediaType.APPLICATION_JSON));

        // then
        MvcResult result =
            actions
                    .andExpect(status().isOk())
                    .andDo(
                        document(
                            "get-members",
                            preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            requestParameters(
                                    getDefaultRequestParameterDescriptors()
                            ),
                            responseFields(
                                Arrays.asList(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터")
                                                                                                    .optional(),
                                        fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data[].email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data[].name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data[].phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data[].memberStatus").type(JsonFieldType.STRING)
                                                .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data[].stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수"),
                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보")
                                                                                                                .optional(),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 번호")
                                                                                                                .optional(),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 사이즈")
                                                                                                                .optional(),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 건 수")
                                                                                                                .optional(),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
                                                                                                                .optional()
                                )
                            )
                        )
                    )
                    .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");
        assertThat(list.size(), is(2));
    }

    @Test
    public void deleteMemberTest() throws Exception {
        // given
        long memberId = 1L;
        doNothing().when(memberService).deleteMember(Mockito.anyLong());

        // when
        ResultActions actions = mockMvc.perform(
                                    RestDocumentationRequestBuilders
                                            .delete("/v11/members/{member-id}", memberId));
        // then
        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-member",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("member-id").description("회원 식별자 ID"))
                                )
                        )
                );
    }
}
