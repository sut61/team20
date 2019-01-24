package team20.se61.sut.wongnai.Entity;

import lombok.*;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String branch;

    @ManyToOne
    private Business business;

    @ManyToOne
    private PriceRange priceRange;


    private String adddress;
    private String hint;
    private String province;
    private String district;
    private String subDistrict;
    private String building;

    private String phone;
    private String email;
    private String website;

    @ManyToMany
    @JoinTable(name = "store_openday", joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "dayOfWeeks_id", referencedColumnName = "id"))
    private Set<DayOfWeek> dayOfWeeks;
    
    private String openTime;
    private String closeTime;

    @ManyToOne
    private NumberOfSeat numberOfSeat;

    private String image; // url

    public Store(Set<DayOfWeek> day){
        this.dayOfWeeks = day;
    }

}