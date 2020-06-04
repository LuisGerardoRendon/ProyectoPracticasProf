/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ALDO
 */
public class ReporteVO {
  private int numero;
  private int horasReportadas; 
  private String fechaCarga;
  private String estado;
  private String reporte;
  private String fechaInicio;
  private String fechaFin;
  private int idExpediente;

    public ReporteVO(int numero, int horasReportadas, String fechaCarga, String estado, String reporte, String fechaInicio, String fechaFin, int idExpediente) {
        this.numero = numero;
        this.horasReportadas = horasReportadas;
        this.fechaCarga = fechaCarga;
        this.estado = estado;
        this.reporte = reporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idExpediente = idExpediente;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setHorasReportadas(int horasReportadas) {
        this.horasReportadas = horasReportadas;
    }

    public void setFechaCarga(String fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public int getHorasReportadas() {
        return horasReportadas;
    }

    public String getFechaCarga() {
        return fechaCarga;
    }

    public String getEstado() {
        return estado;
    }

    public String getReporte() {
        return reporte;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public int getIdExpediente() {
        return idExpediente;
    }
  
  
}
