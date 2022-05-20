package com.hisamprakoso.karyawanapp.controller;

import javax.validation.Valid;
import com.hisamprakoso.karyawanapp.entity.Meeting;
import com.hisamprakoso.karyawanapp.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MeetingController {

    private final MeetingRepository meetingRepository;
    Meeting meeting = new Meeting();

    @Autowired
    public MeetingController(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @GetMapping("/meeting/list")
    public String showMeetings(Model model) {
        model.addAttribute("meeting", meetingRepository.findAll());
        return "meeting/list";
    }

    @GetMapping("/meeting/form")
    public String showMeetingForm(Meeting meeting) {
        // model.addAttribute("meeting", meetingRepository.findAll());
        return "/meeting/form";
    }

    @PostMapping("/meeting/form")
    public String addMeeting(@Valid @ModelAttribute("meeting") Meeting meeting, BindingResult result,
            SessionStatus status, Model model) {
        if (result.hasErrors()) {
            return "/meeting/form";

        }

        meetingRepository.save(meeting);
        status.setComplete();
        return "redirect:/meeting/list";
    }

    @GetMapping("/meeting/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Meeting meeting = meetingRepository.findById(id);
        model.addAttribute("meeting", meeting);
        return "/meeting/update";
    }

    @PostMapping("/meeting/update/{id}")
    public String updateMeeting(@PathVariable("id") Integer id, @Valid Meeting meeting,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            meeting.setId(id);
            return "/meeting/update";
        }
        meetingRepository.save(meeting);
        // status.setComplete();
        return "redirect:/meeting/list";
    }

    @GetMapping("/meeting/delete/{id}")
    public String deleteMeeting(@PathVariable("id") Integer id, Model model) {
        Meeting meeting = meetingRepository.findById(id);
        meetingRepository.delete(meeting);
        return "redirect:/meeting/list";
    }

    @GetMapping("/meeting/detail/{id}")
    public String detailMeeting(@PathVariable("id") Integer id, Model model) {
        // meetingRepository.findById(id);
        Meeting meeting = meetingRepository.findById(id);
        model.addAttribute("meeting", meeting);
        return "/meeting/detail";
    }

}
