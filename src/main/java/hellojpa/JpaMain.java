package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

/*        Member member = new Member();
        member.setId(2L);
        member.setName("HelloB");

        em.persist(member);
        tx.commit();
        em.close();
        emf.close();*/

        try {
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.find(Member.class, 200L);
            member.setName("aaaa");

            em.detach(member);

            em.flush();
            System.out.println("========================");



//            em.clear(); //영속성 컨텍스트를 완전 초기화

            em.find(Member.class, 2L);
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
