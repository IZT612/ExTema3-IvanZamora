package fecha;

/**
 * Clase que contiene el objeto Fecha el cual guarda día, mes y año y contiene
 * varios métodos relacionados con este
 * 
 * @author ivan.zamora
 */
public class Fecha {
	private int d; // día
	private int m; // mes
	private int a; // año

	/**
	 * Constructor sin parámetros
	 */
	public Fecha() {

	}

	/**
	 * Constructor de Fecha que crea el objeto con los valores introducidos por
	 * parámetro
	 * 
	 * @param dia  = día de la fecha
	 * @param mes  = mes de la fecha
	 * @param anio = año de la fecha
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/**
	 * Método que verifica si la fecha es correcta
	 * 
	 * @return 3 booleanos, uno para cada parte de la fecha, indicando si es
	 * correcta o no
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Método que verifica si una fecha pertenece a un año bisiesto o no
	 * 
	 * Privado porque solo lo usa el método "fechaCorrecta"
	 * 
	 * @return booleano indicando si el año de la fecha es bisiesto o no
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Método que actualiza la fecha al día siguiente según si el proximo día, y/o mes es correcto
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Método que introduce la información e un objeto Fecha en un String
	 * 
	 * @return Un string con la información del objeto
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
