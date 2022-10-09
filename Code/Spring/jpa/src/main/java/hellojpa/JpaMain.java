package hellojpa;

import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("HomeCity","street","10000"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
            member.getAddressHistory().add(new AddressEntity("old2","street","10000"));

            em.persist(member);

            em.flush();
            em.clear();



//            System.out.println("==================start==================");
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("==================end==================");
//
//            //homeCity->newCity
//            Address address = findMember.getHomeAddress();
//           // findMember.setHomeAddress(new Address("newCity", address.getStreet(), address.getZipcode()));
//
//            //chicken -< korean
//            //findMember.getFavoriteFoods().remove("치킨");
//            //findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new Address("old1","street","10000"));
//            findMember.getAddressHistory().add(new Address("newCity1","street","10000"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
