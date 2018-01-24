package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatTiposDevolucion;
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

public interface CatTiposDevolucionRepository extends JpaRepository <CatTiposDevolucion,    Integer >,PagingAndSortingRepository<CatTiposDevolucion,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatTiposDevolucion x "
            + "WHERE"  
            + "  (:idTiposDevolucion is null or :idTiposDevolucion = x.idTiposDevolucion )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:codigo is null or x.codigo = :codigo ) "
            + " and (:tipo is null or x.tipo = :tipo ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.catEstado.idEstado) "
            + " ORDER BY x.idTiposDevolucion ASC ")
     Page<CatTiposDevolucion> findByFilters(Pageable page  ,@Param("idTiposDevolucion")  String idTiposDevolucion ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("codigo")  String codigo ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

    @Query(value ="SELECT  x.ID_TIPOS_DEVOLUCION  ,  x.F_MOD_FECHA  ,  x.S_CREA_USUARIO  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.CODIGO  ,  x.TIPO  ,  x.S_MOD_USUARIO  ,  x.ID_ESTADO  "
            + " FROM CAT_TIPOS_DEVOLUCION x "
            + "WHERE"  
            + "  (:idTiposDevolucion is null or :idTiposDevolucion = x.ID_TIPOS_DEVOLUCION )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:codigo is null or x.CODIGO = :codigo ) "
            + " and (:tipo is null or x.TIPO = :tipo ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.ID_ESTADO) "
            + " ORDER BY x.ID_TIPOS_DEVOLUCION ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idTiposDevolucion")  String idTiposDevolucion ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("codigo")  String codigo ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

}

