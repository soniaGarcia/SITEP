package sv.gob.mh.sitep.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import sv.gob.mh.sitep.domain.CatSede;

@Entity
@Setter
@Getter
@Table(name = "CAT_SEDE_TELEFONO")
public class CatSedeTelefono implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_SEDE_TELEFONO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_CAT_SEDE_TELEFONO")
    @SequenceGenerator(name="SEQ_CAT_SEDE_TELEFONO",sequenceName="SEQ_CAT_SEDE_TELEFONO")
    Integer idSedeTelefono;


    @NotNull(message ="No puede estar vacio el campo telefono")
    @Column(name = "TELEFONO",length =20, nullable = false)
    @JsonView
    String telefono;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;


    @Column(name = "S_CREA_USUARIO",length =30, nullable = true)
    @JsonView
    String sCreaUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA", nullable = true)
    @JsonView
    Date fCreaFecha;


    @Column(name = "S_MOD_USUARIO",length =30, nullable = true)
    @JsonView
    String sModUsuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_SEDE", referencedColumnName = "ID_SEDE")})
    CatSede catSede;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatSedeDelegate(){
        return (this.catSede== null) ? null : this.catSede.getIdSede();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatSedeDescriptionDelegate(){
        return (this.catSede== null) ? null : this.catSede.getIdSede();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatSedeDelegate(    Integer  idSede){
        if (idSede == null) {
             this.catSede = null;
        }else {
             this.catSede = new CatSede();
             this.catSede.setIdSede(idSede);
         }
    }


}

