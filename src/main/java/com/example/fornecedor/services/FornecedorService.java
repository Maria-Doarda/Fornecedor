package com.example.fornecedor.services;

import com.example.fornecedor.models.FornecedorModel;
import com.example.fornecedor.repositories.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);
    }

    public List<FornecedorModel> findAll(){
        return fornecedorRepository.findAll();
    }

    public Optional<FornecedorModel> bucarId(Long id){
        return fornecedorRepository.findById(id);
    }

    public void deletar(Long id){
        fornecedorRepository.deleteById(id);
    }
}
