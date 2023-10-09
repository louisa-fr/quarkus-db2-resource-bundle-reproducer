#!/bin/bash

. "${SETUPDIR?}/include/db2_constants"

for script in `ls ${CUSTOM_SETUP_DIR_PATH?}/sql/*.sql`; do
  echo executing \"${script?}\"
  su - ${DB2INSTANCE?} -c "db2 connect to ${DBNAME?} && db2 -tvf ${script?}"
  echo done: \"${script?}\"
done

echo SQL SCRIPTS HAVE BEEN EXECUTED
