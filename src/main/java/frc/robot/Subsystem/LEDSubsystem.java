
package frc.robot.Subsystem;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class LEDSubsystem implements Subsystem{

  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;
  private int redPulseBrightness = 0;
  private int purplePulseBrightness = 0;
  private int greenPulseBrightness = 0;
    public LEDSubsystem(int PWMPort)
    {
        m_led = new AddressableLED(PWMPort);
        m_ledBuffer = new AddressableLEDBuffer(60);
        m_led.setLength(m_ledBuffer.getLength());
        m_led.setData(m_ledBuffer);
        m_led.start();
    }

    public void setRGB(int r, int g, int b)
    {
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            // Sets the specified LED to the RGB values
            m_ledBuffer.setRGB(i, r, g, b);
         }
         
         m_led.setData(m_ledBuffer);
    }

    

      public void setRED() {
        this.setRGB(255,0,0);

      }

      public void setPURPLE(){
        this.setRGB(128, 0, 128);
      }

      public void setGREEN() {
        this.setRGB(0,128,0);

      }


      public void redPulse(){
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
          // Sets the specified LED to the RGB values for red
          m_ledBuffer.setRGB(i, 0, 0, redPulseBrightness);
           }
       
           //increase brightness
           redPulseBrightness += 5;
       
           //Check bounds
           redPulseBrightness %= 255;
       
           m_led.setData(m_ledBuffer);
       
          }

          public void purplePulse(){
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
          // Sets the specified LED to the RGB values for blue
          m_ledBuffer.setRGB(i, 0, 0, purplePulseBrightness);
           }
       
           //increase brightness
           purplePulseBrightness += 5;
       
           //Check bounds
           purplePulseBrightness %= 128;
       
           m_led.setData(m_ledBuffer);
       
          }

          public void greenPulse(){
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
          // Sets the specified LED to the RGB values for green
          m_ledBuffer.setRGB(i, 0, 0, greenPulseBrightness);
           }
       
           //increase brightness
           greenPulseBrightness += 5;
       
           //Check bounds
           greenPulseBrightness %= 128;
       
           m_led.setData(m_ledBuffer);
       
          }


       
    ///////////////////
    //// COMMANDS /////
    //////////////////

    public Command setREDCommand() {
        return runOnce(() -> this.setRED());
    }

    // Flashing red for last 20 sec of match
      public Command setREDPulse() {
        return run(() -> this.setREDPulse());
    }

    public Command setPURPLECommand(){
        return runOnce(() -> this.setPURPLE());
    }

    // Finish setting up AMP Position
      public Command setPURPLEPulse(){
        return run(() -> this.setPURPLEPulse());
    }

    public Command setGREENCommand(){
        return runOnce(() -> this.setGREEN());
    }

    // Intaking a note
      public Command setGREENPulse(){
        return run(() -> this.setGREENPulse());
      }
    // hold for 10 sec (tells Jeffrey when to press AMP )
    public Command setYELLOW(){
        return runOnce(() -> this.setRGB(255,255,0));
    }



    // presten code for Lahaina Luna
      public Command setInit() {
        return runOnce(() -> this.setRGB(255, 192, 203));
    }

    public Command setBLUE() {
        return runOnce(() -> this.setRGB(0, 0, 255));
    }

     public Command setGreenCommand() {
        return runOnce(() -> this.setGREEN());
    }

}