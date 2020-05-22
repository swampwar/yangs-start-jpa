package wind.yang.jpa.event;


import org.springframework.context.ApplicationEvent;

public class TestSaveEvent extends ApplicationEvent {

    private final TestEntity testEntity;

    public TestSaveEvent(Object source) {
        super(source);
        this.testEntity = (TestEntity) source;
    }

    public TestEntity getTestEntity() {
        return testEntity;
    }
}
