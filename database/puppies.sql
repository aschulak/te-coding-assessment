create table puppies (
	id serial PRIMARY KEY,
	name VARCHAR(50),
	weight INT,
	gender VARCHAR(50),
	paper_trained BOOLEAN
);
insert into puppies (id, name, weight, gender, paper_trained) values (1, 'Garçon', 8, 'Female', false);
insert into puppies (id, name, weight, gender, paper_trained) values (2, 'Annotés', 15, 'Male', true);
insert into puppies (id, name, weight, gender, paper_trained) values (3, 'Åke', 10, 'Male', true);
insert into puppies (id, name, weight, gender, paper_trained) values (4, 'Börje', 9, 'Female', true);
insert into puppies (id, name, weight, gender, paper_trained) values (5, 'Håkan', 14, 'Male', false);
ALTER SEQUENCE puppies_id_seq RESTART WITH 6;