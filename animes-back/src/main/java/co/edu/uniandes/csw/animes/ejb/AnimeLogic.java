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
package co.edu.uniandes.csw.animes.ejb;


import co.edu.uniandes.csw.animes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.animes.entities.AnimeEntity;
import co.edu.uniandes.csw.animes.persistence.AnimePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de
 * .
 *
 * @author ISIS2603
 */
@Stateless
public class AnimeLogic {

    private static final Logger LOGGER = Logger.getLogger(AnimeLogic.class.getName());

    @Inject
    private AnimePersistence persistence;

    /**
     * Se encarga de crear un  en la base de datos.
     *
     * @param empresaEntity Objeto de AnimeEntity con los datos nuevos
     * @return Objeto de AnimeEntity con los datos nuevos y su ID.
     */
    public AnimeEntity create(AnimeEntity empresaEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de creación del autor");
        AnimeEntity newAnimeEntity = persistence.create(empresaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del autor");
        return newAnimeEntity;
    }

    /**
     * Obtiene la lista de los registros de .
     *
     * @return Colección de objetos de AnimeEntity.
     */
    public List<AnimeEntity> gets() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los autores");
        List<AnimeEntity> lista = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los autores");
        return lista;
    }

    /**
     * Obtiene los datos de una instancia de  a partir de su ID.
     *
     * @param authorsId Identificador de la instancia a consultar
     * @return Instancia de AnimeEntity con los datos del  consultado.
     */
    public AnimeEntity get(Long authorsId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el autor con id = {0}", authorsId);
        AnimeEntity empresaEntity = persistence.find(authorsId);
        if (empresaEntity == null) {
            LOGGER.log(Level.SEVERE, "La editorial con el id = {0} no existe", authorsId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el autor con id = {0}", authorsId);
        return empresaEntity;
    }

    /**
     * Actualiza la información de una instancia de .
     *
     * @param authorsId Identificador de la instancia a actualizar
     * @param empresaEntity Instancia de AnimeEntity con los nuevos datos.
     * @return Instancia de AnimeEntity con los datos actualizados.
     */
    public AnimeEntity update(Long authorsId, AnimeEntity empresaEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el autor con id = {0}", authorsId);
        AnimeEntity newAnimeEntity = persistence.update(empresaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el autor con id = {0}", authorsId);
        return newAnimeEntity;
    }

}
