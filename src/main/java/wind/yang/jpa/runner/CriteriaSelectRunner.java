package wind.yang.jpa.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import wind.yang.jpa.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//@Component
@Order(4)
public class CriteriaSelectRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("CriteriaSelectRunner ============================");

        // DB에 맞는 SQL로 변환되어 실행된다.
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query.select(root);

        List<Account> resultList = entityManager.createQuery(query).getResultList();
        resultList.forEach(System.out::println);

        System.out.println("=============================================");
    }
}
