create database employees;
use employees;


CREATE TABLE `employees`.`employee_table` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `task1` INT NULL,
  `task2` INT NULL,
  `task3` INT NULL,
  `task4` INT NULL,
  `task5` INT NULL,
  `task6` INT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE INDEX `employee_id_UNIQUE` (`employee_id` ASC),
  UNIQUE INDEX `new_tablecol_UNIQUE` (`login` ASC));

set foreign_key_checks=0;

CREATE TABLE `employees`.`employee_tasks` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `task1` INT NULL,
  `task2` INT NULL,
  `task3` INT NULL,
  `task4` INT NULL,
  `task5` INT NULL,
  `task6` INT NULL,
  UNIQUE INDEX `employee_id_UNIQUE` (`employee_id` ASC),
  PRIMARY KEY (`employee_id`),
  CONSTRAINT `employee_id`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employees`.`employee_tasks` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


insert into employee_table values (1, "JKowalski", "jan123", "Jan", "Kowlski", 20, 20, 30, 10, 15, 30);