package wind.yang.jpa.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Getter
@Setter
@ToString
//@Table(name = "tb_auth")
public class Auth {
//    @Id @GeneratedValue
    private Long authId;

    private String authName;

//    @ManyToOne
    private Account account;
}



