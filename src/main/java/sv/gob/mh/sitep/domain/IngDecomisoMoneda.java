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
import sv.gob.mh.sitep.domain.IngDecomiso;

@Entity
@Setter
@Getter
@Table(name = "ING_DECOMISO_MONEDA")
public class IngDecomisoMoneda implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_DECOMISO_MONEDA", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_ING_DECOMISO_MONEDA")
    @SequenceGenerator(name="SEQ_ING_DECOMISO_MONEDA",sequenceName="SEQ_ING_DECOMISO_MONEDA")
    Integer idDecomisoMoneda;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA", nullable = true)
    @JsonView
    Date fCreaFecha;

    @NotNull(message ="No puede estar vacio el campo monto")
    @Column(name = "MONTO",scale = 2, precision = 10, nullable = false)
    @JsonView
    BigDecimal monto;


    @Column(name = "S_CREA_USUARIO",length =20, nullable = true)
    @JsonView
    String sCreaUsuario;


    @Column(name = "S_MOD_USUARIO",length =20, nullable = true)
    @JsonView
    String sModUsuario;

    @NotNull(message ="No puede estar vacio el campo moneda")
    @Column(name = "MONEDA",length =20, nullable = false)
    @JsonView
    String moneda;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_DECOMISO", referencedColumnName = "ID_DECOMISO")})
    IngDecomiso ingDecomiso;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getIngDecomisoDelegate(){
        return (this.ingDecomiso== null) ? null : this.ingDecomiso.getIdDecomiso();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getIngDecomisoDescriptionDelegate(){
        return (this.ingDecomiso== null) ? null : this.ingDecomiso.getIdDecomiso();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setIngDecomisoDelegate(    Integer  idDecomiso){
        if (idDecomiso == null) {
             this.ingDecomiso = null;
        }else {
             this.ingDecomiso = new IngDecomiso();
             this.ingDecomiso.setIdDecomiso(idDecomiso);
         }
    }


}

