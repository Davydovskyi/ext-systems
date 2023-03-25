DROP TABLE if EXISTS ro_birth_certificate;
DROP TABLE if EXISTS ro_marriage_certificate;
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
);

CREATE TABLE ro_birth_certificate
(
    birth_certificate_id SERIAL,
    number_certificate   varchar(20) not null,
    date_issue           date        not null,
    person_id            integer     not null,
    mother_id            integer,
    father_id            integer,
    PRIMARY KEY (birth_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_marriage_certificate
(
    marriage_certificate_id SERIAL,
    number_certificate      varchar(20) not null,
    date_issue              date        not null,
    active                  boolean DEFAULT false,
    end_date                date,
    wife_id                 integer     not null,
    husband_id              integer     not null,
    PRIMARY KEY (marriage_certificate_id),
    FOREIGN KEY (wife_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT,
    FOREIGN KEY (husband_id) REFERENCES ro_person (person_id) ON DELETE RESTRICT
)
