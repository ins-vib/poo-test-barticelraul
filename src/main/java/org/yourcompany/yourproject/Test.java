/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author alumne
 */
public class Test {

    private ArrayList<Pregunta> preguntes;
    private int[] respostesUsuari;
    private int numPregunta;

    public Test(ArrayList<Pregunta> preguntes) {
        this.preguntes = preguntes;
        this.respostesUsuari = new int[preguntes.size()];
        Arrays.fill(this.respostesUsuari, -1); // -1 indica no contestada
        this.numPregunta = 0;
    }

    public String getEnunciatPreguntaActual() {
        return preguntes.get(numPregunta).getEnunciat();
    }

    public String[] getRespostesPreguntaActual() {
        return preguntes.get(numPregunta).getRespostes();
    }

    public int getNumeroPregunta() {
        return numPregunta;
    }

    public void respondre(int resposta) {
        respostesUsuari[numPregunta] = resposta;
    }

    public boolean anarEndavant() {
        if (numPregunta < preguntes.size() - 1) {
            numPregunta++;
            return true;
        }
        return false;
    }

    public boolean anarEndarrera() {
        if (numPregunta > 0) {
            numPregunta--;
            return true;
        }
        return false;
    }

    public double solucionarTest() {
        double puntuacio = 0.0;
        double puntsPerPregunta = 10.0 / preguntes.size();
        for (int i = 0; i < preguntes.size(); i++) {
            int respostaUsuari = respostesUsuari[i];
            Pregunta p = preguntes.get(i);
            if (respostaUsuari == -1) continue; // No contestada
            if (respostaUsuari == p.getCorrecta()) {
                puntuacio += puntsPerPregunta;
            } else {
                puntuacio += puntsPerPregunta / p.getRespostes().length;
            }
        }
        return Math.round(puntuacio * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        
    }
}
