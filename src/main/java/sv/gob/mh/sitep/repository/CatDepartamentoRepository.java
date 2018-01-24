package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatDepartamento;
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

public interface CatDepartamentoRepository extends JpaRepository <CatDepartamento,    String >,PagingAndSortingRepository<CatDepartamento,    String >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatDepartamento x "
            + "WHERE"  
            + "  (:idDepartamento is null or :idDepartamento = x.idDepartamento )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:descripcion is null or x.descripcion = :descripcion ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " ORDER BY x.idDepartamento ASC ")
     Page<CatDepartamento> findByFilters(Pageable page  ,@Param("idDepartamento")  String idDepartamento ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFecha")  String fCreaFecha ,@Param("descripcion")  String descripcion ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario);

    @Query(value ="SELECT  x.ID_DEPARTAMENTO  ,  x.F_MOD_FECHA  ,  x.F_CREA_FECHA  ,  x.DESCRIPCION  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  "
            + " FROM CAT_DEPARTAMENTO x "
            + "WHERE"  
            + "  (:idDepartamento is null or :idDepartamento = x.ID_DEPARTAMENTO )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:descripcion is null or x.DESCRIPCION = :descripcion ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " ORDER BY x.ID_DEPARTAMENTO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDepartamento")  String idDepartamento ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFecha")  String fCreaFecha ,@Param("descripcion")  String descripcion ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario);

}

