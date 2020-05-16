/*Función para quitarle los colores a una imagen reemplazandolos por la escala de grises*/
function escalaGrisesImagen(x){
    x.style.filter = "grayscale(100%)";
}

/*Función para quitar escala de grises en una imagen*/
function sinEscalaGrisesImagen(x){
    x.style.filter = "grayscale(0%)";
}