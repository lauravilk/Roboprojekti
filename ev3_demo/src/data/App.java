package data;

import lejos.hardware.motor.Motor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class App
{
    public static void main(String[] args)
    {
        String message1 = "This is my 1st LEGO code.";
        String message2 = "Make me autonomous";
        String message3 = "Press any button to Stop.";

        LCD.clear();
        LCD.drawString("Welcome", 0, 0);

        Delay.msDelay(1000);
       
        TextWrap(message1, 1);
        //LCD.drawString("This is my 1st LEGO code.", 0, 1);
        Delay.msDelay(2000);
        TextWrap(message2, 3); // tulostaa tekstin riville 3
        //LCD.drawString("Make me autonomous", 0, 2);
        Delay.msDelay(2000);
        TextWrap(message3, 5);
        //LCD.drawString("Press any button to Stop.", 0,4);
       
        //Wait for a button press to exit
        Button.waitForAnyPress();
    }

    public static void TextWrap(String msg, int startY) {
        
        int maxLength = 16;
        int Localx = 0; // tulostus alkaa riviltä 0
        // int Localy = 0;
        int y = startY; // määrittää rivin jolta tulostus alkaa
        

        for (int i = 0; i < msg.length(); i+=maxLength)
        {
            String line = msg.substring(i, Math.min(i + maxLength, msg.length()));
            //LCD.drawString(line, Localx, Localy++);
            LCD.drawString(line, Localx, y++);
        }

    }


}
