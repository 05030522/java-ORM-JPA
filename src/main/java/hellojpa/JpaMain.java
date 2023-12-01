package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
//            em.persist(member);
////            member.setName("aaaa");
//
////            em.detach(member);
//
////            em.flush();
//            System.out.println("========================");
            member.setUsername("c");

            em.persist(member);
            em.flush();

//            em.clear(); //영속성 컨텍스트를 완전 초기화

//            em.find(Member.class, 2L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            em.remove(findMember);
//            findMember.setName("HelloJPA");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            //jpa는 테이블을 대상으로 코드를 절대짜지않음, 멤버 객체를 대상으로 코드를 작성함
//
//            for (Member member : result){
//                System.out.println("member = " + member.getName());
//            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
