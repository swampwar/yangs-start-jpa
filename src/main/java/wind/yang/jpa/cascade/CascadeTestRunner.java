package wind.yang.jpa.cascade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Order(10)
public class CascadeTestRunner implements ApplicationRunner {
    @PersistenceContext // 빈으로 주입을 위해서
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Parent parent = new Parent();
        parent.setName("부모님");

        Child childA = new Child();
        childA.setName("자식A");
        Child childB = new Child();
        childB.setName("자식B");
        entityManager.persist(parent);

        parent.addChild(childA);
        parent.addChild(childB);
    }
}
