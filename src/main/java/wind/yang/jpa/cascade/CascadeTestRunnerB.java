package wind.yang.jpa.cascade;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Order(11)
public class CascadeTestRunnerB implements ApplicationRunner {
    @PersistenceContext // 빈으로 주입을 위해서
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Parent parent = entityManager.find(Parent.class, 1L);
        parent.getChildren().remove(1);
    }
}
