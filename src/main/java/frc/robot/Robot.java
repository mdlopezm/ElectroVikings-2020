/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Set;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  private Command autoCmd;

  SendableChooser<Command> chooser;

  private RobotContainer robotContainer;

  private int autoCommandCount = 0;

  public Robot() {
    super();
    chooser = new SendableChooser<>();
  }

  public void registerAutonomousCommmand(String name, Command command) {
    if (autoCommandCount == 0) chooser.setDefaultOption(name, command);
    else chooser.addOption(name, command);
    autoCommandCount++;
  }

  public void registerAutonomousCommmand(Command command) {
    registerAutonomousCommmand(command.getName(), command);
  }

  @Override
  public void robotInit() {

    robotContainer = new RobotContainer();

    final var tab = Shuffleboard.getTab("Autonomous");

    Set<String> names = robotContainer.getAutonomousCommands().keySet();
    for(var name : names) registerAutonomousCommmand(name, robotContainer.getAutonomousCommands().get(name));

    tab.add("Auto Mode", chooser);

  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    autoCmd = chooser.getSelected();
    if (autoCmd != null) autoCmd.schedule();
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (autoCmd != null) {
      autoCmd.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

}
