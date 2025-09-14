--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3 (Postgres.app)
-- Dumped by pg_dump version 16.3 (Postgres.app)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: project_documents; Type: TABLE; Schema: public; Owner: soumya.b
--

CREATE TABLE public.project_documents (
    document_id integer NOT NULL,
    project_id integer,
    user_id integer,
    file_name character varying(100),
    file_path character varying(255)
);


ALTER TABLE public.project_documents OWNER TO "soumya.b";

--
-- Name: project_documents_document_id_seq; Type: SEQUENCE; Schema: public; Owner: soumya.b
--

CREATE SEQUENCE public.project_documents_document_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.project_documents_document_id_seq OWNER TO "soumya.b";

--
-- Name: project_documents_document_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: soumya.b
--

ALTER SEQUENCE public.project_documents_document_id_seq OWNED BY public.project_documents.document_id;


--
-- Name: projects; Type: TABLE; Schema: public; Owner: soumya.b
--

CREATE TABLE public.projects (
    project_id integer NOT NULL,
    project_name character varying(100),
    builder_id integer,
    client_id integer,
    manager_id integer,
    budget numeric,
    actual_spend numeric,
    status character varying(50)
);


ALTER TABLE public.projects OWNER TO "soumya.b";

--
-- Name: projects_project_id_seq; Type: SEQUENCE; Schema: public; Owner: soumya.b
--

CREATE SEQUENCE public.projects_project_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.projects_project_id_seq OWNER TO "soumya.b";

--
-- Name: projects_project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: soumya.b
--

ALTER SEQUENCE public.projects_project_id_seq OWNED BY public.projects.project_id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: soumya.b
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(100),
    password character varying(100),
    role character varying(50)
);


ALTER TABLE public.users OWNER TO "soumya.b";

--
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: soumya.b
--

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_user_id_seq OWNER TO "soumya.b";

--
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: soumya.b
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


--
-- Name: project_documents document_id; Type: DEFAULT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.project_documents ALTER COLUMN document_id SET DEFAULT nextval('public.project_documents_document_id_seq'::regclass);


--
-- Name: projects project_id; Type: DEFAULT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.projects ALTER COLUMN project_id SET DEFAULT nextval('public.projects_project_id_seq'::regclass);


--
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- Name: project_documents project_documents_pkey; Type: CONSTRAINT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.project_documents
    ADD CONSTRAINT project_documents_pkey PRIMARY KEY (document_id);


--
-- Name: projects projects_pkey; Type: CONSTRAINT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_pkey PRIMARY KEY (project_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: project_documents project_documents_project_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.project_documents
    ADD CONSTRAINT project_documents_project_id_fkey FOREIGN KEY (project_id) REFERENCES public.projects(project_id);


--
-- Name: project_documents project_documents_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.project_documents
    ADD CONSTRAINT project_documents_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id);


--
-- Name: projects projects_builder_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: soumya.b
--

ALTER TABLE ONLY public.projects
    ADD CONSTRAINT projects_builder_id_fkey FOREIGN KEY (builder_id) REFERENCES public.users(user_id);


--
-- PostgreSQL database dump complete
--

