package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.commands.CycleLed;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Led extends Subsystem
{
	public static final double voltageMin = 1.5;
	public static final double voltageMax = 1.8;
	
	private AnalogOutput analogOutput;
	
	public Led(int channel)
	{
		 analogOutput = new AnalogOutput(channel);
	}
		
	public double getVoltage()
	{
		return analogOutput.getVoltage();
	}
	
	public void setVoltage(double voltage)
	{
		analogOutput.setVoltage(voltage);
	    SmartDashboard.putNumber("Voltage", getVoltage());
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new CycleLed(this));
	}
}
