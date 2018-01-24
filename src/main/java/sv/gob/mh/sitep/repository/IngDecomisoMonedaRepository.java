package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.IngDecomisoMoneda;
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

public interface IngDecomisoMonedaRepository extends JpaRepository <IngDecomisoMoneda,    Integer >,PagingAndSortingRepository<IngDecomisoMoneda,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM IngDecomisoMoneda x "
            + "WHERE"  
            + "  (:idDecomisoMoneda is null or :idDecomisoMoneda = x.idDecomisoMoneda )   "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:monto is null or x.monto = :monto ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and (:moneda is null or x.moneda = :moneda ) "
            + " and  (:fkidDecomisoingDecomiso is null or :fkidDecomisoingDecomiso = x.ingDecomiso.idDecomiso) "
            + " ORDER BY x.idDecomisoMoneda ASC ")
     Page<IngDecomisoMoneda> findByFilters(Pageable page  ,@Param("idDecomisoMoneda")  String idDecomisoMoneda ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFecha")  String fCreaFecha ,@Param("monto")  String monto ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("moneda")  String moneda ,@Param("fkidDecomisoingDecomiso")  String fkidDecomisoingDecomiso);

    @Query(value ="SELECT  x.ID_DECOMISO_MONEDA  ,  x.F_MOD_FECHA  ,  x.F_CREA_FECHA  ,  x.MONTO  ,  x.S_CREA_USUARIO  ,  x.S_MOD_USUARIO  ,  x.MONEDA  ,  x.ID_DECOMISO  "
            + " FROM ING_DECOMISO_MONEDA x "
            + "WHERE"  
            + "  (:idDecomisoMoneda is null or :idDecomisoMoneda = x.ID_DECOMISO_MONEDA )   "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:monto is null or x.MONTO = :monto ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and (:moneda is null or x.MONEDA = :moneda ) "
            + " and  (:fkidDecomisoingDecomiso is null or :fkidDecomisoingDecomiso = x.ID_DECOMISO) "
            + " ORDER BY x.ID_DECOMISO_MONEDA ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idDecomisoMoneda")  String idDecomisoMoneda ,@Param("fModFecha")  String fModFecha ,@Param("fCreaFecha")  String fCreaFecha ,@Param("monto")  String monto ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("sModUsuario")  String sModUsuario ,@Param("moneda")  String moneda ,@Param("fkidDecomisoingDecomiso")  String fkidDecomisoingDecomiso);

}

