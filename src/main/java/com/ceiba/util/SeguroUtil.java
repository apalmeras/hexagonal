package com.ceiba.util;

public class SeguroUtil {
	private static Double PORCENTAJE = 0.05;
	private static Double COMISION = 0.01;
	private static Double DIVISION = 12.0;

	public static Double getValorPrima(Double valorInmueble) {
		Double valor = 0.0;
		Double valorResultante = ((valorInmueble * PORCENTAJE) / DIVISION);
		Double valorComision = valorResultante * COMISION;
		valor = valorResultante + valorComision;
		return valor;
	}

}
