
package com.sebaainf.attestNonMar.model;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.ValueModel;

/**
 * Created by SEBAA Ismail
 * in 2017/03/20
 */

public final class AttestEditorModel extends PresentationModel<Attest>{

	private ValueModel id_attest;
	private ValueModel type_attest;
    private ValueModel wilaya;
    private ValueModel daira;  
    private ValueModel commune;    
    private ValueModel temoins;    
    private ValueModel nom_cit; 
    private ValueModel prenom_cit; 
    private ValueModel nomFR_cit; 
    private ValueModel prenomFR_cit; 
    private ValueModel date_naiss_cit;    
    private ValueModel lieu_naiss_cit;    
    private ValueModel comm_naiss_cit;    
    private ValueModel wil_naiss_cit;    
    private ValueModel adress_cit;    
    private ValueModel fullname_conj1; 
    private ValueModel fullname_conj2; 
    private ValueModel fullname_conj3; 
    private ValueModel fullname_conj4; 
    
    private ValueModel fullname_dame; 
    
    private ValueModel date_deces_conj;    
    private ValueModel date_mar;   
    
    private ValueModel date_conj1;
    private ValueModel date_conj2;
    private ValueModel date_conj3;
    private ValueModel date_conj4;
   
    
    private ValueModel comm_mar;    
    private ValueModel num_mar;    
    private ValueModel date_attest;  
    
    // maybe delete this ???
    private Attest attest;
    
    private ValueModel fullname_tem1;
    private ValueModel num_cni_tem1;
    private ValueModel datedeliv_cni_tem1;
    private ValueModel lieudeliv_cni_tem1;
	
    private ValueModel fullname_tem2;
    private ValueModel num_cni_tem2;
    private ValueModel datedeliv_cni_tem2;
    private ValueModel lieudeliv_cni_tem2;
    
    /**
     * @param attest
     */
    public AttestEditorModel(Attest attest) {


        super(attest);
        //this.setTriggerChannel(new Trigger());
        this.attest = attest;
        initComponents();
    }


    /**
     *
     */
    private void initComponents() {

    	id_attest = this.getBufferedModel(Attest.PROPERTY_ID_ATTEST);
    	type_attest = this.getBufferedModel(Attest.PROPERTY_TYPE_ATTEST);
    	wilaya = this.getBufferedModel(Attest.PROPERTY_WILAYA);
    	daira = this.getBufferedModel(Attest.PROPERTY_DAIRA);
    	commune = this.getBufferedModel(Attest.PROPERTY_COMMUNE);
    	//temoins = this.getBufferedModel(Attest.TE);

    	nom_cit = this.getBufferedModel(Attest.PROPERTY_NOM_CIT);
    	prenom_cit = this.getBufferedModel(Attest.PROPERTY_PRENOM_CIT);
    	nomFR_cit = this.getBufferedModel(Attest.PROPERTY_NOMFR_CIT);
    	prenomFR_cit = this.getBufferedModel(Attest.PROPERTY_PRENOMFR_CIT);
    	
    	date_naiss_cit = this.getBufferedModel(Attest.PROPERTY_DATE_NAISS_CIT);
    	lieu_naiss_cit = this.getBufferedModel(Attest.PROPERTY_LIEU_NAISS_CIT);
    	comm_naiss_cit = this.getBufferedModel(Attest.PROPERTY_COMM_NAISS_CIT);


    	wil_naiss_cit = this.getBufferedModel(Attest.PROPERTY_WIL_NAISS_CIT);

    	adress_cit = this.getBufferedModel(Attest.PROPERTY_ADRESS_CIT);
    	fullname_conj1 = this.getBufferedModel(Attest.PROPERTY_FULLNAME_CONJ1);
    	fullname_conj2 = this.getBufferedModel(Attest.PROPERTY_FULLNAME_CONJ2);
    	fullname_conj3 = this.getBufferedModel(Attest.PROPERTY_FULLNAME_CONJ3);
    	fullname_conj4 = this.getBufferedModel(Attest.PROPERTY_FULLNAME_CONJ4);
    	
    	fullname_dame = this.getBufferedModel(Attest.PROPERTY_FULLNAME_DAME);
    	
    	date_conj1 = this.getBufferedModel(Attest.PROPERTY_DATE_CONJ1);
    	date_conj2 = this.getBufferedModel(Attest.PROPERTY_DATE_CONJ2);
    	date_conj3 = this.getBufferedModel(Attest.PROPERTY_DATE_CONJ3);
    	date_conj4 = this.getBufferedModel(Attest.PROPERTY_DATE_CONJ4);

    	date_deces_conj = this.getBufferedModel(Attest.PROPERTY_DATE_DECES_CONJ);
    	date_mar = this.getBufferedModel(Attest.PROPERTY_DATE_MAR);
    	comm_mar = this.getBufferedModel(Attest.PROPERTY_COMM_MAR);

    	num_mar = this.getBufferedModel(Attest.PROPERTY_NUM_MAR);
    	date_attest = this.getBufferedModel(Attest.PROPERTY_DATE_ATTEST);
    	
    	fullname_tem1 = this.getBufferedModel(Attest.PROPERTY_FULLNAME_TEM1);
    	num_cni_tem1 = this.getBufferedModel(Attest.PROPERTY_NUM_CNI_TEM1);
    	datedeliv_cni_tem1 = this.getBufferedModel(Attest.PROPERTY_DATEDELIV_CNI_TEM1);
    	lieudeliv_cni_tem1 = this.getBufferedModel(Attest.PROPERTY_LIEUDELIV_CNI_TEM1);

    	fullname_tem2 = this.getBufferedModel(Attest.PROPERTY_FULLNAME_TEM2);
    	num_cni_tem2 = this.getBufferedModel(Attest.PROPERTY_NUM_CNI_TEM2);
    	datedeliv_cni_tem2 = this.getBufferedModel(Attest.PROPERTY_DATEDELIV_CNI_TEM2);
    	lieudeliv_cni_tem2 = this.getBufferedModel(Attest.PROPERTY_LIEUDELIV_CNI_TEM2);

    }


