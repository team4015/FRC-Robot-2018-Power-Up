package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToScale extends Command {
	char side;
	int position;
	boolean finish;
	public DriveToScale(int position, char side){
		this.side=side;
		this.position=position;
		finish=false;
	}
	
	@Override
	protected void execute(){
		Robot.drivetrain.drive(0, 1, 0);
		Timer.delay(0);//TODO: find timer from baseline to switch
		Robot.drivetrain.stop();
		if(position==1){
			Robot.drivetrain.drive(1, 0, 0);
			if(side=='L'){
				Timer.delay(0); //TODO: measure strafe time from boundary to left plate
			}
			else if(side=='R'){
				Timer.delay(0); //TODO: measure strafe time from boundary to right plate
			}
			Robot.drivetrain.stop();
		}
		else if(position==3){
			Robot.drivetrain.drive(-1, 0, 0);
			if(side=='R'){
				Timer.delay(0); //TODO: measure strafe time from boundary to right plate
			}
			else if(side=='L'){
				Timer.delay(0); //TODO: measure strafe time from boundary to Left plate
			}
			Robot.drivetrain.stop();
		}
		finish=true;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return finish;
	}

}
