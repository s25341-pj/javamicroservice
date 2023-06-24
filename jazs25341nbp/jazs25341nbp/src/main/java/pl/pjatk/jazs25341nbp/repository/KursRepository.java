package pl.pjatk.jazs25341nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.pjatk.jazs25341nbp.model.Waluta;
import pl.pjatk.jazs25341nbp.model.Kurs;

import java.util.List;

@Repository
public interface KursRepository extends JpaRepository<Kurs, Long> {

    @Query("SELECT m FROM Kurs m WHERE m.kurs = :kurs")
    List<Kurs> findByName(@Param("kurs") String kurs);

    @Query("SELECT m FROM Kurs m WHERE m.waluta = :waluta")
    List<Kurs> findByWaluta(@Param("waluta") Waluta waluta);

}
