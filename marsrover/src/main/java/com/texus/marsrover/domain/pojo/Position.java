package com.texus.marsrover.domain.pojo;

import java.util.Objects;

public class Position {

    int  x ;
    int y ;
    String   facing;

    int dirvalue;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public int getDirvalue() {
        return dirvalue;
    }

    public void setDirvalue(int dirvalue) {
        this.dirvalue = dirvalue;
    }
}
