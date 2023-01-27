package ch3.persistence_managing;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EntityUpdate {
    public static void main(String[] args) {
        EntityManager em = EntitySave.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member memberA = em.find(Member.class, 1L);

        //영속 엔티티 데이터 수정
        memberA.setUsername("h2");
        memberA.setAge(10);

        tx.commit();

        em.close();
        EntitySave.emf.close();
    }
}
