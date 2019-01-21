package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Business {
    @Id
    @SequenceGenerator(name="Business_seq",sequenceName="Business_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Business_seq")
    private Long id;
    private @NonNull String shopName;
    private String district;
    private String tel;
    private String email;

    public Business(){}

    @ManyToOne()   
    @JoinColumn(name= "provinceId")     
    private Province province;

    @ManyToOne()   
    @JoinColumn(name= "profilesId")     
    private @NonNull ProfilesEntity profile;

    @ManyToOne()   
    @JoinColumn(name= "typeId")     
    private BusinessType type;
}