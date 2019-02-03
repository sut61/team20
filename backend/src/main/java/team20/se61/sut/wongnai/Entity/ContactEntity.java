package team20.se61.sut.wongnai.Entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Data
@Table(name="Contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long contactid;

    private
    @NotNull(message = "กรุณากรอกที่อยู่")
    @Size(min = 20,message = "ที่อยู่ต้องอย่างน้อย 20 อักษร")
   // @Pattern(regexp = "[a-zA-Z0-9]*.*-* *|[ก-์]*.*-* *|\\n*|/*",message = "ที่อยู่ต้องไม่มีอักขระพิเศษ")
    String address;

    private
    @NotNull(message = "กรุณากรอกเบอร์โทรศัพท์")
    @Column(unique = true)
    @Pattern(regexp = "0\\d{9}",message ="เบอร์โทรศัพท์ต้องขึ้นต้นด้วย 0 และตัวเลขครบ 10 ตัว" )
    String telephonenumber;

}