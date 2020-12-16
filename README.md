# ClassDojo

Setting up MySQL 
1. Create MySQL user with username-root and password-root
2. Create database named ClassDojo
3. Go to file server/sql/v1/schema/ClassDojo.sql
4. Run command: mysql -u username -p ClassDojo < ClassDojo.sql
  Required tables will be created.
  

Starting the Application

1. Go to server/build/libs
2. It will contain server.jar
3. Use the command: java -jar server.jar port_number
   Example- java -jar server.jar 8000
4. If you see message 'SERVER LAUNCHED AT PORT 8000', that means app is up and running.
5. The app has been internally configured to hit database at localhost with username root and password root.


APIs

1. Teacher sign up (POST)
   http://localhost:{{port}}/api/v1/teachers
   
     {
        "id": -1,
        "email":"",
        "password":"",
        "name":"",
        "age":20,
        "mobile":"9999966666"
      }
      
2. Add subject (POST)
  http://localhost:{{port}}/api/v1/teachers/subjects
  
  {
      "teacherId": 1,
      "name": "Chemistry"
  }
  
3. Get subjects for a teacher (GET)
  http://localhost:{{port}}/api/v1/teachers/{{teacherId}}/subjects
  
4. Delete subject (DELETE)
  http://localhost:{{port}}/api/v1/teachers/{{teacherId}}/subjects/{{subject}}
  
5. Update student attendance (PUT)
  http://localhost:{{port}}/api/v1/attendance/subjects/{{subject}}/students/{{studentId}}
  {
      "attendance": 11
  }
  
6. Teacher login (POST)
  http://localhost:{{port}}/api/v1/teachers/login
  
 email=aaa@gmail.com&password=doehnwohno     (form-url-encoded)
 
 
7. Student sign up (POST)
  http://localhost:{{port}}/api/v1/students
  
  {
      "id": -1,
      "email":"",
      "password":"",
      "name":"",
      "age":20,
      "mobile":"9999966666"
    }
    
8. Create Enrollment (POST)
  http://localhost:{{port}}/api/v1/students/enrollment
  
  {
    "subject":"Physics",
    "teacherId":2,
    "studentId":7
  }
  
9. View Attendance (GET)
  http://localhost:{{port}}/api/v1/students/{{studentId}}/attendance
  
10. Student login (POST)
  http://localhost:{{port}}/api/v1/students/login
  
 email=aaa@gmail.com&password=doehnwohno     (form-url-encoded)
