package com.texus.marsrover.domain;

import com.texus.marsrover.domain.pojo.Position;

public class Rover {

    Position position;
    String processcommand;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getProcesscommand() {
        return processcommand;
    }

    public void setProcesscommand(String processcommand) {
        this.processcommand = processcommand;
    }
}
