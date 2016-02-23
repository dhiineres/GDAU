--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2016-02-21 14:36:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 24579)
-- Name: sala; Type: SCHEMA; Schema: -; Owner: dhiineres
--

CREATE SCHEMA sala;


ALTER SCHEMA sala OWNER TO dhiineres;

--
-- TOC entry 185 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 185
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = sala, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 24658)
-- Name: atividades; Type: TABLE; Schema: sala; Owner: dhiineres; Tablespace: 
--

CREATE TABLE atividades (
    id integer NOT NULL,
    nome character varying(100),
    descricao character varying(5000),
    datalimite character varying(30),
    dificuldade integer,
    coddt bigint
);


ALTER TABLE atividades OWNER TO dhiineres;

--
-- TOC entry 183 (class 1259 OID 24656)
-- Name: atividades_id_seq; Type: SEQUENCE; Schema: sala; Owner: dhiineres
--

CREATE SEQUENCE atividades_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE atividades_id_seq OWNER TO dhiineres;

--
-- TOC entry 2065 (class 0 OID 0)
-- Dependencies: 183
-- Name: atividades_id_seq; Type: SEQUENCE OWNED BY; Schema: sala; Owner: dhiineres
--

ALTER SEQUENCE atividades_id_seq OWNED BY atividades.id;


--
-- TOC entry 176 (class 1259 OID 24590)
-- Name: disciplinas; Type: TABLE; Schema: sala; Owner: dhiineres; Tablespace: 
--

CREATE TABLE disciplinas (
    cod_disc integer NOT NULL,
    nome character varying(100)
);


ALTER TABLE disciplinas OWNER TO dhiineres;

--
-- TOC entry 175 (class 1259 OID 24588)
-- Name: disciplinas_cod_disc_seq; Type: SEQUENCE; Schema: sala; Owner: dhiineres
--

CREATE SEQUENCE disciplinas_cod_disc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE disciplinas_cod_disc_seq OWNER TO dhiineres;

--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 175
-- Name: disciplinas_cod_disc_seq; Type: SEQUENCE OWNED BY; Schema: sala; Owner: dhiineres
--

ALTER SEQUENCE disciplinas_cod_disc_seq OWNED BY disciplinas.cod_disc;


--
-- TOC entry 180 (class 1259 OID 24614)
-- Name: discprof; Type: TABLE; Schema: sala; Owner: dhiineres; Tablespace: 
--

CREATE TABLE discprof (
    codrelpd integer NOT NULL,
    codprof bigint,
    coddisc bigint
);


ALTER TABLE discprof OWNER TO dhiineres;

--
-- TOC entry 179 (class 1259 OID 24612)
-- Name: discprof_codrelpd_seq; Type: SEQUENCE; Schema: sala; Owner: dhiineres
--

CREATE SEQUENCE discprof_codrelpd_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE discprof_codrelpd_seq OWNER TO dhiineres;

--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 179
-- Name: discprof_codrelpd_seq; Type: SEQUENCE OWNED BY; Schema: sala; Owner: dhiineres
--

ALTER SEQUENCE discprof_codrelpd_seq OWNED BY discprof.codrelpd;


--
-- TOC entry 174 (class 1259 OID 24582)
-- Name: professores; Type: TABLE; Schema: sala; Owner: dhiineres; Tablespace: 
--

CREATE TABLE professores (
    id integer NOT NULL,
    nome character varying(100),
    senha character varying(20),
    adm boolean
);


ALTER TABLE professores OWNER TO dhiineres;

--
-- TOC entry 173 (class 1259 OID 24580)
-- Name: professores_id_seq; Type: SEQUENCE; Schema: sala; Owner: dhiineres
--

CREATE SEQUENCE professores_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE professores_id_seq OWNER TO dhiineres;

--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 173
-- Name: professores_id_seq; Type: SEQUENCE OWNED BY; Schema: sala; Owner: dhiineres
--

ALTER SEQUENCE professores_id_seq OWNED BY professores.id;


--
-- TOC entry 182 (class 1259 OID 24640)
-- Name: reldiscturma; Type: TABLE; Schema: sala; Owner: dhiineres; Tablespace: 
--

CREATE TABLE reldiscturma (
    coddt integer NOT NULL,
    codturma bigint,
    coddp bigint
);


ALTER TABLE reldiscturma OWNER TO dhiineres;

--
-- TOC entry 181 (class 1259 OID 24638)
-- Name: reldiscturma_coddt_seq; Type: SEQUENCE; Schema: sala; Owner: dhiineres
--

CREATE SEQUENCE reldiscturma_coddt_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE reldiscturma_coddt_seq OWNER TO dhiineres;

