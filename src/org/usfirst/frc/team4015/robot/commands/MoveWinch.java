package org.usfirst.frc.team4015.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4015.robot.OI;
import org.usfirst.frc.team4015.robot.subsystems.Winch;

public class MoveWinch extends Command {

	Winch winch;
	
	public MoveWinch(){
		winch=new Winch();
	}
	
	@Override
	protected void execute(){
		while(OI.leftStick.getRawButton(5)){
			winch.spin();
		}
		winch.spin();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
