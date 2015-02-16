package org.usfirst.frc.team1165.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1165.robot.commands.ExampleCommand;
import org.usfirst.frc.team1165.robot.commands.FlashLed;
import org.usfirst.frc.team1165.robot.commands.LedFullOff;
import org.usfirst.frc.team1165.robot.commands.LedFullOn;
import org.usfirst.frc.team1165.robot.commands.CycleLed;
import org.usfirst.frc.team1165.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team1165.robot.subsystems.Led;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	public static final Led[] leds = { new Led(0), new Led(1) };
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;

	SendableChooser autoChooser;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		oi = new OI();
		
		SmartDashboard.putData(new LedFullOff());
		SmartDashboard.putData(new LedFullOn());
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Autonomous 0", new FlashLed(leds[0]));
		autoChooser.addObject("Autonomous 1", new FlashLed(leds[1]));
		SmartDashboard.putData("Auto:", autoChooser);
	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit()
	{

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
