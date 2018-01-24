package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoMonedaLog;
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

public interface IngDecomisoMonedaLogRepository extends JpaRepository <IngDecomisoMonedaLog,    Integer >,PagingAndSortingRepository<IngDecomisoMonedaLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoMonedaLog x "
            + "WHERE"  
            + "  (:idDecomisoMonedaLog is null or :idDecomisoMonedaLog = x.idDecomisoMonedaLog )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:idDecomisoMoneda is null or x.idDecomisoMoneda = :idDecomisoMoneda ) "
            + " and (:monto is null or x.monto = :monto ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and (:idDecomiso is null or x.idDecomiso = :idDecomiso ) "
            + " and (:moneda is null or x.moneda = :moneda ) "
            + " ORDER BY x.idDecomisoMonedaLog ASC ")
     Page<IngDecomisoMonedaLog> findByFilters(Pageable page  ,@Param("idDecomisoMonedaLog")  String idDecomisoMonedaLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("fCreaFecha")  String fCreaFecha ,@Param("idDecomisoMoneda")  String idDecomisoMoneda ,@Param("monto")  String monto ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso ,@Param("moneda")  String moneda);

    @Query(value ="SELECT  x.ID_DECOMISO_MONEDA_LOG  ,  x.F_MOD_FECHA  ,  x.F_CREA_FECHA_LOG  ,  x.F_CREA_FECHA  ,  x.ID_DECOMISO_MONEDA  ,  x.MONTO  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  ,  x.ID_DECOMISO  ,  x.MONEDA  "
            + " FROM ING_DECOMISO_MONEDA_LOG x "
            + "WHERE"  
            + "  (:idDecomisoMonedaLog is null or :idDecomisoMonedaLog = x.ID_DECOMISO_MONEDA_LOG )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:idDecomisoMoneda is null or x.ID_DECOMISO_MONEDA = :idDecomisoMoneda ) "
            + " and (:monto is null or x.MONTO = :monto ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and (:idDecomiso is null or x.ID_DECOMISO = :idDecomiso ) "
            + " and (:moneda is null or x.MONEDA = :moneda ) "
            + " ORDER BY x.ID_DECOMISO_MONEDA_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoMonedaLog")  String idDecomisoMonedaLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("fCreaFecha")  String fCreaFecha ,@Param("idDecomisoMoneda")  String idDecomisoMoneda ,@Param("monto")  String monto ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("idDecomiso")  String idDecomiso ,@Param("moneda")  String moneda);

}

