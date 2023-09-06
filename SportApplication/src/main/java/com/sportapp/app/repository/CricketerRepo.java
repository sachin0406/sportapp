package com.sportapp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportapp.cricketerentity.Cricketer;

public interface CricketerRepo extends JpaRepository<Cricketer, String > 
{
     @Query(value = "Select * from cricketer_lists where runs >10000"
     		, nativeQuery = true)
     List<Cricketer>
     findLeadingRunScorerAward();
}
