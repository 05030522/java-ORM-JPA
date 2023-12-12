package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member(); //멤버 저장
            member.setName("member1");
            em.persist(member);

            Team team = new Team(); //팀 저장
            team.setName("TeamA");
//            team.getMembers().add(member); //가짜
            em.persist(team);
            member.setTeam(team); //주인

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            for (Member m : members) { //iter
                System.out.println("m = " +  m.getName());
            }

//            Member member = new Member();
//            member.setName("member1");
////            member.setTeamId(team.getId());
////            em.persist(member);
//            member.setTeam(team);
//            em.persist(member);

//            Member findMember = em.find(Member.class, member.getId());

//            Team findTeam = findMember.getTeam();
////            findTeam.getMember();
//            System.out.println("findTeam = " + findTeam.getName());
////            Team findTeam = em.find(Team.class, findTeamId);

//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m = " + m.getName());
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