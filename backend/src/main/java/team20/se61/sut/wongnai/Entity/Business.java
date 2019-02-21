package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@Getter @Setter
public class Business {
    @Id
    @SequenceGenerator(name="Business_seq",sequenceName="Business_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Business_seq")
    private Long id;
    @Column(unique=true)
    @Pattern(regexp = "[ก-์|A-z|\\s].+")
    private @NotNull String shopName;
    @Size(min = 5,max = 20)
    private String district;
    @Pattern(regexp="\\d{10}")
    private String tel;
    @Pattern(regexp="[A-Za-z0-9._]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String email;

    public Business(){}

    @ManyToOne()   
    @JoinColumn(name= "provinceId")    
    @NotNull 
    private Province province;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn( unique=true, name="profilesId")
    private ProfilesEntity profile;


    @ManyToOne()   
    @JoinColumn(name= "typeId")     
    private BusinessType type;
}