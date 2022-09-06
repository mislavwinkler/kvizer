create table if not exists users (
    id identity,
    username varchar(100) not null unique,
    password varchar(1000) not null,
    email varchar(100)
);

create table if not exists quiz (
    id identity,
    code varchar(6) not null unique,
    name varchar(100) not null,
    maker_id bigint not null,
    creation_date date not null,
    constraint fk_maker foreign key (maker_id) references users(id) on delete cascade
    );

create table if not exists question (
    id identity,
    position bigint not null,
    question varchar(600) not null,
    answer varchar(100) not null,
    quiz_id bigint not null,
    constraint fk_quiz foreign key (quiz_id) references quiz(id) on delete cascade
    );

create table if not exists authority (
    id identity,
    authority_name varchar(100) not null unique
    );
create table if not exists user_authority (
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references users(id) on delete cascade,
    constraint fk_authority foreign key (authority_id) references authority(id) on delete cascade
    );


create table if not exists answer (
    id identity,
    answer varchar(100),
    question_id bigint not null,
    user_id bigint not null,
    constraint fk_question foreign key (question_id) references question(id) on delete cascade,
    constraint fk_answer_user foreign key (user_id) references users(id) on delete cascade
    );