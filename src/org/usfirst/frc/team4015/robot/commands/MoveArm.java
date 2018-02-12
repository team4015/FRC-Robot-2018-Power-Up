package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.subsystems.Arm;
import org.usfirst.frc.team4015.robot.subsystems.pneumaticsControl.*;

/* ===================================================
 * This command allows for control of the arm.
 * =================================================*/

public class MoveArm extends Command
{
	Arm motor;
	Piston p;
	public MoveArm()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.arm);
		motor = new Arm();
		p=new Piston(1,2);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		motor.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		while(OI.rightStick.getRawButton(3)){
			p.retract();
			Timer.delay(2);
			motor.up();
		}
		motor.stop();
		p.extend();
		while(OI.rightStick.getRawButton(4)){
			p.retract();
			Timer.delay(2);
			motor.down();
		}
		motor.stop();
		p.extend();
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
