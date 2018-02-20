package org.usfirst.frc.team4015.robot.robotModes.auto;

import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.auto.DropBox;
import org.usfirst.frc.team4015.robot.commands.auto.TurnToSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/* ===================================================
 * CommandGroup for placing cube in SWITCH
 * =================================================*/

public class Switch extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  Switch(int position, char side)
	{
		/*addSequential(new DriveToBaseLine(position));
		addSequential(new DriveToSwitch(position, side));
		addSequential(new CubeSwitch());*/
		int turn=0;
		if(side=='L'){
			if(position==1){
				turn=1;
			}
			else if(position==3){
				turn=-1;
			}
		}
		else if(side=='R'){
			
		}
			
		addSequential(new DriveToBaseLine(-1));
		addSequential(new TurnToSwitch(-1,turn));
		addSequential(new DropBox());
    }
	
}