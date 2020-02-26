/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.Climb;
import frc.robot.commands.OperateIntake;
import frc.robot.commands.SimpleAuto;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class RobotContainer {

  // SUBSYSTEMS
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Climber climber = new Climber();

  // JOYSTICKS - SET UP FOR 1 LOGITECH CONTROLLER, 1 XBOX CONTROLLER
  private final Joystick driver = new Joystick(Constants.DRIVER_PORT);
  private final XboxController operator = new XboxController(Constants.OPERATOR_PORT);
  
  public RobotContainer() {

    drivetrain.setDefaultCommand(new TankDrive(
      drivetrain,
      () -> -driver.getY(Hand.kLeft), // LEFT INPUT => LEFT JOYSTICK
      () -> -driver.getY(Hand.kRight) // RIGHT INPUT => RIGHT JOYSTICK
    ));

    intake.setDefaultCommand(new OperateIntake(
      intake,
      () -> -operator.getY(Hand.kRight), // ARM INPUT => RIGHT JOYSTICK
      () -> (operator.getTriggerAxis(GenericHID.Hand.kRight) - operator.getTriggerAxis(GenericHID.Hand.kLeft))  // INTAKE INPUT => RIGHT TRIGGER IN, LEFT TRIGGER OUT
    ));

    climber.setDefaultCommand(new Climb(
      climber,
      () -> -operator.getY(Hand.kLeft) // WINCH INPUT => LEFT JOYSTICK
    ));

  }

  public HashMap<String, Command> getAutonomousCommands() {
    HashMap<String, Command> cmds = new HashMap<>();

    // TODO - Add Autons As Needed
    cmds.put("NO AUTO", null);
    cmds.put("MOVE FORWARD", new SimpleAuto(drivetrain));

    return cmds;
  }
}
