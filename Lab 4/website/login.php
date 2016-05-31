<?php
require "/system/mysql.php";
ob_start();
session_start();
 
$username = $_POST['nume'];
$password = $_POST['parola'];
 
$conn = mysqli_connect($mysql_adr, $mysql_user, $mysql_pass);
mysqli_select_db($conn, $mysql_db);
 
$username = mysqli_real_escape_string($conn, $username);
$query = "SELECT id, nume, pass
        FROM user_info
        WHERE nume = '".$username."'";
 
$result = mysqli_query($conn, $query);
 
if(mysqli_num_rows($result) == 0) // User not found. So, redirect to login_form again.
{
    header('Location: login.html');
}
 
$userData = mysqli_fetch_array($result, MYSQL_ASSOC);
$hash = hash('sha256', $password);
 
if($hash != $userData['pass']) // Incorrect password. So, redirect to login_form again.
{
    header('Location: login.html');
}else{ // Redirect to home page after successful login.
	session_regenerate_id();
	$_SESSION['sess_user_id'] = $userData['id'];
	$_SESSION['sess_username'] = $userData['nume'];
	session_write_close();
	header('Location: index.php');
}
?>