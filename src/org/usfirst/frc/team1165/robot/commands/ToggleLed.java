package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.subsystems.Led;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleLed extends Command
{
	private boolean isOn = false;
	private boolean isFinished = false;
	private Button button;
	private boolean hasButtonBeenReleased;
	private Led led;

	public ToggleLed(Button button, Led led)
	{
		this.led = led;
		requires(led);
		this.button = button;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		if (!isOn)
		{
			led.setVoltage(Led.voltageMax);
		}
		
		isOn = !isOn;
		isFinished = !isOn;
		hasButtonBeenReleased = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		if (!hasButtonBeenReleased)
		{
			hasButtonBeenReleased = !button.get();
		}
		
		if (hasButtonBeenReleased && button.get())
		{
			isFinished = true;
		}		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return isFinished;
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
