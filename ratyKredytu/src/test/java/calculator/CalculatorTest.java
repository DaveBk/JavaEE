package calculator;




import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import control.Calculator;
import javaObjects.InputData;
import javaObjects.OutputData;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

	List<OutputData> raty = new ArrayList<>();
	List<OutputData> ratyLista = new ArrayList<>();
	Calculator c = new Calculator();
	InputData rStala;
	InputData rMalejaca;
	
	@Before
	public void setup() {
		raty.add(new OutputData(1, 2000, 50, 2020));
		raty.add(new OutputData(2, 3000, 50, 3020));
		raty.add(new OutputData(3, 4000, 50, 4020));
		raty.add(new OutputData(4, 5000, 50, 5020));
		rStala = new InputData("1000","4","3","200","stale",raty) ;
		rMalejaca = new InputData("1000","4","3","200","malejace",raty) ;
		
	}
	
    @Test
    public void upHarmonogram_rozmiarHarmonogramu_staleRaty() {
        //when
    	ratyLista = c.upHarmonogram(rStala);

        //then
        assertThat(raty.size() == ratyLista.size()).isTrue();
    }
    @Test
    public void upHarmonogram_wysokoscKapitalu_staleRaty(){
        //when
    	ratyLista = c.upHarmonogram(rStala);
        int sum = 0;
        for(OutputData  i : ratyLista){
            sum += i.getKapital();
        }
        //then

        assertThat(sum).isEqualTo(Integer.parseInt(rStala.getwKwota()));
    }

    @Test
    public void upHarmonigram_WysokoscPojedynczegoKosztuStalego_staleRaty(){
        //when
    	ratyLista = c.upHarmonogram(rStala);
        int suma = 0;
        for(OutputData i : raty){
            suma += i.getOplata();
        }
        //then
        assertThat(suma).isEqualTo(Integer.parseInt(rStala.getOplataSt()));
    }

    @Test
    public void upHarmonogram_rozmiarHarmonogramu_malejaceRaty() {
        //when
    	ratyLista = c.upHarmonogram(rMalejaca);

        //then
        assertThat(raty.size() == ratyLista.size()).isTrue();
    }
    @Test
    public void upHarmonogram_wysokoscKapitalu_malejaceRaty(){
        //when
    	ratyLista = c.upHarmonogram(rMalejaca);
        int sum = 0;
        for(OutputData  i : ratyLista){
            sum += i.getKapital();
        }
        //then

        assertThat(sum).isEqualTo(Integer.parseInt(rMalejaca.getwKwota()));
    }

    @Test
    public void upHarmonigram_WysokoscPojedynczegoKosztuStalego_malejaceRaty(){
        //when
    	ratyLista = c.upHarmonogram(rMalejaca);
        int suma = 0;
        for(OutputData i : raty){
            suma += i.getOplata();
        }
        //then
        assertThat(suma).isEqualTo(Integer.parseInt(rMalejaca.getOplataSt()));
    }
}