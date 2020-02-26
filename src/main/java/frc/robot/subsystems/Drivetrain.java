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

public class Drivetrain extends SubsystemBase {

  private final VictorSPX leftMaster;
  private final VictorSPX leftFollow;
  private final VictorSPX rightMaster;
  private final VictorSPX rightFollow;

  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {

    leftMaster = new VictorSPX(Constants.LEFT_MASTER);
    leftFollow = new VictorSPX(Constants.LEFT_FOLLOW);
    rightMaster = new VictorSPX(Constants.RIGHT_MASTER);
    rightFollow = new VictorSPX(Constants.RIGHT_FOLLOW);

    initMotorDirections();

  }

  private void initMotorDirections() {

    leftFollow.follow(leftMaster);
    rightFollow.follow(rightMaster);

    leftMaster.setInverted(false); // TODO - Check Manually in Phoneix Tuner
    leftFollow.setInverted(false); // TODO - Check Manually in Phoneix Tuner
    
    rightMaster.setInverted(true); // TODO - Check Manually in Phoneix Tuner
    rightFollow.setInverted(true); // TODO - Check Manually in Phoneix Tuner 

  }

  public void setPower(double left, double right) {
    leftMaster.set(ControlMode.PercentOutput, left);
    rightMaster.set(ControlMode.PercentOutput, right);
  }

  public void stop() {
    setPower(0d, 0d);
  }

}
