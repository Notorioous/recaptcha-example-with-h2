package am.itspace.recaptchaexamplewithh2.repository;

import am.itspace.recaptchaexamplewithh2.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
