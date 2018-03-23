package org.usfirst.frc.team4015.robot.commands;

import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Control extends Command {

	protected void execute() {
		if(OI.gamepad.getPOV()==0) {
			Robot.drivetrain.chassis.driveCartesian(0.5, 0, 0, 0);
		}
		else if(OI.gamepad.getPOV()==0) {
			Robot.drivetrain.chassis.driveCartesian(0.5, 0, 0, 0);
		}
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
