/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Curs;
import model.Alumne;
import view.ExempleForm;
import view.MostraLlistaForm;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import util.Util;

/**
 *
 * @author alfredo
 */
public class ExempleCtrl {

    private ExempleForm frm;
    private Curs curs;

    public ExempleCtrl() {
        this.frm = new ExempleForm(this);
        this.curs = initCurs();
        this.frm.setVisible(true);

    }

    public int validaCodi(String codi) {
        int lonMin = 3;
        int result = 0;
        boolean err = Util.validaLongitud(codi, lonMin);
        if (!err) {
            result = 1;
        } else {
            err = Util.validaInteger(codi);
            if (!err) {
                result = 2;
            } else {
                err = validaDniNoDuplicat(codi);
                if (!err) {
                    result = 3;
                }
            }
        }
        return result;
    }

    private String getAlumnesTxt() {
        String txt = "";
        Set<Alumne> alumnes = curs.getAlumnes();
        for (Alumne alu : alumnes) {
            txt += alu.toString() + "\n";
        }
        return txt;
    }

    private TableModel getAlumnesDataTable() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Nom");
        tm.addColumn("Dni");
        tm.addColumn("Nota");
        Set<Alumne> alumnes = curs.getAlumnes();
        for (Alumne alu : alumnes) {
            Object[] fila = new Object[3]; // Hay tres columnas en la tabla
            // Se rellena cada posición del array con una atributo de Alumne.
            fila[0] = alu.getNom();
            fila[1] = alu.getDni();
            fila[2] = alu.getNotaFinal();

            // Se añade al modelo la fila completa.     
            tm.addRow(fila);
        }
        return tm;
    }

    public TableModel getAlumnesDataTableFiltreNota(int nota) {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Nom");
        tm.addColumn("Dni");
        tm.addColumn("Nota Modificada");
        Set<Alumne> alumnes = curs.getAlumnes();
        for (Alumne alu : alumnes) {
            if (alu.getNotaFinal() >= nota) {
                Object[] fila = new Object[3]; // Hay tres columnas en la tabla
                // Se rellena cada posición del array con una atributo de Alumne.
                fila[0] = alu.getNom();
                fila[1] = alu.getDni();
                fila[2] = alu.getNotaFinal();

                // Se añade al modelo la fila completa.     
                tm.addRow(fila);
            }
        }
        return tm;
    }

    public boolean afegirItem(Alumne alu) {

        return curs.add(alu);
    }

    public void mostraLlista() {
        MostraLlistaForm dialog = new MostraLlistaForm(this.frm, true, this);
        String txt = this.getAlumnesTxt();
        TableModel tm = this.getAlumnesDataTable();
        dialog.setInfo(txt, tm);
        dialog.setVisible(true);

    }



    public boolean validaDniNoDuplicat(String txt) {
        boolean dupli = true;

        dupli = curs.existeixAlumne(txt);
        return !dupli;
    }

    public Curs initCurs() {
        Curs c = new Curs();
        Alumne alu1 = new Alumne("Victor", "11111", 7);
        Alumne alu2 = new Alumne("Marc", "22222", 10);
        Alumne alu3 = new Alumne("Cristian", "33333", 7);
        Alumne alu4 = new Alumne("Ruben", "44444", 8);
        Alumne alu5 = new Alumne("Judit", "55555", 8);
        Alumne alu6 = new Alumne("Sergio", "66666", 6);
        Alumne alu7 = new Alumne("Jordi", "66666", 9);

        c.add(alu1);
        c.add(alu2);
        c.add(alu3);
        c.add(alu4);
        c.add(alu5);
        c.add(alu6);
        c.add(alu7);
        return c;

    }

}
