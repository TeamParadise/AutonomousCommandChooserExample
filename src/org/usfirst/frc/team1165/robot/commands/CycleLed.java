package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.subsystems.Led;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CycleLed extends Command
{
	static final double voltageStep = .01;
	static final double voltageStepSeconds = .25;

	private double currentStep;
	
	private Led led;

	public CycleLed(Led led)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(led);
		this.led = led;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		led.setVoltage(Led.voltageMin);
		currentStep = voltageStep;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if ((currentStep > 0 && led.getVoltage() >= Led.voltageMax)
				|| (currentStep < 0 && led.getVoltage() <= Led.voltageMin))
		{
			currentStep = -currentStep;
		}
		led.setVoltage(led.getVoltage() + currentStep);
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
