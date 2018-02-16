package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LeftToSwitch extends Command {

	@Override
	protected void execute() {
		Robot.drivetrain.drive(0, 0, -1);
		Timer.delay(0);//TODO: TURNING TIME
		Robot.drivetrain.drive(0, 0, 0);
		Robot.delay(2);
		Robot.drivetrain.drive(0, 1.0, 0);
		Timer.delay(0);//TODO: FILL THIS SHIT IN
		Robot.drivetrain.drive(0, 0, 0);
		Timer.delay(2);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
