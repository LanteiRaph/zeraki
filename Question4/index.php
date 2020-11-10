<?php

//
//Set the database connetion 
$dbhost = "localhost";
$dbuser = "root";
$dbpass = "";
$db = "education";
$conn = new mysqli($dbhost, $dbuser, $dbpass, $db) or die("Connect failed: %s\n" . $conn->error);

//
//Declare the the sql to run aganist
$sql = "Select "
        . "institution.name as institution, "
        . "course.name as course, "
        . "count as number_of_student "
        . "from institution inner JOIN course "
        . "on institution.institutionid = course.institution  inner join "
        . "( SELECT COUNT(student.course) as count, course.courseid  "
        . "from student INNER join course on student.course = course.courseid GROUP BY course.name) "
        . "as stu on stu.courseid = course.courseid";
//Connection  succefull.
//$query the sql
$result = $conn->query($sql);
//
//Print oprnong tag for the 
echo "<table>";
//Print the table head
echo "<tr><td>Institution</td> <td>Course Name</td> <td>Number Of students</td> </tr>";
//Loop through the result to print a table
if ($result->num_rows > 0) {
  
  // output data of each row
  while($row = $result->fetch_assoc()) {
    //
    echo "<tr>";
    echo "<td>" . $row["institution"]. "</td>" . "<td>" . $row["course"]. "</td>" . " <td>" .$row["number_of_student"]. "</td>";
    echo "</td>";
  }
 
} else {
  echo "0 results";
}
echo "</table>";
 

