/**
 * 
 */
package org.usfirst.frc.team4015.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4015.robot.Robot;

/**
 * @author Gerald Lee
 * 
 * Similar to SpinToWin but actually earns some points
 *
 */

public class Autonomous extends Command {
	
	int behavior = 0;  /* Starting position and decision making
						*
						* 0 - Leftmost
						* 1 - Middle go left
						* 2 - Middle go right
						* 3 - Rightmost
						* 
						*/

	int stage = 1;      /* Keeps track of what is being done
						*
						* 1 - Drive to auto line
						* 2 - Turn and deposit cube
						* 3 - Retrieve next cube
						* 4 - Deposit next cube
						* 5 - Move out of the way and end
						*
	 					*/
	boolean working = false; // Prevents the same stage from being called repeatedly
	boolean finished = false;
	boolean safety = false; // Stops everything when true
	
	int speed = 3; // Change to speed in ft / sec (at full speed)
	int tspeed = 90; // Degrees turned / sec (at |yaw| = 1)
	
	public Autonomous() {
		
		requires(Robot.drivetrain);
		
	}
	
	public void waitForSafety() {
		while (safety) {
			Timer.delay(0.5);
		}
	}
	
	@Override
	protected boolean isFinished() {
		
		return finished;
		
	}
	
	@Override
	protected void initialize() {
		
		Robot.drivetrain.stop();
		safety = false;
		
	}
	
	public void Move(double d, int type) {
		
		if (type == 0) { // Mode d ft forward
			
			int maxcycle = (int) (100*(d / speed));
		
			for (int cycle = 0; cycle <= maxcycle; cycle++) {
				
				if (!safety) {
				
					Robot.drivetrain.drive(1, 0, 0);
					Timer.delay(0.05);
				
				}
			
				else {
				
					waitForSafety();
					cycle--;
				
				}
			
			}
		}
		
		else if (type == 1) { // Turn d degrees clockwise
			
			int maxcycle = (int) (100*(d / tspeed));
			
			for (int cycle = 0; cycle <= maxcycle; cycle++) {
				
				if (!safety) {
				
					Robot.drivetrain.drive(0, 0, 1);
					Timer.delay(0.05);
				
				}
			
				else {
				
					waitForSafety();
					cycle--;
				
				}
			
			}
			
		}
		
		else if (type == 2) { // Turn counterclockwise d degrees
			
			int maxcycle = (int) (100*(d / tspeed));
			
			for (int cycle = 0; cycle <= maxcycle; cycle++) {
				
				if (!safety) {
				
					Robot.drivetrain.drive(0, 0, -1);
					Timer.delay(0.05);
				
				}
			
				else {
				
					waitForSafety();
					cycle--;
				
				}
			
			}
			
		}
		
	}
	
	@Override
	protected void execute() {
		
		if (!working && !safety) { // Since execute is run repeatedly, prevents multiple stages from being run simultaneously
			
			if (stage == 1) { 
				
				if (behavior == 0 || behavior == 3) {
					
					working = true;
					
					Move(12.5, 0);
					
					stage++;
					working = false;
					
				}
				
				if (behavior == 1 || behavior == 2) {
					
					working = true;
					
					Move(7, 0);
					
					if (behavior == 1) {
						// TODO Use Mecanum drive to move 10ft left
					}
					
					if (behavior == 2) {
						// TODO Use Mecanum drive to move 6ft right
					}
					
					Move(5.5, 0);
					
					stage++;
					working = false;
					
				}
				
			}
			
			if (stage == 2) {
				
				int maxcycle = (int) (100*(90 / tspeed)); // Time in tenths of a second to turn 90 degrees
				working = true;
				
				for (int cycle = 0; cycle <= maxcycle; cycle++) {
					
					if (!safety) {
						
						if (behavior == 0 || behavior == 1) {
							
							Robot.drivetrain.drive(0, 0, 1); //Turn full speed clockwise
							Timer.delay(0.05);
							
						}
						
						if (behavior == 2 || behavior == 3) {
							
							Robot.drivetrain.drive(0, 0, -1); //Turn full speed counterclockwise
							Timer.delay(0.05);
							
						}
						
					}
					
					else {
						
						waitForSafety();
						cycle--;
						
					}
					
				}
				
				// TODO Move forward if needed then deposit cube
				
				stage++;
				working = false;
				
			}
			
			if (stage == 3) {
				
				if (behavior == 1 || behavior == 2) {
					
					// TODO Mechanum left 3ft
					
				}
				
				if (behavior == 3 || behavior == 4) {
					
					// TODO Mechanum right 3ft
					
				}
				
				
				
				stage++;
				working = false;
				
			}
			
			if (stage == 4) {
				
				working = true;
				
				//TODO Pick up cube with claw
				
				//TODO Move back and deposit cube
				
			}
			
			if (stage == 5) {
				
				//TODO Get out of the way
				
			}
			
		}
		
	}
	
	@Override
	protected void end() {
		
		Robot.drivetrain.stop();
		
	}
	
	@Override
	protected void interrupted() {
		
		Robot.drivetrain.stop();
		
	}
}
