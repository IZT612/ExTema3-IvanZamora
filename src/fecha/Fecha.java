package fecha;

public class Fecha {
	public static final int DIEZ = 10;
	private int diaFecha; //d�a
	private int mesFecha; //mes
	private int anioFecha; //a�o

	
	public Fecha() {

	}

	
	public Fecha(int dia, int mes, int anio) {
		this.diaFecha = dia;
		this.mesFecha = mes;
		this.anioFecha = anio;
	}

	
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto; 
		boolean anioCorrecto;
		anioCorrecto = anioFecha > 0;
		mesCorrecto = mesFecha >= 1 && mesFecha <= 12;
		boolean diaMayor1 = diaFecha >= 1;
		switch (mesFecha) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && diaFecha <= 29;
			} else {
				diaCorrecto = diaMayor1 && diaFecha <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && diaFecha <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && diaFecha <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		return anioFecha % 4 == 0 && anioFecha % 100 != 0 || anioFecha % 400 == 0;
	}

	// M�todo diaSiguiente
	public void nextDay() {
		diaFecha++;
		if (!fechaCorrecta()) {
			diaFecha = 1;
			mesFecha++;
			if (!fechaCorrecta()) {
				mesFecha = 1;
				anioFecha++;
			}
		}
	}

	// M�todo toString
	public String toString() {
		String informacion;
		
		if (diaFecha < DIEZ && mesFecha < 10) {
			informacion = ("0" + diaFecha + "-0" + mesFecha + "-" + anioFecha);
		} else if (diaFecha < 10 && mesFecha >= 10) {
			informacion = ("0" + diaFecha + "-" + mesFecha + "-" + anioFecha);
		} else if (diaFecha >= 10 && mesFecha < 10) {
			informacion = (diaFecha + "-0" + mesFecha + "-" + anioFecha);
		} else {
			informacion = (diaFecha + "-" + mesFecha + "-" + anioFecha);
		}
		
		return informacion;
	}

}
