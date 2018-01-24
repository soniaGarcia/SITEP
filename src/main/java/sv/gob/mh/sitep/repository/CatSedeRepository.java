package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatSede;
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

public interface CatSedeRepository extends JpaRepository <CatSede,    Integer >,PagingAndSortingRepository<CatSede,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatSede x "
            + "WHERE"  
            + "  (:idSede is null or :idSede = x.idSede )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:direccion is null or x.direccion = :direccion ) "
            + " and (:nombre is null or x.nombre = :nombre ) "
            + " and (:idEstado is null or x.idEstado = :idEstado ) "
            + " and (:codigoSede is null or x.codigoSede = :codigoSede ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:dependencia is null or x.dependencia = :dependencia ) "
            + " and (:codigoSolicitud is null or x.codigoSolicitud = :codigoSolicitud ) "
            + " and (:observaciones is null or x.observaciones = :observaciones ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidTipoSedecatTipoSede is null or :fkidTipoSedecatTipoSede = x.catTipoSede.idTipoSede) "
            + " and  (:fkidDepartamentocatDepartamento is null or :fkidDepartamentocatDepartamento = x.catDepartamento.idDepartamento) "
            + " and  (:fkidMunicipiocatMunicipio is null or :fkidMunicipiocatMunicipio = x.catMunicipio.id) "
            + " ORDER BY x.idSede ASC ")
     Page<CatSede> findByFilters(Pageable page  ,@Param("idSede")  String idSede ,@Param("fModFecha")  String fModFecha ,@Param("direccion")  String direccion ,@Param("nombre")  String nombre ,@Param("idEstado")  String idEstado ,@Param("codigoSede")  String codigoSede ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("dependencia")  String dependencia ,@Param("codigoSolicitud")  String codigoSolicitud ,@Param("observaciones")  String observaciones ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidTipoSedecatTipoSede")  String fkidTipoSedecatTipoSede ,@Param("fkidDepartamentocatDepartamento")  String fkidDepartamentocatDepartamento ,@Param("fkidMunicipiocatMunicipio")  String fkidMunicipiocatMunicipio);

    @Query(value ="SELECT  x.ID_SEDE  ,  x.F_MOD_FECHA  ,  x.DIRECCION  ,  x.NOMBRE  ,  x.ID_ESTADO  ,  x.CODIGO_SEDE  ,  x.S_CREA_USUARIO  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.DEPENDENCIA  ,  x.CODIGO_SOLICITUD  ,  x.OBSERVACIONES  ,  x.S_MOD_USUARIO  ,  x.ID_TIPO_SEDE  ,  x.ID_DEPARTAMENTO  ,  x.ID  "
            + " FROM CAT_SEDE x "
            + "WHERE"  
            + "  (:idSede is null or :idSede = x.ID_SEDE )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:direccion is null or x.DIRECCION = :direccion ) "
            + " and (:nombre is null or x.NOMBRE = :nombre ) "
            + " and (:idEstado is null or x.ID_ESTADO = :idEstado ) "
            + " and (:codigoSede is null or x.CODIGO_SEDE = :codigoSede ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:dependencia is null or x.DEPENDENCIA = :dependencia ) "
            + " and (:codigoSolicitud is null or x.CODIGO_SOLICITUD = :codigoSolicitud ) "
            + " and (:observaciones is null or x.OBSERVACIONES = :observaciones ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidTipoSedecatTipoSede is null or :fkidTipoSedecatTipoSede = x.ID_TIPO_SEDE) "
            + " and  (:fkidDepartamentocatDepartamento is null or :fkidDepartamentocatDepartamento = x.ID_DEPARTAMENTO) "
            + " and  (:fkidMunicipiocatMunicipio is null or :fkidMunicipiocatMunicipio = x.ID_MUNICIPIO) "
            + " ORDER BY x.ID_SEDE ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idSede")  String idSede ,@Param("fModFecha")  String fModFecha ,@Param("direccion")  String direccion ,@Param("nombre")  String nombre ,@Param("idEstado")  String idEstado ,@Param("codigoSede")  String codigoSede ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("dependencia")  String dependencia ,@Param("codigoSolicitud")  String codigoSolicitud ,@Param("observaciones")  String observaciones ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidTipoSedecatTipoSede")  String fkidTipoSedecatTipoSede ,@Param("fkidDepartamentocatDepartamento")  String fkidDepartamentocatDepartamento ,@Param("fkidMunicipiocatMunicipio")  String fkidMunicipiocatMunicipio);

}

