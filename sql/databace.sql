CREATE ROLE sender_app WITH
	LOGIN
	NOSUPERUSER
	CREATEDB
	NOCREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'xxxxxx';


CREATE DATABASE sender
    WITH
    OWNER = sender_app
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


CREATE SCHEMA app
    AUTHORIZATION sender_app;


CREATE TABLE app.messages
(
    id bigserial,
    dt_create timestamp without time zone NOT NULL,
    recipient character varying NOT NULL,
    subject character varying NOT NULL,
    text character varying NOT NULL,
    CONSTRAINT messages_id_pk PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS app.messages
    OWNER to sender_app;

