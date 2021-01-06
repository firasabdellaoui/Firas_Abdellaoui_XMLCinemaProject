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
public class Role
{
    String _nom;
    String _prenom;
    String _intitule;

    public Role(String _nom, String _prenom, String _intitule) {
        this._nom = _nom;
        this._prenom = _prenom;
        this._intitule = _intitule;
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

    public String getIntitule() {
        return _intitule;
    }

    public void setIntitule(String _intitule) {
        this._intitule = _intitule;
    }
    
    
}