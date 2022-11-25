-- Database: CHAT_WEB

-- DROP DATABASE IF EXISTS "CHAT_WEB";

CREATE DATABASE "CHAT_WEB"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GRANT ALL ON DATABASE "CHAT_WEB" TO postgres;

GRANT TEMPORARY, CONNECT ON DATABASE "CHAT_WEB" TO PUBLIC;

CREATE SCHEMA IF NOT EXISTS chat_db
    AUTHORIZATION postgres;

COMMENT ON SCHEMA chat_db
    IS 'Banco de dados do Chat';