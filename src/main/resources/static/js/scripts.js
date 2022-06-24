/*Función para quitarle los colores a una imagen reemplazandolos por la escala de grises*/
function escalaGrisesImagen(x){
    x.style.filter = "grayscale(100%)";
    x.style.webkitTransform = "scale(0.9)";
    x.style.transform = "scale(0.9)";
    x.style.transition = "all .5s ease-in-out";
}

/*Función para quitar escala de grises en una imagen*/
function sinEscalaGrisesImagen(x){
    x.style.filter = "grayscale(0%)";
    x.style.webkitTransform = "scale(1)";
    x.style.transform = "scale(1)";
    x.style.transition = "all .5s ease-in-out";
}

/*Funcion para poner borrosa una imagen cuando*/
function desenfocarImagen(x){
    x.style.webkitTransform = "scale(0.9)";
    x.style.transform = "scale(0.9)";
    x.style.transition = "all .5s ease-in-out";
    x.style.filter = "blur(5px)";
}

/*Funcion para poner nitida una imagen*/
function enfocarImagen(x){
	x.style.filter = "grayscale(0%)";
    x.style.webkitTransform = "scale(1)";
    x.style.transform = "scale(1)";
    x.style.transition = "all .5s ease-in-out";
}

function saturacion(x){
  x.style.filter = "saturate(150%)";
  x.style.webkitTransform = "scale(0.9)";
  x.style.transform = "scale(0.9)";
  x.style.transition = "all .5s ease-in-out";
}

/*Función para quitar escala de grises en una imagen*/
function sinSaturacion(x){
  x.style.filter = "saturate(100%)";
  x.style.webkitTransform = "scale(1)";
  x.style.transform = "scale(1)";
  x.style.transition = "all .5s ease-in-out";
}

/*Funcion para los submenus*/
$('.dropdown-menu a.dropdown-toggle').on('click', function(e) {
    if (!$(this).next().hasClass('show')) {
      $(this).parents('.dropdown-menu').first().find('.show').removeClass('show');
    }
    var $subMenu = $(this).next('.dropdown-menu');
    $subMenu.toggleClass('show');
  
  
    $(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function(e) {
      $('.dropdown-submenu .show').removeClass('show');
    });
  
  
    return false;
  });

  /*Extiende el tamaño de un elemento para mostrar más información*/
  function masInfoPijama(x){
    x.children[1].children[2].style.display = 'block';
  }

  /*Deja de forma original el tamaño y esconde información adicional de un elemento*/
  function menosInfoPijama(x){
    x.style.height = "auto";
    x.children[1].children[2].style.display = 'none';
  }

  function showElement(x){
    x.style.display = "block";
  }

  function hideElement(x){
    x.style.display = "none";
  }

  function cambiarColorTooltip(x){
    x.style.backgroundColor = "red";
  }