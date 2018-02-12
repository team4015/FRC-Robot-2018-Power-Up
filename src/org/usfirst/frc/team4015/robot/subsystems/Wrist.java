package org.usfirst.frc.team4015.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team4015.robot.RobotMap;
/* ===================================================
 * This class controls the wrist.  The wrist uses a 
 * windshield wiper motor controlled by a Talon SRX.
 * =================================================*/

public class Wrist extends Subsystem
{
	// Talons here
	Talon talon;
	
	public Wrist()
	{
		talon = new Talon(RobotMap.wristMotors); 
	}
	
	// MOVE WRIST UP //
	
	public void up()
	{
		talon.drive(1.0);
	}
	
	// MOVE WRIST DOWN //
	
	public void down()
	{
		
		talon.drive(1.0);
		
	}
	
	// STOP WRIST //
	
	public void stop()
	{
		talon.drive(0);
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		 setDefaultCommand(new MoveWrist());
	}
}
