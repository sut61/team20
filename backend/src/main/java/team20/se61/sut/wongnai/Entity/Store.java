package team20.se61.sut.wongnai.Entity;

import lombok.*;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=20, message="Name should have atleast 2 characters or max 20 characters")
    private String name;
    @Size(min=2)
    private String branch;

    @ManyToOne
    private Business business;

    @ManyToOne
    @NotNull
    private PriceRange priceRange;

    @NotNull
    @Size(min=5)
    private String adddress;
    @Size(min=2)
    private String hint;
    @Size(min=2)
    private String province;
    @Size(min=2)
    private String district;
    @Size(min=2)
    private String subDistrict;
    @Size(min=2)
    private String building;

    @Size(min=10, max=10, message="Phone should have 10 characters")
    private String phone;
    
    @Email
    private String email;
    @Size(min=3)
    private String website;

    @ManyToMany
    @JoinTable(name = "store_openday", joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "dayOfWeeks_id", referencedColumnName = "id"))
    @NotEmpty
    private Set<DayOfWeek> dayOfWeeks;
    
    @NotNull
    private Date openTime;
    @NotNull
    private Date closeTime;

    @ManyToOne
    @NotNull
    private NumberOfSeat numberOfSeat;

    @Pattern(regexp="(http(s?):).+(.jpg|.png|.gif|.JPG|.PNG|.GIF|.JPEG|.jpeg).+")
    private String image; // url

    public Store(Set<DayOfWeek> day){
        this.dayOfWeeks = day;
    }

}