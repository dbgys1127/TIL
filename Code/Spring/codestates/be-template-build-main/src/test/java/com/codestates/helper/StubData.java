package com.codestates.helper;

import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.order.entity.Order;
import com.codestates.stamp.Stamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StubData {
    private static Map<HttpMethod, Object> stubRequestBody;
    static {
        stubRequestBody = new HashMap<>();
        stubRequestBody.put(HttpMethod.POST, new MemberDto.Post("hgd@gmail.com","홍길동",
                "010-1111-1111"));
        stubRequestBody.put(HttpMethod.PATCH, new MemberDto.Patch(1, "홍길동", "010-1111-1111", Member.MemberStatus.MEMBER_ACTIVE));
    }

    public static class MockMember {
        public static Object getRequestBody(HttpMethod method) {
            return stubRequestBody.get(method);
        }

        public static MemberDto.Response getSingleResponseBody() {
            return new MemberDto.Response(1L,
                    "hgd@gmail.com",
                    "홍길동",
                    "010-1111-1111",
                    Member.MemberStatus.MEMBER_ACTIVE,
                    new Stamp());
        }

        public static List<MemberDto.Response> getMultiResponseBody() {
            return List.of(
                    new MemberDto.Response(1L,
                            "hgd1@gmail.com",
                            "홍길동1",
                            "010-1111-1111",
                            Member.MemberStatus.MEMBER_ACTIVE,
                            new Stamp()),
                    new MemberDto.Response(2L,
                            "hgd2@gmail.com",
                            "홍길동2",
                            "010-2222-2222",
                            Member.MemberStatus.MEMBER_ACTIVE,
                            new Stamp())
            );
        }

        public static Member getSingleResultMember() {
            Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");
            member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member.setStamp(new Stamp());


            return member;
        }

        public static Page<Member> getMultiResultMember() {
            Member member1 = new Member("hgd1@gmail.com", "홍길동1", "010-1111-1111");
            member1.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member1.setStamp(new Stamp());

            Member member2 = new Member("hgd2@gmail.com", "홍길동2", "010-2222-2222");
            member2.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member2.setStamp(new Stamp());

            return new PageImpl<>(List.of(member1, member2),
                    PageRequest.of(0, 10, Sort.by("memberId").descending()),
                    2);
        }

        public static Member getSingleResultMember(long memberId) {
            Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");
            member.setMemberId(memberId);
            member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member.setStamp(new Stamp());
            return member;
        }

        public static Member getSingleResultMember(long memberId, Map<String, String> updatedInfo) {
            String name = Optional.ofNullable(updatedInfo.get("name")).orElse("홍길동");
            String phone = Optional.ofNullable(updatedInfo.get("phone")).orElse("010-1111-1111");
            Member member = new Member("hgd@gmail.com", name, phone);
            member.setMemberId(memberId);
            member.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
            member.setStamp(new Stamp());
            return member;
        }
    }

    public static class MockOrder {
        public static Order getSingleResponseBody(long orderId) {
            Order order = new Order();
            order.setOrderId(orderId);
            order.setOrderStatus(Order.OrderStatus.ORDER_CONFIRM);

            return order;
        }
    }
}
