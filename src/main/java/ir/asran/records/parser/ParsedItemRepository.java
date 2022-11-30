package ir.asran.records.parser;

import ir.asran.records.model.IP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ParsedItemRepository extends JpaRepository<IP,String> {
}
