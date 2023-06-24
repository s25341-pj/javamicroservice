package pl.pjatk.jazs25341nbp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.jazs25341nbp.model.Waluta;
import pl.pjatk.jazs25341nbp.model.Kurs;
import pl.pjatk.jazs25341nbp.repository.KursRepository;
import pl.pjatk.jazs25341nbp.service.KursService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class KursController {

    private final List<Kurs> kursList;

    @Autowired
    private KursService kursService;

    @Autowired
    private KursRepository kursRepository;

    public KursController(){
        this.kursList = Arrays.asList(
                new Kurs(1L, "4.55", Waluta.EURO),
                new Kurs(1L, "1.00", Waluta.PLN),
                new Kurs(1L, "4.08", Waluta.USD)
        );
    }

    @GetMapping("/kurses")
    public ResponseEntity<List<Kurs>> getAllKurs() {
        List<Kurs> kursList = kursRepository.findAll();
        return ResponseEntity.ok(kursList);
    }

    @GetMapping("/kurses/{id}")
    @Operation(summary = "Get kurs by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get kurs", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Kurs.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Kurs not found", content = @Content)
    })
    public ResponseEntity<Kurs> getKursById(@PathVariable Long id) {
        Optional<Kurs> kurs = kursList.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
        if (kurs.isPresent()) {
            return ResponseEntity.ok(kurs.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/kurses/kurs/{kurs}")
    public ResponseEntity<List<Kurs>> getKursByKurs(@PathVariable String kurs) {
        List<Kurs> kursList = kursRepository.findByName(kurs);
        return ResponseEntity.ok(kursList);
    }

    @GetMapping("/kurses/waluta/{waluta}")
    public ResponseEntity<List<Kurs>> getKursByWaluta(@PathVariable Waluta waluta) {
        List<Kurs> kursList = kursRepository.findByWaluta(waluta);
        return ResponseEntity.ok(kursList);
    }
}
