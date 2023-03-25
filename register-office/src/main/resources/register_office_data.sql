INSERT INTO ro_person(sex, first_name, last_name, patronymic, date_of_birth)
VALUES (1, 'Елена', 'Васильева', 'Сергеевна', '1998-03-24'),
       (2, 'Олег', 'Васильев', 'Петрович', '1997-10-16'),
       (2, 'Николай', 'Васильев', 'Олегович', '2018-10-21');

INSERT INTO ro_passport(person_id, series, number, date_issue, issue_department)
VALUES (1, '4000', '123456', '2018-04-10', 'Department Passport');

INSERT INTO ro_birth_certificate(number_certificate, date_issue, person_id, mother_id, father_id)
VALUES ('123 Birth', '2018-1-01', 3, 1, 2)
