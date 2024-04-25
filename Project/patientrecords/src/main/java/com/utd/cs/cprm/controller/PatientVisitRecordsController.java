package com.utd.cs.cprm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utd.cs.cprm.model.Record;

import com.utd.cs.cprm.service.RecordService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PatientVisitRecordsController {

	@Autowired 
    private RecordService recservice;

    @GetMapping("patientvisitrecords")
    public ModelAndView getFormData(HttpServletRequest request, @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {

        ModelAndView mav = new ModelAndView("patientvisitrecords");
        Pageable paging = PageRequest.of(page - 1, size);

        Page<Record> pageRecords;
        try {
            if((keyword != null) && keyword.equals("") == false ) {
                pageRecords = recservice.findByPatientPatientsIdOrPatientLastName(keyword, keyword, paging);
            }
            else
            {
                pageRecords = recservice.findAll(paging);
            }
            if((keyword != null) && keyword.equals("") == false ) {
                mav.addObject("keyword", keyword);
            }
            mav.addObject("records", pageRecords.getContent());
            mav.addObject("currentPage", pageRecords.getNumber() + 1);
            mav.addObject("totalItems", pageRecords.getTotalElements());
            mav.addObject("totalPages", pageRecords.getTotalPages());
            mav.addObject("pageSize", size);

        } catch (Exception e) {
            mav.addObject("message", e.getMessage());
        }
        return mav;
    }
}
