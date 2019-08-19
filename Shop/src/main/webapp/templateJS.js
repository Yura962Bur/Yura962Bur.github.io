/* 
попробуем вынести сюда меню
 */


function header(){
    var res;
    
    res="<div class='header'>";
        res=res + "<h1>Nail-Академии Бурановой Татьяны</h1>"; 
    res=res + "</div>";
    document.write(res);    
}

function menu(currentPage){
    var res;

    res="<div class='topnav'>";
        res=res + "<a href='index.html'"; 
            if(currentPage==='index') {res=res + "style='background-color: #555 '";}
            res=res + ">Главная</a>";
        res=res + "<a href='productList.jsp'";
            if(currentPage==='productList') {res=res + "style='background-color: #555 '";}
            res=res + ">Каталог товаров</a>";
        res=res + "<a href='basket.jsp'"; 
            if (currentPage === 'basket') {res=res + "style='background-color: #555 '";}
            res=res + ">Корзина</a>";
    res=res + "</div>";

    document.write(res);    
}


function footer(){
    var res;
    
    res="<div class='footer'>";
        res=res + "<h2>Найл академия Татьяны Бурановой: 8 937 645 87 76 (Viber, WhatsApp) в <a href='https://vk.com/id12585032' target='_blank'>'Контакте'</a></h2>"; 
    res=res + "</div>";
    document.write(res);    
}
