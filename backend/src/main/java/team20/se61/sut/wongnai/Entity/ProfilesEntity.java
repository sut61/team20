package team20.se61.sut.wongnai.Entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Data
@Table(name="Profiles")
public class ProfilesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long profilesid;

    private
    @NotNull(message = "กรุณากรอกชื่อและนามสกุล")
   // @Pattern(regexp = "[a-zA-Z]*|[ก-์]*|[\\s]*",message = "ที่อยู่ต้องไม่มีอักขระพิเศษ")
    String name;

    private
    @NotNull(message = "กรุณากรอกemail")
    @Column(unique = true)
    @Email(message = "กรอกemailไม่ถูกต้อง")
    String email;

    private
    @NotNull(message = "กรุณากรอกรหัสผ่าน")
    @Size(min =8,message = "รหัสผ่านอย่างน้อย8อักษร")
    String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SexEntity.class)
    @JoinColumn(name="sexid",insertable = true)
    private @NotNull(message = "กรุณาเลือกเพศ") SexEntity sex;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PrefixEntity.class)
    @JoinColumn(name="prefixid",insertable = true)
    private @NotNull(message = "กรุณาเลือกคำนำหน้า") PrefixEntity prefix;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "contactid", insertable = true,unique = true)
    private @NotNull(message = "กรุณากรอกที่อยู่ติดต่อ") ContactEntity contact;
   
}