	public ValueModel getId_attest() {
		return id_attest;
	}


	public ValueModel getWilaya() {
		return wilaya;
	}


	public ValueModel getDaira() {
		return daira;
	}


	public ValueModel getCommune() {
		return commune;
	}


	public ValueModel getTemoins() {
		return temoins;
	}


	public ValueModel getNom_cit() {
		return nom_cit;
	}
	
	public ValueModel getPrenom_cit() {
		return prenom_cit;
	}
	public ValueModel getNomFR_cit() {
		return nomFR_cit;
	}
	
	public ValueModel getPrenomFR_cit() {
		return prenomFR_cit;
	}

	public ValueModel getDate_naiss_cit() {
		return date_naiss_cit;
	}


	public ValueModel getLieu_naiss_cit() {
		return lieu_naiss_cit;
	}


	public ValueModel getComm_naiss_cit() {
		return comm_naiss_cit;
	}


	public ValueModel getWil_naiss_cit() {
		return wil_naiss_cit;
	}


	public ValueModel getAdress_cit() {
		return adress_cit;
	}


	public ValueModel getFullname_conj1() {
		return fullname_conj1;
	}
	public ValueModel getFullname_conj2() {
		return fullname_conj2;
	}
	public ValueModel getFullname_conj3() {
		return fullname_conj3;
	}
	public ValueModel getFullname_conj4() {
		return fullname_conj4;
	}
	public ValueModel getFullname_dame() {
		return fullname_dame;
	}
	
	public ValueModel getDate_deces_conj() {
		return date_deces_conj;
	}


	public ValueModel getDate_mar() {
		return date_mar;
	}


	public ValueModel getComm_mar() {
		return comm_mar;
	}


	public ValueModel getNum_mar() {
		return num_mar;
	}


	public ValueModel getDate_attest() {
		return date_attest;
	}


	public Attest getAttest() {
		return attest;
	}


	public ValueModel getType_attest() {
		return type_attest;
	}


	public ValueModel getFullname_tem1() {
		return fullname_tem1;
	}


	public ValueModel getNum_cni_tem1() {
		return num_cni_tem1;
	}


	public ValueModel getDatedeliv_cni_tem1() {
		return datedeliv_cni_tem1;
	}


	public ValueModel getLieudeliv_cni_tem1() {
		return lieudeliv_cni_tem1;
	}


	public ValueModel getFullname_tem2() {
		return fullname_tem2;
	}


	public ValueModel getNum_cni_tem2() {
		return num_cni_tem2;
	}


	public ValueModel getDatedeliv_cni_tem2() {
		return datedeliv_cni_tem2;
	}


	public ValueModel getLieudeliv_cni_tem2() {
		return lieudeliv_cni_tem2;
	}


	public ValueModel getDate_conj1() {
		return date_conj1;
	}


	public ValueModel getDate_conj2() {
		return date_conj2;
	}


	public ValueModel getDate_conj3() {
		return date_conj3;
	}


	public ValueModel getDate_conj4() {
		return date_conj4;
	}  
	
	

}
