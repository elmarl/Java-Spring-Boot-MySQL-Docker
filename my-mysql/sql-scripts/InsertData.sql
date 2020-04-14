--
-- Inserting data for table `users`
--
USE `spring_security_db`

INSERT INTO `users`
VALUES
('james','{bcrypt}$2y$12$3hSDrhZxHosN/9xXON.aROQ5Z2UfbG83GsCXMOXRGl5zUiIsw5pHC',1),
('mary','{bcrypt}$2y$12$3hSDrhZxHosN/9xXON.aROQ5Z2UfbG83GsCXMOXRGl5zUiIsw5pHC',1),
('susan','{bcrypt}$2y$12$3hSDrhZxHosN/9xXON.aROQ5Z2UfbG83GsCXMOXRGl5zUiIsw5pHC',1);

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('james','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');

--
-- Insert data into employee directory
--

USE `employee_directory`;

INSERT INTO `employee` VALUES
	(1,'Loge','Lando','loge@gmail.com'),
	(2,'Emma','Sanders','emma@gmail.com'),
	(3,'Brown','Adam','brown@gmail.com'),
	(4,'Adams','Legal','adams@gmail.com'),
	(5,'Peter','Lock','peter@gmail.com');
