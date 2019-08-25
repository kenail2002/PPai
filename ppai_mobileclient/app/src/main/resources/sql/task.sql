drop table t_task_info;
create table t_task_info
	 ( taskId nvarchar2(128) not null primary key,
	 parentTaskId nvarchar2(128),
	 taskName nvarchar2(2000) ,
	 beginTime timestamp,
  endTime timestamp,
 	 actualBeginTime timestamp,
  actualEndTIme  timestamp,
  completeRatio number(19),
  sortOrder number(19),
 	 createTime timestamp, 	 
 	 	 updateTime timestamp, 	 	 
 	 	 status nvarchar2(128) ,
 	 	 creator nvarchar2(128) , 	 	 
 	 	 	 	 currentOwner nvarchar2(128) , 	 	 	 	  	 	 	 	 
 	 	 	 	 	 	 location nvarchar2(2000) , 	  
feedback nvarchar2(2000) , 	 	 	 	 	 	 	 	 	 	 
taskType nvarchar2(128) , 	 	 	 	 	 	 	 	 	 	 	 	 
preTaskIds nvarchar2(2000) , 	  
 	 postTaskIds nvarchar2(2000) ,
 	   taskDescription nvarchar2(2000) ,
 	    batchId nvarchar2(128) ,
 	     cost number(19) ,	 	 	 	 	 	 	 	 	 	 	 	 	 
 	      reminder nvarchar2(2000) ,
 	       dependence nvarchar2(2000) ,
 	        priority  number(19) ,	 	 	
 	         emergentLevel number(19) ,	 
 	          importanceLevel number(19) ,	  	         
 	          deadLine timestamp,
 	 	 	 	  resourceStatus nvarchar2(2000) ,
 	 	 	 	    otherComments nvarchar2(2000) ,
 	 	 	 	      comefrom nvarchar2(128)  );
 	 	 	 	      
 drop  table t_user_info;
 create table t_user_info
  (
 userid nvarchar2(128),
  fullname nvarchar2(256),
  account nvarchar2(256),
  nickname nvarchar2(256),
  mobileno nvarchar2(256),
  email nvarchar2(256),
 socailNumber nvarchar2(256),
 password nvarchar2(256),
 rank  number(19),
 status nvarchar2(256),
 createTime timestamp,
 updateTime timestamp,
remark nvarchar2(2000)
	);
 