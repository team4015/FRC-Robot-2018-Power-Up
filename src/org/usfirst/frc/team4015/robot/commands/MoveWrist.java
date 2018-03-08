package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * This command allows for control of the wrist.
 * =================================================*/

public class MoveWrist extends Command
{	
	public MoveWrist()
	{
		requires(Robot.wrist);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		
		if ((OI.leftStick.getRawButtonPressed(5) /*|| OI.gamepad.getRawButton(6)*/) && !Robot.wrist.getTopSwitch())
		{
			Robot.wrist.up();
		}
		else if ((OI.leftStick.getRawButtonPressed(3) /*|| OI.gamepad.getRawButton(7)*/) && !Robot.wrist.getBottomSwitch())
		{
			Robot.wrist.down();
		}
		else
		{
			Robot.wrist.stop();
		}
		
		// ALT?? 
		/*
		 * 
		if ((OI.leftStick.getRawButtonPressed(5) || OI.operatorStick.getRawButton(6)) && !Robot.wrist.getTopSwitch())
		{
			Robot.wrist.up();
		}
		else if ((OI.leftStick.getRawButtonPressed(3) || OI.operatorStick.getRawButton(7)) && !Robot.wrist.getBottomSwitch())
		{
			Robot.wrist.down();
		}
		*/
	}
	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.wrist.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		Robot.wrist.stop();
	}
}
