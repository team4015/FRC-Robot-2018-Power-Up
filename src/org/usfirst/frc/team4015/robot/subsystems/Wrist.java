package org.usfirst.frc.team4015.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;

import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.RobotMap;

/* ===================================================
 * This class controls the wrist.  The wrist uses a 
 * windshield wiper motor controlled by a Talon SRX.
 * =================================================*/

public class Wrist extends Subsystem
{	
	PWMTalonSRX wristMotor;
	DigitalInput topSwitch;
	DigitalInput bottomSwitch;
	
	public Wrist()
	{
		wristMotor = new PWMTalonSRX(RobotMap.wristMotor);
		topSwitch = new DigitalInput(7);
		bottomSwitch = new DigitalInput(8);
	}
	
	// MOVE WRIST DOWN //
	
	public void down()
	{
		if (!getBottomSwitch())
		{
			wristMotor.set(0.5);
		}
	}
	
	// MOVE WRIST UP //
	
	public void up()
	{
		if (!getTopSwitch())
		{
			wristMotor.set(-1);
		}
	}
	
	// STOP WRIST //
	
	public void stop()
	{
		wristMotor.set(0);
	}
	
	// GET TOP SWITCH VALUE //
	
	public boolean getTopSwitch()
	{
		return topSwitch.get();
	}
	
	// GET BOTTOM SWITCH VALUE //
	
	public boolean getBottomSwitch()
	{
		return bottomSwitch.get();
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MoveWrist());
	}
}
