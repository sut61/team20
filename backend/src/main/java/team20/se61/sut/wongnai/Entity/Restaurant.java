package team20.se61.sut.wongnai.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantid;


    @NotNull(message = "restaurant name not null")
    @Pattern(regexp = "[a-zA-Z1-9]*|[ก-์1-9]*",message = "restuarant not special string")
    private String restaurant;

    @NotNull(message = "restaurant telephonenumber not null")
    @Size(min = 9,max = 10,message = "telephone size 9-10")
    @Pattern(regexp = "0\\d+",message = "telephone must start with zero")
    private String telephonenumber;

    @NotNull(message = "restaurant identit not null")
    @Pattern(regexp = "[a-zA-Z0-9]*|[ก-์]*",message = "identity not special string")
    @Column(unique = true)
    private String identity;
}
