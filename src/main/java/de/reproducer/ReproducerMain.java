package de.reproducer;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.springframework.jdbc.core.JdbcTemplate;

@QuarkusMain
public final class ReproducerMain implements QuarkusApplication {
private final JdbcTemplate jdbcTemplate;

    public ReproducerMain(@DataSource("DB2DB") AgroalDataSource db2Datasource) {
        jdbcTemplate = new JdbcTemplate(db2Datasource);
    }
    public static void main(String[] args) {
        Quarkus.run(ReproducerMain.class);
    }
    @Override
    public int run(String... args) throws Exception {
        jdbcTemplate.execute("INSERT INTO SAMPLE_TABLE (ID, DUMMY_TEXT) VALUES (1, 'example') ;");
        jdbcTemplate.execute("INSERT INTO SAMPLE_TABLE (ID, DUMMY_TEXT) VALUES (1, 'example');");
        try {
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }
}
