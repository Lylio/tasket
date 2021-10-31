create table TASKS (
                       ID uuid DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
                       DESCRIPTION text,
                       POSITION int not null,
                       STATUS text not null,
                       TITLE text not null,
                       primary key (ID)
);

insert into TASKS (ID, DESCRIPTION, POSITION, STATUS, TITLE) values ('8e65a586-a6a0-43a3-b3b9-c6f3269c08eb', 'H2 description', 0, 'TODO', 'H2 Task!');