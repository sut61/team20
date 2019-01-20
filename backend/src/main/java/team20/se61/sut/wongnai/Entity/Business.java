package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Business {
    @Id @GeneratedValue
    private Long id;
    private String shopName;
    private String district;
    private String tel;
    private String email;

    public Business(){}

    @ManyToOne()   
    @JoinColumn(name= "provinceId")     
    private Province province;

    @ManyToOne()   
    @JoinColumn(name= "profilesId")     
    private ProfilesEntity profile;

    @ManyToOne()   
    @JoinColumn(name= "typeId")     
    private BusinessType type;
}