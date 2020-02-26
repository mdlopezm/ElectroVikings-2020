/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private final VictorSPX arm;
  private final VictorSPX intake;

  /**
   * Creates a new Intake.
   */
  public Intake() {

    arm = new VictorSPX(Constants.ARM);
    intake = new VictorSPX(Constants.INTAKE);

    initMotorDirections();

  }

  private void initMotorDirections() {
    arm.setInverted(false); // TODO - Check Manually in Phoneix Tuner - Positive Pwr Up, Negative Down
    intake.setInverted(false); // TODO - Check Manually in Phoneix Tuner - Positive Pwr In, Negative Out
  }

  public void setArmPower(double pwr) {
    arm.set(ControlMode.PercentOutput, pwr);
  }

  public void setIntakePower(double pwr) {
    intake.set(ControlMode.PercentOutput, pwr);
  }

  public void stop() {
    setArmPower(0d);
    setIntakePower(0d);
  }

}
