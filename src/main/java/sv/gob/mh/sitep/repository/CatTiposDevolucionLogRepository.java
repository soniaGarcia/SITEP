package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatTiposDevolucionLog;
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

public interface CatTiposDevolucionLogRepository extends JpaRepository <CatTiposDevolucionLog,    Integer >,PagingAndSortingRepository<CatTiposDevolucionLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatTiposDevolucionLog x "
            + "WHERE"  
            + "  (:idTiposDevolucionLog is null or :idTiposDevolucionLog = x.idTiposDevolucionLog )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:idTiposDevolucion is null or x.idTiposDevolucion = :idTiposDevolucion ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:idEstado is null or x.idEstado = :idEstado ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:codigo is null or x.codigo = :codigo ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:tipo is null or x.tipo = :tipo ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " ORDER BY x.idTiposDevolucionLog ASC ")
     Page<CatTiposDevolucionLog> findByFilters(Pageable page  ,@Param("idTiposDevolucionLog")  String idTiposDevolucionLog ,@Param("fModFecha")  String fModFecha ,@Param("idTiposDevolucion")  String idTiposDevolucion ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("idEstado")  String idEstado ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("codigo")  String codigo ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario);

    @Query(value ="SELECT  x.ID_TIPOS_DEVOLUCION_LOG  ,  x.F_MOD_FECHA  ,  x.ID_TIPOS_DEVOLUCION  ,  x.F_CREA_FECHA_LOG  ,  x.ID_ESTADO  ,  x.S_CREA_USUARIO  ,  x.CODIGO  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.TIPO  ,  x.S_MOD_USUARIO  "
            + " FROM CAT_TIPOS_DEVOLUCION_LOG x "
            + "WHERE"  
            + "  (:idTiposDevolucionLog is null or :idTiposDevolucionLog = x.ID_TIPOS_DEVOLUCION_LOG )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:idTiposDevolucion is null or x.ID_TIPOS_DEVOLUCION = :idTiposDevolucion ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:idEstado is null or x.ID_ESTADO = :idEstado ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:codigo is null or x.CODIGO = :codigo ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:tipo is null or x.TIPO = :tipo ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " ORDER BY x.ID_TIPOS_DEVOLUCION_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idTiposDevolucionLog")  String idTiposDevolucionLog ,@Param("fModFecha")  String fModFecha ,@Param("idTiposDevolucion")  String idTiposDevolucion ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("idEstado")  String idEstado ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("codigo")  String codigo ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario);

}

