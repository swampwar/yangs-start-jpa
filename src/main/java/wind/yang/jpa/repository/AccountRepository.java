package wind.yang.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import wind.yang.jpa.entity.Account;

// 스프링이 사용가능한 AccountRepository 객체를 생성하여 빈으로 등록해준다.
public interface AccountRepository extends JpaRepository<Account, Long>/*, AccountCustomRepository, QuerydslPredicateExecutor<Account> */{
    // 제공되는 인터페이스를 상속한다 :  AccountCustomRepository 에서 커스텀한 기능을 사용하기 위해 추가

    // 메서드명을 컨벤션을 지켜서 만들면 자동으로 실행가능한 메서드를 생성해준다.
    Page<Account> findAccountsByUsernameContains(String userName, Pageable pageable);

    long countByUsernameContains(String userName);
}
