package ch3.persistence_managing;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ExamMergeMain {
    public static void main(String[] args) {
        Member member = createMember("회원1");

        member.setUsername("회원명변경");
        mergeMember(member);
    }

    static Member createMember(String username) {
        //==영속성 컨텍스트 1차 시작==//
        System.out.println("//==영속성 컨텍스트 1차 시작==//");
        EntityManager em = EntitySave.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setUsername(username);

        em.persist(member);
        tx.commit();

        em.close(); // 영속성 컨텍스트 1 종료, member 엔티티는 준영속 상태가 된다.
        System.out.println("//==영속성 컨텍스트 1차 종료==//");
        return member;
    }

    static void mergeMember(Member member) {
        //==영속성 컨텍스트 2차 시작==//
        System.out.println("//==영속성 컨텍스트 2차 시작==//");
        EntityManager em = EntitySave.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member mergeMember = em.merge(member);
        tx.commit();

        //member는 준영속 상태
        System.out.println("member = "+member.getUsername());

        //mergeMember는 영속 상태
        System.out.println("mergeMember = "+mergeMember.getUsername());

        System.out.println("em contains member = "+em.contains(member)); // 변경전의 member는 한번 em.close()때 사라졌기때문에, 계속 준영속으로 남는다.
        System.out.println("em contains mergeMember = "+em.contains(mergeMember));

        em.close();
        System.out.println("//==영속성 컨텍스트 2차 종료==//");
    }
}
