package com.example.housebatch.core.repository;

import com.example.housebatch.core.entity.Lawd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LawdRepository extends JpaRepository<Lawd, Long> {
    Optional<Lawd> findByLawdCd(String lawdCd);

    /**
     * @Query("select u from User u where u.firstname like %?1)
     * <p>
     * select distinct substring(lawd_cd, 1, 5) from lawd where exist = 1 laws_cd not like "%00000000";
     * @Query annotation 활용
     */
    @Query("select distinct substring(l.lawdCd, 1 ,5) " +
            "from Lawd l " +
            "where l.exist = 1 and l.lawdCd not like '%00000000'")
    List<String> findDistinctGuLawdCd();
}
