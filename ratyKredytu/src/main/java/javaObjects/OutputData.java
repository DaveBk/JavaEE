package javaObjects;

public class OutputData {
	private int numer;
	private double kapital;
	private double odsetki;
	private double oplata;
	private double calkowitaKwota;
	
	public OutputData(int numer, double kapital, double oplata, double calkowitaKwota) {
		this.numer = numer;
		this.kapital = kapital;
		this.odsetki = Math.round((calkowitaKwota - kapital)*100d)/100d;
		this.oplata = oplata;
		this.calkowitaKwota = calkowitaKwota;
	}

	public int getNumer() {
		return numer;
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}

	public double getKapital() {
		return kapital;
	}

	public void setKapital(double kapital) {
		this.kapital = kapital;
	}

	public double getOdsetki() {
		return odsetki;
	}

	public void setOdsetki(double odsetki) {
		this.odsetki = odsetki;
	}

	public double getOplata() {
		return oplata;
	}

	public void setOplata(double oplata) {
		this.oplata = oplata;
	}

	public double getCalkowitaKwota() {
		return calkowitaKwota;
	}

	public void setCalkowitaKwotaRaty(double calkowitaKwota) {
		this.calkowitaKwota = calkowitaKwota;
	}

	@Override
	public String toString() {
		return "outputData [" +
				"numer=" + numer + 
				", kapital=" + kapital + 
				", odsetki=" + odsetki + 
				", oplata=" + oplata +
				", calkowitaKwotaRaty=" + calkowitaKwota + 
				"]";
	}
	
}
