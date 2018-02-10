package org.usfirst.frc.team4015.robot.robotModes.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4015.robot.commands.SpinToWin;

/* ===================================================
 * This CommandGroup calls the autonomous command to
 * spin the robot :P
 * =================================================*/

public class AutoSpinToWin extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  AutoSpinToWin()
	{	
		addSequential(new SpinToWin());
    }
	
}


