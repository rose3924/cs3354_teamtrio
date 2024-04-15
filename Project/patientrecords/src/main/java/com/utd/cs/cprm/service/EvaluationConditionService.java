package com.utd.cs.cprm.service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.EvaluationConditions;
import com.utd.cs.cprm.repository.EvaluationConditionsRepository;

@Service
public class EvaluationConditionService {

	@Autowired 
    private EvaluationConditionsRepository evaluationRepository;

    public List<EvaluationConditions> findAll() {
        List<EvaluationConditions> list = evaluationRepository.findAll();
        return list;
    }

    public List<EvaluationConditions> findByWithinSixWeeks(String withinSixWeeks) {
        List<EvaluationConditions> list = evaluationRepository.findByWithinSixWeeks(withinSixWeeks);
        return list;
    }

    public List<EvaluationConditions> findByImmediateRelative(String immediateRelative) {
        List<EvaluationConditions> list = evaluationRepository.findByImmediateRelative(immediateRelative);
        return list;
    }
    
    public HashMap<Integer, List<EvaluationConditions>> getMappingOfListWithinSixWeeks(String withinSixWeeks, int itemsPerRow) {
        List<EvaluationConditions>  list = findByWithinSixWeeks(withinSixWeeks);
        HashMap<Integer, List<EvaluationConditions>> map = new HashMap<Integer, List<EvaluationConditions>>();
        Integer mapIndex = 0;
        int count = 0;
        ArrayList<EvaluationConditions>  newlist = null;
        for(EvaluationConditions item : list) {
            if( count == itemsPerRow) {
                map.put(mapIndex, newlist);
                count = 0;
                mapIndex++;
            }
            if( count == 0 ) {
                newlist = new ArrayList<EvaluationConditions>();
            }
            newlist.add(item);
            count++;
        }
        if( count > 0) {
            // Need to add the last set.
            map.put(mapIndex, newlist);
        }
        return map;
    }
    
    public HashMap<Integer, List<EvaluationConditions>> getMappingOfListImmediateRelative(String immediateRelative, int itemsPerRow) {
        List<EvaluationConditions>  list = findByImmediateRelative(immediateRelative);
        HashMap<Integer, List<EvaluationConditions>> map = new HashMap<Integer, List<EvaluationConditions>>();
        Integer mapIndex = 0;
        int count = 0;
        ArrayList<EvaluationConditions>  newlist = null;
        for(EvaluationConditions item : list) {
            if( count == itemsPerRow) {
                map.put(mapIndex, newlist);
                count = 0;
                mapIndex++;
            }
            if( count == 0 ) {
                newlist = new ArrayList<EvaluationConditions>();
            }
            newlist.add(item);
            count++;
        }
        if( count > 0) {
            // Need to add the last set.
            map.put(mapIndex, newlist);
        }
        return map;
    }
}
