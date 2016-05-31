<?php
include 'functions/functions.php'; 
$action = $_GET['do'];
if($action==241625) // stergere
{
	$itm = $_GET['itm'];
	$mysql=conectare_mysql();
	$result = mysqli_query($mysql, 'SELECT * FROM carti WHERE id_carte = "'.$itm.'"');
	$row =  mysqli_fetch_array($result);
	$id = $row['user_id'];
	if($id==get_id())
	{
		$result = mysqli_query($mysql, 'DELETE FROM carti WHERE id_carte = "'.$itm.'"');
	}
	deconectare_mysql($mysql);
}
if($action==398854)  //adaugare
{
	$denumire=$_GET['denumire'];
	$autor=$_GET['autor'];
	$nota=$_GET['nota'];
	
	$mysql=conectare_mysql();
	$result = mysqli_query($mysql, 'INSERT INTO carti (user_id,denumire,autor,nota) VALUES ("'.get_id().'","'.$denumire.'","'.$autor.'","'.$nota.'")');
	deconectare_mysql($mysql);
}
header('Location: index.php');
?>