package org.usfirst.frc.team4015.robot.robotModes.auto;

import org.usfirst.frc.team4015.robot.commands.auto.CubeSwitch;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToSwitch;
import edu.wpi.first.wpilibj.command.CommandGroup;

/* ===================================================
 * CommandGroup for placing cube in SWITCH
 * =================================================*/

public class Switch extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  Switch(int position, char side)
	{
		addSequential(new DriveToBaseLine(position));
		addSequential(new DriveToSwitch(position, side));
		addSequential(new CubeSwitch());
    }
	
}