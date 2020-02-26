/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {

  private Drivetrain drivetrain;
  private DoubleSupplier leftPwr;
  private DoubleSupplier rightPwr;

  /**
   * Creates a new TankDrive.
   */
  public TankDrive(Drivetrain drivetrain, DoubleSupplier leftPwr, DoubleSupplier rightPwr) {
    this.drivetrain = drivetrain;
    this.leftPwr = leftPwr;
    this.rightPwr = rightPwr;
    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    drivetrain.setPower(leftPwr.getAsDouble(), rightPwr.getAsDouble());
  }

}
