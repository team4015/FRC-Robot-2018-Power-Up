package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DropBox extends Command {

	private int target;
	private boolean finish;
	public DropBox(int num){
		target=num;
		finish=false;
	}
	@Override
	protected void execute() {
		Robot.arm.up();
		if(target==1){
			Timer.delay(0); //TODO:Find time to raise arm to scale
		}
		else if(target==-1){
			Timer.delay(0); //TODO:Find time to raise arm to switch
		}
		Robot.arm.stop();
		//Robot.drivetrain.drive(0, 0.5, 0);
		while(!Robot.bottomSwitch.get()) {
			Robot.wrist.down();
		}
		Robot.wrist.stop();
		Timer.delay(2);
		Robot.claw.clawPiston.toggle();
		finish=true;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finish;
	}

}
