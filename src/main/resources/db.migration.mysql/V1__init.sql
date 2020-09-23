CREATE TABLE 'location' (
    'id' bigint(20) NOT NULL,
    'latitude' varchar(255) NOT NULL,
    'longitude' varchar(255) NOT NULL,
    'event_id' varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHAR SET=utf8;

ALTER TABLE 'location' ADD PRIMARY KEY('id');
ALTER TABLE 'location' MODIFY 'id' bigint(20) NOT NULL AUTO_INCREMENT;
ALTER TABLE 'location' ADD CONSTRAINT 'FK_LOCATION_EVENT' FOREIGN KEY ('event_id') REFERENCES 'event' ('id');

CREATE TABLE 'event' (
    'id' bigint(20) NOT NULL,
    'name' varchar(255) NOT NULL,
    'severity' varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHAR SET=utf8;

ALTER TABLE 'event' ADD PRIMARY KEY('id');
ALTER TABLE 'event' MODIFY 'id' bigint(20) NOT NULL AUTO_INCREMENT;

CREATE TABLE 'event_details' (
     'id' bigint(20) NOT NULL,
     'event_id' bigint(20) NOT NULL,
     'description' varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHAR SET=utf8;

ALTER TABLE 'event_details' ADD PRIMARY KEY('id');
ALTER TABLE 'event_details' MODIFY 'id' bigint(20) NOT NULL AUTO_INCREMENT;
ALTER TABLE 'event_details' ADD CONSTRAINT 'FK_EVENTDETAILS_EVENT' FOREIGN KEY ('event_id') REFERENCES 'event' ('id');