package jpabook;

import javax.persistence.Entity;

@Entity
public class Movie extends Item2 {
    private String actor;
    private String director;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
