package wind.yang.jpa.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import wind.yang.jpa.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

//@Component
@Order(3)
public class JpqlSelectRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("JpqlSelectRunner ============================");


        // DB에 맞는 SQL로 변경하여 실행한다. 쿼리가 문자열로 작성되어 Type-Safe하지 않다.
        TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM account AS a", Account.class);
        List<Account> accountList = query.getResultList();
        accountList.forEach(System.out::println);


        System.out.println("=============================================");
    }
}
