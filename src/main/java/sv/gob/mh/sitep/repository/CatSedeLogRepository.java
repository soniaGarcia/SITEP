package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatSedeLog;
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

public interface CatSedeLogRepository extends JpaRepository <CatSedeLog,    Integer >,PagingAndSortingRepository<CatSedeLog,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatSedeLog x "
            + "WHERE"  
            + "  (:idSedeLog is null or :idSedeLog = x.idSedeLog )   "
            + " and (:direccion is null or x.direccion = :direccion ) "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:nombre is null or x.nombre = :nombre ) "
            + " and (:fCreaFechaLog is null or x.fCreaFechaLog = :fCreaFechaLog ) "
            + " and (:idDepartamento is null or x.idDepartamento = :idDepartamento ) "
            + " and (:codigoSede is null or x.codigoSede = :codigoSede ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:idSede is null or x.idSede = :idSede ) "
            + " and (:idTipoSede is null or x.idTipoSede = :idTipoSede ) "
            + " and (:dependencia is null or x.dependencia = :dependencia ) "
            + " and (:codigoSolicitud is null or x.codigoSolicitud = :codigoSolicitud ) "
            + " and (:observaciones is null or x.observaciones = :observaciones ) "
            + " and (:idMunicipio is null or x.idMunicipio = :idMunicipio ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.catEstado.idEstado) "
            + " ORDER BY x.idSedeLog ASC ")
     Page<CatSedeLog> findByFilters(Pageable page  ,@Param("idSedeLog")  String idSedeLog ,@Param("direccion")  String direccion ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("idDepartamento")  String idDepartamento ,@Param("codigoSede")  String codigoSede ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("idSede")  String idSede ,@Param("idTipoSede")  String idTipoSede ,@Param("dependencia")  String dependencia ,@Param("codigoSolicitud")  String codigoSolicitud ,@Param("observaciones")  String observaciones ,@Param("idMunicipio")  String idMunicipio ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

    @Query(value ="SELECT  x.ID_SEDE_LOG  ,  x.DIRECCION  ,  x.F_MOD_FECHA  ,  x.NOMBRE  ,  x.F_CREA_FECHA_LOG  ,  x.ID_DEPARTAMENTO  ,  x.CODIGO_SEDE  ,  x.S_CREA_USUARIO  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.ID_SEDE  ,  x.ID_TIPO_SEDE  ,  x.DEPENDENCIA  ,  x.CODIGO_SOLICITUD  ,  x.OBSERVACIONES  ,  x.ID_MUNICIPIO  ,  x.S_MOD_USUARIO  ,  x.ID_ESTADO  "
            + " FROM CAT_SEDE_LOG x "
            + "WHERE"  
            + "  (:idSedeLog is null or :idSedeLog = x.ID_SEDE_LOG )   "
            + " and (:direccion is null or x.DIRECCION = :direccion ) "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:nombre is null or x.NOMBRE = :nombre ) "
            + " and (:fCreaFechaLog is null or x.F_CREA_FECHA_LOG = :fCreaFechaLog ) "
            + " and (:idDepartamento is null or x.ID_DEPARTAMENTO = :idDepartamento ) "
            + " and (:codigoSede is null or x.CODIGO_SEDE = :codigoSede ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:idSede is null or x.ID_SEDE = :idSede ) "
            + " and (:idTipoSede is null or x.ID_TIPO_SEDE = :idTipoSede ) "
            + " and (:dependencia is null or x.DEPENDENCIA = :dependencia ) "
            + " and (:codigoSolicitud is null or x.CODIGO_SOLICITUD = :codigoSolicitud ) "
            + " and (:observaciones is null or x.OBSERVACIONES = :observaciones ) "
            + " and (:idMunicipio is null or x.ID_MUNICIPIO = :idMunicipio ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.ID_ESTADO) "
            + " ORDER BY x.ID_SEDE_LOG ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idSedeLog")  String idSedeLog ,@Param("direccion")  String direccion ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("fCreaFechaLog")  String fCreaFechaLog ,@Param("idDepartamento")  String idDepartamento ,@Param("codigoSede")  String codigoSede ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("idSede")  String idSede ,@Param("idTipoSede")  String idTipoSede ,@Param("dependencia")  String dependencia ,@Param("codigoSolicitud")  String codigoSolicitud ,@Param("observaciones")  String observaciones ,@Param("idMunicipio")  String idMunicipio ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

}

