package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String branch;

    @ManyToOne
    PriceRange priceRange;

    private String adddress;
    private String hint;
    private String province;
    private String district;
    private String subDistrict;
    private String building;

    private String phone;
    private String email;
    private String website;
    private String time;

    @ManyToOne
    private String numberOfSeat;

    private String image; // url

}