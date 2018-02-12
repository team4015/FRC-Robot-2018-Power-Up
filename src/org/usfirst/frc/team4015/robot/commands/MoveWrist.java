package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4015.robot.OI;

/* ===================================================
 * This command allows for control of the wrist.
 * =================================================*/

public class MoveWrist extends Command
{
	Wrist motor;
	DigitalInput topSwitch;
	DigitalInput bottomSwitch;
	
	public MoveWrist()
	{
		// Use requires() here to declare subsystem dependencies
		
		motor=new Wrist();
		topSwitch = new DigitalInput(1);
		bottomSwitch = new DigitalInput(2);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{

	}
	
	// move the wrist up
	protected void moveUp(){
		motor.up();
	}
	
	// move wrist down
	protected void moveDown(){
		motor.down();
	}
	 //stop wrist
	protected void stop(){
		motor.stop();
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		if (OI.rightStick.getRawButtonPressed(1)){
			moveUp();
		}
		else if(OI.rightStick.getRawButtonPressed(2)){
			moveDown();
		}
		
		if (!((topSwitch.get() && OI.rightStick.getRawButtonPressed(1))||(bottomSwitch.get() && OI.rightStick.getRawButtonPressed(2)))) {
			Timer.delay(2);
		}
		else{
			stop();
			Timer.delay(2);
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
