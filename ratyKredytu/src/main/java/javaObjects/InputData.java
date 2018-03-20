package javaObjects;

import java.util.List;

public class InputData {

	private String wKwota;
	private String iloRat;
	private String oproc;
	private String oplataSt;
	private String rodzRat;
	private List<OutputData> ratyLista;
	
	public InputData() {
		
	}
	
	public InputData(String wKwota, String iloRat, String oproc, String oplataSt, String rodzRat,
			List<OutputData> ratyLista) {
		super();
		this.wKwota = wKwota;
		this.iloRat = iloRat;
		this.oproc = oproc;
		this.oplataSt = oplataSt;
		this.rodzRat = rodzRat;
		this.ratyLista = ratyLista;
	}

	public String getwKwota() {
		return wKwota;
	}

	public void setwKwota(String wKwota) {
		this.wKwota = wKwota;
	}

	public String getIloRat() {
		return iloRat;
	}

	public void setIloRat(String iloRat) {
		this.iloRat = iloRat;
	}

	public String getOproc() {
		return oproc;
	}

	public void setOproc(String oproc) {
		this.oproc = oproc;
	}

	public String getOplataSt() {
		return oplataSt;
	}

	public void setOplataSt(String oplataSt) {
		this.oplataSt = oplataSt;
	}

	public String getRodzRat() {
		return rodzRat;
	}

	public void setRodzRat(String rodzRat) {
		this.rodzRat = rodzRat;
	}

	public List<OutputData> getRatyLista() {
		return ratyLista;
	}

	public void setRatyLista(List<OutputData> ratyLista) {
		this.ratyLista = ratyLista;
	}

	@Override
	public String toString() {
		return "inputData [" +
				"wKwota=" + wKwota + 
				", iloRat=" + iloRat + 
				", oproc=" + oproc +
				", oplataSt=" + oplataSt +
				", rodzRat=" + rodzRat +
				", rodzajRat=" + ratyLista +
				"]";
	}
	
}
