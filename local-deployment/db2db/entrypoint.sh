#!/bin/bash

CUSTOM_SETUP_DIR_PATH=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
export CUSTOM_SETUP_DIR_PATH

cp -r ${CUSTOM_SETUP_DIR_PATH?}/scripts /var/custom
chmod 555 /var/custom/*.sh

cd /var/db2_setup/lib
# execute original entrypoint
exec /var/db2_setup/lib/setup_db2_instance.sh
