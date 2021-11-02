create table TASKS (
                       ID uuid DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
                       DESCRIPTION text,
                       POSITION int not null,
                       STATUS text not null,
                       TITLE text not null,
                       primary key (ID)
);

insert into TASKS (ID, DESCRIPTION, POSITION, STATUS, TITLE) values ('8e65a586-a6a0-43a3-b3b9-c6f3249c08eb', 'GitHub is complaining about passwords being used to push/pull code changes. Generate the necessary Personal Access Tokens and store them in the relevant credentials file.', 0, 'TODO', 'GitHub Personal Access Tokens');
insert into TASKS (ID, DESCRIPTION, POSITION, STATUS, TITLE) values ('8e64a586-a6a0-43a3-b3b9-c6f3259c08eb', 'Write a Python script which when run will clear out the NPM caches in Nexus Repo. This will probably need Selenium to mock pressing the cache clear buttons.', 1, 'TODO', 'Automate cache clearing in Nexus Repo');
insert into TASKS (ID, DESCRIPTION, POSITION, STATUS, TITLE) values ('8e65a586-a6a0-43a3-b3b8-c6f3229c08eb', 'Create a high-level document in Confluence which explains the process involved with migrating our microservices from Spring Boot to Spring Boot 2.', 0, 'IN_PROGRESS', 'Documentation: Spring Boot 2');
insert into TASKS (ID, DESCRIPTION, POSITION, STATUS, TITLE) values ('8e65a586-a6a0-43a3-b3b8-c6f3279c08eb', 'Ping Arthur Badge about getting root access on the non-prod MongoDB server (MDB-NP765-784)', 0, 'DONE', 'MongoDB root access');
insert into TASKS (ID, DESCRIPTION, POSITION, STATUS, TITLE) values ('8e65a586-a6a0-43a3-b3b8-c6f3169c08eb', 'Perform Docker prune on local machine to free up disk space (images and containers)', 1, 'DONE', 'Docker prune');