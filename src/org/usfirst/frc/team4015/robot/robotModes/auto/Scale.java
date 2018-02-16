package org.usfirst.frc.team4015.robot.robotModes.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4015.robot.commands.auto.CubeScale;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToScale;

/* ===================================================
 * CommandGroup for placing cube in SCALE
 * =================================================*/

public class Scale extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  Scale(int position, char side)
	{	
		addSequential(new DriveToBaseLine(position));
		addSequential(new DriveToScale(position, side));
		addSequential(new CubeScale());
    }
	
}