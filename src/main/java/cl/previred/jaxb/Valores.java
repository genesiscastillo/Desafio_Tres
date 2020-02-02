//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.02.02 a las 11:23:51 AM CLST 
//


package cl.previred.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UFs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="UF" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="dato" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inicio",
    "fin",
    "uFs"
})
@XmlRootElement(name = "valores")
public class Valores {

    @XmlElement(required = true)
    protected String inicio;
    @XmlElement(required = true)
    protected String fin;
    @XmlElement(name = "UFs", required = true)
    protected Valores.UFs uFs = new UFs();

    /**
     * Obtiene el valor de la propiedad inicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * Define el valor de la propiedad inicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInicio(String value) {
        this.inicio = value;
    }

    /**
     * Obtiene el valor de la propiedad fin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFin() {
        return fin;
    }

    /**
     * Define el valor de la propiedad fin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFin(String value) {
        this.fin = value;
    }

    /**
     * Obtiene el valor de la propiedad uFs.
     * 
     * @return
     *     possible object is
     *     {@link Valores.UFs }
     *     
     */
    public Valores.UFs getUFs() {
        return uFs;
    }

    /**
     * Define el valor de la propiedad uFs.
     * 
     * @param value
     *     allowed object is
     *     {@link Valores.UFs }
     *     
     */
    public void setUFs(Valores.UFs value) {
        this.uFs = value;
    }

    
    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="UF" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="dato" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "uf"
    })
    public static class UFs {

        @XmlElement(name = "UF", required = true)
        protected List<Valores.UFs.UF> uf = new ArrayList<>();

        /**
         * Gets the value of the uf property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the uf property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUF().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Valores.UFs.UF }
         * 
         * 
         */
        public List<Valores.UFs.UF> getUF() {
            if (uf == null) {
                uf = new ArrayList<Valores.UFs.UF>();
            }
            return this.uf;
        }

        public void add(Valores.UFs.UF uf) {
        	this.uf.add(uf);
        }

        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="dato" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "fecha",
            "dato"
        })
        public static class UF {

            @XmlElement(required = true)
            protected String fecha;
            @XmlElement(required = true)
            protected String dato;

            public UF() {
            	super();
            }
            
            public UF(String fecha , String dato) {
            	this.fecha = fecha;
            	this.dato = dato;
            }
            
            /**
             * Obtiene el valor de la propiedad fecha.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFecha() {
                return fecha;
            }

            /**
             * Define el valor de la propiedad fecha.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFecha(String value) {
                this.fecha = value;
            }

            /**
             * Obtiene el valor de la propiedad dato.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDato() {
                return dato;
            }

            /**
             * Define el valor de la propiedad dato.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDato(String value) {
                this.dato = value;
            }

        }

    }

}
