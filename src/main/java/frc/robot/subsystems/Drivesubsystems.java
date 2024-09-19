// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivesubsystems extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_TalonSRX R1 = new WPI_TalonSRX(12);
  private WPI_TalonSRX R2 = new WPI_TalonSRX(52);
  private WPI_TalonSRX L1 = new WPI_TalonSRX(40);
  private WPI_TalonSRX L2 = new WPI_TalonSRX(33);
  private CANcoder caNcoder = new CANcoder(14);
  private XboxController js1 = new XboxController(0);
  public DifferentialDrive drive = new DifferentialDrive(L1, R1);

  public Drivesubsystems() {
    R2.follow(R1);
    L2.follow(L1);
    R1.setInverted(false);
    L1.setInverted(true);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  drive.setSafetyEnabled(false);
  SmartDashboard.putNumber("speed", R1.getSelectedSensorPosition());
  SmartDashboard.putNumber("postition", getPosition());

  }
  public double getPosition(){
    return caNcoder.getPosition().getValueAsDouble();
  }
  public void setzero(){
    caNcoder.setPosition(0);
  }
  public void stop(){
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
