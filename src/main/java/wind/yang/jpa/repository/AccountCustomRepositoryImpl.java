package wind.yang.jpa.repository;


import wind.yang.jpa.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Repository
//@Transactional
public class AccountCustomRepositoryImpl implements AccountCustomRepository {
    /**
     *  Custom Repository를 생성한다.
     *  새로운 기능의 메서드를 interface에서 정의하여 구현해도 되고,
     *  JpaRepository의 메서드를 interface에서 재정의하여 구현해도 된다.
     */
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Account> findMyAccount() {
        System.out.println("custom Repository");
        return entityManager.createQuery("SELECT a FROM account AS a", Account.class).getResultList();
    }
}
