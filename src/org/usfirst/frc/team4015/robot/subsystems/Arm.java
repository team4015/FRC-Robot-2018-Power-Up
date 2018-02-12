package org.usfirst.frc.team4015.robot.subsystems;


import org.usfirst.frc.team4015.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/* ===================================================
 * This class controls the arm.  The arm is raised and
 * lowered using two CIM motors, each controlled by a 
 * Talon SRX.
 * =================================================*/

public class Arm extends Subsystem
{
	// Talons here - make one object to control both sides
	// use PWMTalonSRX class
	Talon talon;
	
	public Arm()
	{
		talon = new Talon(RobotMap.armMotors);
	}
	
	// MOVE ARM UP //
	
	public void up()
	{
		talon.set(1.0);
	}
	
	// MOVE ARM DOWN //
	
	public void down()
	{
		talon.set(-1.0);
	}
	
	// STOP ARM //
	
	public void stop()
	{
		talon.set(0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
