package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatEmbalaje;
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

public interface CatEmbalajeRepository extends JpaRepository <CatEmbalaje,    Integer >,PagingAndSortingRepository<CatEmbalaje,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatEmbalaje x "
            + "WHERE"  
            + "  (:idEmbalaje is null or :idEmbalaje = x.idEmbalaje )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:codigo is null or x.codigo = :codigo ) "
            + " and (:justificacion is null or x.justificacion = :justificacion ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:tipo is null or x.tipo = :tipo ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.catEstado.idEstado) "
            + " ORDER BY x.idEmbalaje ASC ")
     Page<CatEmbalaje> findByFilters(Pageable page  ,@Param("idEmbalaje")  String idEmbalaje ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("codigo")  String codigo ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

    @Query(value ="SELECT  x.ID_EMBALAJE  ,  x.F_MOD_FECHA  ,  x.S_CREA_USUARIO  ,  x.CODIGO  ,  x.JUSTIFICACION  ,  x.F_CREA_FECHA  ,  x.TIPO  ,  x.S_MOD_USUARIO  ,  x.ID_ESTADO  "
            + " FROM CAT_EMBALAJE x "
            + "WHERE"  
            + "  (:idEmbalaje is null or :idEmbalaje = x.ID_EMBALAJE )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:codigo is null or x.CODIGO = :codigo ) "
            + " and (:justificacion is null or x.JUSTIFICACION = :justificacion ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:tipo is null or x.TIPO = :tipo ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidEstadocatEstado is null or :fkidEstadocatEstado = x.ID_ESTADO) "
            + " ORDER BY x.ID_EMBALAJE ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idEmbalaje")  String idEmbalaje ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("codigo")  String codigo ,@Param("justificacion")  String justificacion ,@Param("fCreaFecha")  String fCreaFecha ,@Param("tipo")  String tipo ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidEstadocatEstado")  String fkidEstadocatEstado);

}

