package com.ppai.timemgr.tasklist.reminder;


public class Reminder
{
	private boolean isOnce;

	public boolean isOnce()
	{
		return isOnce;
	}

	public void setOnce(boolean isOnce)
	{
		this.isOnce = isOnce;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public ReminderHandler getRhr()
	{
		return rhr;
	}

	public void setRhr(ReminderHandler rhr)
	{
		this.rhr = rhr;
	}

	private String method;
	private ReminderHandler rhr;

}
