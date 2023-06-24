package pl.pjatk.lightingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import pl.pjatk.lightingservice.model.Kurs;
import pl.pjatk.lightingservice.service.LightingService;


@RestController
@RequestMapping("/show")
public class LightingController {
    private final LightingService lightingservice;

    @Autowired
    public LightingController(LightingService lightingservice) {
        this.lightingservice = lightingservice;
    }

    @GetMapping("/kurses/{id}")
    public ResponseEntity<Kurs> getKurs(@PathVariable Long id) {
        try {
            Kurs kurs = lightingservice.getKurs(id);
            if (kurs != null) {
                return ResponseEntity.ok(kurs);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (HttpClientErrorException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (HttpClientErrorException.BadRequest ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (HttpServerErrorException.InternalServerError ex) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        } catch (ResourceAccessException ex) {
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
        }
    }

}
