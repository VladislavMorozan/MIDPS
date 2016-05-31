<?php
$nume=$_POST['nume'];
$pass1=$_POST['pass1'];
$pass2=$_POST['pass2'];
if ($nume == "")
{
echo '<meta http-equiv="Refresh" content="0;URL=register.php?err=3">';
}
else
{
	if ($pass1 == "")
	{
	echo '<meta http-equiv="Refresh" content="0;URL=register.php?err=4">';
	}
	else
	{
		if ($pass1 != $pass2)
		{
			echo '<meta http-equiv="Refresh" content="0;URL=register.php?err=1">';
		}
		else
		{
			$parola= hash('sha256', $pass1);
			//$parola=md5($pass1);
			require 'system/mysql.php';
			$mysql = mysqli_connect($mysql_adr,$mysql_user,$mysql_pass,$mysql_db);

			$result = mysqli_query($mysql, 'SELECT * FROM user_info WHERE nume = "'.$nume.'"');
			$row =  mysqli_fetch_array($result);

			if ($row)
			{
				echo '<meta http-equiv="Refresh" content="0;URL=register.php?err=2">';
			}
			else
			{
				$result = mysqli_query($mysql, 'INSERT INTO user_info (nume,pass) VALUES ("'.$nume.'","'.$parola.'")');

				$result = mysqli_query($mysql, 'SELECT * FROM user_info WHERE nume = "'.$nume.'"');
				$row =  mysqli_fetch_array($result);
				$id = $row['ID'];

				echo '<meta http-equiv="Refresh" content="0;URL=index.php">';
			} 
		}
	}
}
?>