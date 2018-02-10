package org.usfirst.frc.team4015.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;

// SUBSYSTEM IMPORTS //

import org.usfirst.frc.team4015.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4015.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4015.robot.subsystems.Claw;
import org.usfirst.frc.team4015.robot.subsystems.Arm;
import org.usfirst.frc.team4015.robot.subsystems.Wrist;
import org.usfirst.frc.team4015.robot.subsystems.Winch;
import org.usfirst.frc.team4015.robot.subsystems.Intake;

// ROBOT MODES (COMMAND GROUP) IMPORTS //

import org.usfirst.frc.team4015.robot.robotModes.Teleop;
import org.usfirst.frc.team4015.robot.robotModes.auto.*;
import org.usfirst.frc.team4015.robot.robotModes.auto.position1.*;

/* =============================================================================
 * The RoboRIO will automatically run the methods in this class depending on
 * which part of the match is being played.
 * ============================================================================*/

public class Robot extends IterativeRobot
{
	// SUBSYSTEM DECLARATION //
	
	public static Drivetrain drivetrain;
	public static Pneumatics pneumatics;
	public static Claw claw;
	public static Arm arm;
	public static Wrist wrist;
	public static Winch winch;
	public static Intake intake;
	
	// DECLARE ROBOT MODES (COMMAND GROUPS) //
	
	Command teleop;
	Command auto;
	
	//SendableChooser<Command> chooser = new SendableChooser<>();

	/* ===================================
	 * This function is run when the robot 
	 * is first started up and should be
	 * used for any initialization code.
	 * ==================================*/
	
	@Override
	public void robotInit()
	{
		// SUBSYSTEM INSTANTIATION //
		
		drivetrain = new Drivetrain();
		drivetrain.newMecanumDrive();
		
		pneumatics = new Pneumatics();
		claw = new Claw();
		arm = new Arm();
		wrist = new Wrist();
		winch = new Winch();
		intake = new Intake();
		
		
		// INSTANTIATE ROBOT MODES (COMMAND GROUPS) //
		
		teleop = new Teleop();
		//auto = new Auto();
		
		/*
		chooser.addDefault("Default Auto", new ExampleCommand());
		chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		*/
	}

	/* =================================================
	 * This function is called once each time the robot 
	 * enters Disabled mode. You can use it to reset any 
	 * subsystem information you want to clear when the 
	 * robot is disabled.
	 * ================================================*/
	
	@Override
	public void disabledInit()
	{

	}

	@Override
	public void disabledPeriodic()
	{
		// Run Scheduler to manage Commands / CommandGroups
		Scheduler.getInstance().run();
	}

	/* =========================================================================
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 * ========================================================================*/
	
	@Override
	public void autonomousInit()
	{
		String plateLocations;
		plateLocations = DriverStation.getInstance().getGameSpecificMessage();
		
		/*
        if (plateLocations.length() > 0)
        {
		  if(plateLocations.charAt(0) == 'L')
		  {
			//Put left auto code here
		  }
		  else if (plateLocations.charAt(0) == 'R')
		  {
			//Put right auto code here
		  }
		}
		*/
                
		//autonomousCommand = chooser.getSelected();
		
		String autoSelected = SmartDashboard.getString("Auto Selector", "BaseLine");
		 
		 switch (autoSelected)
		 {
		 	case "Switch1":
		 		
		 		if (plateLocations.length() > 0)
		        {
				  if(plateLocations.charAt(0) == 'L')
				  {
					auto = new Switch1L();
				  }
				  else if (plateLocations.charAt(0) == 'R')
				  {
					auto = new Switch1R();
				  }
				}
		 		
		 		break;
		 		
		 	case "Scale1":
		 		
		 		if (plateLocations.length() > 0)
		        {
				  if(plateLocations.charAt(0) == 'L')
				  {
					auto = new Scale1L();
				  }
				  else if (plateLocations.charAt(0) == 'R')
				  {
					auto = new Scale1R();
				  }
				}
		 		
		 		break;
		 		
		 	case "AutoSpinToWin":
		 		auto = new AutoSpinToWin();
		 		break;
		 		
		 	case "BaseLine":
		 		auto = new BaseLine();
		 		break;
		 		
		 	default:
		 		auto = new BaseLine();
		 		break;
		 }
		 

		// START AUTONOMOUS COMMAND GROUP //
		
		if (auto != null)
		{
			auto.start();
		}
	}

	/* ======================================================
	 * This function is called periodically during autonomous
	 * =====================================================*/
	
	@Override
	public void autonomousPeriodic()
	{
		// Run Scheduler to manage Commands / CommandGroups
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit()
	{
		/* This makes sure that the autonomous stops
		 * running when teleop starts running. If you
		 * want the autonomous to continue until 
		 * interrupted by another command, remove 
		 * this line or comment it out.
		 */
		
		// STOP AUTONOMOUS COMMAND GROUP //
		
		if (auto != null)
		{
			auto.cancel();
		}
		
		// START TELEOP COMMAND GROUP //
		
		if (teleop != null)
		{
			teleop.start();
		}
	}

	/* ===================================================
	 * This function is called periodically during teleop
	 * ==================================================*/
	
	@Override
	public void teleopPeriodic()
	{
		// Run Scheduler to manage Commands / CommandGroups
		Scheduler.getInstance().run();
	}

	/* =====================================================
	 * This function is called periodically during test mode
	 * ====================================================*/
	@Override
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
