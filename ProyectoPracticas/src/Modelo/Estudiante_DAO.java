/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import javafx.collections.ObservableList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface Estudiante_DAO {
    public ObservableList<ReporteVO> recuperarReportes(String periodo, String matricula);
    public ProyectoVO recuperarProyecto(String periodo, String matricula);
} 
