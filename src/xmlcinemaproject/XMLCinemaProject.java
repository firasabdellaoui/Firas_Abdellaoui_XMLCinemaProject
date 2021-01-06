/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcinemaproject;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import model.XMLDB.DBCinema;
import model.XMLDB.entities.Artiste;
import model.XMLDB.entities.Film;
import model.XMLService;
import model.XPATHService;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author firas
 */
public class XMLCinemaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Chargement du document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            Document document = builder.parse(new File("C:\\films.xml"));
            model.XMLService XMLService = new XMLService();
            model.XPATHService XPathService = new XPATHService();
            XMLService.RestituerTousObjetXML(document);
            System.out.println("Début du parsing");
            System.out.println("----Listing Films-------");
            for (Film f : DBCinema._listFilm) {
                System.out.println(f.getTitre());
            }
            System.out.println("----Listing Artistes--------");
            for (Artiste a : DBCinema._listArtiste) {
                System.out.println(a.getPrenom());
            }
            NodeList result = XPathService.getNodesFromXpath("//ARTISTE[@id=52]/ACTNOM", document);
            System.out.println("Résultat d'une requete XPATH :" + result.item(0).getTextContent());
            XMLService.UpdateXMLFileWithRoleNumber(document);

            DOMSource source = new DOMSource(document);
            StreamResult sortie = new StreamResult(new File("films3.xml"));
            try {
                transformer.transform(source,sortie);
            } catch (TransformerException ex) {
                Logger.getLogger(XMLCinemaProject.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLCinemaProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLCinemaProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
        }
        catch (Exception ex) {
        }

    }

}
