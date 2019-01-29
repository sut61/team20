package team20.se61.sut.wongnai.Entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Data
@Table(name="Prefix")
public class PrefixEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long prefixid;

    private
    @NotNull(message = "กรุณาเลือกคำนำหน้า")
    @Column(unique = true)
    @Pattern(regexp = "เด็กหญิง|เด็กชาย|นาย|นาง|นางสาว",message ="เด็กหญิง เด็กชาย นาย นาง นางสาว เท่านั้น" )
    String prefix;

    public PrefixEntity(){}

    public PrefixEntity(String prefix){
        this.prefix=prefix;
    }

}