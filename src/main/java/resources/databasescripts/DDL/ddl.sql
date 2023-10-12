create type course_level as enum ('beginner', 'middle', 'advanced');
create type gender as enum ('male', 'female');

Create Cast(Varchar AS course_level)with inout as implicit;
Create Cast(Varchar AS gender)with inout as implicit;

create table instructor
(
    id           uuid    not null
        primary key,
    first_name   varchar not null,
    last_name    varchar not null,
    email        varchar not null,
    phone_number varchar not null
);


create table course
(
    course_id         uuid not null
        primary key,
    course_name       varchar,
    course_start_date timestamp,
    course_end_date   timestamp,
    course_level      course_level,
    course_started    boolean,
    instructor_id     uuid
        references instructor
);


create table student
(
    student_id           uuid not null
        primary key,
    student_first_name   varchar,
    student_last_name    varchar,
    student_age          integer,
    student_gender       gender,
    student_email        varchar,
    student_phone_number varchar,
    student_nat_id       varchar
);


create table instructor_details
(
    details_id                 uuid not null
        primary key,
    instructor_hobbies         varchar(255),
    instructor_youtube_channel varchar(255),
    instructor_id              uuid
        constraint uk_l3mwbmkaw8nvu9os35mvkguon
            unique
        constraint fkpcc181ybroli58anvhyxcbfsl
            references instructor
);


create table student_course
(
    student_id uuid not null
        references student,
    course_id  uuid not null
        references course,
    primary key (student_id, course_id)
);





