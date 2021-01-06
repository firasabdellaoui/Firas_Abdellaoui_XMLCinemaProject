/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.XMLDB.entities;

/**
 *
 * @author firas
 */
public class Artiste
{
    int _id;
    String _nom;
    String _prenom;
    String _dateNaiss;

    public Artiste(int id,String _nom, String _prenom, String _dateNaiss) {
        this._nom = _nom;
        this._prenom = _prenom;
        this._dateNaiss = _dateNaiss;
        _id=id;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getPrenom() {
        return _prenom;
    }

    public void setPrenom(String _prenom) {
        this._prenom = _prenom;
    }

    public String getDateNaiss() {
        return _dateNaiss;
    }

    public void setDateNaiss(String _dateNaiss) {
        this._dateNaiss = _dateNaiss;
    }
    
}
