package wind.yang.jpa.relationtest.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
@Getter
@Setter
public class Human {
    @Id @GeneratedValue
    Long id;
    String name;
}
