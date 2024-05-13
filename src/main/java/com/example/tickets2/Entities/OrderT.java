package com.example.tickets2.Entities;

import com.example.tickets2.Enums.OrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createAt;

    private OrderState orderState = OrderState.New;





    @OneToMany(mappedBy = "orderT", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList  = new ArrayList<>();
    @OneToMany(mappedBy = "orderT", fetch = FetchType.LAZY)
    private List<Payment> paymentList  = new ArrayList<>();
    @ManyToOne
    private Customer customer;

    public double getTotalPrice() {
        double totalPrice = 0.0;
        List<OrderDetail> orderDetails = this.getOrderDetailList();

        for (OrderDetail orderDetail : orderDetails) {
            totalPrice += orderDetail.getQuantity() * orderDetail.getTicket().getPrice();
        }

        return totalPrice;
    }




}
