package org.usfirst.frc.team4015.robot.robotModes.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4015.robot.Robot;
import org.usfirst.frc.team4015.robot.commands.auto.DriveToBaseLine;
import org.usfirst.frc.team4015.robot.commands.auto.GetOutOfJail;

/* ===================================================
 * This CommandGroup drives the robot to the baseline
 * in auto.
 * =================================================*/

public class BaseLine extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  BaseLine(int position)
	{
		/*if (position == 1 || position == 3)
		{
			System.out.println("baseline");
			addSequential(new DriveToBaseLine(position));
		}
		else
		{
			addSequential(new GetOutOfJail());
		}*/
		long startTime = System.nanoTime();
		while((System.nanoTime() - startTime)<2000000000) {
			
			System.out.println("3b");
			//auto = new BaseLine(1);
			
			Robot.drivetrain.drive(0, 0.5, 0);
		
			}
		Robot.drivetrain.chassis.stopMotor();
    }
	
}
