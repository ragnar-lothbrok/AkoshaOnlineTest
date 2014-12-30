package com.akosha;

public class MainClass {
    
     public static void main(String[] args) {
         int N = 1;
         MarsRover rover = new MarsRover(); rover.startPosition(1, 2, N);
         rover.process("MMRMMRMRRM"); System.out.println(rover.getPosition()); 
    }
     
}
