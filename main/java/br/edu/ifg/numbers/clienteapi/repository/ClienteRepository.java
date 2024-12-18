package br.edu.ifg.numbers.clienteapi.repository;

import br.edu.ifg.numbers.clienteapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
