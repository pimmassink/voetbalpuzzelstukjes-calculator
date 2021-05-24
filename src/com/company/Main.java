package com.company;

import com.company.models.Puzzel;

public class Main {

    /**
     * Dit programma rekent uit hoe vaak je boodschappen moet doen om voetbalpuzzelstukjes te verzamelen.
     * Bij een puzzel met 30 stukjes, kan je de simulatie (aantalRuns) 100 keer laten draaien.
     * Dan moet je gemiddeld 116 keer boodschappen doen. Sommige mensen hebben de puzzel eerder. Andere later
     */
    public static void main(String[] args) {
        int aantalStukjesInPuzzel = 30;
        CalculatorService calculatorService = new CalculatorService(new Puzzel(aantalStukjesInPuzzel));

        int aantalRuns = 100;
        double average = calculatorService.berekenGemiddeldAantalKeerBoodschappen(aantalRuns);
        System.out.println("Gemiddelde: " + average);
        System.out.println("Run history for " + aantalRuns + " keer boodschappen: " + calculatorService.getRunHistory());
    }
}
