package com.hisamprakoso.karyawanapp.controller;

// import java.util.List;

import javax.validation.Valid;

import com.hisamprakoso.karyawanapp.entity.Meeting;
import com.hisamprakoso.karyawanapp.repository.MeetingRepository;
// import com.hisamprakoso.karyawanapp.service.MeetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MeetingController {
    @Autowired
    private MeetingRepository meetingRepository;
    Meeting meeting = new Meeting();
    // private Meeting meeting;

    // @RequestMapping("/meeting/list")
    // public List<Meeting> findAllMeetings() {
    // return meetingService.getMeetings();
    // }
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

    @GetMapping("/meeting/delete/{id}")
    public String deleteMeeting(@PathVariable("id") Integer id, Model model) {
        // Meeting meeting = (Meeting) meetingRepository.findById(id);
        // .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        meetingRepository.delete(meeting);
        return "redirect:/meeting/list";
    }

}
