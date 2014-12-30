package com.akosha.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import com.akosha.MarsRover;

public class MarsRoverTest {

    public static final int N = 1;
    public static final int E = 2;
    public static final int S = 3;
    public static final int W = 4;

    String roverOneFinalPosCorrect = "1 3 N";

    String roverTwofinalPosCorrect = "5 1 E";
    
    String roveronefinalPosIncorrect = "1 4 N";

    String rovertwofinalPosIncorrect = "2 1 E";
    String message = "rover has reached the coordinates limit";
    
    @Test
    public void testcorrectPositionFirstRover(){
    
        MarsRover rover = new MarsRover();
        rover.startPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        System.out.println(rover.getPosition());
        assertEquals(roverOneFinalPosCorrect, rover.getPosition());
        
    }
    
    @Test
    public void testcorrectPositionSecondRover(){
    
        MarsRover rover = new MarsRover();
        rover.startPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        System.out.println(rover.getPosition());
        assertEquals(roverTwofinalPosCorrect, rover.getPosition());
        
    }
    
    @Test
    public void testwrongPositionFirstRover(){
    
        MarsRover rover = new MarsRover();
        rover.startPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        System.out.println(rover.getPosition());
        assertNotSame(roveronefinalPosIncorrect, rover.getPosition());
        
    }
    
    @Test
    public void testwrongPositionSecondRover(){
    
        MarsRover rover = new MarsRover();
        rover.startPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        System.out.println(rover.getPosition());
        assertNotSame(rovertwofinalPosIncorrect, rover.getPosition());
            
    }
    
    @Test
    public void testoutOfRangeCoordinate(){
    
        MarsRover rover = new MarsRover();
        rover.startPosition(5, 5, E);
        rover.process("MMRMMRMRRM");
        System.out.println(rover.getPosition());

        assertEquals(message, rover.getPosition());
            
    }
    


}
