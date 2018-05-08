/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/5/8 21:42:49                            */
/*==============================================================*/


drop table if exists chat_record;

drop table if exists class;

drop table if exists exam_result;

drop table if exists homework;

drop table if exists leave_record;

drop table if exists notice_bulletin;

drop table if exists parent;

drop table if exists student;

drop table if exists student_parent;

drop table if exists teacher;

drop table if exists teacher_class;

/*==============================================================*/
/* Table: chat_record                                           */
/*==============================================================*/
create table chat_record
(
   id                   int not null auto_increment,
   from_user            int not null,
   to_user              int not null,
   content              varchar(1000) not null,
   create_time          timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp,
   primary key (id)
);

alter table chat_record comment '聊天记录';

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   id                   int not null auto_increment,
   teacher              int,
   grade                int not null,
   class                int not null,
   create_time          timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table class comment '班级表';

/*==============================================================*/
/* Table: exam_result                                           */
/*==============================================================*/
create table exam_result
(
   id                   int not null auto_increment,
   stu_id               int,
   term                 int not null,
   subject              int not null,
   score                float not null,
   create_time          timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table exam_result comment '考试成绩表';

/*==============================================================*/
/* Table: homework                                              */
/*==============================================================*/
create table homework
(
   id                   int not null auto_increment,
   title                varchar(50) not null,
   content              text not null,
   finsh_time           timestamp not null,
   teacher              int not null,
   class                int not null,
   h_create_time        timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table homework comment '作业表';

/*==============================================================*/
/* Table: leave_record                                          */
/*==============================================================*/
create table leave_record
(
   id                   int not null auto_increment,
   tea_id               int,
   stu_id               int,
   reason               varchar(300) not null,
   type                 varchar(10) not null,
   start_time           timestamp not null,
   end_time             timestamp not null,
   create_time          timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_agree             int not null,
   time                 float not null,
   primary key (id)
);

alter table leave_record comment '请假情况表';

/*==============================================================*/
/* Table: notice_bulletin                                       */
/*==============================================================*/
create table notice_bulletin
(
   id                   int not null auto_increment,
   tea_id               int,
   type                 int not null,
   title                varchar(50) not null,
   content              text not null,
   nb_create_time       timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table notice_bulletin comment '通知公告，包含
id
标题
内容
类型
发布时间
                                    -&#&';

/*==============================================================*/
/* Table: parent                                                */
/*==============================================================*/
create table parent
(
   id                   int not null auto_increment,
   name                 varchar(20) not null,
   phone_number         varchar(11),
   create_time          timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table parent comment '家长表，记录家长的某些个人信息';

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   id                   int not null auto_increment,
   cla_id               int,
   name                 varchar(20) not null,
   sex                  varchar(2) not null,
   identity_number      varchar(18) not null,
   student_number       varchar(20) not null,
   s_create_time        timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table student comment '学生表，记录学生的个人信息';

/*==============================================================*/
/* Table: student_parent                                        */
/*==============================================================*/
create table student_parent
(
   stu_id               int not null,
   par_id               int not null,
   id                   int not null auto_increment,
   primary key (id)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   id                   int not null auto_increment,
   name                 varchar(20) not null,
   subject              int not null,
   phone_number         varchar(11),
   is_headmaster        int not null,
   create_time          timestamp not null default CURRENT_TIMESTAMP,
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id)
);

alter table teacher comment '教师表，记录教师的个人信息
';

/*==============================================================*/
/* Table: teacher_class                                         */
/*==============================================================*/
create table teacher_class
(
   tea_id               int not null,
   cla_id               int not null,
   id                   int not null auto_increment,
   primary key (id)
);

alter table teacher_class comment '教师班级对应表';

alter table exam_result add constraint FK_Relationship_8 foreign key (stu_id)
      references student (id) on delete restrict on update restrict;

alter table homework add constraint FK_Relationship_6 foreign key (class)
      references class (id) on delete restrict on update restrict;

alter table homework add constraint FK_Relationship_7 foreign key (teacher)
      references teacher (id) on delete restrict on update restrict;

alter table leave_record add constraint FK_Relationship_10 foreign key (stu_id)
      references student (id) on delete restrict on update restrict;

alter table leave_record add constraint FK_Relationship_11 foreign key (tea_id)
      references teacher (id) on delete restrict on update restrict;

alter table notice_bulletin add constraint FK_Relationship_9 foreign key (tea_id)
      references teacher (id) on delete restrict on update restrict;

alter table student add constraint FK_Relationship_5 foreign key (cla_id)
      references class (id) on delete restrict on update restrict;

alter table student_parent add constraint FK_Relationship_3 foreign key (stu_id)
      references student (id) on delete restrict on update restrict;

alter table student_parent add constraint FK_Relationship_4 foreign key (par_id)
      references parent (id) on delete restrict on update restrict;

alter table teacher_class add constraint FK_Relationship_1 foreign key (tea_id)
      references teacher (id) on delete restrict on update restrict;

alter table teacher_class add constraint FK_Relationship_2 foreign key (cla_id)
      references class (id) on delete restrict on update restrict;

