package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomiso;
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

public interface IngDecomisoRepository extends JpaRepository <IngDecomiso,    Integer >,PagingAndSortingRepository<IngDecomiso,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomiso x "
            + "WHERE"  
            + "  (:idDecomiso is null or :idDecomiso = x.idDecomiso )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:numeroOficio is null or x.numeroOficio = :numeroOficio ) "
            + " and (:referencia is null or x.referencia = :referencia ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:fechaOficio is null or x.fechaOficio = :fechaOficio ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidSedecatSede is null or :fkidSedecatSede = x.catSedeByidSede.idSede) "
            + " and  (:fkidEmbalajecatEmbalaje is null or :fkidEmbalajecatEmbalaje = x.catEmbalaje.idEmbalaje) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.catEstado.idEstado) "
            + " and  (:fkordenIdSedecatSede is null or :fkordenIdSedecatSede = x.catSedeByordenIdSede.idSede) "
            + " ORDER BY x.idDecomiso ASC ")
     Page<IngDecomiso> findByFilters(Pageable page  ,@Param("idDecomiso")  String idDecomiso ,@Param("fModFecha")  String fModFecha ,@Param("numeroOficio")  String numeroOficio ,@Param("referencia")  String referencia ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fechaOficio")  String fechaOficio ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidSedecatSede")  String fkidSedecatSede ,@Param("fkidEmbalajecatEmbalaje")  String fkidEmbalajecatEmbalaje ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado ,@Param("fkordenIdSedecatSede")  String fkordenIdSedecatSede);

    @Query(value ="SELECT  x.ID_DECOMISO  ,  x.F_MOD_FECHA  ,  x.NUMERO_OFICIO  ,  x.REFERENCIA  ,  x.S_CREA_USUARIO  ,  x.FECHA_OFICIO  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.S_MOD_USUARIO  ,  x.ID_SEDE  ,  x.ID_EMBALAJE  ,  x.ID_ESTADO  ,  x.ID_SEDE  "
            + " FROM ING_DECOMISO x "
            + "WHERE"  
            + "  (:idDecomiso is null or :idDecomiso = x.ID_DECOMISO )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:numeroOficio is null or x.NUMERO_OFICIO = :numeroOficio ) "
            + " and (:referencia is null or x.REFERENCIA = :referencia ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:fechaOficio is null or x.FECHA_OFICIO = :fechaOficio ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidSedecatSede is null or :fkidSedecatSede = x.ID_SEDE) "
            + " and  (:fkidEmbalajecatEmbalaje is null or :fkidEmbalajecatEmbalaje = x.ID_EMBALAJE) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.ID_ESTADO) "
            + " and  (:fkordenIdSedecatSede is null or :fkordenIdSedecatSede = x.ORDEN_ID_SEDE) "
            + " ORDER BY x.ID_DECOMISO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomiso")  String idDecomiso ,@Param("fModFecha")  String fModFecha ,@Param("numeroOficio")  String numeroOficio ,@Param("referencia")  String referencia ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fechaOficio")  String fechaOficio ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidSedecatSede")  String fkidSedecatSede ,@Param("fkidEmbalajecatEmbalaje")  String fkidEmbalajecatEmbalaje ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado ,@Param("fkordenIdSedecatSede")  String fkordenIdSedecatSede);

}

