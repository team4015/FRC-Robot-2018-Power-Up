package org.usfirst.frc.team4015.robot.robotModes.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToScale;
import org.usfirst.frc.team4015.robot.commands.auto.DropBox;

public class Scale extends CommandGroup
{
	// CONSTRUCTOR //

	public Scale(int position, char side)
	{
		addSequential(new DriveToBaseLine(1)); // indicate scale
		if (side == 'L')
		{
			if (position == 1)
			{
				addSequential(new DriveToScale(position, side));
			}

		}
		else if (side == 'R')
		{
			if (position == 3)
			{
				addSequential(new DriveToScale(position, side));
			}
		}
		
		addSequential(new DropBox(1));
	}

}