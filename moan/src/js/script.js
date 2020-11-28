
//Swiper init
var mySwiper = new Swiper('.swiper-container', {
    speed: 400,
    spaceBetween: 10,
    loop: true,
    slidesPerView: 3,
    slidesPerGroup: 3,
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
      pagination: {
        el: '.swiper-pagination',
        type: 'bullets',
      },
    breakpoints: {
        320:{
            slidesPerView: 1,
            slidesPerGroup: 1,
            spaceBetween: 20
        },
        768:{
            slidesPerView: 3,
            slidesPerGroup: 3,
            spaceBetween: 20
        }
        

    }
});

//mobile menu
window.addEventListener('DOMContentLoaded', () => {
    const menu = document.querySelector('.menu'),
    menuItem = document.querySelectorAll('.menu__item'),
    hamburger = document.querySelector('.hamburger');

    hamburger.addEventListener('click', () => {
        hamburger.classList.toggle('hamburger_active');
        menu.classList.toggle('menu__active');
    });

    menuItem.forEach(item => {
        item.addEventListener('click', () => {
            hamburger.classList.toggle('hamburger__active');
            menu.classList.toggle('menu__active');
        });
    });
});

//Question
function read(id){
    var text = document.getElementById(id);

    if(text.style.display == "none"){
        text.style.display = "block";
    }else{
        text.style.display = "none";
    }
    
}