--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 181
-- Name: reldiscturma_coddt_seq; Type: SEQUENCE OWNED BY; Schema: sala; Owner: dhiineres
--

ALTER SEQUENCE reldiscturma_coddt_seq OWNED BY reldiscturma.coddt;


--
-- TOC entry 178 (class 1259 OID 24598)
-- Name: turmas; Type: TABLE; Schema: sala; Owner: dhiineres; Tablespace: 
--

CREATE TABLE turmas (
    cod_turma integer NOT NULL,
    nome character varying(100)
);


ALTER TABLE turmas OWNER TO dhiineres;

--
-- TOC entry 177 (class 1259 OID 24596)
-- Name: turmas_cod_turma_seq; Type: SEQUENCE; Schema: sala; Owner: dhiineres
--

CREATE SEQUENCE turmas_cod_turma_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE turmas_cod_turma_seq OWNER TO dhiineres;

--
-- TOC entry 2070 (class 0 OID 0)
-- Dependencies: 177
-- Name: turmas_cod_turma_seq; Type: SEQUENCE OWNED BY; Schema: sala; Owner: dhiineres
--

ALTER SEQUENCE turmas_cod_turma_seq OWNED BY turmas.cod_turma;


--
-- TOC entry 1918 (class 2604 OID 24661)
-- Name: id; Type: DEFAULT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY atividades ALTER COLUMN id SET DEFAULT nextval('atividades_id_seq'::regclass);


--
-- TOC entry 1914 (class 2604 OID 24593)
-- Name: cod_disc; Type: DEFAULT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY disciplinas ALTER COLUMN cod_disc SET DEFAULT nextval('disciplinas_cod_disc_seq'::regclass);


--
-- TOC entry 1916 (class 2604 OID 24617)
-- Name: codrelpd; Type: DEFAULT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY discprof ALTER COLUMN codrelpd SET DEFAULT nextval('discprof_codrelpd_seq'::regclass);


--
-- TOC entry 1913 (class 2604 OID 24585)
-- Name: id; Type: DEFAULT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY professores ALTER COLUMN id SET DEFAULT nextval('professores_id_seq'::regclass);


--
-- TOC entry 1917 (class 2604 OID 24643)
-- Name: coddt; Type: DEFAULT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY reldiscturma ALTER COLUMN coddt SET DEFAULT nextval('reldiscturma_coddt_seq'::regclass);


--
-- TOC entry 1915 (class 2604 OID 24601)
-- Name: cod_turma; Type: DEFAULT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY turmas ALTER COLUMN cod_turma SET DEFAULT nextval('turmas_cod_turma_seq'::regclass);


--
-- TOC entry 2056 (class 0 OID 24658)
-- Dependencies: 184
-- Data for Name: atividades; Type: TABLE DATA; Schema: sala; Owner: dhiineres
--

COPY atividades (id, nome, descricao, datalimite, dificuldade, coddt) FROM stdin;
\.


--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 183
-- Name: atividades_id_seq; Type: SEQUENCE SET; Schema: sala; Owner: dhiineres
--

SELECT pg_catalog.setval('atividades_id_seq', 1, false);


--
-- TOC entry 2048 (class 0 OID 24590)
-- Dependencies: 176
-- Data for Name: disciplinas; Type: TABLE DATA; Schema: sala; Owner: dhiineres
--

COPY disciplinas (cod_disc, nome) FROM stdin;
\.


--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 175
-- Name: disciplinas_cod_disc_seq; Type: SEQUENCE SET; Schema: sala; Owner: dhiineres
--

SELECT pg_catalog.setval('disciplinas_cod_disc_seq', 1, false);


--
-- TOC entry 2052 (class 0 OID 24614)
-- Dependencies: 180
-- Data for Name: discprof; Type: TABLE DATA; Schema: sala; Owner: dhiineres
--

COPY discprof (codrelpd, codprof, coddisc) FROM stdin;
\.


--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 179
-- Name: discprof_codrelpd_seq; Type: SEQUENCE SET; Schema: sala; Owner: dhiineres
--

SELECT pg_catalog.setval('discprof_codrelpd_seq', 1, false);


--
-- TOC entry 2046 (class 0 OID 24582)
-- Dependencies: 174
-- Data for Name: professores; Type: TABLE DATA; Schema: sala; Owner: dhiineres
--

COPY professores (id, nome, senha, adm) FROM stdin;
\.


--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 173
-- Name: professores_id_seq; Type: SEQUENCE SET; Schema: sala; Owner: dhiineres
--

SELECT pg_catalog.setval('professores_id_seq', 1, true);


