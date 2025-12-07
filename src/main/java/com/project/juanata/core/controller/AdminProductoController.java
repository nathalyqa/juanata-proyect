package com.project.juanata.core.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.project.juanata.core.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.juanata.core.configuration.Vistas;
import com.project.juanata.core.entity.Categoria;
import com.project.juanata.core.entity.Item;
import com.project.juanata.core.entity.Producto;
import com.project.juanata.core.util.Constantes;

@Controller
@RequestMapping("/usuario/admin")
public class AdminProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/panel")
    public ModelAndView mostrarPanelAdmin() {
        ModelAndView mv = new ModelAndView(Vistas.ADMIN_PANEL);
        List<Producto> productos = productoRepository.findAll();
        mv.addObject("productos", productos);
        return mv;
    }

    @GetMapping("/producto/{id}/editar")
    public ModelAndView mostrarFormularioEditarProducto(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView(Vistas.ADMIN_EDITAR_PRODUCTO);
        Producto producto = productoRepository.findById(id).orElse(null);
        mv.addObject("producto", producto);
        return mv;
    }

    @PostMapping("/producto/{id}/editar")
    public String actualizarProducto(@PathVariable("id") Integer id,
                                     @RequestParam("precio") BigDecimal precio,
                                     @RequestParam("rutaFoto") String rutaFoto,
                                     @RequestParam(value = "imagen", required = false) MultipartFile imagen) {

        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setPrecio(precio);

            // Si se sube una nueva imagen, la guardamos y actualizamos rutaFoto
            if (imagen != null && !imagen.isEmpty()) {
                try {
                    String rutaWeb = guardarImagenPorCategoriaYItem(producto, imagen);
                    producto.setRutaFoto(rutaWeb);
                } catch (IOException e) {
                    System.out.println("Error guardando imagen de producto: " + e.getMessage());
                    // Si falla, mantenemos la ruta anterior
                    producto.setRutaFoto(rutaFoto);
                }
            } else {
                // Si no se sube imagen, conservamos la ruta actual
                producto.setRutaFoto(rutaFoto);
            }

            productoRepository.save(producto);
        }

        return "redirect:/usuario/admin/panel?exito";
    }

    private String guardarImagenPorCategoriaYItem(Producto producto, MultipartFile imagen) throws IOException {
        // Obtener nombres de categoría e item desde la BD
        String nombreCategoria = producto.getCategoria() != null ? producto.getCategoria().getNombre().toLowerCase() : "otros";
        String nombreItem = producto.getItem() != null ? producto.getItem().getNombre().toLowerCase() : "otros";

        // Directorio raíz del proyecto (donde está el pom.xml)
        Path projectRoot = Paths.get(System.getProperty("user.dir"));

        // Ruta física base dentro del proyecto
        Path basePath = projectRoot.resolve(Paths.get(
                "src", "main", "resources", "static", "img",
                "categorias", nombreCategoria, nombreItem));
        Files.createDirectories(basePath);

        String nombreOriginal = imagen.getOriginalFilename();
        String extension = "";
        if (nombreOriginal != null && nombreOriginal.lastIndexOf('.') != -1) {
            extension = nombreOriginal.substring(nombreOriginal.lastIndexOf('.'));
        }
        if (extension.isEmpty()) {
            extension = ".jpg";
        }

        String nombreArchivo = "producto-" + producto.getId() + extension;
        Path destino = basePath.resolve(nombreArchivo);
        imagen.transferTo(destino.toFile());

        // Ruta web que se guarda en BD (coincide con static/img/...)
        String rutaWeb = "/img/categorias/" + nombreCategoria + "/" + nombreItem + "/" + nombreArchivo;
        return rutaWeb;
    }
}
