// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivesubsystems;

public class turnL extends Command {
 private Drivesubsystems m_drive = new Drivesubsystems();
 private Timer timer = new Timer();
  public turnL(Drivesubsystems m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.drive.arcadeDrive(0, -0.7);
    if (timer.get()>0.52){
      m_drive.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.get()>1) {
      return true;
    }
    else{
    return false;
    }
  }
}
