package mk.ukim.finki.emc.lab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.emc.lab.model.domain.AccommodationActivityLog;
import mk.ukim.finki.emc.lab.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lab.model.dto.DisplayReviewDto;
import mk.ukim.finki.emc.lab.model.dto.FilterAccommodationDto;
import mk.ukim.finki.emc.lab.model.projection.AccommodationDetailedProjection;
import mk.ukim.finki.emc.lab.model.projection.AccommodationSummaryProjection;
import mk.ukim.finki.emc.lab.model.view.AccommodationStatsView;
import mk.ukim.finki.emc.lab.model.view.AccommodationView;
import mk.ukim.finki.emc.lab.service.application.AccommodationApplicationService;
import org.springframework.data.domain.Page;
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

    @GetMapping("/{id}/with-host-and-country")
    public ResponseEntity<DisplayAccommodationDto> findWithHostAndCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.findWithHostAndCountryById(id));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<DisplayReviewDto>> findAllReviews(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationApplicationService.findAllReviews(id));
    }

    @GetMapping
    public ResponseEntity<List<DisplayAccommodationDto>> findAll() {
        return ResponseEntity.ok(accommodationApplicationService.findAll());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<DisplayAccommodationDto>> findAll(
            @ModelAttribute FilterAccommodationDto filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(accommodationApplicationService.findAll(filter, page, size, sortBy));
    }

    @GetMapping("/activity-logs")
    public ResponseEntity<Page<AccommodationActivityLog>> findAllActivityLogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy
    ) {
        return ResponseEntity.ok(accommodationApplicationService.findAllActivityLogs(page, size, sortBy));
    }

    @GetMapping("/summary")
    public ResponseEntity<List<AccommodationSummaryProjection>> findAllSummary() {
        return ResponseEntity.ok(accommodationApplicationService.findAllSummary());
    }

    @GetMapping("/detailed")
    public ResponseEntity<List<AccommodationDetailedProjection>> findAllDetailed() {
        return ResponseEntity.ok(accommodationApplicationService.findAllDetailed());
    }

    @GetMapping("/views")
    public ResponseEntity<List<AccommodationView>> findAllViews() {
        return ResponseEntity.ok(accommodationApplicationService.findAllViews());
    }

    @GetMapping("/stats")
    public ResponseEntity<List<AccommodationStatsView>> findAllStats() {
        return ResponseEntity.ok(accommodationApplicationService.findAllStats());
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
