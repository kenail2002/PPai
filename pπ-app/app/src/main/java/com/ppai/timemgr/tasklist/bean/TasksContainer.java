package com.ppai.timemgr.tasklist.bean;

import com.ppai.timemgr.tasklist.bean.TaskEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TasksContainer
{

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<TaskEntity> ITEMS = new ArrayList();
	
	public static List<String> keys=new ArrayList<String>();
	

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, TaskEntity> ITEM_MAP = new HashMap();

	static
	{
		// Add 3 sample items.
		addItem(new TaskEntity("1", "Item 1"));
		addItem(new TaskEntity("2", "Item 2"));
		addItem(new TaskEntity("3", "Item 3"));
	}

	private static void addItem(TaskEntity item)
	{
		ITEMS.add(item);
		ITEM_MAP.put(item.getId(), item);
		keys.add(item.getId());
	}

}
