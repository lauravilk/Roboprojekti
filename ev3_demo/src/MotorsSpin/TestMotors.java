package MotorsSpin;

import lejos.hardware.motor.Motor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class TestMotors {

    public static void main(String[] args) {
        
        // Set the motors to rotate
        Motor.D.forward();                          // Start motor A
        Motor.C.forward();                          // Start motor B
        
        LCD.clear();
        LCD.drawString("Spinning motors.", 0, 0);

        Motor.D.setSpeed(200);                      // Motor speed: 200 degrees/sec
        Motor.C.setSpeed(200);              

        Delay.msDelay(5000);                        // inserting 5 sec delay
        
        Motor.D.stop();
        Motor.C.stop();
        // LCD.clear();
        LCD.drawString("Motors stopped.", 0, 1);
        
        Button.waitForAnyPress();
    }
}

