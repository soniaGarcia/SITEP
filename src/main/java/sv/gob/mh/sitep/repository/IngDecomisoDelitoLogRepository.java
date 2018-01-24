package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoDelitoLog;
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

public interface IngDecomisoDelitoLogRepository extends JpaRepository <IngDecomisoDelitoLog,    Integer >,PagingAndSortingRepository<IngDecomisoDelitoLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoDelitoLog x "
            + "WHERE"  
            + "  (:idDecomisoDelitoLog is null or :idDecomisoDelitoLog = x.idDecomisoDelitoLog )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:delito is null or x.delito = :delito ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and (:idDecomisoDelito is null or x.idDecomisoDelito = :idDecomisoDelito ) "
            + " and (:idDecomiso is null or x.idDecomiso = :idDecomiso ) "
            + " ORDER BY x.idDecomisoDelitoLog ASC ")
     Page<IngDecomisoDelitoLog> findByFilters(Pageable page  ,@Param("idDecomisoDelitoLog")  String idDecomisoDelitoLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("delito")  String delito ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomisoDelito")  String idDecomisoDelito ,@Param("idDecomiso")  String idDecomiso);

    @Query(value ="SELECT  x.ID_DECOMISO_DELITO_LOG  ,  x.F_MOD_FECHA  ,  x.F_CREA_FECHA_LOG  ,  x.DELITO  ,  x.F_CREA_FECHA  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  ,  x.ID_DECOMISO_DELITO  ,  x.ID_DECOMISO  "
            + " FROM ING_DECOMISO_DELITO_LOG x "
            + "WHERE"  
            + "  (:idDecomisoDelitoLog is null or :idDecomisoDelitoLog = x.ID_DECOMISO_DELITO_LOG )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:delito is null or x.DELITO = :delito ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and (:idDecomisoDelito is null or x.ID_DECOMISO_DELITO = :idDecomisoDelito ) "
            + " and (:idDecomiso is null or x.ID_DECOMISO = :idDecomiso ) "
            + " ORDER BY x.ID_DECOMISO_DELITO_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoDelitoLog")  String idDecomisoDelitoLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("delito")  String delito ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomisoDelito")  String idDecomisoDelito ,@Param("idDecomiso")  String idDecomiso);

}

