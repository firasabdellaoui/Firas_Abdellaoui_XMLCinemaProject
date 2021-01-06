/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.XMLDB.entities;
import java.util.List;
import model.XMLDB.entities.Role;
/**
 *
 * @author firas
 */
public class Film
{
    int _annee;
    String _titre;
    String _genre;
    String _pays;
    int _mes;
    List<Role> _roles;
    
    public Film(){}

    public Film(int _annee, String _titre, String _genre, String _pays, int _mes, List<Role> _roles) {
        this._annee = _annee;
        this._titre = _titre;
        this._genre = _genre;
        this._pays = _pays;
        this._mes = _mes;
        this._roles = _roles;
    }

    public int getAnnee() {
        return _annee;
    }

    public void setAnnee(int _annee) {
        this._annee = _annee;
    }

    public String getTitre() {
        return _titre;
    }

    public void setTitre(String _titre) {
        this._titre = _titre;
    }

    public String getGenre() {
        return _genre;
    }

    public void setGenre(String _genre) {
        this._genre = _genre;
    }

    public String getPays() {
        return _pays;
    }

    public void setPays(String _pays) {
        this._pays = _pays;
    }

    public int getMes() {
        return _mes;
    }

    public void setMes(int _mes) {
        this._mes = _mes;
    }

    public List<Role> getRole() {
        return _roles;
    }

    public void setRole(List<Role> _roles) {
        this._roles = _roles;
    }
    
            
}
