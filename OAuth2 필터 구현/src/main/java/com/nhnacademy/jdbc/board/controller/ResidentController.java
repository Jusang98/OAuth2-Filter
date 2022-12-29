package com.nhnacademy.jdbc.board.controller;


import com.nhnacademy.jdbc.board.Service.ResidentService;
import com.nhnacademy.jdbc.board.domain.ResidentId;
import com.nhnacademy.jdbc.board.domain.ResidentRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }


//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResidentId creatResident(@RequestBody ResidentRegisterRequest registerRequest) {
        return residentService.createResident(registerRequest);
    }

    @PutMapping("/{serialNumber}")
    public int UpdateResidentName(@PathVariable("serialNumber") Long serialNumber, @RequestBody ResidentRegisterRequest registerRequest) {
        return residentService.updateResidentName(serialNumber, registerRequest.getName());
    }
}