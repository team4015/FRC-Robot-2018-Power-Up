package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DropBox extends Command {

	@Override
	protected void execute() {

		
		//Robot.drivetrain.drive(0, 0.5, 0);
		while(!Robot.bottomSwitch.get()) {
			Robot.wrist.down();
		}
		Robot.wrist.stop();
		Timer.delay(2);
		Robot.claw.clawPiston.toggle();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
