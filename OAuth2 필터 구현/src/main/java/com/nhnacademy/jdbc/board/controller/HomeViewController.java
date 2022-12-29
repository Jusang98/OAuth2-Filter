package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.Service.ResidentService;
import com.nhnacademy.jdbc.board.entity.Resident;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;


@Slf4j
@Controller
public class HomeViewController {
    private final ResidentService residentService;

    public HomeViewController(ResidentService residentService) {
        this.residentService = residentService;
    }
    @GetMapping("/")
    public String HomeView(@SessionAttribute(name = "username", required = false)String username,
                           Model model) {
        if(Objects.nonNull(username)){
            Resident resident = residentService.findById(username);

            model.addAttribute("username",resident.getResidentSerialNumber());
        }
        model.addAttribute("residentList", residentService.getResidents());
        return "home";
    }

    @DeleteMapping("/delete/{serialNumber}")
    public void deleteResident(@PathVariable("serialNumber") Long serialNumber) {
        residentService.deleteResidentBySerialNumber(serialNumber);
    }
}
