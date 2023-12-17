package jpabasic1;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class O {
    @Id @GeneratedValue
    @Column(name = "O_ID")
    private Long id;
//    @Column(name = "MEMBER_ID")
//    private Long memberId;
    @ManyToOne
    @JoinColumn(name = "M_ID")
    private M m;

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private O_S status;

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public O_S getStatus() {
        return status;
    }

    public void setStatus(O_S status) {
        this.status = status;
    }
}
