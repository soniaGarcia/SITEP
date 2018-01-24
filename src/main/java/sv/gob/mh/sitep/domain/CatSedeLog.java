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
import sv.gob.mh.sitep.domain.CatEstado;

@Entity
@Setter
@Getter
@Table(name = "CAT_SEDE_LOG")
public class CatSedeLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_SEDE_LOG", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_CAT_SEDE_LOG")
    @SequenceGenerator(name="SEQ_CAT_SEDE_LOG",sequenceName="SEQ_CAT_SEDE_LOG")
    Integer idSedeLog;


    @NotNull(message ="No puede estar vacio el campo direccion")
    @Column(name = "DIRECCION",length =300, nullable = false)
    @JsonView
    String direccion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @NotNull(message ="No puede estar vacio el campo nombre")
    @Column(name = "NOMBRE",length =300, nullable = false)
    @JsonView
    String nombre;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA_LOG", nullable = true)
    @JsonView
    Date fCreaFechaLog;

    @NotNull(message ="No puede estar vacio el campo idDepartamento")
    @Column(name = "ID_DEPARTAMENTO",length =20, nullable = false)
    @JsonView
    String idDepartamento;


    @Column(name = "CODIGO_SEDE",length =20, nullable = true)
    @JsonView
    String codigoSede;


    @Column(name = "S_CREA_USUARIO",length =30, nullable = true)
    @JsonView
    String sCreaUsuario;

    @NotNull(message ="No puede estar vacio el campo justificacion")
    @Column(name = "JUSTIFICACION",length =1000, nullable = false)
    @JsonView
    String justificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA", nullable = true)
    @JsonView
    Date fCreaFecha;

    @NotNull(message ="No puede estar vacio el campo idSede")
    @Column(name = "ID_SEDE", nullable = false)
    @JsonView
    Integer idSede;

    @NotNull(message ="No puede estar vacio el campo idTipoSede")
    @Column(name = "ID_TIPO_SEDE", nullable = false)
    @JsonView
    Integer idTipoSede;


    @Column(name = "DEPENDENCIA",length =300, nullable = true)
    @JsonView
    String dependencia;


    @Column(name = "CODIGO_SOLICITUD",length =20, nullable = true)
    @JsonView
    String codigoSolicitud;


    @Column(name = "OBSERVACIONES",length =300, nullable = true)
    @JsonView
    String observaciones;


    @Column(name = "ID_MUNICIPIO", nullable = true)
    @JsonView
    Integer idMunicipio;


    @Column(name = "S_MOD_USUARIO",length =30, nullable = true)
    @JsonView
    String sModUsuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")})
    CatEstado catEstado;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatEstadoDelegate(){
        return (this.catEstado== null) ? null : this.catEstado.getIdEstado();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatEstadoDescriptionDelegate(){
        return (this.catEstado== null) ? null : this.catEstado.getIdEstado();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatEstadoDelegate(    Integer  idEstado){
        if (idEstado == null) {
             this.catEstado = null;
        }else {
             this.catEstado = new CatEstado();
             this.catEstado.setIdEstado(idEstado);
         }
    }


}

