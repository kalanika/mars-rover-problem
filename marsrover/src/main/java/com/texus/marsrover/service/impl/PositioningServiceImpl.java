package com.texus.marsrover.service.impl;


import com.texus.marsrover.constants.Constants;
import com.texus.marsrover.domain.Rover;
import com.texus.marsrover.domain.pojo.Position;
import com.texus.marsrover.service.PositioningService;
import com.texus.marsrover.util.ValidationHelper;
import org.springframework.stereotype.Service;


@Service
public class PositioningServiceImpl implements PositioningService {

    @Override
    public String getPositioning(Rover rover) {

        ValidationHelper.checkCommand(rover);
        String output= processCommad(rover);
        return output;

    }

    /**
     *  Processing the user entered body command.
     * @param rover
     * @return output
     */
    public String processCommad(Rover rover) {

        setFaceingDirectionValue(rover);
        String command = rover.getProcesscommand();
        String output="";
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'L') {
                output = leftmove(rover);

            }
            if (command.charAt(i) == 'R') {
                output =  rightmove(rover);
            }

            if (command.charAt(i) == 'M') {
                output=   move(rover);
            }

        }
           return output;
    }

    void setFaceingDirectionValue(Rover rover){

        Position position=rover.getPosition();

        if(position.getFacing().equals(Constants.NORTH_DIRECTION))
        {
            position.setDirvalue(Constants.N);
        }

        if(position.getFacing().equals(Constants.EAST_DIRECTION)){

            position.setDirvalue(Constants.E);
        }

        if(position.getFacing().equals(Constants.SOUTH_DIRECTION)){
            position.setDirvalue(Constants.S);

        }

        if(position.getFacing().equals(Constants.WEST_DIRECTION)){
            position.setDirvalue(Constants.W);
        }

    }

    /**
     * Set facing direction after moving to left
     * @param rover
     * @return
     */
   public String leftmove(Rover rover){

        Position position=rover.getPosition();
        String output;
        String dir = null;

            if (position.getDirvalue() == -1)
            {
               position.setDirvalue(2);
            }
            else{
                position.setDirvalue(position.getDirvalue()-1);
            }
               dir=setdirValue(rover);

            output=position.getX() +""+position.getY()+""+dir;
            return output;
    }

    /**
     *  Set facing direction after moving to right
     * @param rover
     * @return output
     */
   public  String rightmove(Rover rover){
            Position position=rover.getPosition();
            String dir=null;
            String output;
            if (position.getDirvalue() ==2)
            {
                position.setDirvalue(-1);

            }
            else {

                position.setDirvalue(position.getDirvalue()+1);

          }
            dir=setdirValue(rover);
            output=position.getX() +""+position.getY()+""+dir;
            return output;
    }


    /**
     * Set X Y coordinate values
     * @param rover
     * @return output
     */
     public String move(Rover rover) {
        String output;
        Position position=rover.getPosition();
        String dir=null;
        if (position.getDirvalue()==(Constants.N))
        {
            position.setY(position.getY()+1);

        }
        if (position.getDirvalue()==(Constants.E))
        {
            position.setX(position.getX()+1);

        }
        if (position.getDirvalue()==(Constants.S))
        {
            position.setY(position.getY()-1);

        }
        if (position.getDirvalue()==(Constants.W))
        {
            position.setX(position.getX()-1);

        }

        dir=setdirValue(rover);
        output=position.getX() +""+position.getY()+""+dir;
        return output;

    }

    /**
     * Set final facing direction values after turning and moving
     * @param rover
     * @return dir value
     */
   public String setdirValue(Rover rover){
      Position position=rover.getPosition();
      String dir=null;

      if(position.getDirvalue()==0){
          dir=Constants.NORTH_DIRECTION;
      }

      if(position.getDirvalue()==1){
          dir=Constants.EAST_DIRECTION;
      }
      if(position.getDirvalue()==2){
          dir=Constants.SOUTH_DIRECTION;
      }
      if(position.getDirvalue()==-1){
          dir=Constants.WEST_DIRECTION;
      }
      return dir;
    }

}
