package frc.robot.subsystems;
//Import the uhhh motor classes??
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//Import the constants
import static frc.robot.Constants.IntakeConstants.INTAKE_OFF_SPEED;
import static frc.robot.Constants.IntakeConstants.INTAKE_ON_SPEED;
import static frc.robot.Constants.INTAKE_DRIVE_ID;

public class IntakeSubsystem extends SubsystemBase {
  
    //declare the motor ids
    private final VictorSPX intakeMotor = new VictorSPX(INTAKE_DRIVE_ID);

  public IntakeSubsystem() {}

  @Override
  public void periodic() {}

    //When the command is executed this turns on and off the intake. I think
    public void setPosition(boolean open) {
        if (open){
            intakeMotor.set(VictorSPXControlMode.PercentOutput, INTAKE_ON_SPEED);
        
        } else {
            intakeMotor.set(VictorSPXControlMode.PercentOutput, INTAKE_OFF_SPEED);;
        }
    }

}
