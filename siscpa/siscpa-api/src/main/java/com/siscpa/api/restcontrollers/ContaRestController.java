package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.ContaBackendConfiguration;
import fai.cpa.entities.UsuarioModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usuario.CreateUsuario;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
public class ContaRestController {

    private final ContaBackendConfiguration contaBackendConfiguration = new ContaBackendConfiguration();

    @PostMapping("/add")
    public int createUsuario(@RequestBody UsuarioModel usuario){
        return contaBackendConfiguration.createUsuario().createUsuario(usuario);
    }

    @GetMapping("/all")
    @CrossOrigin
    public List<UsuarioModel> getUsuarios(){
        List<UsuarioModel> usuarios = contaBackendConfiguration.findUsuario().find();
        return usuarios;
    }

    @GetMapping("/findById/{id}")
    @CrossOrigin
    public UsuarioModel findById(@PathVariable final int id){
        return contaBackendConfiguration.findUsuario().find(id);
    }

    @GetMapping("/findByTipoAndInstituicaoId/{tipo}/{id}")
    @CrossOrigin
    public List<UsuarioModel> findByTipo(@PathVariable final String tipo, @PathVariable int id){
        return contaBackendConfiguration.findUsuario().findByTipoAndInstituicaoId(tipo, id);
    }

    @GetMapping("findAllByInstituicaoId/{id}")
    @CrossOrigin
    public List<UsuarioModel> findAllByInstituicaoId(@PathVariable final int id){
        List<UsuarioModel> usuarios = contaBackendConfiguration.findUsuario().findAllByInstituicaoId(id);
        return usuarios;
    }


    @PostMapping("/login")
    public UsuarioModel login(@RequestParam String email,@RequestParam String senha){
        return contaBackendConfiguration.findUsuario().findByEmaileSenha(email, senha);
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        if (session != null) {
            session.invalidate(); // Invalida a sessão do usuário
            return ResponseEntity.ok("Logout realizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nenhuma sessão ativa para logout.");
        }
    }

    @PutMapping("/vincular-usuario")
    public Boolean vinularUsuario(@RequestBody UsuarioModel usuario){
        return contaBackendConfiguration.updateUsuario().updateById(usuario);
    }

    @PutMapping("/update/{id}")
    public boolean getUpdateUsuario(@PathVariable int id, @RequestBody UsuarioModel usuarioModel){
        boolean result = contaBackendConfiguration.updateUsuario().update(usuarioModel);
        return result;
    }
}
