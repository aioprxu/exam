drop table question;
create table `question` (
`id` int not null AUTO_INCREMENT,
`model_id` int not null,
`question_type` int not null,
`questionstem` varchar(50) not null,
`options` varchar(50) not null,
`answer` varchar(50) not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into question (model_id, question_type, questionstem, options, answer) value (1, 2,'???','1,2,3','A');
insert into question (model_id, question_type, questionstem, options, answer) value (1, 2,'这题选a','1,2,3','A');
insert into question (model_id, question_type, questionstem, options, answer) value (1, 2,'这题选b','1,2,3','B');
insert into question (model_id, question_type, questionstem, options, answer) value (1, 2,'这题选c','1,2,3','C');
insert into question (model_id, question_type, questionstem, options, answer) value (1, 1,'世界上最帅的人是谁','','未解之谜');
insert into question (model_id, question_type, questionstem, options, answer) value (1, 1,'试飞员飞行前能不能吃东西','','不能');
insert into question (model_id, question_type, questionstem, options, answer) value (1, 4,'试飞员飞行前是否能吃东西','','否');
insert into question (model_id, question_type, questionstem, options, answer) value (1, 5,'请说明为什么试飞前不能吃东西','','暂无');

drop table answer;
create table `answer` (
`id` int not null AUTO_INCREMENT,
`exam_id` int not null,
`user_id` int not null,
`question_id` int not null,
`answer` varchar(50),
`score` int not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into answer (exam_id, user_id, question_id, answer, score) value ()

drop table exam;
create table `exam` (
`exam_id` int not null AUTO_INCREMENT,
`model_id` int not null,
`name` varchar(16) not null,
`paper_id` int not null,
`is_open` int not null,
`start_time` timestamp not null,
`stop_time` timestamp not null,
PRIMARY KEY (`exam_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into exam (model_id, name, paper_id, is_open, start_time, stop_time) value (1, '期中考试', 1, 1, now(), now());

create table `exam_user` (
`id` int not null AUTO_INCREMENT,
`exam_id` int not null,
`user_id` int not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



create table `model` (
`id` int not null AUTO_INCREMENT,
`name` varchar(50) not null,
`user_id` int not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table paper;
create table `paper` (
`paper_id` int not null AUTO_INCREMENT,
`name` varchar(16) not null,
`model_id` int not null,
PRIMARY KEY (`paper_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into paper (name, model_id) values ('超难的试卷', 1);

create table `paper_question` (
`id` int not null AUTO_INCREMENT,
`paper_id` int not null,
`question_id` int not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into paper_question (paper_id, question_id) value (1, 1);
insert into paper_question (paper_id, question_id) value (1, 2);
insert into paper_question (paper_id, question_id) value (1, 3);
insert into paper_question (paper_id, question_id) value (1, 4);
insert into paper_question (paper_id, question_id) value (1, 5);
insert into paper_question (paper_id, question_id) value (1, 6);
insert into paper_question (paper_id, question_id) value (1, 7);







create table `result` (
`id` int not null AUTO_INCREMENT,
`exam_id` int not null,
`user_id` int not null,
`score` int not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into result (exam_id, user_id, score) value (1, 1, 100);

drop table user;
create table `user` (
`id` int not null AUTO_INCREMENT,
`name` varchar(16) not null,
`password` varchar(16) not null,
`profession` varchar(16) not null,
`info` varchar(50),
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into user (name, password, profession) value ("admin", 123456, "管理员");
insert into user (name, password, profession) value ("user", 123, "喵喵");
