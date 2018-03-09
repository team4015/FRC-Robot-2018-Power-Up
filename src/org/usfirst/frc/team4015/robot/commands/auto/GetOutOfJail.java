package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class GetOutOfJail extends Command {
	private boolean finish;
	public GetOutOfJail(){
		finish=false;
	}
	@Override
	protected void execute(){
		Timer.delay(5); //Time to let other robots clear path
		Robot.drivetrain.drive(0.5, 0, 0);
		Timer.delay(0);//TODO: Find time to reach right
		Robot.drivetrain.stop();
		Timer.delay(2);
		Robot.drivetrain.drive(0, 0.5, 0);
		Timer.delay(0);//TODO: Time to reach baseline
		Robot.drivetrain.stop();
		finish=true;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finish;
	}

}
