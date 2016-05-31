<?php
session_start(); 
if(!isset($_SESSION['sess_user_id']) || (trim($_SESSION['sess_user_id']) == '')) {
	header("location: login.html");
	exit();
}

function get_name()
{
	$name=$_SESSION['sess_username'];
    return $name;
}

function get_id()
{
	$mysql=conectare_mysql();
	$result = mysqli_query($mysql, 'SELECT * FROM user_info WHERE nume = "'.get_name().'"');
	$row =  mysqli_fetch_array($result);
	return $row['ID'];
	mysqli_close($mysql);
}

function conectare_mysql()
{
    require './system/mysql.php';
	$link = mysqli_connect($mysql_adr,$mysql_user,$mysql_pass,$mysql_db);
	return $link;
}

function deconectare_mysql($mysql)
{
	mysqli_close($mysql);
}

?>