package de.reproducer.config;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(targets = {
    com.ibm.db2.jcc.DB2BaseDataSource.class,
    com.ibm.db2.jcc.DB2ConnectionPoolDataSource.class,
    com.ibm.db2.jcc.DB2XADataSource.class})
@SuppressWarnings("unused")
public class ReflectionConfig {
}
