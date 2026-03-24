package com.example.fornecedor.controllers;

import com.example.fornecedor.models.FornecedorModel;
import com.example.fornecedor.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
        FornecedorModel request = fornecedorService.criarFornecedor(fornecedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(fornecedorModel).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> request = fornecedorService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<FornecedorModel> buscarId(@PathVariable Long id){
        return fornecedorService.bucarId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        fornecedorService.deletar(id);
    }


}
