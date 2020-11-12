package com.trip.tripsoda.domain.tour;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.domain.dirver.Driver;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private Long id;

    private String name;

    private int personCount; //인원

    private int payment; //결제금액

    private int takeTime; //걸리는 시간

    private int visitCount; //투어일정 몇 곳인지

    private boolean finish;

    private String tourType; //all, taxi, other enum으로 줄 수 있는데 jsp 에서 enum 데이터 바인딩 하는 방법을 알아야함

    private String buyType; //구매 방식

    private int buyPay;// 구매 가격

    private String code;  //구매 코드

    @Embedded
    private TourAddress address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private LocalDate tourDate;
}
