
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.XMLDB.*;
import model.XMLDB.entities.Artiste;
import model.XMLDB.entities.Film;
import model.XMLDB.entities.Role;
import org.w3c.dom.*;

/**
 *
 * @author firas
 */
public class XMLService {
    private Object transformer;

    public void RestituerTousObjetXML(Document document) {
        //Restitution des films
        Element racine = document.getDocumentElement();
        NodeList enfantsCinema = racine.getChildNodes();
        int length = enfantsCinema.getLength();
        for (int i = 0; i < length; i++) {
            if (enfantsCinema.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) enfantsCinema.item(i);
                switch (el.getNodeName()) {
                    case "FILM":
                        DBCinema._listFilm.add(TraiterNoeudFim(el));
                        break;
                    case "ARTISTE":
                        DBCinema._listArtiste.add(TraiterNoeudArtiste(el));
                        break;
                }
            }
        }
    }

    Film TraiterNoeudFim(Element elFilm) {
        int idfilm = Integer.parseInt(elFilm.getAttribute("Annee"));
        String titre = elFilm.getElementsByTagName("TITRE").item(0).getTextContent();
        String genre = elFilm.getElementsByTagName("GENRE").item(0).getTextContent();
        String pays = elFilm.getElementsByTagName("PAYS").item(0).getTextContent();
        int mes = Integer.parseInt(((Element) elFilm.getElementsByTagName("MES").item(0)).getAttribute("idref"));
        NodeList roles = elFilm.getElementsByTagName("ROLES").item(0).getChildNodes();
        List<Role> listeRoles = new ArrayList<Role>();
        int nbEnfantRoles = roles.getLength();
        for (int j = 0; j < nbEnfantRoles; j++) {
            if (roles.item(j).getNodeType() == Node.ELEMENT_NODE) {
                Element elRole = (Element) roles.item(j);
                String prenom = elFilm.getAttribute("PRENOM");
                String nom = elFilm.getElementsByTagName("NOM").item(0).getTextContent();
                String intitule = elFilm.getElementsByTagName("INTITULE").item(0).getTextContent();
                Role role = new Role(prenom, nom, intitule);
                listeRoles.add(role);

            }
        }

        return new Film(idfilm, titre, genre, pays, mes, listeRoles);
    }

    Artiste TraiterNoeudArtiste(Element elArtiste) {
        int idArtiste = Integer.parseInt(elArtiste.getAttribute("id"));
        String nom = elArtiste.getElementsByTagName("ACTNOM").item(0).getTextContent();
        String prenom = elArtiste.getElementsByTagName("ACTPNOM").item(0).getTextContent();
        String nais = elArtiste.getElementsByTagName("ANNEENAISS").item(0).getTextContent();
        return new Artiste(idArtiste, nom, prenom, nais);
    }

    public void UpdateXMLFileWithRoleNumber(Document document) {
        XPATHService XPathService = new XPATHService();
        NodeList roles = XPathService.getNodesFromXpath("//FILM/ROLES", document);
        //Number count =XPathService.getNumberFromXpath("count(//FILM/ROLES)",document);
        //System.out.println(count);
        int length = roles.getLength();
        for (int i = 0; i < length; i++) {
            if (roles.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Number count = XPathService.getNumberFromXpath("count(ROLE)", roles.item(i));
                Element nombreRole = document.createElement("NOMBRE");
                nombreRole.setTextContent(count.toString());
                roles.item(i).appendChild(nombreRole);
                System.out.println(count);
            }
        }
      
    }

}
