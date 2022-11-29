package ir.asran.records.parser;

import ir.asran.records.model.IP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



//for  sqlite extends JpaRepository !!
@Repository
public interface ParsedItemRepository extends CrudRepository<IP,String> {
}
