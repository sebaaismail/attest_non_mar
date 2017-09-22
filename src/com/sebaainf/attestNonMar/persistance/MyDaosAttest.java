package com.sebaainf.attestNonMar.persistance;

import com.jenkov.db.itf.IDaos;
import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.ismUtils.IsmPrintStream;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.attestNonMar.persistance.MyDaos;

import java.util.*;

import javax.swing.JOptionPane;

//import com.sebaainf.fichfamil.common.Deces;

/**
 * Created by admin on 23/04/2017.
 * Class to create new, update or delete Attests
 */
public class MyDaosAttest {




    /**
     * @param id_attest
     * @return
     * @throws com.jenkov.db.itf.PersistenceException
     * @should return Attest with id_attest
     */
    public static Attest getAttest(int id_attest) throws PersistenceException {

        Attest Attest = null;


        try {

            String sql = "select * from attest where id_attest=?";
            IDaos daos = MyDaos.persistenceManager.createDaos();
            Attest = daos.getObjectDao().read(Attest.class, sql, id_attest);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return Attest;
        }
    }


    /**
     * @param nomFR_cit
     * @param prenomFR_cit
     * @return
     * @should return list Attest with nom prenom
     */
    public static TreeSet<Attest> getListAttest(String nomFR_cit, String prenomFR_cit) {


        List<Attest> listAttests;
        TreeSet<Attest> setAttests = new TreeSet<Attest>();
        try {
            String sql = "select * from Attest where nomFR_cit='" + nomFR_cit +
                    "' and prenomFR_cit='" + prenomFR_cit;
            IDaos daos = MyDaos.persistenceManager.createDaos();
            listAttests = daos.getObjectDao().readList(Attest.class, sql);
            if (listAttests != null) {
                setAttests = new TreeSet<Attest>(listAttests);
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return setAttests;
        }

    }

    /**
     * method to add new Attest
     *
     * @param attest
     * @return
     * @should insert Attest attest into Data base
     */
    public static Attest insertAttest(Attest attest) throws PersistenceException{

            IDaos daos = MyDaos.persistenceManager.createDaos();
            //int id;
            //if (daos.getObjectDao().getLastGeneratedKeyAsBigDecimal() < 0) id = 0;
            //else id = (int) daos.getObjectDao().getLastGeneratedKeyAsBigDecimal() + 1;
            //attest.setId_attest(id);
            if (isExist(attest)) {
                JOptionPane.showMessageDialog(null, "Attestation existe deja dans la base de donnees !"
                		+ "\n Fait une recherche par nom ,prenom"); 
                return null;
            } else {
            	System.out.println("rani jayyyyy ");
                int i = daos.getObjectDao().insert(attest);
                System.out.println(" id_new attest = " + i);
                return attest;
            }
    }


    /**
     * method to update
     *
     * @param attest
     * @return
     * @should update Attest attest
     */
    public static Attest updateAttest(Attest attest) throws PersistenceException {


            IDaos daos = MyDaos.persistenceManager.createDaos();
            daos.getObjectDao().update(attest);

        return attest;

    }

    /**
     * method to delete Attest attest
     *
     * @param attest
     * @return
     * @should delete Attest attest
     */
    public static boolean deleteAttest(Attest attest) {

        boolean flag = false;

        try {
            IDaos daos = MyDaos.persistenceManager.createDaos();
            daos.getObjectDao().delete(attest);
            flag = true;
            IsmPrintStream.logging("Attest is deleted");

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            IsmPrintStream.logging("flag :" + flag);
            return flag;
        }


    }

    /**
     * method to delete Attest attest
     *
     * @param id_attest
     * @return
     * @should delete Attest attest by id_attest
     */
    public static boolean deleteAttest(int id_attest) {

        boolean flag = false;
        try {
            if (getAttest(id_attest) != null) {

                IDaos daos = MyDaos.persistenceManager.createDaos();
                daos.getObjectDao().delete(Attest.class, id_attest);
                flag = true;
                IsmPrintStream.logging("Attest deleted");
            } else {
                IsmPrintStream.logging("Attest not found in data base !!");
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            IsmPrintStream.logging("flag :" + flag);
            return flag;
        }

    }

    public static Collection<Attest> getAttests() throws PersistenceException {

        //createBeanCollection

        Vector Attests = new Vector();
        Attest Attest = null;

        try {
            /*String sql    = "select * from Attest where num_actnaiss="+new Integer(num_actnaiss).toString()+" and annee_actnaiss="
                    +new Integer(annee_naiss).toString()+" and code_lieunaiss="+new Integer(lieu_naiss).toString();
          */
            String sql = "select * from Attest where id_attest>0";
            IDaos daos = MyDaos.persistenceManager.createDaos();
            Attests = (Vector) daos.getObjectDao().readList(Attest.class, sql);

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return Attests;
        }
    }


	public static List<Attest> getListAtt(String nom, String prenom) {
        List<Attest> list = new ArrayList<Attest>();

        try {
            if (!nom.equals("") && !prenom.equals("")) {

                String sql = "";

                    sql = "select * from attest where nomFR_cit like '"
                            + nom + "%' and prenomFR_cit like '" + prenom + "%'";

                IDaos daos = MyDaos.persistenceManager.createDaos();
                list = daos.getObjectDao().readList(Attest.class, sql);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
	}
	

    /**
     * method to check if Attest att , exist in DB
     *
     * @param att
     * @return
     * @should verifies if att existe in the data base
     */
    public static boolean isExist(Attest att) {


        boolean flag = false;
        String nomFr = att.getNomFR_cit();
        String prenomFr = att.getPrenomFR_cit();
        Date dateNaiss = att.getDate_naiss_cit();
        String commNaiss = att.getComm_naiss_cit();
        java.util.Date sqlDate;



        if (!nomFr.equals(null)  && !prenomFr.equals(null)
				&& !commNaiss.equals(null) && dateNaiss != null) {


		    if (MyDaosAttest.getAttest(nomFr, prenomFr, dateNaiss, commNaiss) != null) {

		        flag = true;
		        System.out.println("Attestation pour cet citoyen existe deja dans la base de donnees! ");
		        return flag;
		    }

		}

        return flag;

    }


	private static Object getAttest(String nomFr, String prenomFr, Date dateNaiss, String commNaiss) {

        Attest att = null;
        java.sql.Date sqlDate = new java.sql.Date(dateNaiss.getTime());;
        try {
            String sql = "select * from attest where nomFR_cit='" + nomFr +
                    "' and prenomFR_cit='" + prenomFr +
                    "' and date_naiss_cit='" + sqlDate + "' and comm_naiss_cit='" + commNaiss + "';";
            IDaos daos = MyDaos.persistenceManager.createDaos();
            att = daos.getObjectDao().read(Attest.class, sql);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return att;
        }
	}

}
