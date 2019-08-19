<?php
session_start();
// the message
$msg = "Hello world! It's my first sending to mail via php!";

// use wordwrap() if lines are longer than 70 characters
$msg = wordwrap($msg,70);

$to="humorman962@gmail.com";

// send email
 mail($to,"Заказ сформирован",$msg);
?>

<!DOCTYPE html>
<html>
	<head>
		<body> The message is send.</body>
	</head>
</html>