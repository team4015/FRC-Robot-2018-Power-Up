package org.usfirst.frc.team4015.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4015.robot.RobotMap;
import org.usfirst.frc.team4015.robot.commands.MoveWrist;
/* ===================================================
 * This class controls the wrist.  The wrist uses a 
 * windshield wiper motor controlled by a Talon SRX.
 * =================================================*/

public class Wrist extends Subsystem
{
	
	public Wrist()
	{
		
	}
	
	// MOVE WRIST UP //
	
	public void up()
	{
		
	}
	
	// MOVE WRIST DOWN //
	
	public void down()
	{
		
		
		
	}
	
	// STOP WRIST //
	
	public void stop()
	{
		
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		 setDefaultCommand(new MoveWrist());
	}
}
