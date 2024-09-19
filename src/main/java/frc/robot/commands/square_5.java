// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivesubsystems;

public class square_5 extends Command {

  private Drivesubsystems m_drive = new Drivesubsystems();
  private PIDController pid = new PIDController(0.7, 0, 0);
  private Timer timer = new Timer();
  public square_5(Drivesubsystems m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    if (timer.get()<0.5) {
      m_drive.drive.arcadeDrive(0.7, 0.65);
    }
    m_drive.stop();
    timer.restart();
    if (timer.get()<0.52){
      m_drive.drive.arcadeDrive(0, 0.7);
    }
    m_drive.stop();
    timer.restart();
    
    if (timer.get()<0.5) {
      m_drive.drive.arcadeDrive(0.7, 0.65);
    }
    m_drive.stop();
    timer.restart();
    if (timer.get()<0.52){
      m_drive.drive.arcadeDrive(0, 0.7);
    }
    m_drive.stop();
    timer.restart();
    
    if (timer.get()<0.5) {
      m_drive.drive.arcadeDrive(0.7, 0.65);
    }
    m_drive.stop();
    timer.restart();
    if (timer.get()<0.52){
      m_drive.drive.arcadeDrive(0, 0.7);
    }
    m_drive.stop();
    timer.restart();

    if (timer.get()<0.5) {
      m_drive.drive.arcadeDrive(0.7, 0.65);
    }
    m_drive.stop();
    timer.restart();
    if (timer.get()<0.52){
      m_drive.drive.arcadeDrive(0, 0.7);
    }
    m_drive.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
