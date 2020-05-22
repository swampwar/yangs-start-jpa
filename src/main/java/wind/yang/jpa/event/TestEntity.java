package wind.yang.jpa.event;

import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
//@Table(name = "tb_test_for_event")
public class TestEntity extends AbstractAggregateRoot<TestEntity> {
    @Id @GeneratedValue
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestEntity save(){
        this.registerEvent(new TestSaveEvent(this));
        return this;
    }
}
