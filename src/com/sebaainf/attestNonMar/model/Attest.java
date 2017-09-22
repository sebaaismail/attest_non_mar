package com.sebaainf.attestNonMar.model;
import java.util.Collection;

import java.util.Date;
import java.util.Vector;

import com.jenkov.db.itf.mapping.AGetterMapping;
import com.jgoodies.common.bean.Bean;
import com.sebaainf.ismUtils.IsmPrintStream;
import com.sebaainf.attestNonMar.common.MyApp;

/**
* Created by ISMAIL on 19/03/2017.
* for butterfly mapping
* 1- we have follow the naming conditions of class and properties
* just match the table and their columns in data base
* 2- we have initialise all properties in class with defaults values
* 3- put GETTER anotations just before their getter methods
*/

public class Attest extends Bean{
	
	public static final String PROPERTY_ID_ATTEST = "id_attest";
	public static final String PROPERTY_TYPE_ATTEST = "type_attest";
	public static final String PROPERTY_WILAYA = "wilaya";
	public static final String PROPERTY_DAIRA = "daira";
	public static final String PROPERTY_COMMUNE = "commune";
	
	public static final String PROPERTY_NOM_CIT = "nom_cit";
	public static final String PROPERTY_PRENOM_CIT = "prenom_cit";
	public static final String PROPERTY_NOMFR_CIT = "nomFR_cit";
	public static final String PROPERTY_PRENOMFR_CIT = "prenomFR_cit";
	
	public static final String PROPERTY_DATE_NAISS_CIT = "date_naiss_cit";
	public static final String PROPERTY_LIEU_NAISS_CIT = "lieu_naiss_cit";
	public static final String PROPERTY_COMM_NAISS_CIT = "comm_naiss_cit";
	public static final String PROPERTY_WIL_NAISS_CIT = "wil_naiss_cit";
	public static final String PROPERTY_ADRESS_CIT = "adress_cit";
	
	public static final String PROPERTY_FULLNAME_CONJ1 = "fullname_conj1";
	public static final String PROPERTY_FULLNAME_CONJ2 = "fullname_conj2";
	public static final String PROPERTY_FULLNAME_CONJ3 = "fullname_conj3";
	public static final String PROPERTY_FULLNAME_DAME = "fullname_dame";
	
	public static final String PROPERTY_FULLNAME_CONJ4 = "fullname_conj4";
	
	//public static final String PROPERTY_DATE_TYPE_ATTEST = "date_type_attest";
	public static final String PROPERTY_DATE_DECES_CONJ = "date_deces_conj";
	public static final String PROPERTY_DATE_CONJ1 = "date_conj1";
	public static final String PROPERTY_DATE_CONJ2 = "date_conj2";
	public static final String PROPERTY_DATE_CONJ3 = "date_conj3";
	public static final String PROPERTY_DATE_CONJ4 = "date_conj4";
	public static final String PROPERTY_DATE_MAR = "date_mar";
	
	public static final String PROPERTY_COMM_MAR = "comm_mar";
	public static final String PROPERTY_NUM_MAR = "num_mar";
	public static final String PROPERTY_DATE_ATTEST = "date_attest";
	
	public static final String PROPERTY_FULLNAME_TEM1 = "fullname_tem1";
	public static final String PROPERTY_NUM_CNI_TEM1 = "num_cni_tem1";
	public static final String PROPERTY_DATEDELIV_CNI_TEM1 = "datedeliv_cni_tem1";
	public static final String PROPERTY_LIEUDELIV_CNI_TEM1 = "lieudeliv_cni_tem1";

	public static final String PROPERTY_FULLNAME_TEM2 = "fullname_tem2";
	public static final String PROPERTY_NUM_CNI_TEM2 = "num_cni_tem2";
	public static final String PROPERTY_DATEDELIV_CNI_TEM2 = "datedeliv_cni_tem2";
	public static final String PROPERTY_LIEUDELIV_CNI_TEM2 = "lieudeliv_cni_tem2";

	private int id_attest = -1;
	private String type_attest = "ndiv_mar1"; //"ndiv_mar1" non div depuis mar
								//"nmar_dec2" non mar depuis dec
								//"nmar_div3" non mar depuis div
	
	private String wilaya = MyApp.wilaya;
	private String daira =MyApp.daira;
	private String commune =MyApp.commune;

