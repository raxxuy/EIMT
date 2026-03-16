package mk.ukim.finki.emc.lab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.service.application.AccommodationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationApplicationService accommodationApplicationService;

    public AccommodationController(AccommodationApplicationService accommodationApplicationService) {
        this.accommodationApplicationService = accommodationApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DisplayAccommodationDto>> findAll() {
        return ResponseEntity.ok(accommodationApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> create(@RequestBody @Valid CreateAccommodationDto createAccommodationDto) {
        return ResponseEntity.ok(accommodationApplicationService.create(createAccommodationDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayAccommodationDto> update(
            @PathVariable Long id,
            @RequestBody CreateAccommodationDto createAccommodationDto
    ) {
        return ResponseEntity.ok(accommodationApplicationService.update(id, createAccommodationDto));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayAccommodationDto> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.deleteById(id));
    }

    @PatchMapping("/{id}/rent")
    public ResponseEntity<DisplayAccommodationDto> markAsRented(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.markAsRented(id));
    }
}
