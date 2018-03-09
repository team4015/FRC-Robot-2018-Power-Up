package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.Robot;

/* ===================================================
 * This command allows for control of the claw. 
 * =================================================*/

public class MoveClaw extends Command
{
	public MoveClaw()
	{
		requires(Robot.claw);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		// Default starting position
		Robot.claw.clawPiston.retract();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		if (OI.rightStick.getRawButton(1) /*|| OI.gamepad.getRawButton(9)*/)
		{
			Robot.claw.clawPiston.toggle();
			Timer.delay(1);
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
