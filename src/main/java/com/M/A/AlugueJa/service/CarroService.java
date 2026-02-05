package com.M.A.AlugueJa.service;

import com.M.A.AlugueJa.model.ModeloCarro;
import com.M.A.AlugueJa.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service

public class CarroService {
    @Autowired
    private CarroRepository repository;

    public List<ModeloCarro> listarTodos() {
        return repository.findAll();
    }

    public ModeloCarro salvar(ModeloCarro carro) {
        // Verificar se ja tem carro com a mesma placa e retornar erro
        carro.setPlaca(carro.getPlaca().toUpperCase());
        System.out.println("commit 2");
        return repository.save(carro);

    }

    public ModeloCarro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com o ID: " + id));
    }


    public void deletar(Long id) {
        ModeloCarro carro = buscarPorId(id);
        repository.delete(carro);
    }

}

// PATCH ou PUT -> Quando voce quer atualizar ou remover parte do objeto
// DELETE -> voce quer deletar o objeto inteiro