package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatFuncionario;
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

public interface CatFuncionarioRepository extends JpaRepository <CatFuncionario,    Integer >,PagingAndSortingRepository<CatFuncionario,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatFuncionario x "
            + "WHERE"  
            + "  (:idFuncionario is null or :idFuncionario = x.idFuncionario )   "
            + " and (:idUnidadOrganizativa is null or x.idUnidadOrganizativa = :idUnidadOrganizativa ) "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:nombre is null or x.nombre = :nombre ) "
            + " and (:cargo is null or x.cargo = :cargo ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:numeroCarnet is null or x.numeroCarnet = :numeroCarnet ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.catEstado.idEstado) "
            + " ORDER BY x.idFuncionario ASC ")
     Page<CatFuncionario> findByFilters(Pageable page  ,@Param("idFuncionario")  String idFuncionario ,@Param("idUnidadOrganizativa")  String idUnidadOrganizativa ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("cargo")  String cargo ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("numeroCarnet")  String numeroCarnet ,@Param("justificacion")  String justificacion ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

    @Query(value ="SELECT  x.ID_FUNCIONARIO  ,  x.ID_UNIDAD_ORGANIZATIVA  ,  x.F_MOD_FECHA  ,  x.NOMBRE  ,  x.CARGO  ,  x.S_CREA_USUARIO  ,  x.F_CREA_FECHA  ,  x.NUMERO_CARNET  ,  x.JUSTIFICACION  ,  x.S_MOD_USUARIO  ,  x.ID_ESTADO  "
            + " FROM CAT_FUNCIONARIO x "
            + "WHERE"  
            + "  (:idFuncionario is null or :idFuncionario = x.ID_FUNCIONARIO )   "
            + " and (:idUnidadOrganizativa is null or x.ID_UNIDAD_ORGANIZATIVA = :idUnidadOrganizativa ) "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:nombre is null or x.NOMBRE = :nombre ) "
            + " and (:cargo is null or x.CARGO = :cargo ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:numeroCarnet is null or x.NUMERO_CARNET = :numeroCarnet ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.ID_ESTADO) "
            + " ORDER BY x.ID_FUNCIONARIO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idFuncionario")  String idFuncionario ,@Param("idUnidadOrganizativa")  String idUnidadOrganizativa ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("cargo")  String cargo ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("numeroCarnet")  String numeroCarnet ,@Param("justificacion")  String justificacion ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

}

