
//Лайк
let like = document.querySelectorAll('.like');
for(let i = 0; i < like.length; i++){
    like[i].onclick=function() {
        like[i].classList.toggle('like-clicked');
    }
}


//Кнопка "Купить"
let buyBtn = document.querySelectorAll('.buy');
for(let i = 0; i < buyBtn.length; i++){
    buyBtn[i].onclick=function() {  
        buyBtn[i].classList.toggle('buy-clicked');
        if(buyBtn[i].textContent == 'Купить'){
            buyBtn[i].textContent = 'Продан';
        }else{
            buyBtn[i].textContent = 'Купить';
        }
    }
}

//Прокрутка
let header = document.getElementById('header');
let toTopBtn = document.querySelector('.cats__top-btn');
toTopBtn.onclick=function() {
    header.scrollIntoView({behavior: "smooth"});
}