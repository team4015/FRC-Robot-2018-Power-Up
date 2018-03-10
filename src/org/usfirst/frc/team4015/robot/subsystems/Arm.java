package org.usfirst.frc.team4015.robot.subsystems;

import org.usfirst.frc.team4015.robot.RobotMap;
import org.usfirst.frc.team4015.robot.subsystems.pneumaticsControl.Piston;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/* ===================================================
 * This class controls the arm.  The arm is raised and
 * lowered using two CIM motors, each controlled by a 
 * Talon SRX.
 * =================================================*/

public class Arm extends Subsystem
{
	public PWMTalonSRX armMotors;
	//public Piston p;
	//private DigitalInput topSwitch;
	//private DigitalInput bottomSwitch;
	
	public Arm()
	{
		armMotors = new PWMTalonSRX(RobotMap.armMotors);
		//p = new Piston(4,5);
		//topSwitch = new DigitalInput(5);
		//bottomSwitch = new DigitalInput(6);
	}
	
	// MOVE ARM UP //
	
	public void up()
	{
		//p.retract();
		System.out.println("Arm UP");
		armMotors.set(-0.5);
	}
	
	// DIRECT MOTOR CONTROL //
	
	public void move(double speed)
	{
		armMotors.set(speed);
	}
	
	// MOVE ARM DOWN //
	
	public void down()
	{
		//p.retract();
		System.out.println("Arm DOWN");
		armMotors.set(0.3);
	}
	
	// STOP ARM //
	
	public void stop()
	{
		armMotors.set(0);
		//p.extend();
	}
	
	/*
	
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
	
	*/
	
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
