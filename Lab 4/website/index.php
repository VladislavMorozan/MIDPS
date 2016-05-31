<?php
include 'functions/functions.php'; 
$nume = get_name();
?>
<html>
<head>
<title>Biblioteca mea | <?php echo $nume; ?></title>
</head>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
	<!-- Add jQuery library -->
	<script type="text/javascript" src="../lib/jquery-1.10.1.min.js"></script>

	<!-- Add fancyBox main JS and CSS files -->
	<script type="text/javascript" src="../source/jquery.fancybox.js?v=2.1.5"></script>
	<link rel="stylesheet" type="text/css" href="../source/jquery.fancybox.css?v=2.1.5" media="screen" />

	<script type="text/javascript">
		$(document).ready(function() {
			/*
			 *  Simple image gallery. Uses default settings
			 */

			$('.fancybox').fancybox();

			/*
			 *  Different effects
			 */

			// Change title type, overlay closing speed
			$(".fancybox-effects-a").fancybox({
				helpers: {
					title : {
						type : 'outside'
					},
					overlay : {
						speedOut : 0
					}
				}
			});

			// Disable opening and closing animations, change title type
			$(".fancybox-effects-b").fancybox({
				openEffect  : 'none',
				closeEffect	: 'none',

				helpers : {
					title : {
						type : 'over'
					}
				}
			});

			// Set custom style, close if clicked, change title type and overlay color
			$(".fancybox-effects-c").fancybox({
				wrapCSS    : 'fancybox-custom',
				closeClick : true,

				openEffect : 'none',

				helpers : {
					title : {
						type : 'inside'
					},
					overlay : {
						css : {
							'background' : 'rgba(238,238,238,0.85)'
						}
					}
				}
			});

			// Remove padding, set opening and closing animations, close if clicked and disable overlay
			$(".fancybox-effects-d").fancybox({
				padding: 0,

				openEffect : 'elastic',
				openSpeed  : 150,

				closeEffect : 'elastic',
				closeSpeed  : 150,

				closeClick : true,

				helpers : {
					overlay : null
				}
			});

			/*
			 *  Button helper. Disable animations, hide close button, change title type and content
			 */

			$('.fancybox-buttons').fancybox({
				openEffect  : 'none',
				closeEffect : 'none',

				prevEffect : 'none',
				nextEffect : 'none',

				closeBtn  : false,

				helpers : {
					title : {
						type : 'inside'
					},
					buttons	: {}
				},

				afterLoad : function() {
					this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
				}
			});


			/*
			 *  Thumbnail helper. Disable animations, hide close button, arrows and slide to next gallery item if clicked
			 */

			$('.fancybox-thumbs').fancybox({
				prevEffect : 'none',
				nextEffect : 'none',

				closeBtn  : false,
				arrows    : false,
				nextClick : true,

				helpers : {
					thumbs : {
						width  : 50,
						height : 50
					}
				}
			});

			/*
			 *  Media helper. Group items, disable animations, hide arrows, enable media and button helpers.
			*/
			$('.fancybox-media')
				.attr('rel', 'media-gallery')
				.fancybox({
					openEffect : 'none',
					closeEffect : 'none',
					prevEffect : 'none',
					nextEffect : 'none',

					arrows : false,
					helpers : {
						media : {},
						buttons : {}
					}
				});

			/*
			 *  Open manually
			 */

			$("#fancybox-manual-a").click(function() {
				$.fancybox.open('1_b.jpg');
			});

			$("#fancybox-manual-b").click(function() {
				$.fancybox.open({
					href : 'iframe.html',
					type : 'iframe',
					padding : 5
				});
			});

			$("#fancybox-manual-c").click(function() {
				$.fancybox.open([
					{
						href : '1_b.jpg',
						title : 'My title'
					}, {
						href : '2_b.jpg',
						title : '2nd title'
					}, {
						href : '3_b.jpg'
					}
				], {
					helpers : {
						thumbs : {
							width: 75,
							height: 50
						}
					}
				});
			});


		});
	</script>
	<style type="text/css">
		.fancybox-custom .fancybox-skin {
			box-shadow: 0 0 50px #222;
		}

		body {
			max-width: 700px;
			margin: 0 auto;
		}
	</style>
</head>
<body>
<center>
<h2>Bine ai venit <u><?php echo $nume; ?></u> in biblioteca ta </h2><br>
<?php 
$mysql=conectare_mysql();
$result = mysqli_query($mysql, 'SELECT * FROM carti WHERE user_id = "'.get_id().'"');
$row =  mysqli_fetch_array($result);
$id = $row['id_carte'];

if(!$row)
{
	echo '<b>Lipsa carti!</b><br>';
}
else
{
	echo '
	<table class="book">
	<tr class="bookTitle">
		<td width=20><b>Nr.</b></td>
		<td width=200><b>Denumire</b></td>
		<td width=200><b>Autor</b></td>
		<td width=40><b>Nota</b></td>
		<td width=40><b>Stergere</b></td>
	</tr>';
	$i=0;
	$result1 = mysqli_query($mysql, 'SELECT * FROM carti WHERE user_id = "'.get_id().'"');
	while($row =  mysqli_fetch_array($result1))
	{
		$i++;
		echo '<tr class="bookCells">';
		echo "
		<td>".$i."</td>
		<td>".$row['denumire']."</td>
		<td>".$row['autor']."</td>";
		?>
		<td>
		<?php echo '<a class="fancybox" href="#note_info'.$i.'" title="Nota despre carte">Citeste</a>
		<div id="note_info'.$i.'" style="width:400px;display: none;">'; ?>
		<center><h3>Nota despre cartea <?php echo $row['denumire'];?> </h3></center>
		<hr>
		<p>
			<?php echo $row['nota']; ?>
		</p>
	</div>
		</td>
		<td><center>
		<input type="button" onClick="location.href='action.php?do=241625&itm=<?php echo $row["id_carte"]; ?>'" value="Sterge">
		</center></td>
	</tr>
	
<?php
	}
}
?>
</table>

<form method="get" action="action.php">
			<center><br>Adaugare carte:</center><br>
			<input type="hidden" name="do" value="398854" >
			<table class="book">
			<tr class="bookTitle">
				<td width=200><b>Denumire</b></td>
				<td width=200><b>Autor</b></td>
				<td width=50><b>Nota</b></td>
				<td width=50><b>Adaugare</b></td>
			</tr>
			<tr class="bookCells">
				<td width=150><input type="text" name="denumire"></td>
				<td width=150><input type="text" name="autor"></td>
				<td width=150><input type="text" name="nota"></td>
				<td width=50><input type="submit" value="Adaugare"></td>
			</tr>
			</table>
			</form>

<br><input type="button" onClick="location.href='destroy.php'" value="Iesire">	
</center>
</body>
</html>
<?php deconectare_mysql($mysql); ?>