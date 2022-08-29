package frc.robot.subsystems;

import com.fasterxml.jackson.databind.deser.impl.ValueInjector;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants.IntakeConstants;



public class IntakeSubsystem extends SubsystemBase {
  
    private static final double IntakeOnSpeed = intakeOnSpeed;
    private static final double Intakeoffspeed = 0;
    private final VictorSPX intakeMotor = new VictorSPX(4);




  public IntakeSubsystem() {}

    public void setPosition(boolean open) {
        if (open){
            intakeMotor.set(VictorSPXControlMode.PercentOutput, intakeOnSpeed);
        
        } else {
            intakeMotor.set(VictorSPXControlMode.PercentOutput, intakeoffspeed);;
        }
    }
}
