package team20.se61.sut.wongnai.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ShopAdvertise")
public class ShopAdvertise {
    @Id
    @SequenceGenerator(name = "ShopAdvertise_seq", sequenceName = "ShopAdvertise_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ShopAdvertise_seq")
    private long id;
    @Pattern(regexp = "[ก-์|A-z|\\s].+")
    @Column(unique = true)
    private @NotNull String name;
    @Size(min = 10, max = 100, message = "size must be 10 - 100")
    private String detail;
    @Pattern(regexp = "(http(s?):).+(.jpg|.gif|.png).+", message = "imgUrl is not Pattern")
    private @NotNull String imgUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true, name = "storeId")
    private Store store;

    @ManyToOne()
    @JoinColumn(name = "advertisePackageId")
    private @NotNull AdvertisePackage advertisePackage;
}