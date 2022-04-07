<?php 
if($_SERVER['REQUEST_METHOD'] == 'POST'){
$complete_name = $_POST['complete_name'];
$username = $_POST['username'];
$password = $_POST['password'];
$mobile_number = $_POST['mobile_number'];
$user_type = $_POST['user_type'];

$password = password_hash($password, PASSWORD_DEFAULT);

require_once 'conn.php';
$sql = "INSERT INTO mobileusers(complete_name,  username, password, mobile_number, user_type) 
VALUES('$complete_name', '$username', '$password', '$mobile_number', '$user_type')";

if(mysqli_query($conn, $sql)){
    $result["success"] = "1";
    $result["message"] = "success";
    } else {

        $result["success"] = "0";
        $result["message"] = "error";
        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>