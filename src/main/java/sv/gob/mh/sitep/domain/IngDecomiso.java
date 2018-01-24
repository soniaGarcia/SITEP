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
import sv.gob.mh.sitep.domain.CatEmbalaje;
import sv.gob.mh.sitep.domain.CatEstado;
import sv.gob.mh.sitep.domain.IngDecomisoVictima;
import sv.gob.mh.sitep.domain.IngDecomisoImputado;
import sv.gob.mh.sitep.domain.IngDecomisoDelito;
import sv.gob.mh.sitep.domain.IngDecomisoMoneda;

@Entity
@Setter
@Getter
@Table(name = "ING_DECOMISO")
public class IngDecomiso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_DECOMISO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_ING_DECOMISO")
    @SequenceGenerator(name="SEQ_ING_DECOMISO",sequenceName="SEQ_ING_DECOMISO")
    Integer idDecomiso;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @NotNull(message ="No puede estar vacio el campo numeroOficio")
    @Column(name = "NUMERO_OFICIO",length =30, nullable = false)
    @JsonView
    String numeroOficio;

    @NotNull(message ="No puede estar vacio el campo referencia")
    @Column(name = "REFERENCIA",length =30, nullable = false)
    @JsonView
    String referencia;


    @Column(name = "S_CREA_USUARIO",length =30, nullable = true)
    @JsonView
    String sCreaUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message ="No puede estar vacio el campo fechaOficio")
    @Column(name = "FECHA_OFICIO", nullable = false)
    @JsonView
    Date fechaOficio;


    @Column(name = "JUSTIFICACION",length =300, nullable = true)
    @JsonView
    String justificacion;

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
    CatSede catSedeByidSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_EMBALAJE", referencedColumnName = "ID_EMBALAJE")})
    CatEmbalaje catEmbalaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")})
    CatEstado catEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ORDEN_ID_SEDE", referencedColumnName = "ID_SEDE")})
    CatSede catSedeByordenIdSede;

    @OneToMany(mappedBy = "ingDecomiso", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<IngDecomisoVictima> ingDecomisoVictimas;

    @OneToMany(mappedBy = "ingDecomiso", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<IngDecomisoImputado> ingDecomisoImputados;

    @OneToMany(mappedBy = "ingDecomiso", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<IngDecomisoDelito> ingDecomisoDelitos;

    @OneToMany(mappedBy = "ingDecomiso", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<IngDecomisoMoneda> ingDecomisoMonedas;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getcatSedeByidSedeDelegate(){
        return (this.catSedeByidSede== null) ? null : this.catSedeByidSede.getIdSede();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getcatSedeByidSedeDescriptionDelegate(){
        return (this.catSedeByidSede== null) ? null : this.catSedeByidSede.getIdSede();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatSedeDelegate(    Integer  idSede){
        if (catSedeByidSede == null) {
             this.catSedeByidSede = null;
        }else {
             this.catSedeByidSede = new CatSedeByidSede();
             this.catSedeByidSede.setIdSede(idSede);
         }
    }

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatEmbalajeDelegate(){
        return (this.catEmbalaje== null) ? null : this.catEmbalaje.getIdEmbalaje();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatEmbalajeDescriptionDelegate(){
        return (this.catEmbalaje== null) ? null : this.catEmbalaje.getIdEmbalaje();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatEmbalajeDelegate(    Integer  idEmbalaje){
        if (idEmbalaje == null) {
             this.catEmbalaje = null;
        }else {
             this.catEmbalaje = new CatEmbalaje();
             this.catEmbalaje.setIdEmbalaje(idEmbalaje);
         }
    }

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

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getcatSedeByordenIdSedeDelegate(){
        return (this.catSedeByordenIdSede== null) ? null : this.catSedeByordenIdSede.getIdSede();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getcatSedeByordenIdSedeDescriptionDelegate(){
        return (this.catSedeByordenIdSede== null) ? null : this.catSedeByordenIdSede.getIdSede();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatSedeDelegate(    Integer  idSede){
        if (catSedeByordenIdSede == null) {
             this.catSedeByordenIdSede = null;
        }else {
             this.catSedeByordenIdSede = new CatSedeByordenIdSede();
             this.catSedeByordenIdSede.setIdSede(idSede);
         }
    }


}

