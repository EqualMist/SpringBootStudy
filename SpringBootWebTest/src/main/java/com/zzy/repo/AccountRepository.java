package com.zzy.repo;

import com.zzy.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsername(String name);

    Account findAccountByUsernameLike(String name);

    Account findAccountByIdAndUsername(Integer id, String name);

    boolean existsAccountByUsername(String name);
}
