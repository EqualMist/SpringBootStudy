package com.zzy.repo;

import com.zzy.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsername(String name);

    Account findAccountByUsernameLike(String name);

    Account findAccountByIdAndUsername(Integer id, String name);

    boolean existsAccountByUsername(String name);

    @Modifying
    @Query("UPDATE Account SET password =?2 WHERE id =?1")
    int updatePasswordById(int id, String newPassword);

    @Modifying
    @Query(value = "UPDATE account set password = ?2 where username = ?1", nativeQuery = true)
    int updatePasswordByUsername(String username, String newPassword);
}
