package com.ppai.timemgr.tasklist.bean;

import com.ppai.timemgr.tasklist.reminder.Reminder;

import java.util.Date;

public class TaskEntity implements java.io.Serializable
{
	
	public TaskEntity(String id,String title)
	{
		this.id=id;
		this.title=title;
	}
	public TaskEntity(String id,String title,String descr)
	{
		this.id=id;
		this.title=title;
		this.content=descr;
	}
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 360051051369306652L;

	private Date createTime;

	private String title;
	private String id;
	private String content;
	private String remark;
	private String owner;
	private Date startTime;
	private Date endTime;

	private Reminder remder;

	private String status;

	private String source;

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	} 

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public Reminder getRemder()
	{
		return remder;
	}

	public void setRemder(Reminder remder)
	{
		this.remder = remder;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}
	
	public String toSting()
	{
		return this.id+":"+this.title;
	}

}
