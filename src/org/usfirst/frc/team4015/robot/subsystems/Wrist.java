package org.usfirst.frc.team4015.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

import org.usfirst.frc.team4015.robot.RobotMap;

/* ===================================================
 * This class controls the wrist.  The wrist uses a 
 * windshield wiper motor controlled by a Talon SRX.
 * =================================================*/

public class Wrist extends Subsystem
{
	PWMTalonSRX wristMotor;
	
	public Wrist()
	{
		wristMotor = new PWMTalonSRX(RobotMap.wristMotor);
	}
	
	// MOVE WRIST UP //
	
	public void moveUp()
	{
		wristMotor.set(1.0);
	}
	
	// MOVE WRIST DOWN //
	
	public void moveDown()
	{
		wristMotor.set(-1.0);
	}
	
	// STOP WRIST //
	
	public void stop()
	{
		wristMotor.set(0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MoveWrist());
	}
}
