package com.texus.marsrover.util;

import com.texus.marsrover.constants.Constants;
import com.texus.marsrover.domain.Rover;
import com.texus.marsrover.exception.BadRequestException;
import com.texus.marsrover.exception.IllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationHelper {

    /**
     * validating the user entered body values
     * @param rover
     */
    public static void  checkCommand(Rover rover){
        List<String> dirlist= new ArrayList<>(Arrays.asList("N", "S", "W", "E"));

        if (rover == null) {
            throw new BadRequestException("Body  must exist.");
        }
        if(rover.getPosition()==null){

            throw new BadRequestException("Position must exist");
        }

        if(rover.getProcesscommand().isEmpty()){
            throw new BadRequestException("Value must exist");
        }

       if(!dirlist.contains(rover.getPosition().getFacing())){
           throw new IllegalArgumentException("Enter valid facing direction");
       }
    }
}
