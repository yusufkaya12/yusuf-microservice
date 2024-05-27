#!/bin/bash
set -e
set -u
function create_user_and_database() {
  echo "Trying to create user and database from triple.."
  local database=$(echo $1 | tr ':' ' ' | awk '{print $1}')
  local owner=$(echo $1 | tr ':' ' ' | awk '{print $2}')
  local pass=$(echo $1 | tr ':' ' ' | awk '{print $3}')
  echo "Creating user '$owner' and database '$database'.."
  psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER "$owner" WITH ENCRYPTED PASSWORD '$pass';
    CREATE DATABASE "$database";
    GRANT ALL PRIVILEGES ON DATABASE "$database" TO "$owner";
EOSQL
  echo "$database created successfully.."
  psql --username "$POSTGRES_USER" --dbname "$database" -c 'CREATE EXTENSION IF NOT EXISTS "uuid-ossp";'
}
if [ -n "$POSTGRES_MULTIPLE_DATABASES" ]; then
  echo "Multiple database creation requested.."
  for triple in $(echo $POSTGRES_MULTIPLE_DATABASES | tr '|' ' '); do
    create_user_and_database $triple
  done
  echo "Multiple databases created.."
fi