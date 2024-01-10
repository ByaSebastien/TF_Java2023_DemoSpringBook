package be.bstorm.tf_java2023_demospringbook.api.controllers;

import be.bstorm.tf_java2023_demospringbook.api.models.dtos.ReviewDTO;
import be.bstorm.tf_java2023_demospringbook.api.models.forms.ReviewForm;
import be.bstorm.tf_java2023_demospringbook.bll.services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAll(){
        return ResponseEntity.ok(
                reviewService.getAll().stream()
                        .map( ReviewDTO::fromEntity )
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(
                ReviewDTO.fromEntity( reviewService.getById(id) )
        );
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> create(@RequestBody @Valid ReviewForm form){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ReviewDTO.fromEntity( reviewService.insert(form.toEntity()) )
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> update(@PathVariable Long id, @RequestBody @Valid ReviewForm form){
        return ResponseEntity.ok(
                ReviewDTO.fromEntity(reviewService.update(id, form.toEntity()) )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.ok().build();
    }
}
