package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.subsystems.Led;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlashLed extends Command
{
	private final static int COUNT = 10;
	private Led led;
	private int count;

	public FlashLed(Led led)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(led);
		this.led = led;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		led.setVoltage(0);
		count = COUNT;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if (count-- <= 0)
		{
			led.setVoltage(2.0 - led.getVoltage());
			count = COUNT;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end()
	{
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
