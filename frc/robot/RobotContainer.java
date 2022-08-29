// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.driveForwardTimed;
import frc.robot.commands.driveWithJoysticks;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsytem = new ShooterSubsystem();

  
  private final PS4Controller ps4Controller = new PS4Controller(0); // 0 is the USB Port to be used as indicated on the Driver Station
  
  private final drivetrain drivetrain;
  private final driveWithJoysticks driveWithJoystick;
  private final driveForwardTimed driveForwardTimed;
  public static XboxController driverJoystick;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    intakeSubsystem.setDefaultCommand(new IntakeCommand(intakeSubsystem, false));
    shooterSubsytem.setDefaultCommand(new ShooterCommand(shooterSubsytem, false));

    drivetrain = new drivetrain();
    driveWithJoystick = new driveWithJoysticks(drivetrain);
    driveWithJoystick.addRequirements(drivetrain);
    drivetrain.setDefaultCommand(driveWithJoystick);

    driveForwardTimed = new driveForwardTimed(drivetrain);
    driveForwardTimed.addRequirements(drivetrain);

    driverJoystick = new XboxController(Constants.JOYSTICK_NUMBER);

    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

      
      new JoystickButton(ps4Controller, 3).whileHeld(new IntakeCommand(intakeSubsystem, true));
      new JoystickButton(ps4Controller, 4).whileHeld(new ShooterCommand(shooterSubsytem, true));

      new JoystickButton(ps4Controller, 5).whileHeld(new ParallelCommandGroup(
        new IntakeCommand(intakeSubsystem, true), new ShooterCommand(shooterSubsytem, true)
      ));

      
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForwardTimed;
  }
}
