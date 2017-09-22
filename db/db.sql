create database dbattest_nm;
use dbattest_nm;

DROP TABLE IF EXISTS attest;
CREATE TABLE attest
(
	id_attest INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	adress_cit VARCHAR(100) NULL,
	comm_mar VARCHAR(60) NULL,
	comm_naiss_cit VARCHAR(60) NULL,
	lieu_naiss_cit VARCHAR(60) NULL,
	commune VARCHAR(60) NULL,
	wil_naiss_cit VARCHAR(60) NULL,
	wilaya VARCHAR(60) NULL,
	daira VARCHAR(60) NULL,
	date_attest DATE NULL,
	date_conj1 DATE NULL,
	date_conj2 DATE NULL,
	date_conj3 DATE NULL,
	date_conj4 DATE NULL,
	date_deces_conj DATE NULL,
	date_mar DATE NULL,
	date_naiss_cit DATE NULL,
	datedeliv_cni_tem1 DATE NULL,
	datedeliv_cni_tem2 DATE NULL,
	fullname_conj1 VARCHAR(80) NULL,
	fullname_conj2 VARCHAR(80) NULL,
	fullname_conj3 VARCHAR(80) NULL,
	fullname_conj4 VARCHAR(80) NULL,
	fullname_dame VARCHAR(80) NULL,
	fullname_tem1 VARCHAR(80) NULL,
	fullname_tem2 VARCHAR(80) NULL,	
	nom_cit VARCHAR(40) NOT NULL,
	nomFR_cit VARCHAR(40) NOT NULL,
	num_cni_tem1 LONG UNSIGNED,
	num_cni_tem2 LONG UNSIGNED,	
	num_mar INT UNSIGNED,	
	prenom_cit VARCHAR(40) NOT NULL,
	prenomFR_cit VARCHAR(40) NOT NULL,
	UNIQUE KEY(nomFR_cit, prenomFR_cit, date_naiss_cit, comm_naiss_cit)

);