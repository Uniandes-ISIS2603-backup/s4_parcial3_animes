/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.clientes.dtos;

import co.edu.uniandes.csw.clientes.adapters.DateAdapter;
import co.edu.uniandes.csw.clientes.entities.ClienteEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ClienteDTO implements Serializable {

    private Long id;
    private String name;
    private String city;
    private String address;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date aniocreacion;

    /**
     * Constructor vacio
     */
    public ClienteDTO() {
    }

    /**
     * Crea un objeto DTO a partir de un objeto Entity.
     *
     * @param Entity Entidad Entity desde la cual se va a crear el nuevo objeto.
     *
     */
    public ClienteDTO(ClienteEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.name = entity.getName();
            this.aniocreacion = entity.getAniocreacion();
            this.city = entity.getCity();
            this.address = entity.getAddress();

        }
    }

    /**
     * Convierte un objeto DTO a Entity.
     *
     * @return Nueva objeto Entity.
     *
     */
    public ClienteEntity toEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setCity(this.city);
        entity.setAddress(this.address);
        entity.setAniocreacion(this.getAniocreacion());
        return entity;
    }

    /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el atributo name.
     *
     * @return atributo name.
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el valor del atributo name.
     *
     * @param name nuevo valor del atributo
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el atributo descripción
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Ontiene el atributo de imagen
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Establece el atributo de descripción
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Establece la imagen del autor
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * @return the aniocreacion
     */
    public Date getAniocreacion() {
        return aniocreacion;
    }

    /**
     * @param aniocreacion the aniocreacion to set
     */
    public void setAniocreacion(Date aniocreacion) {
        this.aniocreacion = aniocreacion;
    }
}
