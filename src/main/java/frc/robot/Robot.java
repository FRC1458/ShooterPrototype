// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private  WPI_TalonSRX shooterMotor;

  private Joystick leftStick;

  public Robot() {
    super(0.03);
    shooterMotor = new WPI_TalonSRX(RobotConstants.shooterMotorID);
  }

  @Override
  public void robotInit() {
    shooterMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void teleopInit() {
    
  }

  @Override
  public void teleopPeriodic() {
    if(leftStick.getRawButton(3))
      shooterMotor.set(ControlMode.PercentOutput, (leftStick.getZ()-1)/2);
    else 
      shooterMotor.set(ControlMode.PercentOutput, 0);
  }
}