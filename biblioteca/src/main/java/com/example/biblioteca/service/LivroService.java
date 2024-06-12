package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro encontrarPorId(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> encontrarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    public List<Livro> encontrarPorAutor(String autor) {
        return livroRepository.findByAutorContaining(autor);
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        Livro livro = encontrarPorId(id);
        if (livro != null) {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            return livroRepository.save(livro);
        }
        return null;
    }
}
