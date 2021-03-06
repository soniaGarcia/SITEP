package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoImputadoLog;
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

public interface IngDecomisoImputadoLogRepository extends JpaRepository <IngDecomisoImputadoLog,    Integer >,PagingAndSortingRepository<IngDecomisoImputadoLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoImputadoLog x "
            + "WHERE"  
            + "  (:idDecomisoImputadoLog is null or :idDecomisoImputadoLog = x.idDecomisoImputadoLog )   "
            + " and (:idDecomisoImputado is null or x.idDecomisoImputado = :idDecomisoImputado ) "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:nombre is null or x.nombre = :nombre ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and (:idDecomiso is null or x.idDecomiso = :idDecomiso ) "
            + " ORDER BY x.idDecomisoImputadoLog ASC ")
     Page<IngDecomisoImputadoLog> findByFilters(Pageable page  ,@Param("idDecomisoImputadoLog")  String idDecomisoImputadoLog ,@Param("idDecomisoImputado")  String idDecomisoImputado ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso);

    @Query(value ="SELECT  x.ID_DECOMISO_IMPUTADO_LOG  ,  x.ID_DECOMISO_IMPUTADO  ,  x.F_MOD_FECHA  ,  x.NOMBRE  ,  x.F_CREA_FECHA_LOG  ,  x.F_CREA_FECHA  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  ,  x.ID_DECOMISO  "
            + " FROM ING_DECOMISO_IMPUTADO_LOG x "
            + "WHERE"  
            + "  (:idDecomisoImputadoLog is null or :idDecomisoImputadoLog = x.ID_DECOMISO_IMPUTADO_LOG )   "
            + " and (:idDecomisoImputado is null or x.ID_DECOMISO_IMPUTADO = :idDecomisoImputado ) "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:nombre is null or x.NOMBRE = :nombre ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and (:idDecomiso is null or x.ID_DECOMISO = :idDecomiso ) "
            + " ORDER BY x.ID_DECOMISO_IMPUTADO_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoImputadoLog")  String idDecomisoImputadoLog ,@Param("idDecomisoImputado")  String idDecomisoImputado ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso);

}

