package team20.se61.sut.wongnai.Entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Data
@Table
public class Foodproperties {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private
    @NotNull(message = "�?รุณา�?รอ�?�?ุณ�?�?าทา�?�?ภ�?�?า�?าร")
    @Size(min=2,max=250)
    @Pattern(regexp = "^((?!(ลุ�?�?ท�?ี�?|SamuelJackson))[\\s\\S])*$",message = "�?รุณา�?�?�?�?ำที�?สุภา�?")
    @Column(unique = true)
    String foodproperties;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Recipe_id", unique = true)
    private @NotNull Recipe recipe;

}