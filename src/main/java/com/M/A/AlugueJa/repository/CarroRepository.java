package com.M.A.AlugueJa.repository;

import com.M.A.AlugueJa.model.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface CarroRepository extends JpaRepository<ModeloCarro, Long> {

}
