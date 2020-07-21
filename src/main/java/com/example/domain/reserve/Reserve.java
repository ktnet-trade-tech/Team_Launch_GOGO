package com.example.domain.reserve;

import com.example.domain.company.Company;
import com.example.domain.store.Store;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
public class Reserve {

    @Id
    @GeneratedValue
    @Column(name = "reserve_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private String reserver;

    private Date reserve_date;   // 예약 날짜

    private int count;          // 방문 횟수
    private int reserved_count; // 한번에 몇명 방문했는지.

    public static Reserve createStore(Store store,String reserver, Date reserve_date, int count){
        Reserve result = new Reserve();
        result.setStore(store);
        result.setCount(count);
        result.setReserver(reserver);
        result.setReserve_date(reserve_date);

        return result;
    }

}
