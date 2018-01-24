package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoVictimaLog;
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

public interface IngDecomisoVictimaLogRepository extends JpaRepository <IngDecomisoVictimaLog,    Integer >,PagingAndSortingRepository<IngDecomisoVictimaLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoVictimaLog x "
            + "WHERE"  
            + "  (:idDecomisoVictimaLog is null or :idDecomisoVictimaLog = x.idDecomisoVictimaLog )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:idDecomisoVictima is null or x.idDecomisoVictima = :idDecomisoVictima ) "
            + " and (:nombre is null or x.nombre = :nombre ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and (:idDecomiso is null or x.idDecomiso = :idDecomiso ) "
            + " ORDER BY x.idDecomisoVictimaLog ASC ")
     Page<IngDecomisoVictimaLog> findByFilters(Pageable page  ,@Param("idDecomisoVictimaLog")  String idDecomisoVictimaLog ,@Param("fModFecha")  String fModFecha ,@Param("idDecomisoVictima")  String idDecomisoVictima ,@Param("nombre")  String nombre ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso);

    @Query(value ="SELECT  x.ID_DECOMISO_VICTIMA_LOG  ,  x.F_MOD_FECHA  ,  x.ID_DECOMISO_VICTIMA  ,  x.NOMBRE  ,  x.F_CREA_FECHA_LOG  ,  x.F_CREA_FECHA  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  ,  x.ID_DECOMISO  "
            + " FROM ING_DECOMISO_VICTIMA_LOG x "
            + "WHERE"  
            + "  (:idDecomisoVictimaLog is null or :idDecomisoVictimaLog = x.ID_DECOMISO_VICTIMA_LOG )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:idDecomisoVictima is null or x.ID_DECOMISO_VICTIMA = :idDecomisoVictima ) "
            + " and (:nombre is null or x.NOMBRE = :nombre ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and (:idDecomiso is null or x.ID_DECOMISO = :idDecomiso ) "
            + " ORDER BY x.ID_DECOMISO_VICTIMA_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoVictimaLog")  String idDecomisoVictimaLog ,@Param("fModFecha")  String fModFecha ,@Param("idDecomisoVictima")  String idDecomisoVictima ,@Param("nombre")  String nombre ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso);

}

