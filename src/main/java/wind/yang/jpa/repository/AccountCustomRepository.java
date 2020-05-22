package wind.yang.jpa.repository;



import wind.yang.jpa.entity.Account;

import java.util.List;

public interface AccountCustomRepository {
    List<Account> findMyAccount();
}
