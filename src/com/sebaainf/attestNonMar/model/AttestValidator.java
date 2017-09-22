package com.sebaainf.attestNonMar.model;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;
import com.sebaainf.ismUtils.IsmPrintStream;
import com.sebaainf.ismUtils.IsmValidator;

/**
 * Created by SEBAA Ismail on 20/03/2017.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class AttestValidator extends IsmValidator implements Validator<Object> {


    public AttestValidator(PresentationModel preModel) {

        this.preModel = preModel;

    }

    @Override
    public ValidationResult validate(Object attest) {

   	    IsmPrintStream.logging("validating attestation ...");
        addBlankError(Attest.PROPERTY_WILAYA, "wilaya");
        addBlankError(Attest.PROPERTY_DAIRA, "daira");
        addBlankError(Attest.PROPERTY_COMMUNE, "commune");
        addBlankError(Attest.PROPERTY_NOM_CIT, "nom_cit");
        addBlankError(Attest.PROPERTY_PRENOM_CIT, "prenom_cit");
        addBlankError(Attest.PROPERTY_NOMFR_CIT, "nomFR_cit");
        addBlankError(Attest.PROPERTY_PRENOMFR_CIT, "prenomFR_cit");
        
        addBlankError(Attest.PROPERTY_LIEU_NAISS_CIT, "lieu_naiss_cit");
        
        addBlankError(Attest.PROPERTY_COMM_NAISS_CIT, "comm_naiss_cit");
        addBlankError(Attest.PROPERTY_WIL_NAISS_CIT, "wil_naiss_cit");
        addBlankError(Attest.PROPERTY_ADRESS_CIT, "adress_cit");
       
        
        addBlankError(Attest.PROPERTY_NUM_CNI_TEM1, "num_cni_tem1");
        addBlankError(Attest.PROPERTY_NUM_CNI_TEM2, "num_cni_tem2");


        return validationResult;
    }
    public ValidationResult validate(Object attest, Boolean b) {
    	//TODO
    	return validate(attest);
    }

	@Override
	public ValidationResult validateForSearch(Object o) {
   	    IsmPrintStream.logging("validating search attestation object...");
        addBlankError(Attest.PROPERTY_NOMFR_CIT, "nomFR_cit");
        addBlankError(Attest.PROPERTY_PRENOMFR_CIT, "prenomFR_cit");


        return validationResult;
	}

}
