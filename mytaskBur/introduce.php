<?php 
session_start(); 
?>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="styles.css">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="Behav-2.js" type="text/javascript"></script>  
	</head>
	
	<body onload="submitEnable(); check();">	
		<?php
			function setSessionParams() {

				$l = $_POST["fencingLength"];
				$h = $_POST["fencingHeight"];
				$m = $_POST["material"];
				$i = empty($_POST["needInstall"]) ? false: true;
				//$i = $_POST["needInstall"];
				
				$materialName = array("", "Профнастил", "Модули", "Бетон", "Сетка");
				$materialSum = array(0, 400, 500, 700, 200);		

				$sq = $l*$h;
				$s = $sq*$materialSum[$m]+( $i ? $sq*200 : 0 );

				$_SESSION["fencingLength"] = $l; 
				$_SESSION["fencingHeight"] = $h; 
				$_SESSION["material"] = $materialName[$m]; 
				$_SESSION["needInstall"] = $i; 
				$_SESSION["sum"] = $s;
			}
			setSessionParams();
		?>		

		<form class="center" id="intro" action="popUp.php" method="post">
			<h1>Пожалуйста, преставьтесь</h1>

			<div class="center">
				<p>Ваше имя</p> 
				<div style="display: flex; width:60%; position:relative; left: 25%;">
					<input type="text" oninput="submitEnable (); check();" id="yourName" name="yourName" required style="width:80%"/> 
					<span id="yourNameOK" class="fa fa-chevron-down" 
						style="font-size:15px; color: #00ff00;  width:20%; align-self: center"/>
				</div>
			</div>
			
			<div class="center">
				<p>Электронная почта</p> 
				<div style="display: flex; width:60%; position:relative; left: 25%;">
					<input type="email" name="yourMail" id="yourMail" oninput="submitEnable (); check();" required style="width:80%"/>
					<span id="emailOK" class="fa fa-chevron-down" 
						style="font-size:15px; color: #00ff00;  width:20%; align-self: center"/>
				</div>
			</div>
			
			<div class="center">
				<p style="margin: 10px 0 0 0;">Телефон</p> 
				<p style="font-size: 12px; margin: 0 0 10px 0;">(в формате: Х-ХХХ-ХХХ-ХХ-ХХ)</p> 

				<div style="display: flex; width:60%; position:relative; left: 25%;">
					<input type="tel" oninput ="submitEnable (); check();" name="yourPhone" id="yourPhone" required
						style="width:80%" pattern="[0-9]{1}-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}"/> 
					<span id="telOK" class="fa fa-chevron-down" 
						style="font-size:15px; color: #00ff00;  width:20%; align-self: center"/>
				</div>
			</div>

			<br>
			<span id="nameForOrder"> </span>
			<span id ="orderDesc" style="width:80%; position:relative; left: 10%;">
				вы укомплектовали забор длиной <?php echo $_SESSION["fencingLength"]; ?> метров и 
				высотой <?php echo $_SESSION["fencingHeight"]; ?> метров
				из материала <?php echo $_SESSION['material']; ?> 
				на сумму <?php echo $_SESSION['sum']; ?> рублей
			</span>
			<br>
			
			<input type="submit" name="then" value="Отправить" class="then" style="margin:15px">
		</form>

		<script>

		function isSubmitEnable(){
			
			const n = document.getElementsByName("yourName")[0].value.trim();

			if (n.length>0) {
				return true;
			}
			return false;

		}

		function submitEnable (){
			bt = document.getElementsByName("then")[0]
			bt.disabled=true;	
			bt.style.background = "gray";		
			if (isSubmitEnable()) {
				bt.disabled=false;	
				bt.style.background = "#008CBA";			
			}				
		}

		function check(){
			const n = document.getElementsByName("yourName")[0].value.trim();
			const m = document.getElementsByName("yourMail")[0].value.trim();
			const ph = document.getElementsByName("yourPhone")[0].value.trim();
			

			document.getElementById("yourNameOK").style.display = "block";
			document.getElementById("orderDesc").style.display = "block";
			document.getElementById("nameForOrder").innerHTML=n;
			if (n.length==0) {
				document.getElementById("yourNameOK").style.display = "none";
				document.getElementById("orderDesc").style.display = "none";
			}

			document.getElementById("emailOK").style.display = "block";
			if (m.length==0) {
				document.getElementById("emailOK").style.display = "none";			
			}

			document.getElementById("telOK").style.display = "block";
			if (ph.length==0) {
				document.getElementById("telOK").style.display = "none";			
			}

		}
					
		</script>

	</body>
</html>
