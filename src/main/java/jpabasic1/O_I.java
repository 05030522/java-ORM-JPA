package jpabasic1;

import javax.persistence.*;

@Entity
public class O_I {
    @Id @GeneratedValue
    @Column(name = "O_I_ID")
    private Long id;
//    @Column(name = "O_ID")
//    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "O_ID")
    private O oder;
//    @Column(name = "I_ID")
//    private Long itemId;
    @ManyToOne
    @JoinColumn(name = "I_ID")
    private I item;
    private int orderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public O getOder() {
        return oder;
    }

    public void setOder(O oder) {
        this.oder = oder;
    }

    public I getItem() {
        return item;
    }

    public void setItem(I item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setOrder(O o) {
    }
}
