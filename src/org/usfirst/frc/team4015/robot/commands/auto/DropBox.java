package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DropBox extends Command {
	private int loc;//-1=switch   1=scale
	public DropBox(int loc) {
		this.loc=loc;
	}
	@Override
	protected void execute() {
		Robot.arm.up();
		if(loc==-1) {
		Timer.delay(0);//TODO: ROBOGT ARM UP TIME to switch
		}
		else if(loc==1) {
			Timer.delay(0);//TODO: ROBOT ARM UP TIME TO SCALE
		}
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
