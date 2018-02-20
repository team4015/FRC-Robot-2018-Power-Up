package org.usfirst.frc.team4015.robot.commands.auto;

import org.usfirst.frc.team4015.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TurnToSwitch extends Command {

	int position;//-1: switch     1:Scale
	int turn;// 1==right -1===left
	
	public TurnToSwitch(int pos, int turn) {
		position=pos;
		this.turn=turn;
	}
	@Override
	protected void execute() {
		Robot.arm.up();
		if(position==-1) {
		Timer.delay(0);//TODO: ROBOGT ARM UP TIME to switch
		}
		else if(position==1) {
			Timer.delay(0);//TODO: ROBOT ARM UP TIME TO SCALE
		}
		Robot.arm.stop();
		if (turn==-1)
			Robot.drivetrain.drive(0, 0, -1);
		else if(turn==-1) {
			Robot.drivetrain.drive(0, 0, -1);
		}
		Timer.delay(0);//TODO: TURNING TIME
		Robot.drivetrain.stop();
		Timer.delay(2);
		Robot.drivetrain.drive(0, 1.0, 0);
		if(position==-1) {
			Timer.delay(0);//TODO: FILL THIS SHIT IN switch time
		}
		else if(position==1) {
			Timer.delay(0);//TODO: FILL THIS SHIT IN scale time
		}
		
		Robot.drivetrain.stop();
		Timer.delay(2);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
