package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.RobotMap;
import org.usfirst.frc.team4015.robot.subsystems.pneumaticsControl.Piston;
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
	public Piston p;
	
	public Arm()
	{
		armMotors = new PWMTalonSRX(RobotMap.armMotors);
		p = new Piston(4,5);
	}
	
	// MOVE ARM UP //
	
	public void up()
	{
		p.retract();
		armMotors.set(1.0);
	}
	
	// MOVE ARM DOWN //
	
	public void down()
	{
		p.retract();
		armMotors.set(-1.0);
	}
	
	// STOP ARM //
	
	public void stop()
	{
		armMotors.set(0);
		p.extend();
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
