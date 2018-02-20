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
		
		addSequential(new DriveToBaseLine(-1)); //indicate switch
		if(side=='L'){
			if(position==1){
			
				addSequential(new TurnToSwitch(-1,1));
			}
			/*else if(position==3){
				Robot.drivetrain.drive(0, 0.75, 0);
				Timer.delay(3);
				Robot.drivetrain.stop();
				Robot.drivetrain.drive(1, 0, 0);
				Timer.delay(0); //TODO: Find strafe time
				Robot.drivetrain.stop();
				turn=-1;
			}*/
		}
		else if(side=='R'){
			if(position==3){
	
				addSequential(new TurnToSwitch(-1,-1));
			}
		}
			
		
		
		addSequential(new DropBox(-1));
    }
	
}