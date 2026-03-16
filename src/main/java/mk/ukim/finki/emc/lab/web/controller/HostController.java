package mk.ukim.finki.emc.lab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.emc.lab.model.dto.CreateHostDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayHostDto;
import mk.ukim.finki.emc.lab.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {
    private final HostApplicationService hostApplicationService;

    public HostController(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return hostApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayHostDto>> findAll() {
        return ResponseEntity.ok(hostApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> create(@RequestBody @Valid CreateHostDto createHostDto) {
        return ResponseEntity.ok(hostApplicationService.create(createHostDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayHostDto> update(
            @PathVariable Long id,
            @RequestBody CreateHostDto createHostDto
    ) {
        return hostApplicationService
                .update(id, createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayHostDto> deleteById(@PathVariable Long id) {
        return hostApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
