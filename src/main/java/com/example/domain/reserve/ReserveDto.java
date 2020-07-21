package com.example.domain.reserve;

import com.example.domain.store.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ReserveDto {

    private Long id;
    private String name;
    private String address;
    private String phoneNum;
    private String reserver;
    private Date reserve_date;   // 예약 날짜
    private int count;
    private Long storeId;

    public ReserveDto(Reserve reserve) {
        id = reserve.getId();
        reserver = reserve.getReserver();
        reserve_date = reserve.getReserve_date();
        name = reserve.getStore().getName();
        address = reserve.getStore().getAddress();
        phoneNum = reserve.getStore().getPhoneNum();
        count= reserve.getCount();
        storeId = reserve.getStore().getId();
    }

}
