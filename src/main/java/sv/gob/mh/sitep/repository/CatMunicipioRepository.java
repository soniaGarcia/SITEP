package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatMunicipio;
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

public interface CatMunicipioRepository extends JpaRepository <CatMunicipio,    Integer >,PagingAndSortingRepository<CatMunicipio,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatMunicipio x "
            + "WHERE"  
            + "  (:id is null or :id = x.id )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:idMunicipio is null or x.idMunicipio = :idMunicipio ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and (:descripcion is null or x.descripcion = :descripcion ) "
            + " and  (:fkidDepartamentocatDepartamento is null or :fkidDepartamentocatDepartamento = x.catDepartamento.idDepartamento) "
            + " ORDER BY x.id ASC ")
     Page<CatMunicipio> findByFilters(Pageable page  ,@Param("id")  String id ,@Param("fModFecha")  String fModFecha ,@Param("idMunicipio")  String idMunicipio ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario ,@Param("descripcion")  String descripcion ,@Param("fkidDepartamentocatDepartamento")  String fkidDepartamentocatDepartamento);

    @Query(value ="SELECT  x.ID  ,  x.F_MOD_FECHA  ,  x.ID_MUNICIPIO  ,  x.S_CREA_USUARIO  ,  x.F_CREA_FECHA  ,  x.S_MOD_USUARIO  ,  x.DESCRIPCION  ,  x.ID_DEPARTAMENTO  "
            + " FROM CAT_MUNICIPIO x "
            + "WHERE"  
            + "  (:id is null or :id = x.ID )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:idMunicipio is null or x.ID_MUNICIPIO = :idMunicipio ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and (:descripcion is null or x.DESCRIPCION = :descripcion ) "
            + " and  (:fkidDepartamentocatDepartamento is null or :fkidDepartamentocatDepartamento = x.ID_DEPARTAMENTO) "
            + " ORDER BY x.ID ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("id")  String id ,@Param("fModFecha")  String fModFecha ,@Param("idMunicipio")  String idMunicipio ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario ,@Param("descripcion")  String descripcion ,@Param("fkidDepartamentocatDepartamento")  String fkidDepartamentocatDepartamento);

}

