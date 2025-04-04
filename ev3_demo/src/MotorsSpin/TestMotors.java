package MotorsSpin;

import lejos.hardware.motor.Motor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;

public class TestMotors {

    public static void main(String[] args) {

        Ultrasonic sensor = new Ultrasonic();
        

        // Set motor speeds before moving
        Motor.D.setSpeed(400);
        Motor.C.setSpeed(400);

        LCD.clear();
        LCD.drawString("Moving forward", 0, 0);

        Motor.D.forward();
        Motor.C.forward();

        Delay.msDelay(10000); // Move forward for 10 seconds

        // Stop motors before next command
        Motor.D.stop(true);
        Motor.C.stop();

        sensor.display();  // Call display method for ultrasonic sensor

        LCD.drawString("Rotating", 0, 1);

        // Rotate in place (e.g., 360 degrees left forward, right backward)
        Motor.D.rotate(720, true); // Non-blocking
        Motor.C.rotate(-720);      // Blocking (waits until it's done)

        // Move backward
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

class Ultrasonic {

    public void display() {
        // Create an instance of the ultrasonic sensor on port 2
        EV3UltrasonicSensor ultrasonicSensor = new EV3UltrasonicSensor(SensorPort.S2);

        // Get the distance sample provider
        SampleProvider distance = ultrasonicSensor.getDistanceMode();

        // Create a sample array to hold the distance value
        float[] sample = new float[distance.sampleSize()];

        // Display the distance until the ESCAPE button is pressed
        while (!Button.ESCAPE.isDown()) {
            // Fetch the current distance reading from the sensor
            distance.fetchSample(sample, 0);

            // Display the distance on the LCD screen
            LCD.clear();
            LCD.drawString("Dist: " + sample[0] + " m   ", 0, 0); // Added extra spaces for clearing old text

            // Refresh the display every 100 ms
            Delay.msDelay(100);
        }

        // Close the ultrasonic sensor
        ultrasonicSensor.close();
    }
}
