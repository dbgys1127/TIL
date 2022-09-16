package com.codestates.homework;

import com.codestates.helper.MemberControllerTestHelper;
import com.codestates.helper.StubData;
import com.codestates.member.controller.MemberController;
import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static com.codestates.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MemberControllerDocumentationHomeworkTest_V2 implements MemberControllerTestHelper {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;

    @Test
    public void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = (MemberDto.Post) StubData.MockMember.getRequestBody(HttpMethod.POST);
        String content = toJsonContent(post);

        MemberDto.Response responseBody = StubData.MockMember.getSingleResponseBody();

        // willReturn()이 최소한 null은 아니어야 한다.
        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseBody);

        // when
        ResultActions actions =
                mockMvc.perform(postRequestBuilder(getUrl(), content));

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(post.getName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
                .andDo(document("post-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                getDefaultMemberPostRequestDescriptors()
                        ),
                        responseFields(
                                getFullResponseDescriptors(
                                        getDefaultMemberResponseDescriptors(DataResponseType.SINGLE))
                        )
                ));
    }

    @Test
    public void patchMemberTest() throws Exception {
        // given
        long memberId = 1L;
        MemberDto.Patch patch = (MemberDto.Patch) StubData.MockMember.getRequestBody(HttpMethod.PATCH);
        String content = toJsonContent(patch);

        MemberDto.Response responseDto = StubData.MockMember.getSingleResponseBody();

        // willReturn()이 최소한 null은 아니어야 한다.
        given(mapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());

        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        // when
        ResultActions actions = mockMvc.perform(patchRequestBuilder(getURI(), memberId, content));

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andExpect(jsonPath("$.data.name").value(patch.getName()))
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(patch.getMemberStatus().getStatus()))
                .andDo(document("patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                getMemberRequestPathParameterDescriptor()
                        ),
                        requestFields(
                               getDefaultMemberPatchRequestDescriptors()
                        ),
                        responseFields(
                                getFullResponseDescriptors(
                                        getDefaultMemberResponseDescriptors(DataResponseType.SINGLE))
                        )
                ));
    }

    @Test
    public void getMemberTest() throws Exception {
        // given
        long memberId = 1L;
        MemberDto.Response response = StubData.MockMember.getSingleResponseBody();

        given(memberService.findMember(Mockito.anyLong())).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(getRequestBuilder(getURI(), memberId));

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(memberId))
                .andExpect(jsonPath("$.data.name").value(response.getName()))
                .andDo(
                    document("get-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                getMemberRequestPathParameterDescriptor()
                        ),
                        responseFields(
                                getFullResponseDescriptors(
                                        getDefaultMemberResponseDescriptors(DataResponseType.SINGLE))
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

        Page<Member> members = StubData.MockMember.getMultiResultMember();
        List<MemberDto.Response> responses = StubData.MockMember.getMultiResponseBody();

        // Stubbing
        given(memberService.findMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(members);
        given(mapper.membersToMemberResponses(Mockito.anyList())).willReturn(responses);

        // when
        ResultActions actions = mockMvc.perform(getRequestBuilder(getUrl(), queryParams));

        // then
        MvcResult result =
            actions
                    .andExpect(status().isOk())
                    .andDo(
                            document(
                                    "get-members",
                                    getRequestPreProcessor(),
                                    getResponsePreProcessor(),
                                    requestParameters(
                                            getDefaultRequestParameterDescriptors()
                                    ),
                                    responseFields(
                                            getFullPageResponseDescriptors(
                                                    getDefaultMemberResponseDescriptors(DataResponseType.LIST))

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
        mockMvc.perform(deleteRequestBuilder(getURI(), memberId))
                .andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-member",
                                getRequestPreProcessor(),
                                getResponsePreProcessor(),
                                pathParameters(
                                        getMemberRequestPathParameterDescriptor()
                                )
                        )
                );
        // then
    }
}
