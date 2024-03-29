/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.led.RainbowAnimation;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  private RobotContainer robotContainer;

  // private AddressableLED led = new AddressableLED(0);
  // private AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(60);
  // private int rainbowFirstPixelHue = 0;

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    // CameraServer.startAutomaticCapture();
  }

  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    // led.setLength(ledBuffer.getLength());
    // for (var i = 0; i < ledBuffer.getLength(); i++) {
    //   final var hue = (rainbowFirstPixelHue + (i * 180 / ledBuffer.getLength())) % 180;
    //   // Set the HSV value to led
    //   ledBuffer.setHSV(i, hue, 255, 128);
    // }
    // rainbowFirstPixelHue += 3;
    // rainbowFirstPixelHue %= 180;
  }

  @Override
  public void autonomousInit() {
    robotContainer.getAutonomousCommand().schedule();
  }

  @Override
  public void autonomousPeriodic() {
  }
  
  @Override
  public void teleopInit() {
    robotContainer.getAutonomousCommand().cancel();
    robotContainer.setDefaultCommands();
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
