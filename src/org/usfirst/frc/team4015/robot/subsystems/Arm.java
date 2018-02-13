package org.usfirst.frc.team4015.robot.subsystems;


import org.usfirst.frc.team4015.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/* ===================================================
 * This class controls the arm.  The arm is raised and
 * lowered using two CIM motors, each controlled by a 
 * Talon SRX.
 * =================================================*/

public class Arm extends Subsystem
{
	PWMTalonSRX armMotors;
	
	public Arm()
	{
		armMotors = new PWMTalonSRX(RobotMap.armMotors);
	}
	
	// MOVE ARM UP //
	
	public void up()
	{
		armMotors.set(1.0);
	}
	
	// MOVE ARM DOWN //
	
	public void down()
	{
		armMotors.set(-1.0);
	}
	
	// STOP ARM //
	
	public void stop()
	{
		armMotors.set(0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
