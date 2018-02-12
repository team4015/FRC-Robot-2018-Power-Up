package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/* ===================================================
 * This class controls the winch.  The winch is 
 * controlled with two motors, each using a Talon SRX.
 * =================================================*/

public class Winch extends Subsystem
{
	// Talons here - make one object to control both sides
	Talon talon;
	public Winch()
	{
		talon = new Talon(RobotMap.winchMotor);
	}
	
	// SPIN WINCH TO CLIMB UP //
	
	public void spin()
	{
		talon.set(1.0);
	}
	
	// STOP WINCH //
	
	public void stop()
	{
		
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
