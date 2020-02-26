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

public class Climber extends SubsystemBase {

  private final VictorSPX winch;

  /**
   * Creates a new Climber.
   */
  public Climber() {

    winch = new VictorSPX(Constants.WINCH);

    initMotorDirections();

  }

  private void initMotorDirections() {
    winch.setInverted(false); // TODO - Check Manually in Phoneix Tuner - Positive Pwr Up, Negative Down
  }

  public void setPower(double pwr) {
    winch.set(ControlMode.PercentOutput, pwr);
  }

  public void stop() {
    setPower(0d);
  }

}