--
-- TOC entry 2054 (class 0 OID 24640)
-- Dependencies: 182
-- Data for Name: reldiscturma; Type: TABLE DATA; Schema: sala; Owner: dhiineres
--

COPY reldiscturma (coddt, codturma, coddp) FROM stdin;
\.


--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 181
-- Name: reldiscturma_coddt_seq; Type: SEQUENCE SET; Schema: sala; Owner: dhiineres
--

SELECT pg_catalog.setval('reldiscturma_coddt_seq', 1, false);


--
-- TOC entry 2050 (class 0 OID 24598)
-- Dependencies: 178
-- Data for Name: turmas; Type: TABLE DATA; Schema: sala; Owner: dhiineres
--

COPY turmas (cod_turma, nome) FROM stdin;
\.


--
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 177
-- Name: turmas_cod_turma_seq; Type: SEQUENCE SET; Schema: sala; Owner: dhiineres
--

SELECT pg_catalog.setval('turmas_cod_turma_seq', 1, false);


--
-- TOC entry 1930 (class 2606 OID 24666)
-- Name: atividades_pkey; Type: CONSTRAINT; Schema: sala; Owner: dhiineres; Tablespace: 
--

ALTER TABLE ONLY atividades
    ADD CONSTRAINT atividades_pkey PRIMARY KEY (id);


--
-- TOC entry 1922 (class 2606 OID 24595)
-- Name: disciplinas_pkey; Type: CONSTRAINT; Schema: sala; Owner: dhiineres; Tablespace: 
--

ALTER TABLE ONLY disciplinas
    ADD CONSTRAINT disciplinas_pkey PRIMARY KEY (cod_disc);


--
-- TOC entry 1926 (class 2606 OID 24619)
-- Name: discprof_pkey; Type: CONSTRAINT; Schema: sala; Owner: dhiineres; Tablespace: 
--

ALTER TABLE ONLY discprof
    ADD CONSTRAINT discprof_pkey PRIMARY KEY (codrelpd);


--
-- TOC entry 1920 (class 2606 OID 24587)
-- Name: professores_pkey; Type: CONSTRAINT; Schema: sala; Owner: dhiineres; Tablespace: 
--

ALTER TABLE ONLY professores
    ADD CONSTRAINT professores_pkey PRIMARY KEY (id);


--
-- TOC entry 1928 (class 2606 OID 24645)
-- Name: reldiscturma_pkey; Type: CONSTRAINT; Schema: sala; Owner: dhiineres; Tablespace: 
--

ALTER TABLE ONLY reldiscturma
    ADD CONSTRAINT reldiscturma_pkey PRIMARY KEY (coddt);


--
-- TOC entry 1924 (class 2606 OID 24603)
-- Name: turmas_pkey; Type: CONSTRAINT; Schema: sala; Owner: dhiineres; Tablespace: 
--

ALTER TABLE ONLY turmas
    ADD CONSTRAINT turmas_pkey PRIMARY KEY (cod_turma);


--
-- TOC entry 1935 (class 2606 OID 24667)
-- Name: atividades_coddt_fkey; Type: FK CONSTRAINT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY atividades
    ADD CONSTRAINT atividades_coddt_fkey FOREIGN KEY (coddt) REFERENCES reldiscturma(coddt);


--
-- TOC entry 1932 (class 2606 OID 24625)
-- Name: discprof_coddisc_fkey; Type: FK CONSTRAINT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY discprof
    ADD CONSTRAINT discprof_coddisc_fkey FOREIGN KEY (coddisc) REFERENCES disciplinas(cod_disc);


--
-- TOC entry 1931 (class 2606 OID 24620)
-- Name: discprof_codprof_fkey; Type: FK CONSTRAINT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY discprof
    ADD CONSTRAINT discprof_codprof_fkey FOREIGN KEY (codprof) REFERENCES professores(id);


--
-- TOC entry 1934 (class 2606 OID 24651)
-- Name: reldiscturma_coddp_fkey; Type: FK CONSTRAINT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY reldiscturma
    ADD CONSTRAINT reldiscturma_coddp_fkey FOREIGN KEY (coddp) REFERENCES discprof(codrelpd);


--
-- TOC entry 1933 (class 2606 OID 24646)
-- Name: reldiscturma_codturma_fkey; Type: FK CONSTRAINT; Schema: sala; Owner: dhiineres
--

ALTER TABLE ONLY reldiscturma
    ADD CONSTRAINT reldiscturma_codturma_fkey FOREIGN KEY (codturma) REFERENCES turmas(cod_turma);


--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-02-21 14:36:25

--
-- PostgreSQL database dump complete
--

