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
 * MAJOR CHANGES HAVE BEEN MADE
 * ON LINES 147 - 154 THE CLAW REQUIRES THE CODE FOR OPENING AND CLOSING
 * OTHERWISE READY FOR TESTING
 *
 */

public class Autonomous extends Command {
	
	/*           COMMAND SET DIRECTIONS
	 * 
	 * [0] - STARTING POSITION 1, ROUTE 1, LEFT
	 * [1] - STARTING POSIIOTN 1, ROUTE 1, RIGHT
	 * [2] - STARTING POSITION 1, ROUTE 2, LEFT
	 * [3] - STARTING POSITION 1, ROUTE 2, RIGHT
	 * [4] - STARTING POSITION 2, ROUTE 1, LEFT
	 * [5] - STARTING POSITION 2, ROUTE 1, RIGHT
	 * [6] - STARTING POSITION 2, ROUTE 2, LEFT
	 * [7] - STARTING POSITION 2, ROUTE 2, RIGHT
	 * [8] - STARTING POSITION 3 (FALLBACK), LEFT
	 * [9] - STARTING POSITION 3 (FALLBACK), RIGHT
	 * 
	 *           COMMAND SET COMMANDS
	 *           
	 *       MOVE_FORWARD:DISTANCE (FT)
	 *       MOVE_LEFT:DISTANCE (FT)
	 *       MOVE_RIGHT:DISTANCE (FT)
	 *       MOVE_BACK:DISTANCE (FT)
	 *       TURN_CW:DEGREES
	 *       TURN_CCW:DEGREES
	 *       CLAW:OPEN/CLOSE
	 *       ARM:UP/DOWN
	 *       
	 *       Put spaces between commands
	 * 
	 */
	
	String commandSet_0 = "MOVE_LEFT:16.5 MOVE_FORWARD:1 CLAW:OPEN MOVE_BACK:1 CLAW:CLOSE MOVE_LEFT:4 TURN_CW:90 CLAW:OPEN MOVE_LEFT:1.5 MOVE_FORWARD:0.5 CLAW:CLOSE MOVE_LEFT:0.5 MOVE_FORWARD:1 CLAW:OPEN";
	
	String commandSet_1 = "MOVE_LEFT:6.5 MOVE_FORWARD:14 TURN_CW:180 MOVE_RIGHT:10 MOVE_FORWARD:1 CLAW:OPEN MOVE_BACK:1 CLAW:CLOSE MOVE_RIGHT:4 TURN_CCW:90 CLAW:OPEN MOVE_RIGHT:1.5 MOVE_FORWARD:0.5 CLAW:CLOSE MOVE_FORWARD:1 CLAW:OPEN";
	
	String commandSet_2 = "MOVE_LEFT:6.5 TURN_CCW:90 MOVE_RIGHT:4 MOVE_FORWARD:5.5 CLAW:OPEN MOVE_BACK:4 CLAW:CLOSE MOVE_RIGHT:4 MOVE_FORWARD:O.5 CLAW:CLOSE MOVE_LEFT:4 MOVE_FORWARD:4 CLAW:OPEN";
	
	String commandSet_3 = "MOVE_LEFT:6.5 TURN_CCW:90 MOVE_RIGHT:11 MOVE_FORWARD:5.5 CLAW:OPEN MOVE_BACK:4 CLAW:CLOSE MOVE_LEFT:4 MOVE_FORWARD:O.5 CLAW:CLOSE MOVE_RIGHT:4 MOVE_FORWARD:4 CLAW:OPEN";
	
	String commandSet_4 = "MOVE_LEFT:6.5 MOVE_BACK:8 MOVE_LEFT:10 MOVE_FORWARD:1 CLAW:OPEN MOVE_BACK:1 CLAW:CLOSE MOVE_LEFT:4 TURN_CW:90 MOVE_LEFT:1.5 MOVE_FORWARD:0.5 CLAW:CLOSE MOVE_FORWARD:1 CLAW:OPEN";
	
	String commandSet_5 = "MOVE_LEFT:6.5 MOVE_FORWARD:5 TURN_CW:180 MOVE_RIGHT:10 MOVE_FORWARD:1 CLAW:OPEN MOVE_BACK:1 CLAW:CLOSE MOVE_RIGHT:4 TURN_CCW:90 MOVE_RIGHT:1.5 MOVE_FORWARD:0.5 CLAW:CLOSE MOVE_FORWARD:1 CLAW:OPEN";
	
