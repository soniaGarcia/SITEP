package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatEmbalajeLog;
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

public interface CatEmbalajeLogRepository extends JpaRepository <CatEmbalajeLog,    Integer >,PagingAndSortingRepository<CatEmbalajeLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatEmbalajeLog x "
            + "WHERE"  
            + "  (:idEmbalajeLog is null or :idEmbalajeLog = x.idEmbalajeLog )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:idEmbalaje is null or x.idEmbalaje = :idEmbalaje ) "
            + " and (:idEstado is null or x.idEstado = :idEstado ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:codigo is null or x.codigo = :codigo ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:tipo is null or x.tipo = :tipo ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " ORDER BY x.idEmbalajeLog ASC ")
     Page<CatEmbalajeLog> findByFilters(Pageable page  ,@Param("idEmbalajeLog")  String idEmbalajeLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("idEmbalaje")  String idEmbalaje ,@Param("idEstado")  String idEstado ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("codigo")  String codigo ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario);

    @Query(value ="SELECT  x.ID_EMBALAJE_LOG  ,  x.F_MOD_FECHA  ,  x.F_CREA_FECHA_LOG  ,  x.ID_EMBALAJE  ,  x.ID_ESTADO  ,  x.S_CREA_USUARIO  ,  x.CODIGO  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.TIPO  ,  x.S_MOD_USUARIO  "
            + " FROM CAT_EMBALAJE_LOG x "
            + "WHERE"  
            + "  (:idEmbalajeLog is null or :idEmbalajeLog = x.ID_EMBALAJE_LOG )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:idEmbalaje is null or x.ID_EMBALAJE = :idEmbalaje ) "
            + " and (:idEstado is null or x.ID_ESTADO = :idEstado ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:codigo is null or x.CODIGO = :codigo ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:tipo is null or x.TIPO = :tipo ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " ORDER BY x.ID_EMBALAJE_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idEmbalajeLog")  String idEmbalajeLog ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("idEmbalaje")  String idEmbalaje ,@Param("idEstado")  String idEstado ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("codigo")  String codigo ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario);

}

