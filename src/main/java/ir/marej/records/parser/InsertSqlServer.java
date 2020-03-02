package ir.marej.records.parser;

import ir.marej.records.model.IPDR;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertSqlServer extends CrudRepository<IPDR,String> {
}
