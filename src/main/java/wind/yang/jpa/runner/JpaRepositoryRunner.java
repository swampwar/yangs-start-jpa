package wind.yang.jpa.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import wind.yang.jpa.repository.AccountRepository;

@Order(6)
//@Component
public class JpaRepositoryRunner implements ApplicationRunner {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("JpaRepositoryRunner ========================");
        accountRepository.findAll().forEach(System.out::println);
        System.out.println("============================================");
    }
}
