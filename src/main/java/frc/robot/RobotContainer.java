// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Teleop;
import frc.robot.commands.move_1m;
import frc.robot.commands.square_5;
import frc.robot.commands.square_n5;
import frc.robot.commands.turnL;
import frc.robot.commands.turnR;
import frc.robot.subsystems.Drivesubsystems;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivesubsystems m_Drivesubsystems = new Drivesubsystems();
  private move_1m move_1m = new move_1m(m_Drivesubsystems);
  private turnL turnL = new turnL(m_Drivesubsystems);
  private turnR turnR= new turnR(m_Drivesubsystems);
  private square_5 square_5 = new square_5(m_Drivesubsystems);
  private square_n5 square_n5= new square_n5(m_Drivesubsystems);
  private Teleop teleop = new Teleop(m_Drivesubsystems);
  private SendableChooser<Command> m_Chooser = new SendableChooser<Command>();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_Chooser.setDefaultOption("move_1m", move_1m);
    m_Chooser.addOption("turnL", turnL);
    m_Chooser.addOption("turnR", turnR);
    m_Chooser.addOption("square_5", square_5);
    m_Chooser.addOption("square_n5", square_n5);

    SmartDashboard.putData("choser", m_Chooser);
    m_Drivesubsystems.setDefaultCommand(teleop);
  
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_Drivesubsystems::exampleCondition)
    .onTrue(new Teleop(m_Drivesubsystems));
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_Drivesubsystems.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new SequentialCommandGroup(
new move_1m(m_Drivesubsystems),
m_Chooser.getSelected(),
new move_1m(m_Drivesubsystems),
m_Chooser.getSelected(),
new move_1m(m_Drivesubsystems),
m_Chooser.getSelected(),
new move_1m(m_Drivesubsystems)
    );
  }
}
