
//Лайк
// let like=document.querySelector('.like');

// like.onclick=function() {
//     like.classList.toggle('like-clicked');
// }


// //Кнопка "Купить"
// let buyBtn=document.querySelector('.buy');

// buyBtn.onclick=function() {  
//     buyBtn.classList.toggle('buy-clicked');
//     if(buyBtn.textContent == 'Купить'){
//         buyBtn.textContent = 'Продан';
//     }else{
//         buyBtn.textContent = 'Купить';
//     }
// }

//Прокрутка
let header = document.getElementById('header');
let toTopBtn = document.querySelector('.cats__top-btn');
toTopBtn.onclick=function() {
    header.scrollIntoView({behavior: "smooth"});
}
