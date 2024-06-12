package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Doacao;
import com.exemplo.biblioteca.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoService {
    @Autowired
    private DoacaoRepository doacaoRepository;

    public Doacao salvarDoacao(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    public Doacao encontrarPorId(Long id) {
        return doacaoRepository.findById(id).orElse(null);
    }

    public List<Doacao> listarTodas() {
        return doacaoRepository.findAll();
    }

    public List<Doacao> encontrarPorUsuarioId(Long usuarioId) {
        return doacaoRepository.findByUsuarioId(usuarioId);
    }

    public List<Doacao> encontrarPorLivroId(Long livroId) {
        return doacaoRepository.findByLivroId(livroId);
    }

    public Doacao atualizarDoacao(Long id, Doacao doacaoAtualizada) {
        Doacao doacao = encontrarPorId(id);
        if (doacao != null) {
            doacao.setUsuario(doacaoAtualizada.getUsuario());
            doacao.setLivro(doacaoAtualizada.getLivro());
            return doacaoRepository.save(doacao);
        }
        return null;
    }
}
