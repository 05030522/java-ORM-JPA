package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
//    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;
//    @Column(name = "TEAM_ID")
//    private Long teamId;
    private int age;
    //    @ManyToOne(fetch = FetchType.LAZY) //멤버랑 팀이랑 쿼리가 분리해서 나가는 지연로딩 전략
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}