


	

		function isNumber(v) {
			if (isNaN(Number(v)) || v.trim().length==0) {
				return false;
			}
			else {
				return true;
			}
		}

		function getMetrDesc (v) {
			if (isNaN(Number(v))) {
				return "---";
			}
	
			if ((Number(v)>=10) && (Number(v)<=19)) {
				return "метров"
			}
	
			const mt  =  ["метров","метр", "метра", "метра", "метра", "метров", "метров", "метров","метров","метров"];
			var pos = Number(v).toString()[Number(v).toString().length-1];
			return mt[pos];
		}	
				
		function getMaterialName(material){
			debugger;
			switch(material){
				case "1": material="Профнастил 400₽ за м2";
				break;
				case "2": material="Модули 500₽ за м2";
				break;
				case "3": material="Бетон 700₽ за м2";
				break;
				case "4": material="Сетка 200₽ за м2";
				break;
			}
			debugger;
			return material;
	   }
		
		//Генерация номера заказа
		function getRnd(min,max){
			var number = document.getElementById("Order").innerHTML = Math.floor(Math.random()*(max-min+1)+min);
			return number;
		}		


