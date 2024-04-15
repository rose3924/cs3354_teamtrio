package com.utd.cs.cprm.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utd.cs.cprm.model.EvaluationConditions;

@Repository
public interface EvaluationConditionsRepository extends JpaRepository<EvaluationConditions, Long>{

	public List<EvaluationConditions> findByWithinSixWeeks(String withinSixWeeks);
    public List<EvaluationConditions> findByImmediateRelative(String immediateRelative);
}
