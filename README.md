1. start docker-db2: 
   - cd local-deployment
   - docker-compose up 
2. run mvn -Pnative package [mandrel version 22.0]
3. execute ./target/reproducer-resource-bundle-1.0-SNAPSHOT-runner

At first, there will maybe be exceptions because of the missing db2 license (e.g. db2 errorcode -4472). 

Expected logs once the license problems have been solved: 

```
WARN: Datasource 'DB2DB': [jcc]Missing resource bundle: A resource bundle could not be found in the com.ibm.db2.jcc package for IBM Data Server Driver for JDBC and SQLJ ERRORCODE=-4201, SQLSTATE=2D521
```

```
WARN: ARJUNA016045: attempted rollback of < formatId=131077, gtrid_length=35, bqual_length=36, tx_uid=0:ffff7f000101:cbed:652644ec:16, node_name=quarkus, branch_uid=0:ffff7f000101:cbed:652644ec:18, subordinatenodename=null, eis_name=0 > (io.agroal.narayana.BaseXAResource@42665326) failed with exception code ARJUNA016099: Unknown error code:0
: javax.transaction.xa.XAException: Error trying to end xa transaction: [jcc]Missing resource bundle: A resource bundle could not be found in the com.ibm.db2.jcc package for IBM Data Server Driver for JDBC and SQLJ ERRORCODE=-4228, SQLSTATE=null
```