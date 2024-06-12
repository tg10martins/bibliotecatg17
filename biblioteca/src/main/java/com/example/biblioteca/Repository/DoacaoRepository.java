package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
    List<Doacao> findByUsuarioId(Long usuarioId);
    List<Doacao> findByLivroId(Long livroId);
}
