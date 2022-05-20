package com.hisamprakoso.karyawanapp.controller;

import javax.validation.Valid;

import com.hisamprakoso.karyawanapp.entity.Karyawan;
import com.hisamprakoso.karyawanapp.entity.Salary;
import com.hisamprakoso.karyawanapp.repository.SalaryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class SalaryController {

    // private Object salaryRepository;

    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryController(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @GetMapping("/salary/list")
    public String showSalaries(Model model) {
        model.addAttribute("salary", salaryRepository.findAll());
        return "/salary/list";

    }

    @GetMapping("/salary/form")
    public String showSalaryForm(Salary salary) {
        return "/salary/form";

    }

    @PostMapping("/salary/form")
    public String addSalary(@Valid @ModelAttribute("salary") Salary salary,
            @ModelAttribute("karyawan") Karyawan karyawan, BindingResult result, SessionStatus status,
            Model model) {
        if (result.hasErrors()) {
            return "/salary/form";
        }

        salaryRepository.save(salary);
        status.setComplete();
        return "redirect:/salary/list";
    }

}
