CREATE TABLE event (
    name varchar(255) NOT NULL,
    severity varchar(200) NOT NULL,
    description varchar(255) DEFAULT NULL,
    latitude NUMERIC(8,6) NOT NULL,
    longitude NUMERIC(9,6) NOT NULL,
    event_date timestamp NOT NULL,
    created_at timestamp NOT NULL
);

ALTER TABLE event ADD COLUMN id SERIAL PRIMARY KEY;

CREATE TABLE user (
    username varchar(50) NOT NULL,
    password varchar(255) NOT NULL
);

ALTER TABLE user ADD COLUMN id SERIAL PRIMARY KEY;