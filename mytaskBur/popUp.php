<?php session_start(); ?>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="styles.css">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="Behav.js" type="text/javascript"></script>  
	</head>
	
	<body>
		
		<?php 
		  $_SESSION["yourName"] = $_POST["yourName"]; 
		  $_SESSION["yourMail"] = $_POST["yourMail"]; 
		  $_SESSION["yourPhone"] = $_POST["yourPhone"]; 
		  $_SESSION["Order"] = 123;

			// use wordwrap() if lines are longer than 70 characters
			

			$to=$_SESSION["yourMail"];
			$subject = "Тестовое задание, заказ забора №".$_SESSION["Order"];
			$msg = "Тестовое задание";
			
			mail($to,$subject,$msg); 
		?>
		
		 
		<h1 style="visibility: hidden;"> Добро пожаловать!</h1>
			
			<form class="center" id="popUp" onload="">
				<div class="center">
					<h1>
						<strong style="color:#00ace6">
							<?php echo $_SESSION["yourName"]; ?>
						</strong>
						,заказ № 
						<strong style="color:#00ace6" id="Order">
							<?php echo $_SESSION['Order']; ?>
						</strong> 
						сформирован!
					</h1>
				</div>
				
				<div class="center">
					<p>Мы повторили его комплектацию на почту <br>
					<strong style="color:#00ace6"><?php echo $_SESSION["yourMail"]; ?>
					</strong></p>
				</div>
				
				<div class="center">
					<p>В ближайшее время наш специалист 
					свяжется с вами по телефону <br>
					<strong style="color:#00ace6"><?php echo $_SESSION["yourPhone"]; ?></strong></p>
				</div>
			</form>
			<script>
				
			</script>
			
	</body>
</html>
