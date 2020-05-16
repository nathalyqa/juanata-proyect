/*Función para quitarle los colores a una imagen reemplazandolos por la escala de grises*/
function escalaGrisesImagen(x){
    x.style.filter = "grayscale(100%)";
}

/*Función para quitar escala de grises en una imagen*/
function sinEscalaGrisesImagen(x){
    x.style.filter = "grayscale(0%)";
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