package wind.yang.jpa.relationtest.OneToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter
@Setter
public class Human {
    @Id @GeneratedValue
    Long id;
    String name;

    @OneToMany
    List<Car> cars;

    public List<Car> getCars() {
        if(cars == null){
            this.cars = new ArrayList<>();
        }
        return cars;
    }
}
