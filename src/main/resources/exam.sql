create table `question` (
`id` int not null AUTO_INCREMENT,
`model_id` int not null,
`question_type` varchar(16) not null,
`title` varchar(50) not null,
`options` varchar(50) not null,
`answer` varchar(50) not null,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into question (model_id, question_type, title, options, answer) value ('1','choice','???','a:1 b:2 c:3','a');
insert into question (model_id, question_type, title, options, answer) value ('1','choice','这题选a','a:1 b:2 c:3','a');
insert into question (model_id, question_type, title, options, answer) value ('1','choice','这题选b','a:1 b:2 c:3','a');
insert into question (model_id, question_type, title, options, answer) value ('1','choice','这题选c','a:1 b:2 c:3','a');
insert into question (model_id, question_type, title, options, answer) value ('1','fill_blank','世界上最帅的人是谁','','未解之谜');
insert into question (model_id, question_type, title, options, answer) value ('1','fill_blank','试飞员飞行前能不能吃东西','','不能');
insert into question (model_id, question_type, title, options, answer) value ('1','judge','试飞员飞行前是否能吃东西','','否');
insert into question (model_id, question_type, title, options, answer) value ('1','subjective','请说明为什么试飞前不能吃东西','','暂无');
