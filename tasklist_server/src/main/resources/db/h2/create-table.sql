--CREATE ALIAS IF NOT EXISTS FT_INIT FOR "org.h2.fulltext.FullText.init";
--CALL FT_INIT();

create table LOGRECORD(id BIGINT primary key,loglevel varchar(32),
 logTime timestamp,
 threadName varchar(64),
 msg varchar);

create table task_basic(id bigint primary key,
title varchar(256),
descr varchar,
towner varchar(128),
createTime timestamp,
beginTime timestamp,
endTime timestamp,
level varchar(32),
parentId bigint,
status varchar(32));
create index idx_task_b001 on task_basic(createtime);
create index idx_task_b002 on task_basic(towner);

--CALL FT_CREATE_INDEX('PUBLIC', 'LOGRECORD', NULL);
