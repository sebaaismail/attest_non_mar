package com.sebaainf.attestNonMar.common;

import com.jenkov.db.itf.PersistenceException;
//import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.*;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.attestNonMar.model.AttestEditorModel;
import com.sebaainf.attestNonMar.persistance.MyDaosAttest;
import com.sebaainf.attestNonMar.view.Editor_window;
import com.sebaainf.attestNonMar.view.SearchAttest_window;
import com.sebaainf.ismThemes.BlackTheme;
import com.sebaainf.ismThemes.MyTheme;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmPrintStream;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by admin on 24/01/2015.
 */
public class MyApp {

    public static int default_id_c = 3114; //todo maybe get from general variable or file config
    public static MyTheme theme = new BlackTheme();
    public static Color tableBackColor = Color.white;
    public static Color alternateRowColor = Color.lightGray;
    public static Date defaultDate;
    public static String wilaya ="";
    public static String daira = "";
    public static String commune ="";



    //public static Color tableBackgColor = Color.decode("#D7EAF5");

    //public static MyTheme theme = new GreyTheme(); // put in config
    public static void setUIFont(javax.swing.plaf.FontUIResource f) {

        java.util.Enumeration keys = UIManager.getDefaults().keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }


    public static void updateCommune() {



    }

    public static void main(String[] args) {

        /**
         * set jgoodies Look And Feel
         */

        try {
            defaultDate =new SimpleDateFormat("yyyy/MM/dd").parse("1900/01/01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Commune.initilize();
        //Commune.changeCommune();
        Commune.readCommune();
        IsmPrintStream.prepareLogFile();
        IsmPrintStream.logging("Welcome to Attestation-Non-Mariage app        " +
        		"تطبيق شهادة عدم الزواج/الطلاق");

        EventQueue.invokeLater(new Runnable() {
            public void run() {



                try {
                    UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                    UIManager.put("TextField.inactiveBackground", new ColorUIResource(Color.blue));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setUIFont(new javax.swing.plaf.FontUIResource("Times New Roman", Font.PLAIN, 18));

        //*****************************************************



        Toolkit toolkit = Toolkit.getDefaultToolkit();
        IsmAbstractJFrame.screenSize = toolkit.getScreenSize();

        //TODO
        //JFrame frame = new SearchCit_window();
        /*
         JFrame frame = new SearchAttestEditor();
         frame.setVisible(true);
        //*/
        
        
        
        //AttestEditorModel attestModel = new AttestEditorModel(getObj());
       /*
        try {
			MyDaosAttest.insertAttest(getObj());
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
        //*/
        AttestEditorModel attestModel = new AttestEditorModel(new Attest());
        //Editor_window view = new Editor_window(new AttestEditorModel(getObj()));
        SearchAttest_window view = new SearchAttest_window();
        view.setVisible(true);
    }
    public static Attest getObj(){
    	Attest obj = new Attest();
        obj.setWilaya("وهران");
        obj.setDaira("وادي تليلات");
        obj.setCommune("بوفاطيس");
        
        obj.setFullname_tem1("الهادي ربيع");
        obj.setNum_cni_tem1(14752);
        obj.setLieudeliv_cni_tem1("قديل");
        obj.setDatedeliv_cni_tem1(new Date());
        
        obj.setFullname_tem2("بومخلوف عيسى");
        obj.setNum_cni_tem2(10123);
        obj.setLieudeliv_cni_tem2("بير الجير");
        obj.setDatedeliv_cni_tem2(new Date());
        
        obj.setNom_cit("بن زوبير");
        obj.setPrenom_cit("كريمة");
        obj.setPrenomFR_cit("Karima");
        obj.setNomFR_cit("BEN ZOUBIR");
        
        obj.setDate_naiss_cit(new Date());
        obj.setLieu_naiss_cit("بوفاطيس");
        obj.setComm_naiss_cit("بوفاطيس");
        obj.setWil_naiss_cit("وهران");
        obj.setAdress_cit("92 شارع هواري بومدين - بوفاطيس");        
        obj.setFullname_conj1("عايد حسين");
        obj.setFullname_conj2("2عايد حسين");
        obj.setFullname_conj3("3عايد حسين");
        obj.setFullname_conj4("4عايد حسين");

        obj.setDate_deces_conj(new Date());
        
        obj.setNum_mar(157);
        obj.setDate_conj1(new Date());
        obj.setComm_mar("سيق");
        return obj;
    }
    public static Attest getObj2(){
    	Attest obj = new Attest();
        obj.setWilaya("2وهران");
        obj.setDaira("وادي تليلات2");
        obj.setCommune("2بوفاطيس");
        
        obj.setFullname_tem1("الهادي ربيع2");
        obj.setNum_cni_tem1(14752);
        obj.setLieudeliv_cni_tem1("قديل2");
        obj.setDatedeliv_cni_tem1(new Date());
        
        obj.setFullname_tem2("2بومخلوف عيسى");
        obj.setNum_cni_tem2(10123);
        obj.setLieudeliv_cni_tem2("بير الجير2");
        obj.setDatedeliv_cni_tem2(new Date());
        
        obj.setNom_cit("2بن زوبير");
        obj.setPrenom_cit("2كريمة");
        obj.setPrenomFR_cit("2Karima");
        obj.setNomFR_cit("2BEN ZOUBIR");
        
        obj.setDate_naiss_cit(new Date());
        obj.setLieu_naiss_cit("2بوفاطيس");
        obj.setComm_naiss_cit("بوفاطيس2");
        obj.setWil_naiss_cit("2وهران");
        obj.setAdress_cit("92 شارع هواري بومدين 2- بوفاطيس");        
        obj.setFullname_conj1("2عايد حسين");
        obj.setFullname_conj2("2عايد حسين2");
        obj.setFullname_conj3("23عايد حسين");
        obj.setFullname_conj4("24عايد حسين");

        obj.setDate_deces_conj(new Date());
        
        obj.setNum_mar(157);
        obj.setDate_conj1(new Date());
        obj.setComm_mar("2سيق");
        return obj;
    }
}

