package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Doacao;
import com.exemplo.biblioteca.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {
    @Autowired
    private DoacaoService doacaoService;

    @PostMapping("/adicionar")
    public ResponseEntity<Doacao> adicionarDoacao(@RequestBody Doacao doacao) {
        Doacao novaDoacao = doacaoService.salvarDoacao(doacao);
        return ResponseEntity.ok(novaDoacao);
    }

    @GetMapping
    public ResponseEntity<List<Doacao>> listarDoacoes() {
        List<Doacao> doacoes = doacaoService.listarTodas();
        return ResponseEntity.ok(doacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doacao> buscarDoacaoPorId(@PathVariable Long id) {
        Doacao doacao = doacaoService.encontrarPorId(id);
        if (doacao != null) {
            return ResponseEntity.ok(doacao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doacao> atualizarDoacao(@PathVariable Long id, @RequestBody Doacao doacao) {
        Doacao doacaoAtualizada = doacaoService.atualizarDoacao(id, doacao);
        if (doacaoAtualizada != null) {
            return ResponseEntity.ok(doacaoAtualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