	String commandSet_6 = "MOVE_LEFT:6.5 TURN_CCW:90 MOVE_LEFT:6 MOVE_FORWARD:8 CLAW:OPEN MOVE_BACK:4 CLAW:CLOSE MOVE_RIGHT:4 MOVE_FORWARD:1 CLAW:CLOSE MOVE_LEFT:4 MOVE_FORWARD:4 CLAW:OPEN";
	
	String commandSet_7 = "MOVE_LEFT:6.5 TURN_CCW:90 MOVE_RIGHT:4 MOVE_FORWARD:8 CLAW:OPEN MOVE_BACK:4 CLAW:CLOSE MOVE_LEFT:4 MOVE_FORWARD:1 CLAW:CLOSE MOVE_RIGHT:4 MOVE_FORWARD:4 CLAW:OPEN";
	
	String commandSet_8 = "MOVE_LEFT:19 MOVE_BACK:17 MOVE_LEFT:4 ARM:UP MOVE_FORWARD:1 CLAW:OPEN MOVE_BACK:2 ARM:DOWN";
	
	String commandSet_9 = "MOVE_LEFT:24 TURN_CW:180 ARM:UP MOVE_FORWARD:2 CLAW:OPEN MOVE_BACK:2 ARM:DOWN";
	
	String commandSet_USE = "ERROR";
	
	public void DecideCommandSet() {
		
		if (useAlt) {
			if (positionID == 1) {
				if (sideSwitch == 0) {
					commandSet_USE = commandSet_3;
				}
				else {
					commandSet_USE = commandSet_2;
				}
			}
			if (positionID == 2) {
				if (sideSwitch == 0) {
					commandSet_USE = commandSet_7;
				}
				else {
					commandSet_USE = commandSet_6;
				}
			}
			if (positionID == 3) {
				if (sideScale == 0) {
					commandSet_USE = commandSet_9;
				}
				else {
					commandSet_USE = commandSet_8;
				}
			}
		}
		
		else {
			if (positionID == 1) {
				if (sideSwitch == 0) {
					commandSet_USE = commandSet_1;
				}
				else {
					commandSet_USE = commandSet_0;
				}
			}
			if (positionID == 2) {
				if (sideSwitch == 0) {
					commandSet_USE = commandSet_5;
				}
				else {
					commandSet_USE = commandSet_4;
				}
			}
			if (positionID == 3) {
				if (sideScale == 0) {
					commandSet_USE = commandSet_9;
				}
				else {
					commandSet_USE = commandSet_8;
				}
			}
		}
	}
	
	public void ExecuteSpecific(String com) {
		String[] part = com.split(":");
		double moveVar;
		if (part[0].equals("MOVE_FORWARD")) {
			moveVar = Double.parseDouble(part[1]);
			Move(moveVar,0);
		}
		if (part[0].equals("MOVE_BACK")) {
			moveVar = Double.parseDouble(part[1]);
			Move(-moveVar,0);
		}
		if (part[0].equals("MOVE_RIGHT")) {
			moveVar = Double.parseDouble(part[1]);
			Move(moveVar,3);
		}
		if (part[0].equals("MOVE_LEFT")) {
			moveVar = Double.parseDouble(part[1]);
			Move(moveVar,4);
		}
		if (part[0].equals("CLAW")) {
			if (part[1].equals("OPEN")) {
				//OPEN CLAW
			}
			else if (part[1].equals("CLOSE")) {
				//CLOSE CLAW
			}
		}
		if (part[0].equals("ARM")) {
			if (part[1].equals("UP")) {
				Robot.arm.up();
			}
			else if (part[1].equals("DOWN")) {
				Robot.arm.down();
			}
		}
		if (part[0].equals("TURN_CW")) {
			moveVar = Double.parseDouble(part[1]);
			Move(moveVar,1);
		}
		if (part[0].equals("TUWN_CCW")) {
			moveVar = Double.parseDouble(part[1]);
			Move(moveVar,2);
		}
	}
	
