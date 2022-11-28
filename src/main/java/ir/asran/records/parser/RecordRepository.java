package ir.asran.records.parser;

import ir.asran.records.model.IP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<IP,String> {
}
