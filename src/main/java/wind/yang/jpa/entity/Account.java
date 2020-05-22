package wind.yang.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "account") // 객체의 이름
@Table(name = "tb_account") // 테이블의 이름, 디폴트는 @Entity name과 동일하다.
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column // 옵션을 주는게 아니라면 생략해도 된다.
    private String password;

    @Temporal(TemporalType.TIMESTAMP) // java.util.Date와 java.util.Calendar만 지원한다.
    private Date created;

    @Transient // 테이블에 칼럼을 추가하지 않는다.
    private String noTableCol;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column = @Column(name="inner_street")),
            @AttributeOverride(name="zipCode", column = @Column(name="inner_zipCode")),

    })
    private Address address;

//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    Set<Auth> auths = new HashSet<>();

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                '}';
    }
}
