/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.Converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jean
 */
@FacesConverter("statusTrabConverter")
public class StatusTrabConverter implements Converter {

    private final int PENDENTE = 0;
    private final int ENVIADO = 1;
    private final int VALIDADO = 2;
    private final int INVALIDADO = 3;
    private final int ACEITO = 4;
    private final int CORRIGIR = 5;
    private final int EM_CORRECAO = 6;
    private final int CORRIGIDO = 7;
    private final int RECUSADO = 8;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value == null) {
            return "";
        }
        int status = (int) value;

        switch (status) {
            case PENDENTE:
                return "Pendente";
            case ENVIADO:
                return "Enviado";
            case VALIDADO:
                return "Validado";
            case INVALIDADO:
                return "Invalidado";
            case ACEITO:
                return "Aceito";
            case CORRIGIR:
                return "Corrigir";
            case EM_CORRECAO:
                return "Em Correção";
            case CORRIGIDO:
                return "Corrigido";
            case RECUSADO:
                return "Recusado";
            default:
                return "status desconhecido";
        }
    }

}
