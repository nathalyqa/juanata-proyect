package com.project.juanata.core.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.project.juanata.core.repository.ProductoRepository;
import com.project.juanata.core.repository.CategoriaRepository;
import com.project.juanata.core.repository.ItemRepository;
import com.project.juanata.core.repository.LineaRepository;
import com.project.juanata.core.repository.MaterialRepository;
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
import com.project.juanata.core.entity.Linea;
import com.project.juanata.core.entity.Material;
import com.project.juanata.core.entity.Producto;

@Controller
@RequestMapping("/usuario/admin")
public class AdminProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private LineaRepository lineaRepository;

    @Autowired
    private MaterialRepository materialRepository;

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

        mv.addObject("categorias", categoriaRepository.findAll());
        mv.addObject("items", itemRepository.findAll());
        mv.addObject("lineas", lineaRepository.findAll());
        mv.addObject("materiales", materialRepository.findAll());

        return mv;
    }

    @PostMapping("/producto/{id}/editar")
    public String actualizarProducto(@PathVariable("id") Integer id,
                                     @RequestParam("descripcion") String descripcion,
                                     @RequestParam("categoriaId") Integer categoriaId,
                                     @RequestParam("itemId") Integer itemId,
                                     @RequestParam("lineaId") Integer lineaId,
                                     @RequestParam("materialId") Integer materialId,
                                     @RequestParam("precio") BigDecimal precio,
                                     @RequestParam("rutaFoto") String rutaFoto,
                                     @RequestParam(value = "imagen", required = false) MultipartFile imagen) {

        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {

            // Campos simples
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);

            // Relaciones
            Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);
            Item item = itemRepository.findById(itemId).orElse(null);
            Linea linea = lineaRepository.findById(lineaId).orElse(null);
            Material material = materialRepository.findById(materialId).orElse(null);

            producto.setCategoria(categoria);
            producto.setItem(item);
            producto.setLinea(linea);
            producto.setMaterial(material);

            // Imagen
            if (imagen != null && !imagen.isEmpty()) {
                try {
                    String rutaWeb = guardarImagenPorCategoriaYItem(producto, imagen);
                    producto.setRutaFoto(rutaWeb);
                } catch (IOException e) {
                    System.out.println("Error guardando imagen de producto: " + e.getMessage());
                    producto.setRutaFoto(rutaFoto);
                }
            } else {
                producto.setRutaFoto(rutaFoto);
            }

            productoRepository.save(producto);
        }

        return "redirect:/usuario/admin/panel?exito";
    }

    private String guardarImagenPorCategoriaYItem(Producto producto, MultipartFile imagen) throws IOException {
        String nombreCategoria = producto.getCategoria() != null ? producto.getCategoria().getNombre().toLowerCase() : "otros";
        String nombreItem = producto.getItem() != null ? producto.getItem().getNombre().toLowerCase() : "otros";
        nombreCategoria = normalizarCategoria(nombreCategoria);

        Path projectRoot = Paths.get(System.getProperty("user.dir"));

        Path basePath = projectRoot.resolve(Paths.get(
                "src", "main", "resources", "static", "img",
                "categorias", nombreCategoria, nombreItem));
        Files.createDirectories(basePath);

        String nombreOriginal = imagen.getOriginalFilename();
        String nombreArchivo = "";
        if (nombreOriginal != null) {
            nombreArchivo = nombreOriginal;
        }

        Path destino = basePath.resolve(nombreArchivo);
        imagen.transferTo(destino.toFile());

        String rutaWeb = "/img/categorias/" + nombreCategoria + "/" + nombreItem + "/" + nombreArchivo;
        return rutaWeb;
    }

    private String normalizarCategoria(String nombreCategoria) {
        if ("mujer".equalsIgnoreCase(nombreCategoria)) {
            return "mujeres";
        } else if ("hombre".equalsIgnoreCase(nombreCategoria)) {
            return "hombres";
        } else {
            return nombreCategoria;
        }

    }

    @PostMapping("/producto/{id}/eliminar")
    public String eliminarProducto(@PathVariable("id") Integer id) {
        productoRepository.deleteById(id);
        return "redirect:/usuario/admin/panel?eliminado";
    }

    @GetMapping("/producto/nuevo")
    public ModelAndView mostrarFormularioNuevoProducto() {
        ModelAndView mv = new ModelAndView("admin-nuevo-producto");

        // Cargar listas desplegables
        mv.addObject("categorias", categoriaRepository.findAll());
        mv.addObject("items", itemRepository.findAll());
        mv.addObject("lineas", lineaRepository.findAll());
        mv.addObject("materiales", materialRepository.findAll());

        return mv;
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") BigDecimal precio,
            @RequestParam("categoriaId") Integer categoriaId,
            @RequestParam("itemId") Integer itemId,
            @RequestParam("lineaId") Integer lineaId,
            @RequestParam("materialId") Integer materialId,
            @RequestParam("imagen") MultipartFile imagen) throws IOException {

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);

        // Establecer relaciones
        Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);
        Item item = itemRepository.findById(itemId).orElse(null);
        Linea linea = lineaRepository.findById(lineaId).orElse(null);
        Material material = materialRepository.findById(materialId).orElse(null);

        producto.setCategoria(categoria);
        producto.setItem(item);
        producto.setLinea(linea);
        producto.setMaterial(material);

        // Guardar la imagen
        if (imagen != null && !imagen.isEmpty()) {
            String rutaWeb = guardarImagenPorCategoriaYItem(producto, imagen);
            producto.setRutaFoto(rutaWeb);
        }

        productoRepository.save(producto);

        return "redirect:/usuario/admin/panel?exito";
    }
}