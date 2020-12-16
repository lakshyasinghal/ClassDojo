#!/bin/sh


createDB(){
	echo "Creating database ClassDojo"

	mysql -u root -proot -e "create database IF NOT EXISTS ClassDojo"; 
}

createTables(){
	echo "Creating Tables"

	cd ../schema
	pwd
	            
	mysql -u root -proot ClassDojo < Students.sql
	mysql -u root -proot ClassDojo < Teachers.sql
	mysql -u root -proot ClassDojo < StudentAttendances.sql
	mysql -u root -proot ClassDojo < Subjects.sql
	mysql -u root -proot ClassDojo < Enrollments.sql

	echo "\nCreated Tables\n"
}


createDB
createTables
# createDummyData

echo "\n\nYour DB setup is complete :)"