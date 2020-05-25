package wind.yang.jpa.cascade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Parent {
    @Id @GeneratedValue
    Long id;
    String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Child> children = new ArrayList<>();

    public void addChild(Child child){
        this.children.add(child);
        child.setParent(this);
    }
}
