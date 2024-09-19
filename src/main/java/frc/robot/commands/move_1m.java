// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Timer;

import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.Time;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivesubsystems;

public class move_1m extends Command {
  private Drivesubsystems m_drive = new Drivesubsystems();
  private PIDController pid = new PIDController(0.1, 0, 0);
  public CANcoder caNcoder = new CANcoder(14);
  private edu.wpi.first.wpilibj.Timer timer = new edu.wpi.first.wpilibj.Timer();

  /** Creates a new move_1m. */
  public move_1m(Drivesubsystems m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    caNcoder.setPosition(0);
    m_drive.drive.arcadeDrive(0, 0);
timer.reset();
timer.start();
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  //   double error = 1;
  //   double output =  pid.calculate(error/(6*2.54/100)*Math.PI-caNcoder.getPosition().getValueAsDouble());
  //   m_drive.drive.arcadeDrive(output*0.7, 0.65);
  //   if (caNcoder.getPosition().getValueAsDouble()>=error/(6*2.54/100)*Math.PI-1){
  //     m_drive.drive.arcadeDrive(0, 0);
  //   }
  m_drive.drive.arcadeDrive(0.7, 0.65);
  if (timer.get()>0.5){
    m_drive.stop();
  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if (caNcoder.getPosition().getValueAsDouble()>=1/(6*2.54/100)*Math.PI-1){
    //   return true;
    // }
    // else{
    //   return false;
    // }
    

    if (timer.get()>1) {
      return true;
    }
    else{
    return false;
    }
    
  }
}
