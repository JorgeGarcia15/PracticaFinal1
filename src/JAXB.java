
import javaVideojuegos.Videojuegos;
import java.io.File;

import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import javax.xml.bind.Unmarshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xp
 */
public class JAXB {

    Videojuegos misVideojuegos;

    public int abrir_XML_JAXB() {
        JAXBContext contexto;
      
        try {
            File fichero = new File("Videojuegos.xml");
//Crea una instancia JAXB
            contexto = JAXBContext.newInstance(Videojuegos.class);
//Crea un objeto Unmarsheller.
            Unmarshaller u = contexto.createUnmarshaller();
//Deserializa (unmarshal) el fichero
                
            misVideojuegos = (Videojuegos) u.unmarshal(fichero);
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    
    
    public String ModificarJAXB(String _id, String modificacion, String eleccion) {
        String datos_nodo[] = null;
        String cadena_resultado = "";
//Crea una lista con objetos de tipo libro.
        List<Videojuegos.Videojuego> lVideojuegos = misVideojuegos.getVideojuego();
//Recorre la lista para sacar los valores.
        for (int i = 0; i < lVideojuegos.size(); i++){
            
          if(lVideojuegos.get(i).getId().equals(_id) && eleccion.equals("Lanzamiento")){
            
            lVideojuegos.get(i).setLanzadoEn(modificacion);
            
            }
            if(lVideojuegos.get(i).getId().equals(_id) && eleccion.equals("Empresa")){
            
            lVideojuegos.get(i).setEmpresa(modificacion);
            
            }
            if(lVideojuegos.get(i).getId().equals(_id) && eleccion.equals("Genero")){
            
            lVideojuegos.get(i).setGenero(modificacion);
            
            }
            cadena_resultado = cadena_resultado + "\n" + "La Empresa es: " + lVideojuegos.get(i).getEmpresa();
            
            if(lVideojuegos.get(i).getId().equals(_id) && eleccion.equals("Tipo")){
            
            lVideojuegos.get(i).setPEGI(modificacion);
            
            }
            
            cadena_resultado = cadena_resultado + "\n" + "El Genero es: " + lVideojuegos.get(i).getGenero();
            
            cadena_resultado = cadena_resultado + "\n" + "La Plataforma es: " + lVideojuegos.get(i).getPlataforma();
            
            cadena_resultado = cadena_resultado + "\n" + "El precio es: " + lVideojuegos.get(i).getPrecio();
            
            cadena_resultado = cadena_resultado + "\n ------------------------------";
        }
        return cadena_resultado;
    }
    
    public void guardarJAXB(){
    
        JAXBContext contexto;
      
        try {
            File fichero = new File("Videojuegos.xml");
//Crea una instancia JAXB
            contexto = JAXBContext.newInstance(Videojuegos.class);
//Crea un objeto Unmarsheller.
            Marshaller m = contexto.createMarshaller();
            
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//Deserializa (unmarshal) el fichero
                
           m.marshal(misVideojuegos, fichero);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        
        
    
    }

}
