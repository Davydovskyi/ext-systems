DROP TABLE if EXISTS ro_passport;
DROP TABLE if EXISTS ro_person;

CREATE TABLE ro_person
(
    person_id     SERIAL,
    sex           smallint     not null,
    first_name    varchar(100) not null,
    last_name     varchar(100) not null,
    patronymic    varchar(100),
    date_of_birth date         not null,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport
(
    passport_id      SERIAL,
    person_id        integer     not null,
    series           varchar(10) not null,
    number           varchar(10) not null,
    date_issue       date        not null,
    issue_department varchar(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
)

