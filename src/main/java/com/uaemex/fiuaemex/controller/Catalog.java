package com.uaemex.fiuaemex.controller;

import com.uaemex.fiuaemex.dto.ConsumeOrProduceLongDto;
import com.uaemex.fiuaemex.dto.ListaProductosDto;
import com.uaemex.fiuaemex.dto.ListadoPersonasDto;
import com.uaemex.fiuaemex.dto.ReporteTotalDto;
import com.uaemex.fiuaemex.entities.PersonaEntity;
import com.uaemex.fiuaemex.entities.ProductoEntity;
import com.uaemex.fiuaemex.entities.TiendaEntity;
import com.uaemex.fiuaemex.services.PersonaService;
import com.uaemex.fiuaemex.services.ProductoService;
import com.uaemex.fiuaemex.services.TiendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*") //puedes hacerle peticiones desde cualquier puerto o servidor 
@RestController
@RequestMapping("/catalog")
public class Catalog {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private TiendaService tiendaService;

    
    @GetMapping(value = "/persona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaEntity> getPersonaById(@RequestBody ConsumeOrProduceLongDto consumeLongDto) {
        PersonaEntity personaEntity = this.personaService.buscarPeronaPorId(consumeLongDto.getValue());
        return new ResponseEntity<>(personaEntity, HttpStatus.OK);

    }
    
    @GetMapping(value = "/listadoPersonas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListadoPersonasDto>> getListaPersonas() {
        List<ListadoPersonasDto> listaPersonasDto = this.personaService.getListaPersonas();
        return new ResponseEntity<>(listaPersonasDto, HttpStatus.OK);
    }
    
    @GetMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductoEntity> getProductoById(@RequestBody ConsumeOrProduceLongDto consumeLongDto) {
        ProductoEntity productoEntity = this.productoService.findProductById(consumeLongDto.getValue());
        return new ResponseEntity<>(productoEntity, HttpStatus.OK);
    }
    
    @GetMapping(value = "/listadoProductos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListaProductosDto>> getListaProductos() {
        List<ListaProductosDto> listaProductosDto = this.productoService.getListaProductos();
        return new ResponseEntity<>(listaProductosDto, HttpStatus.OK);
    }

    @GetMapping(value = "/reporteTotal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReporteTotalDto>> getReporteTotal() {
        List<ReporteTotalDto> reportesTotalDto = this.tiendaService.getReporteTotal();
        return new ResponseEntity<>(reportesTotalDto, HttpStatus.OK);

    }
    
   /* @GetMapping(value = "/listadoTienda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListaDeTiendasDto>> getListaTienda() {
        List<ListaTiendaDto> listaTiendaDto = this.tiendaService.getListaTienda();
        return new ResponseEntity<>(listaTiendaDto, HttpStatus.OK);*/
}
