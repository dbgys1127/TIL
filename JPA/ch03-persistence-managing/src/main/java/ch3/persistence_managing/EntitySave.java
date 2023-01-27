package ch3.persistence_managing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntitySave {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {

        Member member1 = new Member("c",11);
        Member member2 = new Member("b",11);

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(member1);

        em.detach(member1);

        tx.commit(); // 커밋하지 않으면 insert쿼리를 실행 하지 않는다.
        em.close();
        emf.close();
    }
}
