package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatTipoSede;
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

public interface CatTipoSedeRepository extends JpaRepository <CatTipoSede,    Integer >,PagingAndSortingRepository<CatTipoSede,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatTipoSede x "
            + "WHERE"  
            + "  (:idTipoSede is null or :idTipoSede = x.idTipoSede )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:descripcion is null or x.descripcion = :descripcion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " ORDER BY x.idTipoSede ASC ")
     Page<CatTipoSede> findByFilters(Pageable page  ,@Param("idTipoSede")  String idTipoSede ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("descripcion")  String descripcion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario);

    @Query(value ="SELECT  x.ID_TIPO_SEDE  ,  x.F_MOD_FECHA  ,  x.S_CREA_USUARIO  ,  x.DESCRIPCION  ,  x.F_CREA_FECHA  ,  x.S_MOD_USUARIO  "
            + " FROM CAT_TIPO_SEDE x "
            + "WHERE"  
            + "  (:idTipoSede is null or :idTipoSede = x.ID_TIPO_SEDE )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:descripcion is null or x.DESCRIPCION = :descripcion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " ORDER BY x.ID_TIPO_SEDE ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idTipoSede")  String idTipoSede ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("descripcion")  String descripcion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario);

}

