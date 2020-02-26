/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class OperateIntake extends CommandBase {

  private Intake intake;
  private DoubleSupplier armPwr;
  private DoubleSupplier intakePwr;

  /**
   * Creates a new OperateIntake.
   */
  public OperateIntake(Intake intake, DoubleSupplier armPwr, DoubleSupplier intakePwr) {
    this.intake = intake;
    this.armPwr = armPwr;
    this.intakePwr = intakePwr;
    addRequirements(intake);
  }


  @Override
  public void execute() {
    intake.setArmPower(armPwr.getAsDouble());
    intake.setIntakePower(intakePwr.getAsDouble());
  }

}
