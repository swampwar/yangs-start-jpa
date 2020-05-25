package wind.yang.jpa.relationtest.OneToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
@Getter
@Setter
public class Car {
    @Id @GeneratedValue
    Long Id;
    String type;
    int number;
}
