package com.sebaainf.attestNonMar.common;

import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.ismUtils.IsmPrintStream;

import java.util.Collection;
import java.util.Vector;

/**
 * Created by ${sebaainf.com} on 01/11/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class ReportedBean {

    private Attest attest;

	private String barre1 = "/  /  /";
    private String barre2 = "/  /  /";
    private String wil = MyApp.wilaya;
    private String da = MyApp.daira;
    private String com = MyApp.commune;


    
    
    //later TODO *encapsulate temoins data in Temoin[] Object
    //private Temoin ment;

    //private String marge = "زواج";



	//later TODO *
    //public ReportedBean(Citoyen cit, Mention ment) {
    public ReportedBean(Attest attest) {
        this.attest = attest;
        //this.temoins = temoins;
        //"ndiv_mar1" non div depuis mar
		//"nmar_dec2" non mar depuis dec
		//"nmar_div3" non mar depuis div
        if(attest.getType_attest().equals("ndiv_mar1")){
            //TODO ndiv_mar1
        } else if (attest.getType_attest().equals("nmar_dec2")){
        	//TODO nmar_dec2
        } else {
        	// TODO nmar_div3
        }
    }

    public Attest getAttest() {

        return attest;
    }

    public void setAttest(Attest attest) {

        this.attest = attest;
    }
    public String getBarre1() {
		return barre1;
	}

	public String getBarre2() {
		return barre2;
	}

	public void setBarre1(String barre1) {

		this.barre1 = barre1;
		
	}

	public void setBarre2(String barre2) {
		this.barre2 = barre2;
			}

    
/* TODO
    public Temoin[] getTemoins() {

        return temoins;
    }

    public void setMent(Mention ment) {

        this.ment = ment;
    }

    public String getMarge() {

        return marge;
    }

    public void setMarge(String marge) {

        this.marge = marge;
    }
//*/



}
