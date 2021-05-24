package com.company;

import com.company.models.Plaatje;
import com.company.models.Puzzel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CalculatorService {

    public CalculatorService(Puzzel puzzel) {
        this.puzzel = puzzel;
    }

    private List<Integer> runHistory = new ArrayList<>();
    private Puzzel puzzel;

    public double berekenGemiddeldAantalKeerBoodschappen(int aantalRuns) {
        while (aantalRuns > 0) {
            doeBoodschappenTotVerzamelingCompleet();
            aantalRuns--;
        }
        double gemiddelde = this.runHistory.stream().mapToDouble(e -> e).average().getAsDouble();
        return gemiddelde;
    }

    /**
     * Dit is één enkele run. Gegeven het aantal plaatjes gaan we boodschappen doen tot de verzameling compleet is.
     * We nemen aan dat de kans dat we een bepaald plaatje krijgen willekeurig is.
     * Er zijn dus geen 'extra zeldzame' plaatjes.
     */
    private void doeBoodschappenTotVerzamelingCompleet() {
        List<Plaatje> verzameling = new ArrayList<>();
        while (!isCompleet(verzameling)) {
            doeBoodschappen(verzameling);
        }
        this.runHistory.add(verzameling.size());
    }

    private void doeBoodschappen(List<Plaatje> verzameling) {
        Plaatje nieuwPlaatje = generatePlaatje();
        verzameling.add(nieuwPlaatje);
    }

    /**
     * We nemen aan dat de kans dat we een bepaald plaatje krijgen willekeurig is.
     * Er zijn dus geen 'extra zeldzame' plaatjes.
     */
    private Plaatje generatePlaatje() {
        Random random = new Random();
        return new Plaatje(random.nextInt(this.puzzel.getAantalPlaatjesInPuzzel()));
    }

    /**
     * We beschouwen een verzameling compleet als het aantal unieke stukjes gelijk is aan het aantal plaatjes in de puzzel
     */
    private boolean isCompleet(List<Plaatje> verzameling) {
        return telAantalUniekeStukjes(verzameling) == this.puzzel.getAantalPlaatjesInPuzzel();
    }

    /**
     * We verwijderen alle duplicaten uit de verzameling, en kijken dan hoe lang ie is.
     */
    public int telAantalUniekeStukjes(List<Plaatje> verzameling) {
        List<Integer> listOfIds = verzameling.stream().map(Plaatje::getId).collect(Collectors.toList());
        List<Integer> nonDuplicateList = createNonDuplicateList(new ArrayList<>(listOfIds));
        return nonDuplicateList.size();
    }

    public List<Integer> createNonDuplicateList(List<Integer> inputList) {
        List<Integer> result = new ArrayList<>();
        inputList.forEach(element -> {
            if (! result.contains(element)) {
                result.add(element);
            }
        });
        return result;
    }

    public List<Integer> getRunHistory() {
        return runHistory;
    }
}
