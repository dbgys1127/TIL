package com.codestates.restdocs.member;


import com.codestates.member.controller.MemberController;
import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.stamp.Stamp;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.codestates.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

//(1) Controller를 테스트 하기 위한 전용 애너테이션이다.
// 괄호 안에는 테스트 대상 컨트롤러가 지정된다.
@WebMvcTest(MemberController.class)

//(2)JPA에서 사용하는 bean들을 Mock 객체로 주입해주는 설정이다.
// Spring Boot 기반의 테스트는 항상 최상위 패키지 경로에 있는 xxxxxApplication 클래스를 찾아서 실행한다.
// 최상위에 xxxxxApplication에 @EnableJpaAuditing이 추가 되면 JPA 관련 Bean을 필요로 하기 때문에
// @WebMvcTest 애너테이션을 사용해서 테스트를 진행할 경우 항상 JpaMetamodelMappingContext.class가 필요하다.
@MockBean(JpaMetamodelMappingContext.class)

//(3) Spring Rest Docs에 대한 자동 구성을 위해 필요하다.
@AutoConfigureRestDocs
public class MemberControllerRestDocsTest {
    //(4) MockMvc 객체를 주입
    @Autowired
    private MockMvc mockMvc;

    // 컨트롤러 클래스가 의존하는 객체(서비스, Mapper)의 의존성 제거를 의해 Mock 객체를 주입받는다.
    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;
    // 위 두개의 @MockBean로 의존성을 제거한 가짜 객체는 테스트 케이스에서 가짜 메서드를 호출하는데 쓴다.
    @Autowired
    private Gson gson;

    @Test
    public void postMemberTest() throws Exception {
        //given
        // (6-1) 테스트 데이터
        // HTTP request에 필요한 request body나 query parameter, path variable 등 데이터를 추가
        // postMember() 핸들러 메서드에 전송하는 request body 이다.
        MemberDto.Post post = new MemberDto.Post("dbgys1127@gmail.com", "김유현", "010-1111-2222");
        String content = gson.toJson(post);

        //(6-2)
        // postMember() 핸들러 메서드가 응답으로 전송하는 response body이다.
        MemberDto.response responseDto = new MemberDto.response(1L,
                "dbgys1127@gmail.com",
                "김유현",
                "010-1111-2222",
                Member.MemberStatus.MEMBER_ACTIVE,
                new Stamp());

        // (7-1) Mock 객체를 이용한 Stubbing
        // (5)에서 주입 받은 Mock 객체가 동작하도록 given() 메서드로 Stubbing 해준다.
        // MemberController의 postMember()에서 의존하는 객체의 메서드 호출을 주입받은 Mock 객체를 사용해서 Stubbing하고 있다.
        //(7-2)
        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        //(7-3)
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());

        //(7-4)
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);


        //when
        ResultActions actions =
                mockMvc.perform(
                        //(8) request 전송
                        //perfrom 메서드로 request를 전송한다.
                        // HTTP 헤더를 구성해서 POST 요청을 전송
                        post("/v11/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        //then
        actions//(9) response에 대한 기대 값 검증)
                // 비교대상은 postMember()를 통해 요청이 전달된후 응답으로 온 데이터를 원래 우리가 요청보낼때 데이터와 비교하는것이다.
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(post.getName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
                .andDo(document(
                        //(10-1) API 문서 스펙 정보 추가
                        // 테스트 수행 이후, API 문서를 자동 생성하기 위해 해당 컨트롤러 핸들러 메서드의
                        // API스펙정보를 document()에 추가해준다.
                        //andDo는 일반적인 동작을 정의할 때 사용한다.
                        //**********
                        // document(...)메서드는 API 스펙 정보를 전달 받아서 실질적인 문서화 작업을 수행하는
                        // RestDocumentationResultHandler 클래스 에서 가장 핵심 기능을 하는 메서드다
                        //(10-2) API 문서 스니핏(문서조각)의 식별자 역할을 하며,
                        // 지정한 값의 디렉토리 하위에 문서 스니핏이 생성됨
                        "post-member",
                        //(10-3) request와 response에 해당하는 문서 영역을 전처리한다.
                        getRequestPreProcessor(),
                        //(10-4)
                        getResponsePreProcessor(),
                        //(10-5)
                        // 문서로 표현될 request body를 의미하며,
                        // fieldWithPate의 반환값인 FieldDescriptor 객체가 request body에 포함될 데이터다
                        requestFields(
                                List.of(
                                        //(10-6)
                                        //JSON 포맷으로 표현시 하나의 프로퍼티를 의미하는 FieldDescriptor이며,
                                        // type(JsonFieldType.String) 는 JSON프로퍼티 값의 타입을 의미
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호")
                                )
                        ),
                        //(10-7)
                        responseFields(
                                List.of(
                                        //(10-8)
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원상태"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }
    @Test
    public void patchMemberTest() throws Exception {
        //given
        long memberId = 1L;
        MemberDto.Patch patch = new MemberDto.Patch(memberId,
                "김유현",
                "010-1111-1111",
                Member.MemberStatus.MEMBER_ACTIVE);
        String content = gson.toJson(patch);

        MemberDto.response responseDto =
                new MemberDto.response(1L,
                        "dbgys1127@gmail.com",
                        "김유현",
                        "010-1111-1111",
                        Member.MemberStatus.MEMBER_ACTIVE,
                        new Stamp());

        given(mapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());

        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        //when
        ResultActions actions =
                mockMvc.perform(
                        patch("/v11/members/{member-id}",memberId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andExpect(jsonPath("$.data.name").value(patch.getName()))
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(patch.getMemberStatus()))
                .andDo(document("patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        //(1) 쿼리 파라미터에 대한 API 안내 부분이다.
                        //patchMember()와 getMember()는 “/v11/members/{member-id}”
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        ),
                        requestFields(
                                List.of(
                                        //(2) path variable(쿼리파라미터)로 전달 받으면 requestbody에 매핑되지 않으므로 ignored()
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자").ignored(),
                                        //(3) 수정해도 되고 안해도 되기 때문에, optional()
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름").optional(),
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호").optional(),
                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING).description("회원상태: MEMBER_ACTIVE / MEMBER_SLEEP / MEMBER_QUIT").optional()
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING).description("회원상태: 활동중 / 휴면상태 / 탈퇴 상태"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }
}