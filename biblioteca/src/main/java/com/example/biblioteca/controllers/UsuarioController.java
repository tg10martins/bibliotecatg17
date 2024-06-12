package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Usuario;
import com.exemplo.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.encontrarPorEmail(usuario.getEmail());
        if (usuarioExistente != null && usuarioExistente.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
