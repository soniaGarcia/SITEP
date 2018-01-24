package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatEstado;
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

public interface CatEstadoRepository extends JpaRepository <CatEstado,    Integer >,PagingAndSortingRepository<CatEstado,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatEstado x "
            + "WHERE"  
            + "  (:idEstado is null or :idEstado = x.idEstado )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:descripcion is null or x.descripcion = :descripcion ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " ORDER BY x.idEstado ASC ")
     Page<CatEstado> findByFilters(Pageable page  ,@Param("idEstado")  String idEstado ,@Param("fModFecha")  String fModFecha ,@Param("descripcion")  String descripcion ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario);

    @Query(value ="SELECT  x.ID_ESTADO  ,  x.F_MOD_FECHA  ,  x.DESCRIPCION  ,  x.S_CREA_USUARIO  ,  x.F_CREA_FECHA  ,  x.S_MOD_USUARIO  "
            + " FROM CAT_ESTADO x "
            + "WHERE"  
            + "  (:idEstado is null or :idEstado = x.ID_ESTADO )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:descripcion is null or x.DESCRIPCION = :descripcion ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " ORDER BY x.ID_ESTADO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idEstado")  String idEstado ,@Param("fModFecha")  String fModFecha ,@Param("descripcion")  String descripcion ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario);

}

