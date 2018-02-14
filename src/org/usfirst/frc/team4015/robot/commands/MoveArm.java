package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.subsystems.pneumaticsControl.Piston;

/* ===================================================
 * This command allows for control of the arm.
 * =================================================*/

public class MoveArm extends Command
{
	Piston p;
	public MoveArm()
	{
		requires(Robot.arm);
		p = new Piston(1,2);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		Robot.arm.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		// MOVE ARM UP //
		System.out.println(OI.rightStick.getRawButton(3));
		
		if (OI.rightStick.getRawButton(3))
		{
			p.retract();
			//Timer.delay(0.05);
			Robot.arm.up();
		}
		else
		{
		Robot.arm.stop(); 
		p.extend();
		}
		
		// MOVE ARM UP //
		System.out.println(OI.rightStick.getRawButton(4));
		
		if(OI.rightStick.getRawButton(4))
		{
			p.retract();
			//Timer.delay(0.05);
			Robot.arm.down();
		}
		else
		{
		Robot.arm.stop();
		p.extend();
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
		Robot.arm.stop();
		p.extend();
	}
}
