package com.vaniadiasbronze.bronzeamento_app.controller;

import com.vaniadiasbronze.bronzeamento_app.model.Servico;
import com.vaniadiasbronze.bronzeamento_app.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Optional<Servico> servico = servicoService.findById(id);
        return servico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Servico createServico(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable Long id, @RequestBody Servico servicoDetails) {
        Optional<Servico> servico = servicoService.findById(id);
        if (servico.isPresent()) {
            Servico updatedServico = servico.get();
            updatedServico.setNome(servicoDetails.getNome());
            updatedServico.setDescricao(servicoDetails.getDescricao());
            updatedServico.setPreco(servicoDetails.getPreco());
            updatedServico.setDuracao(servicoDetails.getDuracao());
            return ResponseEntity.ok(servicoService.save(updatedServico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
