package com.uaemex.fiuaemex.controller;

import com.uaemex.fiuaemex.controller.exeption.RequestException;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceLongDto;
import com.uaemex.fiuaemex.dto.ConsumeOrProduceMensaje;
import com.uaemex.fiuaemex.dto.InsertaPersonaDto;
import com.uaemex.fiuaemex.dto.InsertaProductoDto;
import com.uaemex.fiuaemex.entities.PersonaEntity;
import com.uaemex.fiuaemex.services.PersonaService;
import com.uaemex.fiuaemex.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")//es el acceso para consumir aplicaciones desde cualquier lado del cliente(angular,php,pyton,,cualquier servicio rest)
@RestController
public class MainController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProductoService productoService;

    @PostMapping(value = "/insertaPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumeOrProduceLongDto> insertPersona(@RequestBody InsertaPersonaDto insertaPersonaDto) {
        if (insertaPersonaDto.getId() != 0) {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No se puede mandar un Id que sea diferente de 0", HttpStatus.NOT_FOUND.value());
        } else {

            ConsumeOrProduceLongDto consumeOrProduceLongDto = this.personaService.insertarPersona(insertaPersonaDto);
            return new ResponseEntity<>(consumeOrProduceLongDto, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/actualizaPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumeOrProduceLongDto> modificaPersona(@RequestBody InsertaPersonaDto insertaPersonaDto) {
        if (this.personaService.existePersona(insertaPersonaDto.getId())) {
            ConsumeOrProduceLongDto consumeOrProduceLongDto = this.personaService.insertarPersona(insertaPersonaDto);
            return new ResponseEntity<>(consumeOrProduceLongDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "El id que se ingreso no existe", HttpStatus.NOT_FOUND.value());
        }

    }

    @DeleteMapping(value = "/eliminaPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumeOrProduceMensaje> deletePersona(@RequestBody ConsumeOrProduceLongDto consumeLongDto) { // al pricipio van lo que se produce y al final lo que se consume o manda el usuario      
        if (this.personaService.existePersona(consumeLongDto.getValue())) {
            ConsumeOrProduceMensaje consumeOrProduceMensaje = this.personaService.deletePersona(consumeLongDto);
            return new ResponseEntity<>(consumeOrProduceMensaje, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "el id de la persona que se ingreso no existe", HttpStatus.NOT_FOUND.value());
        }
    }

    //aqui aplica para producto
    @PostMapping(value = "/insertaProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumeOrProduceLongDto> insertProducto(@RequestBody InsertaProductoDto insertaProductoDto) {
        if (insertaProductoDto.getId() != 0) {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No se puede mandar un Id que sea diferente de 0", HttpStatus.NOT_FOUND.value());
        } else {
            if (insertaProductoDto.getCantidad() > 0) {
                ConsumeOrProduceLongDto consumeOrProduceLongDto = this.productoService.insertarProducto(insertaProductoDto);
                return new ResponseEntity<>(consumeOrProduceLongDto, HttpStatus.OK);
            } else {
                throw new RequestException(HttpStatus.NOT_FOUND.name(), "la cantidad de unidades del producto debe ser mayor a 0", HttpStatus.NOT_FOUND.value());
            }
        }

    }

    @PutMapping(value = "/actualizaProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumeOrProduceLongDto> modificaProducto(@RequestBody InsertaProductoDto insertaProductoDto) {
        if (this.productoService.existeProducto(insertaProductoDto.getId()) && insertaProductoDto.getCantidad()>0) {
            //(this.productoService.existeProducto(insertaProductoDto.getId()))
            //(this.productoService.existeProducto(InsertaProductoDto.getId()))

            ConsumeOrProduceLongDto consumeOrProduceLongDto = this.productoService.insertarProducto(insertaProductoDto);
            return new ResponseEntity<>(consumeOrProduceLongDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "El id que se ingreso no existe o la cantidad de unidades debe ser mayor a 0", HttpStatus.NOT_FOUND.value());
        }
    }
    
    @DeleteMapping(value = "/eliminaProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumeOrProduceMensaje> deleteProducto(@RequestBody ConsumeOrProduceLongDto consumeLongDto) { // al pricipio van lo que se produce y al final lo que se consume o manda el usuario      
        if (this.productoService.existeProducto(consumeLongDto.getValue())) {
            ConsumeOrProduceMensaje consumeOrProduceMensaje = this.productoService.deleteProducto(consumeLongDto);
            return new ResponseEntity<>(consumeOrProduceMensaje, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "el id del producto que se ingreso no existe", HttpStatus.NOT_FOUND.value());
        }
    }
}

//    @PostMapping(value= "/insertaProducto", produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ConsumeOrProduceLongDto>insertProducto(@RequestBody InsertaPersonaDto insertaPersonaDto){
//        ConsumeOrProduceLongDto consumeOrProduceLongDto = this.personaService.insertarPersona(insertaPersonaDto);
//        return new ResponseEntity<>(consumeOrProduceLongDto, HttpStatus.OK);
//    }
//    

