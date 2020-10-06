CREATE TABLE `event` (
    `id` bigint(20) NOT NULL,
    `name` varchar(255) NOT NULL,
    `severity` varchar(200) NOT NULL,
    `description` varchar(255) DEFAULT NULL,
    `latitude` DECIMAL(8,6) NOT NULL,
    `longitude` DECIMAL(9,6) NOT NULL,
    `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHAR SET=utf8;

ALTER TABLE `event` ADD PRIMARY KEY(`id`);
ALTER TABLE `event` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;