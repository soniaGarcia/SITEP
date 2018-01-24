package sv.gob.mh.sitep.repository;

import sv.gob.mh.sitep.domain.CatSedeTelefono;
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

public interface CatSedeTelefonoRepository extends JpaRepository <CatSedeTelefono,    Integer >,PagingAndSortingRepository<CatSedeTelefono,    Integer >{

    /**
    * Metodo para obtener y filtrar el query y paginar la entidad
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    @Query("SELECT x "
            + " FROM CatSedeTelefono x "
            + "WHERE"  
            + "  (:idSedeTelefono is null or :idSedeTelefono = x.idSedeTelefono )   "
            + " and (:telefono is null or x.telefono = :telefono ) "
            + " and (:fModFecha is null or x.fModFecha = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.sCreaUsuario = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.fCreaFecha = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.sModUsuario = :sModUsuario ) "
            + " and  (:fkidSedecatSede is null or :fkidSedecatSede = x.catSede.idSede) "
            + " ORDER BY x.idSedeTelefono ASC ")
     Page<CatSedeTelefono> findByFilters(Pageable page  ,@Param("idSedeTelefono")  String idSedeTelefono ,@Param("telefono")  String telefono ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidSedecatSede")  String fkidSedecatSede);

    @Query(value ="SELECT  x.ID_SEDE_TELEFONO  ,  x.TELEFONO  ,  x.F_MOD_FECHA  ,  x.S_CREA_USUARIO  ,  x.F_CREA_FECHA  ,  x.S_MOD_USUARIO  ,  x.ID_SEDE  "
            + " FROM CAT_SEDE_TELEFONO x "
            + "WHERE"  
            + "  (:idSedeTelefono is null or :idSedeTelefono = x.ID_SEDE_TELEFONO )   "
            + " and (:telefono is null or x.TELEFONO = :telefono ) "
            + " and (:fModFecha is null or x.F_MOD_FECHA = :fModFecha ) "
            + " and (:sCreaUsuario is null or x.S_CREA_USUARIO = :sCreaUsuario ) "
            + " and (:fCreaFecha is null or x.F_CREA_FECHA = :fCreaFecha ) "
            + " and (:sModUsuario is null or x.S_MOD_USUARIO = :sModUsuario ) "
            + " and  (:fkidSedecatSede is null or :fkidSedecatSede = x.ID_SEDE) "
            + " ORDER BY x.ID_SEDE_TELEFONO ASC ",nativeQuery=true)
     /**
    * Metodo para obtener y filtrar el query de la entidad y usarlo para exportar a excel
    * @return Lista de tipo entidad
    * @author Generador-Safi
    * @version 1.0
    **/
    List<Object[]> findByFilters( @Param("idSedeTelefono")  String idSedeTelefono ,@Param("telefono")  String telefono ,@Param("fModFecha")  String fModFecha ,@Param("sCreaUsuario")  String sCreaUsuario ,@Param("fCreaFecha")  String fCreaFecha ,@Param("sModUsuario")  String sModUsuario ,@Param("fkidSedecatSede")  String fkidSedecatSede);

}

