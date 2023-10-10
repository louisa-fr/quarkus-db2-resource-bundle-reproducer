package de.reproducer;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.sql;
import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.timer;

@ApplicationScoped
public class ReproducerRoute extends RouteBuilder {
    @DataSource("DB2DB") AgroalDataSource db2DataSource;

    @Override
    public void configure() {
        onException(Throwable.class)
            .process(exchange -> exchange.setRollbackOnly(true));
        
        from(timer("timer"))
            .transacted()
            .log("start")
            .to(sql("SELECt * FROM SAMPLE_TABLE").dataSource(db2DataSource))
            .to(sql("INSERT INTO SAMPLE_TABLE (ID, DUMMY_TEXT) VALUES (1, 'example');").dataSource(db2DataSource))
            .to(sql("INSERT INTO SAMPLE_TABLE (ID, DUMMY_TEXT) VALUES (1, 'example');").dataSource(db2DataSource))
        ;
    }
}
