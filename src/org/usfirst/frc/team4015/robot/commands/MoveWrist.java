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
		if (OI.rightStick.getRawButtonPressed(1))
		{
			Robot.wrist.up();
		}
		else if (OI.rightStick.getRawButtonPressed(2))
		{
			Robot.wrist.down();
		}
		
		if (!((Robot.wrist.getTopSwitch() && OI.rightStick.getRawButtonPressed(1))||(Robot.wrist.getBottomSwitch() && OI.rightStick.getRawButtonPressed(2))))
		{
			Timer.delay(2);
		}
		else
		{
			Robot.wrist.stop();
			Timer.delay(2);
		}
		
		// ALT?? 
		/*
		if (OI.rightStick.getRawButton(1) && !Robot.wrist.getTopSwitch())
		{
			Robot.wrist.up();
		}
		else if (OI.rightStick.getRawButton(2) && !Robot.wrist.getBottomSwitch())
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
