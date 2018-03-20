package control;

import javaObjects.OutputData;

import java.util.ArrayList;
import java.util.List;

import javaObjects.InputData;


public class Calculator {
	
    private double wKredytu(InputData c) {
        return Double.parseDouble(c.getwKwota());
    }

    private double iloRat(InputData c) {
        return Double.parseDouble(c.getIloRat());
    }

    private double oprocentowanie(InputData c) {
        return Double.parseDouble(c.getOproc());
    }

    private double stopaDostosowana(InputData c) {
        return (oprocentowanie(c) * 0.01) / iloRat(c);
    }

    private double oplataSt(InputData c) {
        return Double.parseDouble(c.getOplataSt());
    }

	public List<OutputData> upHarmonogram(InputData c){
		if (c.getRodzRat().equals("stale")) {
			return upHarmonogramRatStal(c);
		}
		return upHarmonogramRatMal(c);
	}
	
	private List<OutputData> upHarmonogramRatMal(InputData c) {
        List<OutputData> harmonogramRat = new ArrayList<>();
        for (int i = 1; i <= iloRat(c); i++) {
            harmonogramRat.add(new OutputData(i, jednaRataBezOprocentowania(c), pojedynczyKosztStaly(c), jednaRataMalejaca(c, i)));
        }
        return harmonogramRat;

    }

    private List<OutputData> upHarmonogramRatStal(InputData c) {
        List<OutputData> harmonogramRat = new ArrayList<>();
        for (int i = 1; i <= iloRat(c); i++) {
            harmonogramRat.add(new OutputData(i, jednaRataBezOprocentowania(c), pojedynczyKosztStaly(c), jednaRataRowna(c)));
        }
        return harmonogramRat;
    }

    private double jednaRataMalejaca(InputData c, int rata) {
        return Math.round(wKredytu(c) * (1 + ((iloRat(c) - rata) + 1) * stopaDostosowana(c)) / iloRat(c) * 100d) / 100d;
    }

    private double jednaRataRowna(InputData c) {
        return Math.round(wKredytu(c) * stopaDostosowana(c) * Math.pow((stopaDostosowana(c) + 1), iloRat(c)) /
                ((Math.pow(stopaDostosowana(c) + 1, iloRat(c))) - 1) * 100d) / 100d;
    }

    private double pojedynczyKosztStaly(InputData c) {
        return Math.round(oplataSt(c) / iloRat(c) * 100d) / 100d;
    }

    private double jednaRataBezOprocentowania(InputData c) {
        return Math.round(wKredytu(c) / iloRat(c) * 100d) / 100d;
    }


}
