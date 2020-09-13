package com.texus.marsrover.controller;


import com.texus.marsrover.domain.Rover;
import com.texus.marsrover.service.impl.PositioningServiceImpl;
import com.texus.marsrover.util.ValidationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProcessCommandController {
    private static final Logger LOG = LoggerFactory.getLogger(ProcessCommandController.class);

    @Autowired
    PositioningServiceImpl positioningService;

    @GetMapping("/marsrover")
    public String processCommand( @RequestBody Rover rover){

        LOG.info("process Command request is created--> get output ");
       String output= positioningService.getPositioning(rover);
       return output;
    }

}
