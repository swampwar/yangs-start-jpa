package wind.yang.jpa.relationtest.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Getter
@Setter
public class Car {
    @Id @GeneratedValue
    Long Id;
    String type;
    int number;

    @ManyToOne
    Human owner;
}
