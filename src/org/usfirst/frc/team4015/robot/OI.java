package org.usfirst.frc.team4015.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team4015.robot.RobotMap;

/* =============================================================================
 * This class stores the objects that are used to interface with the joysticks
 * and controllers used for controlling the robot.
 * ============================================================================*/
public class OI 
{	
	/* left stick buttons:
	 * 		5 - winch up
	 * 		4 - claw toggle
	 * right stick buttons:
	 * 		1 - wrist up
	 * 		2 - arm down
	 * 		3 - arm up
	 * 		4 - arm down
	 */
	public static JoystickDeadzone leftStick = new JoystickDeadzone(RobotMap.leftStickPort);
	public static JoystickDeadzone rightStick = new JoystickDeadzone(RobotMap.rightStickPort);
	public static JoystickDeadzone operatorStick = new JoystickDeadzone(RobotMap.gamepadPort);

	
}
