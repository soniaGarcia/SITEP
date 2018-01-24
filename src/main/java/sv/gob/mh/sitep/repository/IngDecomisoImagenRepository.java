package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoImagen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngDecomisoImagenRepository extends JpaRepository <IngDecomisoImagen,    Integer >,PagingAndSortingRepository<IngDecomisoImagen,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoImagen x "
            + "WHERE"  
            + "  (:idDecomisoImagen is null or :idDecomisoImagen = x.idDecomisoImagen )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:archivo is null or x.archivo = :archivo ) "
            + " and (:nombreArchivo is null or x.nombreArchivo = :nombreArchivo ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and (:idDecomiso is null or x.idDecomiso = :idDecomiso ) "
            + " ORDER BY x.idDecomisoImagen ASC ")
     Page<IngDecomisoImagen> findByFilters(Pageable page  ,@Param("idDecomisoImagen")  String idDecomisoImagen ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("archivo")  String archivo ,@Param("nombreArchivo")  String nombreArchivo ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso);

    @Query(value ="SELECT  x.ID_DECOMISO_IMAGEN  ,  x.F_MOD_FECHA  ,  x.F_CREA_FECHA_LOG  ,  x.ARCHIVO  ,  x.NOMBRE_ARCHIVO  ,  x.F_CREA_FECHA  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  ,  x.ID_DECOMISO  "
            + " FROM ING_DECOMISO_IMAGEN x "
            + "WHERE"  
            + "  (:idDecomisoImagen is null or :idDecomisoImagen = x.ID_DECOMISO_IMAGEN )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:archivo is null or x.ARCHIVO = :archivo ) "
            + " and (:nombreArchivo is null or x.NOMBRE_ARCHIVO = :nombreArchivo ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and (:idDecomiso is null or x.ID_DECOMISO = :idDecomiso ) "
            + " ORDER BY x.ID_DECOMISO_IMAGEN ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoImagen")  String idDecomisoImagen ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("archivo")  String archivo ,@Param("nombreArchivo")  String nombreArchivo ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso);

}

