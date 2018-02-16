package org.usfirst.frc.team4015.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * This is a template class for creating a new Command
 * =================================================*/

public class DriveToScale extends Command
{
	int position;
	char side;
	
	public DriveToScale(int position, char side)
	{
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		this.position = position;
		this.side = side;
	}
	
	public DriveToScale()
	{
		position = 0;
		side = 'L';
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
		if (side == 'L')
		{
			if (position == 1)
			{

			}
			else if (position == 2)
			{

			}
			else if (position == 3)
			{

			}
		}
		else if (side == 'R')
		{
			if (position == 1)
			{

			}
			else if (position == 2)
			{

			}
			else if (position == 3)
			{

			}
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

