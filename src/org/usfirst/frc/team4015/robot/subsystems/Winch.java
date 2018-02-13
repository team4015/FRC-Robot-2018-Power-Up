package org.usfirst.frc.team4015.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/* ===================================================
 * This class controls the winch.  The winch is 
 * controlled with two motors, each using a Talon SRX.
 * =================================================*/

public class Winch extends Subsystem
{
	PWMTalonSRX winchMotors;
	
	public Winch()
	{
		winchMotors = new PWMTalonSRX(5);
	}
	
	// SPIN WINCH TO CLIMB UP //
	
	public void spin()
	{
		winchMotors.set(1);
	}
	
	// STOP WINCH //
	
	public void stop()
	{
		winchMotors.set(0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
