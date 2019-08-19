<?php session_start(); ?>

<DOCTYPE html>
<html>
	<head></head>
	<body>
	
		<?php echo $_SESSION["YourName"] = $_POST["YourName"]; ?> <br>
		<?php echo $_SESSION["YourMail"] = $_POST["YourMail"]; ?> <br>
		<?php echo $_SESSION["YourPhone"] = $_POST["YourPhone"]; ?> <br>
		
		<?php echo "Session variables are set.<br><br>"; 
			echo "Your name is <br>" .$_SESSION["YourName"]."</p><br>";
			echo "Your mail is <br>" .$_SESSION["YourMail"]."</p><br>";
			echo "Your teleplone <br>" .$_SESSION["YourPhone"]."</p><br>";
		?>
	</body>
</html>