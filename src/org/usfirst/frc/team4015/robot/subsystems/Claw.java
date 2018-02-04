package org.usfirst.frc.team4015.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4015.robot.RobotMap;
import org.usfirst.frc.team4015.robot.subsystems.pneumaticsControl.Piston;

/* ===================================================
 * This class contains the methods/objects required to 
 * control the compressor and piston(s).
 * =================================================*/

public class Claw extends Subsystem
{
	public Piston clawPiston;
	
	// CONSTRUCTOR //
	
	public Claw()
	{
		clawPiston = new Piston(RobotMap.clawPistonLeftChannel, RobotMap.clawPistonRightChannel);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}