package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoVictima;
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

public interface IngDecomisoVictimaRepository extends JpaRepository <IngDecomisoVictima,    Integer >,PagingAndSortingRepository<IngDecomisoVictima,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoVictima x "
            + "WHERE"  
            + "  (:idDecomisoVictima is null or :idDecomisoVictima = x.idDecomisoVictima )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:nombre is null or x.nombre = :nombre ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidDecomisoingDecomiso is null or :fkidDecomisoingDecomiso = x.ingDecomiso.idDecomiso) "
            + " ORDER BY x.idDecomisoVictima ASC ")
     Page<IngDecomisoVictima> findByFilters(Pageable page  ,@Param("idDecomisoVictima")  String idDecomisoVictima ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidDecomisoingDecomiso")  String fkidDecomisoingDecomiso);

    @Query(value ="SELECT  x.ID_DECOMISO_VICTIMA  ,  x.F_MOD_FECHA  ,  x.NOMBRE  ,  x.F_CREA_FECHA  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  ,  x.ID_DECOMISO  "
            + " FROM ING_DECOMISO_VICTIMA x "
            + "WHERE"  
            + "  (:idDecomisoVictima is null or :idDecomisoVictima = x.ID_DECOMISO_VICTIMA )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:nombre is null or x.NOMBRE = :nombre ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidDecomisoingDecomiso is null or :fkidDecomisoingDecomiso = x.ID_DECOMISO) "
            + " ORDER BY x.ID_DECOMISO_VICTIMA ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoVictima")  String idDecomisoVictima ,@Param("fModFecha")  String fModFecha ,@Param("nombre")  String nombre ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidDecomisoingDecomiso")  String fkidDecomisoingDecomiso);

}

