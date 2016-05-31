<?php
if(isset($_GET['err'])){ $err=$_GET['err'];} else {$err=0;}
?>
<html>
<head>
	<title>Inregistrare utilizator</title>
	<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<table class="register">
<tr>
	<td>
		<br>
		<h2>Inregistrare utilizator nou </h2>
		<form action="registerdone.php" method="post">
		<center>
		<table bordesize="0">
		<tr>
			<td>Nume:</td><td> <input type="text" name="nume"> <?php if($err==2) { echo '<br>Nume ocupat!';} if($err==3) { echo '<br>Lipsa nume!';}  ?></td>
		</tr>
		<tr>
			<td>Parola:</td><td> <input type="password" name="pass1"> <?php if($err==4) { echo '<br>Lipsa parola!';} ?></td> 
		</tr>
		<tr>
			<td>Repeta parola:</td> <td><input type="password" name="pass2"> <?php if($err==1) { echo '<br>Parola nu coincide!';}  ?></td>
		</tr>
		</table>
		</center>
		<br>
		<center><input type=button onClick="location.href='index.php'" value='Inapoi'> &nbsp;&nbsp;&nbsp;
		<input type="submit" value="Inregistrare"></center>
		</form>
	</td>
</tr>
</table>
</body>
</html>