create table if not exists SportsTeam(
    id int(10) unsigned not null auto_increment primary key,
    teamname varchar(60) not null,
    ownerfirstname varchar(30),
    ownerlastname varchar(30),
    createDate datetime default current_timestamp,
    lastUpdatedDate datetime default current_timestamp on update current_timestamp
);

