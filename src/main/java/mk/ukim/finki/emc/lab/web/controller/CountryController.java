package mk.ukim.finki.emc.lab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.emc.lab.model.dto.CreateCountryDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayCountryDto;
import mk.ukim.finki.emc.lab.service.application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(countryApplicationService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DisplayCountryDto>> findAll() {
        return ResponseEntity.ok(countryApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> create(@RequestBody @Valid CreateCountryDto createCountryDto) {
        return ResponseEntity.ok(countryApplicationService.create(createCountryDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayCountryDto> update(
            @PathVariable Long id,
            @RequestBody CreateCountryDto createCountryDto
    ) {
        return ResponseEntity.ok(countryApplicationService.update(id, createCountryDto));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayCountryDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(countryApplicationService.deleteById(id));
    }
}
