
import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xp
 */
public class SAX {

    SAXParser parser;

    SAX.ManejadorSAX sh;

    File ficheroXML;

    public int abrir_XML_SAX(File fichero) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
//Se crea un objeto SAXParser para interpretar el documento XML.
            parser = factory.newSAXParser();
//Se crea una instancia del manejador que será el que recorra
//el documento XML secuencialmente
            sh = new ManejadorSAX();
           
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    class ManejadorSAX extends DefaultHandler {

        int ultimoelement;
        String cadena_resultado = "";

        public ManejadorSAX() {
            ultimoelement = 0;
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes atts) throws SAXException {

            //A?ado este condicional para que cuando me encuentre la etiqueta libros me ponga el texto
            if (qName.equals("Videojuegos")) {
                cadena_resultado = cadena_resultado + "Videojuegos encontrados:"
                        + "\n" + "*********************************************" + "\n";
            } else if (qName.equals("Videojuego")) {
                cadena_resultado = cadena_resultado + "\nLanzado en: "
                        + atts.getValue(atts.getQName(0)) + "\n";
                ultimoelement = 1;
            } else if (qName.equals("id")) {
                ultimoelement = 2;
                cadena_resultado = cadena_resultado.trim() + "\nEl id es: ";
            } else if (qName.equals("Nombre")) {
                ultimoelement = 3;
                cadena_resultado = cadena_resultado.trim() + "\nEl nombre es: ";
            } else if (qName.equals("Empresa")) {
                ultimoelement = 4;
                cadena_resultado = cadena_resultado.trim() + "\nLa empresa es: ";
            } else if (qName.equals("PEGI")) {
                ultimoelement = 5;
                cadena_resultado = cadena_resultado.trim() + "\nPEGI: ";
            } else if (qName.equals("Genero")) {
                ultimoelement = 6;
                cadena_resultado = cadena_resultado.trim() + "\nEl genero es: ";
            } else if (qName.equals("Plataforma")) {
                ultimoelement = 7;
                cadena_resultado = cadena_resultado.trim() + "\nLa plataforma es: ";
            } else if (qName.equals("Precio")) {
                ultimoelement = 8;
                cadena_resultado = cadena_resultado.trim() + "\nEl precio es: ";
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equals("Videojuego")) {

                cadena_resultado = cadena_resultado + "\n -------------------";
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws
                SAXException {
            if (ultimoelement == 2) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
            } else if (ultimoelement == 3) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }

            } else if (ultimoelement == 4) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
            } else if (ultimoelement == 5) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
            } else if (ultimoelement == 6) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
            } else if (ultimoelement == 7) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
            } else if (ultimoelement == 8) {
                for (int i = start; i < length + start; i++) {
                    cadena_resultado = cadena_resultado + ch[i];
                }
            }
        }
        
    }

        public String recorrerSAX() {
            try {
                parser.parse("Videojuegos.xml", sh);
                return sh.cadena_resultado;
            } catch (SAXException e) {
                e.printStackTrace();
                return "Error al parsear con SAX";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error al parsear con SAX";
            }
        }

    
}
