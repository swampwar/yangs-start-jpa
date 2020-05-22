package wind.yang.jpa.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import wind.yang.jpa.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Component
@Order(5)
public class NavtiveQuerySelectRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("NavtiveQuerySelectRunner ============================");

        List<Account> resultList = entityManager.createNativeQuery("Select * From tb_account", Account.class).getResultList();
        resultList.forEach(System.out::println);

        System.out.println("=============================================");
    }
}
