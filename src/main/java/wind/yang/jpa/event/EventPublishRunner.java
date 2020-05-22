package wind.yang.jpa.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;

//@Component
public class EventPublishRunner implements ApplicationRunner {
    @Autowired
    ApplicationContext appCtx;

    @Autowired
    EventTestRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        TestEntity e1 = new TestEntity();
        e1.setName("하이");
//        repository.save(e1.save());
    }
}
