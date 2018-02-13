package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * This command allows for control of the winch for 
 * climbing.
 * =================================================*/

public class Climb extends Command
{
	public Climb()
	{
		requires(Robot.winch);
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
		if (OI.leftStick.getRawButton(5))
		{
			Robot.winch.spin();
		}
		else
		{
			Robot.winch.stop();
		}
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
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		Robot.winch.stop();
	}
}
