package MotorsSpin;

import lejos.hardware.motor.Motor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class TestMotors {

    public static void main(String[] args) {
        
        // Asetetaan moottorien nopeus ennen liikkeellelähtöä
        Motor.D.setSpeed(400);
        Motor.C.setSpeed(400);

        LCD.clear();
        LCD.drawString("Moving forward", 0, 0);

        Motor.D.forward();
        Motor.C.forward();

        Delay.msDelay(10000); // Eteenpäin 10 sekuntia

        // Pysäytetään moottorit ennen seuraavaa komentoa
        Motor.D.stop(true);
        Motor.C.stop();

        LCD.drawString("Rotating", 0, 1);

        // Pyörähdetään paikallaan (esim. 360 astetta vasen eteenpäin, oikea taaksepäin)
        Motor.D.rotate(720, true); // true = non-blocking
        Motor.C.rotate(-720);      // false = blocking (odottaa tämän loppuun)

        // Takaisin taaksepäin
        Motor.D.setSpeed(500);
        Motor.C.setSpeed(500);

        LCD.drawString("Going back", 0, 2);

        Motor.D.backward();
        Motor.C.backward();

        Delay.msDelay(10000);

        Motor.D.stop(true);
        Motor.C.stop();

        LCD.drawString("Motors stopped.", 0, 3);

        Button.waitForAnyPress();
    }
}
