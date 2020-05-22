package wind.yang.jpa.runner;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import wind.yang.jpa.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Component
//@Transactional
@Order(2)
public class JpaSelectRunner implements ApplicationRunner {
    @PersistenceContext // JPA 코드를 사용하여 빈을 주입받는다. 코드에서 스프링을 최대한 배제한다.(스프링 철학)
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Session session = entityManager.unwrap(Session.class);
        Account account = session.get(Account.class, 1l);
        System.out.println("DB에서 조회된 Account Id : " + account.getId());
//        account.getAuths().forEach(System.out::println);
    }
}
