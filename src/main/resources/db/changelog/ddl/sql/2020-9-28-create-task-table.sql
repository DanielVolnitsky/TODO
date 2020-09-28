create extension if not exists "uuid-ossp";

create table task
(
    id          varchar(36) primary key default uuid_generate_v4(),
    description varchar
)