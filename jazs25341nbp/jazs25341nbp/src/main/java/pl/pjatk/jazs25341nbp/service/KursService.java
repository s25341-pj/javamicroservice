package pl.pjatk.jazs25341nbp.service;

import org.springframework.stereotype.Service;
import pl.pjatk.jazs25341nbp.repository.KursRepository;
import pl.pjatk.jazs25341nbp.model.Kurs;

import java.util.List;
import java.util.Optional;

@Service
public class KursService {

    private final KursRepository kursRepository;

    public KursService(KursRepository kursRepository) {
        this.kursRepository = kursRepository;
    }

    public List<Kurs> getAllKurs() {
        return kursRepository.findAll();
    }

    public Optional<Kurs> findById(Long id) {
        return kursRepository.findById(id);
    }

    public Kurs addKurs(Kurs kurs) {
        return kursRepository.save(kurs);
    }

    public boolean deleteKurs(Long id) {
        Optional<Kurs> kurs = kursRepository.findById(id);
        if (kurs.isPresent()) {
            kursRepository.delete(kurs.get());
            return true;
        } else {
            return false;
        }
    }
}
