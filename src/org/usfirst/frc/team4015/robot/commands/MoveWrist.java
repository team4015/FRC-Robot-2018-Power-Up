package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.OI;

/* ===================================================
 * This command allows for control of the wrist.
 * =================================================*/

public class MoveWrist extends Command
{
	public MoveWrist()
	{
		// Use requires() here to declare subsystem dependencies
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
		if (OI.rightStick.getRawButton(4) == true)
		{
			Robot.wrist.up();
		}
		else if (OI.rightStick.getRawButton(5) == true)
		{
			Robot.wrist.down();
		}
		else
		{
			Robot.wrist.stop();
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
		
	}
}
