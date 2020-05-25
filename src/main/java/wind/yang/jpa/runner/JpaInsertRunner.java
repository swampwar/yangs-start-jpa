package wind.yang.jpa.runner;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wind.yang.jpa.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

//@Component
//@Transactional // 메서드로 묶을 수 있지만 클래스도 가능, EntityManager가 실행하는 동작들은 한 트랜잭션 안에서 이루어져야 하기 때문에 선언한다.
@Order(1)
public class JpaInsertRunner implements ApplicationRunner {
    @PersistenceContext // 빈으로 주입을 위해서
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("jaeseok");
        account.setPassword("1234");
        account.setCreated(new Date());
//
//        Auth auth = new Auth();
//        auth.setAuthName("운영자");
//        Auth auth2 = new Auth();
//        auth2.setAuthName("사용자");

        // 객체의 관계설정은 양방향으로 해준다.
//        account.getAuths().add(auth);
//        account.getAuths().add(auth2);
//        auth.setAccount(account);
//        auth2.setAccount(account);

        // 하이버네이트의 Session을 이용하여 DB저장
        Session session = entityManager.unwrap(Session.class);
        session.save(account); // 이 구문에서 DB에 저장되는 것이 아니다. > 저장은 트랜잭션이 끝나는 시점에서 한다.
//        session.save(auth);

        System.out.println("저장 될 Account ID : " + session.load(Account.class, account.getId()).getId());
    }
}
