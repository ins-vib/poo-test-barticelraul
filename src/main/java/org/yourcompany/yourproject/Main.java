package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pregunta> preguntes = inicialitzarPreguntes();
        Test test = new Test(preguntes);
        Scanner sc = new Scanner(System.in);
        boolean finalitzat = false;
        while (!finalitzat) {
            System.out.println("Pregunta " + (test.getNumeroPregunta() + 1) + ". " + test.getEnunciatPreguntaActual());
            String[] respostes = test.getRespostesPreguntaActual();
            for (int i = 0; i < respostes.length; i++) {
                System.out.println((i + 1) + ". " + respostes[i]);
            }
            System.out.println("Tria una opció: (1) Endarrera - (2) Respondre - (3) Endavant - (4) Finalitzar");
            int opcio = sc.nextInt();
            switch (opcio) {
                case 1:
                    if (!test.anarEndarrera()) {
                        System.out.println("No pots anar més enrere.");
                    }
                    break;
                case 2:
                    System.out.print("La teva resposta és: ");
                    int resposta = sc.nextInt() - 1;
                    test.respondre(resposta);
                    break;
                case 3:
                    if (!test.anarEndavant()) {
                        System.out.println("No pots anar més endavant.");
                    }
                    break;
                case 4:
                    finalitzat = true;
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        }
        double nota = test.solucionarTest();
        System.out.println("Has aconseguit un " + nota);
        sc.close();
    }

    public static ArrayList<Pregunta> inicialitzarPreguntes() {
        ArrayList<Pregunta> preguntes = new ArrayList<>();
        preguntes.add(new Pregunta("Qui va pintar el Guernica", new String[]{"Velàzquez", "Goya", "Picasso"}, 2));
        preguntes.add(new Pregunta("Qui va escriure Alicia al país de les meravelles", new String[]{"Grimm", "Stevenson", "Carrol"}, 2));
        preguntes.add(new Pregunta("Quina és la magnitud que relaciona espai i temps", new String[]{"velocitat", "temperatura", "pes"}, 0));
        preguntes.add(new Pregunta("Si el radi d'una circumferència és 4, el seu diàmetre és", new String[]{"4", "8", "12", "14"}, 1));
        preguntes.add(new Pregunta("Quants segons té 1 hora", new String[]{"420", "760", "3600"}, 2));
        preguntes.add(new Pregunta("Quin no és un llenguatge de programació", new String[]{"java", "php", "samsung"}, 2));
        preguntes.add(new Pregunta("Dins un termòmetre hi trobem", new String[]{"aigua", "aigua amb gas", "mercuri"}, 2));
        preguntes.add(new Pregunta("L'Acropolis es troba a", new String[]{"Atenes", "Roma", "París"}, 0));
        preguntes.add(new Pregunta("L'element químic amb símbol Fe és ", new String[]{"Estronci", "Ferro", "Feril·li"}, 1));
        preguntes.add(new Pregunta("La capital d'Estats Units és", new String[]{"Georgetown", "New York", "Washington"}, 2));
        return preguntes;
    }
}
