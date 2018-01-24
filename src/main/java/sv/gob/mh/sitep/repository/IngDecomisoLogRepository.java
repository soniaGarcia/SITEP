package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoLog;
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

public interface IngDecomisoLogRepository extends JpaRepository <IngDecomisoLog,    Integer >,PagingAndSortingRepository<IngDecomisoLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoLog x "
            + "WHERE"  
            + "  (:idDecomisoLog is null or :idDecomisoLog = x.idDecomisoLog )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:numeroOficio is null or x.numeroOficio = :numeroOficio ) "
            + " and (:idEmbalaje is null or x.idEmbalaje = :idEmbalaje ) "
            + " and (:idEstado is null or x.idEstado = :idEstado ) "
            + " and (:referencia is null or x.referencia = :referencia ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:fechaOficio is null or x.fechaOficio = :fechaOficio ) "
            + " and (:ordenIdSede is null or x.ordenIdSede = :ordenIdSede ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:idSede is null or x.idSede = :idSede ) "
            + " and (:idDecomiso is null or x.idDecomiso = :idDecomiso ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " ORDER BY x.idDecomisoLog ASC ")
     Page<IngDecomisoLog> findByFilters(Pageable page  ,@Param("idDecomisoLog")  String idDecomisoLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("numeroOficio")  String numeroOficio ,@Param("idEmbalaje")  String idEmbalaje ,@Param("idEstado")  String idEstado ,@Param("referencia")  String referencia ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fechaOficio")  String fechaOficio ,@Param("ordenIdSede")  String ordenIdSede ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("idSede")  String idSede ,@Param("idDecomiso")  String idDecomiso ,@Param("sModUsuario")  String sModUsuario);

    @Query(value ="SELECT  x.ID_DECOMISO_LOG  ,  x.F_MOD_FECHA  ,  x.F_CREA_FECHA_LOG  ,  x.NUMERO_OFICIO  ,  x.ID_EMBALAJE  ,  x.ID_ESTADO  ,  x.REFERENCIA  ,  x.S_CREA_USUARIO  ,  x.FECHA_OFICIO  ,  x.ORDEN_ID_SEDE  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.ID_SEDE  ,  x.ID_DECOMISO  ,  x.S_MOD_USUARIO  "
            + " FROM ING_DECOMISO_LOG x "
            + "WHERE"  
            + "  (:idDecomisoLog is null or :idDecomisoLog = x.ID_DECOMISO_LOG )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:numeroOficio is null or x.NUMERO_OFICIO = :numeroOficio ) "
            + " and (:idEmbalaje is null or x.ID_EMBALAJE = :idEmbalaje ) "
            + " and (:idEstado is null or x.ID_ESTADO = :idEstado ) "
            + " and (:referencia is null or x.REFERENCIA = :referencia ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:fechaOficio is null or x.FECHA_OFICIO = :fechaOficio ) "
            + " and (:ordenIdSede is null or x.ORDEN_ID_SEDE = :ordenIdSede ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:idSede is null or x.ID_SEDE = :idSede ) "
            + " and (:idDecomiso is null or x.ID_DECOMISO = :idDecomiso ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " ORDER BY x.ID_DECOMISO_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoLog")  String idDecomisoLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("numeroOficio")  String numeroOficio ,@Param("idEmbalaje")  String idEmbalaje ,@Param("idEstado")  String idEstado ,@Param("referencia")  String referencia ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fechaOficio")  String fechaOficio ,@Param("ordenIdSede")  String ordenIdSede ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("idSede")  String idSede ,@Param("idDecomiso")  String idDecomiso ,@Param("sModUsuario")  String sModUsuario);

}

