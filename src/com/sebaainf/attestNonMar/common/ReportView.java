package com.sebaainf.attestNonMar.common;

import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.ismUtils.IsmPrintStream;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRFieldFactory;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by admin on 07/02/2015.
 */
public class ReportView {

	private static String coche1, coche2, coche3;
	private static Attest attest;
    public static void report(Attest bigBean) {


    	attest=bigBean;
        IsmPrintStream.logging("reporting began ...");

        // Preparing data

        //ficheFam.prepareTexts();
        
        prepareCoches();
        
        Collection<Attest> data = new Vector<Attest>();
        data.add(bigBean);


        try {
            JasperReport jasperReport1 = null;
            JasperDesign jasperDesign1 = null;
            JasperPrint jasperPrint1 = null;



            JRBeanCollectionDataSource beanDs1;
            


            Map parameters = new HashMap();
            parameters.put("coche1", coche1);
            parameters.put("coche2", coche2);
            parameters.put("coche3", coche3);

            beanDs1 = new JRBeanCollectionDataSource(data);
            //Attest obj = ((ReportedBean) beanDs1.getData().iterator().next()).getAttest();
            //IsmPrintStream.logging("type attest : " + obj.getType_attest());

            //parameters.put("COUNT_ROWS", beanDs2.getData().size());
            //parameters.put("myText", " سنـة ");
            
            jasperDesign1 = JRXmlLoader.load("files/reportAttestNM.jrxml");

            jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
            
            //IsmPrintStream.logging("cool until now 11    : " + jasperReport1.getFields()[0].getName());
            //IsmPrintStream.logging("beanDs1 prenom cit =   : " + ((ReportedBean)(beanDs1.getData().iterator().next())).getAttest().getNom_cit());

            jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, beanDs1);


            /* if we went to merge the two pages in one

            jasperPrint1.addPage(jasperPrint2.getPages().get(0));
            //*/
            IsmPrintStream.logging("cool until now 22");
            JasperViewer.viewReport(jasperPrint1, false);
            IsmPrintStream.logging("cool until now 33");
            int x = JasperViewer.getFrames()[1].getLocation().x;
            int y = JasperViewer.getFrames()[1].getLocation().y;
            JasperViewer.getFrames()[1].setLocation(x + 100, y + 100);


        } catch (JRException e) {
            e.printStackTrace();
            IsmPrintStream.logging("error in reporting ...ya ismail");
        }

        IsmPrintStream.logging("end reporting ...");

    }
    private static void prepareCoches() {
		coche1 = coche2 = coche3 = "/  /  /";
		
		//coche1.replaceAll("\\s+", ""); // to remove all white space from string
		if (attest.getFullname_conj1() == null) attest.setFullname_conj1("");
		if (attest.getFullname_conj2() == null) attest.setFullname_conj2("");
		if (attest.getFullname_conj3() == null) attest.setFullname_conj3("");
		//if (attest.getNum_mar() <= 0) attest.setNum_mar();
		
		if (attest.getFullname_conj2().equals("")
				&& attest.getFullname_conj3().isEmpty() && attest.getComm_mar().equals("") ) {
			if (attest.getFullname_conj1().equals("")) {
				coche1 = ""; // non mariage
			} else {
				coche2 = ""; // non divorce
			}

		} else if (attest.getFullname_conj1().equals("")){
				coche3 = ""; // non remariage
		}
		
	}
	// for connect the ireport
    /**
     *
     * @return
     * @should return an attest collection
     */
    public static Collection<ReportedBean> getMyAttest() {

        ReportedBean myBean = new ReportedBean(new Attest());
        Vector data = new Vector<ReportedBean>();

        try {
            //TODO Attest attest = MyDaos.getListAttest(nom, prenom, inFrench);
            Attest attest = MyApp.getObj();
            attest.setType_attest("ndiv_mar1");
        	myBean = new ReportedBean(attest);
        	
            data.add(myBean);
        } finally {
            return data;
        }

    }

}
