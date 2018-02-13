package org.usfirst.frc.team4015.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/* ===================================================
 * This class controls the wrist.  The wrist uses a 
 * windshield wiper motor controlled by a Talon SRX.
 * =================================================*/

public class Wrist extends Subsystem
{
	PWMTalonSRX wristMotor;
	
	public Wrist()
	{
		wristMotor = new PWMTalonSRX(6);
	}
	
	// MOVE WRIST UP //
	
	public void up()
	{
		wristMotor.set(0.5);
	}
	
	// MOVE WRIST DOWN //
	
	public void down()
	{
		wristMotor.set(-0.5);
	}
	
	// STOP WRIST //
	
	public void stop()
	{
		wristMotor.set(0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