	public void ExecuteCommandSet() {
		
		DecideCommandSet();
		
		if (commandSet_USE.equals("ERROR")) {
			// YOU DUN GOOFED. IF THIS EVER HAPPENS SOMETHING HAS GONE HORRIBLY WRONG
		}
		else {
			String[] order = commandSet_USE.split(" ");
			for (int i = 0; i < order.length; i++) {
				ExecuteSpecific(order[i]);
			}
		}
		
	}
	
	boolean working = false; // Prevents the same stage from being called repeatedly
	boolean finished = false;
	boolean safety = false; // Stops everything when true
	
	int speed = 3; // Change to speed in ft / sec (at full speed)
	int mspeed = 3; // Mechanum speed in ft / sec (at full speed)
	int tspeed = 90; // Degrees turned / sec (at |yaw| = 1)
	
	public Autonomous(int startPosition, char switchSide, char scaleSide, boolean alternateRoute) {
		
		positionID = startPosition; // ONLY EVER SHOULD BE 1, 2, OR 3
		
		if (switchSide == 'R') {
			sideSwitch = 0;
		}
		else if (switchSide == 'L') {
			sideSwitch = 1;
		}
		
		if (scaleSide == 'R') {
			sideScale = 0;
		}
		else if (scaleSide == 'L') {
			sideScale = 1;
		}
		
		useAlt = !alternateRoute;
		requires(Robot.drivetrain);
		requires(Robot.arm);
		requires(Robot.claw);
	}
	
	int positionID = 0; // Where are we starting
	int sideSwitch = 0; // What side is the switch on
	int sideScale = 0; // What side is the scale on
	boolean useAlt = false;
	
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
		if (type == 0) { // Move d ft forward
			int maxcycle = (int) (100*(Math.abs(d) / speed));
			for (int cycle = 0; cycle <= maxcycle; cycle++) {
				if (!safety) {
					if (d > 0) {
						Robot.drivetrain.backLeft.set(1);
						Robot.drivetrain.backRight.set(1);
						Robot.drivetrain.frontLeft.set(1);
						Robot.drivetrain.frontRight.set(1);
					}
					else {
						Robot.drivetrain.backLeft.set(-1);
						Robot.drivetrain.backRight.set(-1);
						Robot.drivetrain.frontLeft.set(-1);
						Robot.drivetrain.frontRight.set(-1);
					}
					Timer.delay(0.01);
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
					Robot.drivetrain.backLeft.set(1);
					Robot.drivetrain.backRight.set(-1);
					Robot.drivetrain.frontLeft.set(1);
					Robot.drivetrain.frontRight.set(-1);
					Timer.delay(0.01);
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
					Robot.drivetrain.backLeft.set(-1);
					Robot.drivetrain.backRight.set(1);
					Robot.drivetrain.frontLeft.set(-1);
					Robot.drivetrain.frontRight.set(1);
					Timer.delay(0.01);
				}
				else {
					waitForSafety();
					cycle--;
				}
			}
		}
		else if (type == 3) { // Mechanum drive right
			int maxcycle = (int) (100*(d / tspeed));
			for (int cycle = 0; cycle <= maxcycle; cycle++) {	
				if (!safety) {
					Robot.drivetrain.chassis.driveCartesian(0,1,0);
					/*Robot.drivetrain.backLeft.set();
					Robot.drivetrain.backRight.set();
					Robot.drivetrain.frontLeft.set();
					Robot.drivetrain.frontRight.set();*/
					Timer.delay(0.01);
				}
				else {
					waitForSafety();
					cycle--;
				}
			}	
		}
		else if (type == 4) { // Mechanum drive left			
			int maxcycle = (int) (100*(d / tspeed));			
			for (int cycle = 0; cycle <= maxcycle; cycle++) {						
				if (!safety) {					
					Robot.drivetrain.chassis.driveCartesian(0,-1,0);
					/*Robot.drivetrain.backLeft.set();
					Robot.drivetrain.backRight.set();
					Robot.drivetrain.frontLeft.set();
					Robot.drivetrain.frontRight.set();*/
					Timer.delay(0.01);						
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
		if (!working && !safety && !finished) { // Since execute is run repeatedly, prevents multiple stages from being run simultaneously
			working = true;
			ExecuteCommandSet();
			finished = true;
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
