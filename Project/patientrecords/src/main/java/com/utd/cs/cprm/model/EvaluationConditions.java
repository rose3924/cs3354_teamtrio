package com.utd.cs.cprm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eval_conditions")
public class EvaluationConditions {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(name="immediate_relative", length = 1)
    private String immediateRelative;

    @Column(name="within_six_weeks", length = 1)
    private String withinSixWeeks;

    public EvaluationConditions() {}

	public EvaluationConditions(Long id, String name, String immediateRelative, String withinSixWeeks) {
		super();
		this.id = id;
		this.name = name;
		this.immediateRelative = immediateRelative;
		this.withinSixWeeks = withinSixWeeks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImmediateRelative() {
		return immediateRelative;
	}

	public void setImmediateRelative(String immediateRelative) {
		this.immediateRelative = immediateRelative;
	}

	public String getWithinSixWeeks() {
		return withinSixWeeks;
	}

	public void setWithinSixWeeks(String withinSixWeeks) {
		this.withinSixWeeks = withinSixWeeks;
	}

    
}