	private String nom_cit = "";
	private String prenom_cit = "";
	private String nomFR_cit = "";
	private String prenomFR_cit = "";
	
	private java.util.Date date_naiss_cit = MyApp.defaultDate;
	private String lieu_naiss_cit = "";
	private String comm_naiss_cit = "";
	private String wil_naiss_cit = "";
	private String adress_cit = "";
	
	//dans les trois types de cas d'attestion
	//on aura nom prenom du conjoint
	//et une date des 03 cas : 
	//   date mariage, date deces conjoint
	//   ou date divorce 
	private String fullname_conj1 = "";
	private String fullname_conj2 = "";
	private String fullname_conj3 = "";
	private String fullname_conj4 = "";
	
	private java.util.Date date_deces_conj;
	
	private java.util.Date date_conj1;
	private java.util.Date date_conj2;
	private java.util.Date date_conj3;
	private java.util.Date date_conj4;
	
	private java.util.Date date_mar;// = MyApp.defaultDate;
	private String comm_mar = "";
	private int num_mar;
	
	private java.util.Date date_attest;
	
	//TODO later encapsulate this in Temoin Object
	//private int id_temoin;
	//private int id_attest;
	
	

	
	private String fullname_tem1 = "";
	private long num_cni_tem1;
	private java.util.Date datedeliv_cni_tem1;
	private String lieudeliv_cni_tem1 = "";
	
	private String fullname_tem2 = "";
	private long num_cni_tem2;
	private java.util.Date datedeliv_cni_tem2;
	private String lieudeliv_cni_tem2 = "";
	
	private String fullname_dame = "";
	
	//******************************************************
	@AGetterMapping(databaseGenerated = true)
	
	public int getId_attest() {
		return id_attest;
	}

	public String getAdress_cit() {
		return adress_cit;
	}

	public java.util.Date getDate_mar() {
		return date_mar;
	}
	
		public String getType_attest() {
		return type_attest;
	}

	public String getWilaya() {
		return wilaya;
	}

	public String getDaira() {
		return daira;
	}

	public String getCommune() {
		return commune;
	}

	public String getNom_cit() {
		return nom_cit;
	}
	public String getPrenom_cit() {
		return prenom_cit;
	}
	
	public String getNomFR_cit() {
		return nomFR_cit;
	}
	public String getPrenomFR_cit() {
		return prenomFR_cit;
	}

	public java.util.Date getDate_naiss_cit() {
		return date_naiss_cit;
	}

	public String getLieu_naiss_cit() {
		return lieu_naiss_cit;
	}

	public String getComm_naiss_cit() {
		return comm_naiss_cit;
	}

	public String getWil_naiss_cit() {
		return wil_naiss_cit;
	}

	public String getFullname_conj1() {
		return fullname_conj1;
	}
	public String getFullname_conj2() {
		return fullname_conj2;
	}

	public String getFullname_conj3() {
		return fullname_conj3;
	}
	public String getFullname_conj4() {
		return fullname_conj4;
	}
	
	public java.util.Date getDate_deces_conj() {
		return date_deces_conj;
	}

	public java.util.Date getDate_attest() {
		return date_attest;
	}
	
	public java.util.Date getDate_conj1() {
		return date_conj1;
	}
	public java.util.Date getDate_conj2() {
		return date_conj2;
	}
	public java.util.Date getDate_conj3() {
		return date_conj3;
	}
	public java.util.Date getDate_conj4() {
		return date_conj4;
	}

	public String getComm_mar() {
		return comm_mar;
	}

	public int getNum_mar() {
		return num_mar;
	}

	public String getFullname_tem1() {
		return fullname_tem1;
	}

	public long getNum_cni_tem1() {
		return num_cni_tem1;
	}

	public java.util.Date getDatedeliv_cni_tem1() {
		return datedeliv_cni_tem1;
	}

	public String getLieudeliv_cni_tem1() {
		return lieudeliv_cni_tem1;
	}

	public String getFullname_tem2() {
		return fullname_tem2;
	}

	public long getNum_cni_tem2() {
		return num_cni_tem2;
	}

	public java.util.Date getDatedeliv_cni_tem2() {
		return datedeliv_cni_tem2;
	}

	public String getLieudeliv_cni_tem2() {
		return lieudeliv_cni_tem2;
	}
	
	
	
	
	public String getFullname_dame() {
		return fullname_dame;
	}

