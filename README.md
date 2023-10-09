1. start docker-db2: 
   - cd local-deployment
   - docker-compose up 
2. run mvn -Pnative package [mandrel version 22.0]
3. ./target/reproducer-resource-bundle-1.0-SNAPSHOT-runner

Expected Error: 

: org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection
at org.springframework.jdbc.datasource.DataSourceUtils.getConnection(DataSourceUtils.java:84)
at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:378)
at org.springframework.jdbc.core.JdbcTemplate.execute(JdbcTemplate.java:434)
at de.reproducer.ReproducerMain.run(ReproducerMain.java:22)
at de.reproducer.ReproducerMain_ClientProxy.run(Unknown Source)
at io.quarkus.runtime.ApplicationLifecycleManager.run(ApplicationLifecycleManager.java:132)
at io.quarkus.runtime.Quarkus.run(Quarkus.java:71)
at io.quarkus.runtime.Quarkus.run(Quarkus.java:44)
at de.reproducer.ReproducerMain.main(ReproducerMain.java:18)
Caused by: com.ibm.db2.jcc.am.SqlException: [jcc]Missing resource bundle: A resource bundle could not be found in the com.ibm.db2.jcc package for IBM Data Server Driver for JDBC and SQLJ ERRORCODE=-4472, SQLSTATE=null