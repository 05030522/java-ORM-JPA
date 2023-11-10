package hellojpa;

import javax.persistence.*;

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
            Member findMember = em.find(Member.class, 2L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            em.remove(findMember);
            findMember.setName("HelloJPA");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
