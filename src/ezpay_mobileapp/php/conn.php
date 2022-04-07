<?php 
$server = "184.168.102.151";
$username = "ezpaydbadmin";
$password = "WvsuCictThesis2020";
$database = "ezpaydbadmin";
$conn = new mysqli($server, $username, $password,$database);
if($conn->connect_error){
    die("Connection failed: ". $conn->connect_error);
}

?>