/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class Climb extends CommandBase {

  private Climber climber;
  private DoubleSupplier winchPwr;

  /**
   * Creates a new Climb.
   */
  public Climb(Climber climber, DoubleSupplier winchPwr) {
    this.climber = climber;
    this.winchPwr = winchPwr;
    addRequirements(climber);
  }

  @Override
  public void execute() {
    climber.setPower(winchPwr.getAsDouble());
  }

}
