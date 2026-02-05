package com.M.A.AlugueJa.controller;

import com.M.A.AlugueJa.model.ModeloCarro;
import com.M.A.AlugueJa.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")

public class CarroController {

    @Autowired
    CarroService service;

    @GetMapping
    public List<ModeloCarro> listar(){
            return service.listarTodos();
    }

    @PostMapping
    public ModeloCarro criar( @RequestBody ModeloCarro carro){
        return service.salvar(carro);
    }

    @GetMapping("/{id}")
    public ModeloCarro buscar(@PathVariable Long id){
        return service.buscarPorId(id);

    }
    @DeleteMapping("/{id}")
    public void excluir (@PathVariable Long id){
        service.deletar(id);
    }

    @PatchMapping("/{placa}")
    public void atualizar(@PathVariable String placa) { service.atualizar(placa); }
}

// Servico externo > Controller > Service > Repository