	public void setDate_mar(java.util.Date newDate) {
		
		Date oldDate = this.date_mar;
		this.date_mar = newDate;
		if (oldDate != newDate) {
			System.out.println("date_mar .... tchanga ma ");
			firePropertyChange(Attest.PROPERTY_DATE_MAR, oldDate, newDate);
			System.out.println("date_mar .... tchanga ma w zeeed");
		}
	}
	public void setId_attest(int newValue) {
	
		int oldValue = this.id_attest;
		this.id_attest = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Attest.PROPERTY_ID_ATTEST, oldValue, newValue);
		}
	}

	public void setWilaya(String newValue) {
	
		String oldValue = this.wilaya;
		this.wilaya = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_WILAYA, oldValue, newValue);
		}
	}

	public void setDaira(String newValue) {
	
		String oldValue = this.daira;
		this.daira = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_DAIRA, oldValue, newValue);
		}
	}

	public void setCommune(String newValue) {
	
		String oldValue = this.commune;
		this.commune = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_COMMUNE, oldValue, newValue);
		}
	}

	public void setNom_cit(String newValue) {
	
		newValue = newValue.toLowerCase();
		String oldValue = this.nom_cit;
		this.nom_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_NOM_CIT, oldValue, newValue);
		}
	}
	
	public void setPrenom_cit(String newValue) {
		
		newValue = newValue.toLowerCase();
		String oldValue = this.prenom_cit;
		this.prenom_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_PRENOM_CIT, oldValue, newValue);
		}
	}
	
	public void setNomFR_cit(String newValue) {
		
		newValue = newValue.toLowerCase();
		String oldValue = this.nomFR_cit;
		this.nomFR_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_NOMFR_CIT, oldValue, newValue);
		}
	}
	
	public void setPrenomFR_cit(String newValue) {
		
		newValue = newValue.toLowerCase();
		String oldValue = this.prenomFR_cit;
		this.prenomFR_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_PRENOMFR_CIT, oldValue, newValue);
		}
	}

	public void setDate_naiss_cit(java.util.Date newDate) {
	
		Date oldDate = this.date_naiss_cit;
		this.date_naiss_cit = newDate;
		if (oldDate != newDate) {
			firePropertyChange(Attest.PROPERTY_DATE_NAISS_CIT, oldDate, newDate);
		}
	}

	public void setLieu_naiss_cit(String newValue) {
	
		String oldValue = this.lieu_naiss_cit;
		this.lieu_naiss_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_LIEU_NAISS_CIT, oldValue, newValue);
		}
	}

	public void setComm_naiss_cit(String newValue) {
	
		String oldValue = this.comm_naiss_cit;
		this.comm_naiss_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_COMM_NAISS_CIT, oldValue, newValue);
		}
	}

	public void setWil_naiss_cit(String newValue) {
	
		String oldValue = this.wil_naiss_cit;
		this.wil_naiss_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_WIL_NAISS_CIT, oldValue, newValue);
		}
	}

	public void setAdress_cit(String newValue) {
	
		String oldValue = this.adress_cit;
		this.adress_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_ADRESS_CIT, oldValue, newValue);
		}
	}

	public void setFullname_conj1(String newValue) {
	
		String oldValue = this.fullname_conj1;
		this.fullname_conj1 = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_FULLNAME_CONJ1, oldValue, newValue);
		}
	}
	public void setFullname_conj2(String newValue) {
		
		String oldValue = this.fullname_conj2;
		this.fullname_conj2 = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_FULLNAME_CONJ2, oldValue, newValue);
		}
	}
	public void setFullname_conj3(String newValue) {
		
		String oldValue = this.fullname_conj3;
		this.fullname_conj3 = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_FULLNAME_CONJ3, oldValue, newValue);
		}
	}
	public void setFullname_conj4(String newValue) {
		
		String oldValue = this.fullname_conj4;
		this.fullname_conj4 = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_FULLNAME_CONJ4, oldValue, newValue);
		}
	}
	
	public void setDate_deces_conj(java.util.Date newDate) {
	
		Date oldDate = this.date_deces_conj;
		this.date_deces_conj = newDate;
		if (oldDate != newDate) {
			firePropertyChange(Attest.PROPERTY_DATE_DECES_CONJ, oldDate, newDate);
		}
	}

	public void setDate_conj1(java.util.Date newDate) {
	
		Date oldDate = this.date_conj1;
		this.date_conj1 = newDate;
		if (oldDate != newDate) {
			firePropertyChange(Attest.PROPERTY_DATE_CONJ1, oldDate, newDate);
		}
	}
	public void setDate_conj2(java.util.Date newDate) {
		
		Date oldDate = this.date_conj2;
		this.date_conj2 = newDate;
		if (oldDate != newDate) {
			firePropertyChange(Attest.PROPERTY_DATE_CONJ2, oldDate, newDate);
		}
	}
	public void setDate_conj3(java.util.Date newDate) {
		
		Date oldDate = this.date_conj3;
		this.date_conj3 = newDate;
		if (oldDate != newDate) {
			firePropertyChange(Attest.PROPERTY_DATE_CONJ3, oldDate, newDate);
		}
	}
	public void setDate_conj4(java.util.Date newDate) {
		
		Date oldDate = this.date_conj4;
		this.date_conj4 = newDate;
		if (oldDate != newDate) {
			firePropertyChange(Attest.PROPERTY_DATE_CONJ4, oldDate, newDate);
		}
	}

	public void setComm_mar(String newValue) {
	
		String oldValue = this.comm_mar;
		this.comm_mar = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_COMM_MAR, oldValue, newValue);
		}
	}

	public void setNum_mar(int newValue) {
	
		/*
		Integer i = newValue;
		newValue = (i.equals(null))? 0 : newValue; 
		//*/
		
		int oldValue = this.num_mar;
		this.num_mar = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Attest.PROPERTY_NUM_MAR, oldValue, newValue);
		}
	}

	public void setDate_attest(java.util.Date newDate) {
	
		Date oldDate = this.date_attest;
		this.date_attest = newDate;
		if (oldDate != newDate) {
			firePropertyChange(Attest.PROPERTY_DATE_ATTEST, oldDate, newDate);
		}
	}
	public void setFullname_tem1(String newValue) {
		
		String oldValue = this.fullname_tem1;
		this.fullname_tem1 = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_FULLNAME_TEM1, oldValue, newValue);
		}
	}

	public void setNum_cni_tem1(long newValue) {
	
		long oldValue = this.num_cni_tem1;
		this.num_cni_tem1 = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Attest.PROPERTY_NUM_CNI_TEM1, oldValue, newValue);
		}
	}

	public void setDatedeliv_cni_tem1(java.util.Date newValue) {
	
		Date oldValue = this.datedeliv_cni_tem1;
		this.datedeliv_cni_tem1 = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Attest.PROPERTY_DATEDELIV_CNI_TEM1, oldValue, newValue);
		}
	}

	public void setLieudeliv_cni_tem1(String newValue) {
	
		String oldValue = this.lieudeliv_cni_tem1;
		this.lieudeliv_cni_tem1 = newValue;
		if (!oldValue.equals(newValue)) {
		}
	}

	public void setFullname_tem2(String newValue) {
		
		String oldValue = this.fullname_tem2;
		this.fullname_tem2 = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_FULLNAME_TEM2, oldValue, newValue);
		}
	}

	public void setNum_cni_tem2(long newValue) {
	
		long oldValue = this.num_cni_tem2;
		this.num_cni_tem2 = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Attest.PROPERTY_NUM_CNI_TEM2, oldValue, newValue);
			IsmPrintStream.logging("firePropertyChange setNum_cni_tem2 ");
		}
	}

	public void setDatedeliv_cni_tem2(java.util.Date newValue) {
	
		Date oldValue = this.datedeliv_cni_tem2;
		this.datedeliv_cni_tem2 = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Attest.PROPERTY_DATEDELIV_CNI_TEM2, oldValue, newValue);
		}
	}

	public void setLieudeliv_cni_tem2(String newValue) {
	
		String oldValue = this.lieudeliv_cni_tem2;
		this.lieudeliv_cni_tem2 = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_LIEUDELIV_CNI_TEM2, oldValue, newValue);
		}
	}
	
	public void setType_attest(String newValue) {
		
		String oldValue = this.type_attest;
		this.type_attest = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_TYPE_ATTEST, oldValue, newValue);
		}
	}
	
	public void setFullname_dame(String newValue) {
		
		String oldValue = this.fullname_dame;
		this.fullname_dame = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Attest.PROPERTY_FULLNAME_DAME, oldValue, newValue);
		}
	}

}
