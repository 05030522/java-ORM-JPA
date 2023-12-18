package jpabasic1;

import jpabook.jpashop.domain.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class M {
    @Id @GeneratedValue
    @Column(name = "M_ID")
    private Long id;
    private String nema;
    private String city;
    private String street;
    private int zipcode;
    @OneToMany(mappedBy = "m")
    private List<O> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNema() {
        return nema;
    }

    public void setNema(String nema) {
        this.nema = nema;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
