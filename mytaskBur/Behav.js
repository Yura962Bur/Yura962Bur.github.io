
	count=0;
	
	//Генерация номера заказа
	function getRnd(min,max){
		var number = document.getElementById("Order").innerHTML = Math.floor(Math.random()*(max-min+1)+min);
		return number;
	}
	
	//Перевод значения дропдауна из текстого в численный тип
	function getMaterialCost(material){
		debugger;
		switch(material){
			case "Профнастил 400₽ за м2": material=400;
			break;
			case "Модули 500₽ за м2": material=500;
			break;
			case "Бетон 700₽ за м2": material=700;
			break;
			case "Сетку 200₽ за м2": material=200;
			break;
		}
		debugger;
		return material;
	}
	
	function editing(){
		count++;
		if(count%2==0) return 0;
		else return 200;
	}
	
	//Подсчет итоговой суммы заказа
	function getSum(width, height, materialCost){
		debugger;
		var amount = (width+height)*materialCost;
		debugger;
		document.getElementById("sum").innerHTML = amount;
	}