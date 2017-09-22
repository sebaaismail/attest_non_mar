package com.sebaainf.attestNonMar.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.sebaainf.attestNonMar.common.MyApp;
import com.sebaainf.attestNonMar.model.Attest;
import com.sebaainf.attestNonMar.model.AttestEditorModel;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmTableAdapter;

public class ResultaRech_window extends JFrame {


    public static Dimension dimWin;
    public static Dimension dimPannel;
    private static ResultaRech_window uniqueFrame;
    private List listAtt;

    private ResultaRech_window(List listAtt) {

        UIManager.put("Table.background", new ColorUIResource(MyApp.tableBackColor));
        UIManager.put("Table.alternateRowColor", MyApp.alternateRowColor);

        this.listAtt = listAtt;
        dimWin = new Dimension(6 * (int) IsmAbstractJFrame.screenSize.getWidth() / 10, 4 * (int) IsmAbstractJFrame.screenSize.getHeight() / 10);
        dimPannel = new Dimension(5 * (int) IsmAbstractJFrame.screenSize.getWidth() / 10, 3 * (int) IsmAbstractJFrame.screenSize.getHeight() / 10);

        this.setTitle("Resultat de recherche !");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());

        this.pack();

        this.setSize(dimWin);

        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
    }

    public static ResultaRech_window getInstance(List listCit) {

        if (uniqueFrame == null) {
            uniqueFrame = new ResultaRech_window(listCit);
        } else {
            //becarfull with using singleton
            // for exple : without this else part it was an disaster
            uniqueFrame.dispose();
            uniqueFrame = new ResultaRech_window(listCit);
        }
        return uniqueFrame;

    }

    // Singleton

    public JComponent createPanel() {


        //final List listCitoyens = new ArrayListModel(this.listCit);

        //final SelectionInList selectionInList = new SelectionInList(listCit);
        IsmTableAdapter tableAdapter = new IsmTableAdapter(
        		listAtt, new String[]{Attest.PROPERTY_ID_ATTEST, Attest.PROPERTY_NOM_CIT, Attest.PROPERTY_PRENOM_CIT,
        				Attest.PROPERTY_DATE_NAISS_CIT,
        				Attest.PROPERTY_NOMFR_CIT, Attest.PROPERTY_PRENOMFR_CIT}
                , new String[]{"ID_ATTEST", "الإسم", "اللقب", "تاريخ الإزدياد", "Nom", "Prenom"});
        JTable table = new JTable(tableAdapter);

        tableAdapter.settingTable(table);

        // on double Click Action  ******************

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    // your valueChanged overridden method

                    Attest selectedAtt = (Attest) new ArrayListModel(listAtt).getElementAt(table.getSelectedRow());
                    //to update commune if changed
                    selectedAtt.setCommune(MyApp.commune);
                    selectedAtt.setDaira(MyApp.daira);
                    selectedAtt.setWilaya(MyApp.wilaya);


                            AttestEditorModel attModel = new AttestEditorModel(selectedAtt);

                            Editor_window view = new Editor_window(attModel, false);
                            view.setVisible(true);
                        }
                }

        });

        //*********************************


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(dimPannel);


        return FormBuilder.create()
                .columns("p:g")
                .rows("p:g")
                .padding(Paddings.DIALOG)
                .add(scrollPane).xy(1, 1)
                .build();

    }

    class AttestTableAdapter extends AbstractTableAdapter {

        public AttestTableAdapter(ListModel listModel, String[] columnNames) {

            super(listModel, columnNames);
        }

        /**
         * Returns the value for the cell at <code>columnIndex</code> and
         * <code>rowIndex</code>.
         *
         * @param rowIndex    the row whose value is to be queried
         * @param columnIndex the column whose value is to be queried
         * @return the value Object at the specified cell
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            Attest att = (Attest) getRow(rowIndex);
            if (columnIndex == 0) {
                return att.getNom_cit();
            } else if (columnIndex == 1) {
                return att.getId_attest();
            }else if (columnIndex == 2) {
                return att.getPrenom_cit();
            } else if (columnIndex == 3) {
                return att.getDate_naiss_cit();
            }  else if (columnIndex == 4) {
                return att.getNomFR_cit();
            } else {
                return att.getPrenomFR_cit();
            }
        }
    }


}
