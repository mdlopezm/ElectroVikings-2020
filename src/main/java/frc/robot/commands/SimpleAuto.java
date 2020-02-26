/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class SimpleAuto extends CommandBase {

  private final double DURATION = 0.75;

  private Drivetrain drivetrain;
  private double startTime = 0d;
  
  /**
   * Creates a new SimpleAuto. 
   * Command runs forward full power for 3/4 seconds to get off the initation line.
   */
  public SimpleAuto(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
    drivetrain.setPower(1d, 1d);
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return ((Timer.getFPGATimestamp() - startTime) > DURATION);
  }
}
