DROP TABLE IF EXISTS `StudentAttendances`;

CREATE TABLE `StudentAttendances` (
	id INT AUTO_INCREMENT PRIMARY KEY,
	studentId INT NOT NULL,
	subject VARCHAR(50) NOT NULL,
	attendance TINYINT DEFAULT 0
);