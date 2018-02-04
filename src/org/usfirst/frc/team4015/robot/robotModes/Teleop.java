package org.usfirst.frc.team4015.robot.robotModes;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4015.robot.commands.Drive;
import org.usfirst.frc.team4015.robot.commands.MoveClaw;
import org.usfirst.frc.team4015.robot.commands.ToggleCompressor;
import org.usfirst.frc.team4015.robot.commands.MoveArm;
import org.usfirst.frc.team4015.robot.commands.MoveWrist;
import org.usfirst.frc.team4015.robot.commands.SpinIntake;
import org.usfirst.frc.team4015.robot.commands.Climb;

/* ===================================================
 * This CommandGroup enables control of the drivetrain,
 * piston, and compressor during teleop mode.
 * To leave the compressor on automatic control, 
 * remove the line "addParallel(new ToggleCompressor());"
 * =================================================*/

public class Teleop extends CommandGroup
{
	// CONSTRUCTOR //
	
	public  Teleop()
	{
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addParallel(new Drive());
    	addParallel(new MoveClaw());
    	addParallel(new MoveArm());
    	addParallel(new MoveWrist());
    	addParallel(new SpinIntake());
    	addParallel(new Climb());
    	
    	// Uncomment for manual compressor control
    	addParallel(new ToggleCompressor());
    }
	
}
