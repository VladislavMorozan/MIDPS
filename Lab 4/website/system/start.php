<?php
require "mysql.php";

$dbhost = $mysql_adr;
$dbuser = $mysql_user;
$dbpass = $mysql_pass;
$conn = mysqli_connect($dbhost, $dbuser, $dbpass);
if(! $conn )
{
  die('Nu se poate conecta: ' . mysqli_error($conn).'<br>');
}
echo 'Concectat cu succes!<br>';
$sql = 'CREATE Database '.$mysql_db;
$retval = mysqli_query( $conn , $sql );
if(! $retval )
{
  die('Nu sa putut crea baza de date: ' . mysqli_error($conn).'<br>');
}
echo "Baza de date a fost creata cu succes<br>";
// baza de date este creata -----> tabelele

$sql = 'CREATE TABLE user_info( '.
       'ID INT(11) NOT NULL AUTO_INCREMENT UNIQUE, '.
       'nume VARCHAR(20) NOT NULL, '.
       'pass  text NOT NULL)';

mysqli_select_db($conn, $mysql_db);
$retval = mysqli_query($conn , $sql);
if(! $retval )
{
  die('Nu sa putut cera tabelul info: ' . mysqli_error($conn).'<br>');
}
echo "Tabelul note a fost creat cu succes<br>";

$sql = 'CREATE TABLE carti( '.
       'user_id INT(11) NOT NULL, '.
	   'id_carte INT(11) NOT NULL AUTO_INCREMENT UNIQUE, '.
	   'denumire VARCHAR(50) NOT NULL, '.
	   'autor VARCHAR(50) NOT NULL, '.
       'nota  TEXT NOT NULL)';

mysqli_select_db($conn, $mysql_db);
$retval = mysqli_query( $conn , $sql );
if(! $retval )
{
  die('Nu sa putut crea tabelul carti: ' . mysqli_error($conn).'<br>');
}
echo "Tabelul carti a fost creat cu succes<br>";

mysqli_close($conn);
?>