package jpabasic1;

import jpabook.jpashop.domain.OrderItem;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ORDERS")
public class O {
    @Id @GeneratedValue
    @Column(name = "O_ID")
    private Long id;
//    @Column(name = "MEMBER_ID")
//    private Long memberId;
    @ManyToOne
    @JoinColumn(name = "M_ID")
    private M m;
    @OneToMany(mappedBy = "o")
    private List<O_I> orderItems = new ArrayList<>();
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

    public void addOrderItem(O_I orderItem) {
        orderItems.add(orderItem);
        orderItem.setO(this);
    }
}
