package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DropBox extends Command {
	@Override
	protected void execute() {
		Robot.arm.up();
		Timer.delay(0);//TODO: ROBOGT ARM UP TIME
		Robot.arm.stop();
		Robot.drivetrain.drive(0, 0.5, 0);
		while(Robot.bottomSwitch.get()) {
			Robot.wrist.moveDown();
		}
		Robot.wrist.stop();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
