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
import sv.gob.mh.sitep.domain.CatTipoSede;
import sv.gob.mh.sitep.domain.CatDepartamento;
import sv.gob.mh.sitep.domain.CatMunicipio;
import sv.gob.mh.sitep.domain.CatSedeTelefono;
import sv.gob.mh.sitep.domain.IngDecomiso;

@Entity
@Setter
@Getter
@Table(name = "CAT_SEDE")
public class CatSede implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_SEDE", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_CAT_SEDE")
    @SequenceGenerator(name="SEQ_CAT_SEDE",sequenceName="SEQ_CAT_SEDE")
    Integer idSede;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @NotNull(message ="No puede estar vacio el campo direccion")
    @Column(name = "DIRECCION",length =300, nullable = false)
    @JsonView
    String direccion;

    @NotNull(message ="No puede estar vacio el campo nombre")
    @Column(name = "NOMBRE",length =300, nullable = false)
    @JsonView
    String nombre;

    @NotNull(message ="No puede estar vacio el campo idEstado")
    @Column(name = "ID_ESTADO", nullable = false)
    @JsonView
    Integer idEstado;


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


    @Column(name = "DEPENDENCIA",length =300, nullable = true)
    @JsonView
    String dependencia;


    @Column(name = "CODIGO_SOLICITUD",length =20, nullable = true)
    @JsonView
    String codigoSolicitud;


    @Column(name = "OBSERVACIONES",length =300, nullable = true)
    @JsonView
    String observaciones;


    @Column(name = "S_MOD_USUARIO",length =30, nullable = true)
    @JsonView
    String sModUsuario;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_TIPO_SEDE", referencedColumnName = "ID_TIPO_SEDE")})
    CatTipoSede catTipoSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")})
    CatDepartamento catDepartamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_MUNICIPIO", referencedColumnName = "ID")})
    CatMunicipio catMunicipio;

    @OneToMany(mappedBy = "catSede", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatSedeTelefono> catSedeTelefonos;

    @OneToMany(mappedBy = "catSedeByidSede", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<IngDecomiso> ingDecomisoByidSedes;

    @OneToMany(mappedBy = "catSedeByordenIdSede", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<IngDecomiso> ingDecomisoByordenIdSedes;


    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatTipoSedeDelegate(){
        return (this.catTipoSede== null) ? null : this.catTipoSede.getIdTipoSede();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatTipoSedeDescriptionDelegate(){
        return (this.catTipoSede== null) ? null : this.catTipoSede.getIdTipoSede();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatTipoSedeDelegate(    Integer  idTipoSede){
        if (idTipoSede == null) {
             this.catTipoSede = null;
        }else {
             this.catTipoSede = new CatTipoSede();
             this.catTipoSede.setIdTipoSede(idTipoSede);
         }
    }

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    String getCatDepartamentoDelegate(){
        return (this.catDepartamento== null) ? null : this.catDepartamento.getIdDepartamento();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    String getCatDepartamentoDescriptionDelegate(){
        return (this.catDepartamento== null) ? null : this.catDepartamento.getIdDepartamento();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatDepartamentoDelegate(    String  idDepartamento){
        if (idDepartamento == null) {
             this.catDepartamento = null;
        }else {
             this.catDepartamento = new CatDepartamento();
             this.catDepartamento.setIdDepartamento(idDepartamento);
         }
    }

    /**
    * Metodo para obtener la llave primaria del padre de la entidad
    * @return el tipo de dato de la llave primaria
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatMunicipioDelegate(){
        return (this.catMunicipio== null) ? null : this.catMunicipio.getId();
    }

    /**
    * Metodo para obtener la descripcion de la tabla, por defecto coloca la llave primaria del padre de la entidad
    * @return String que debe contener la descripcion de la columna Padre
    * @author Generador-Safi
    * @version 1.0
    **/
    public    Integer getCatMunicipioDescriptionDelegate(){
        return (this.catMunicipio== null) ? null : this.catMunicipio.getId();
    }

    /**
    * Metodo para  setear la llave primaria del padre de la entidad
    * @return void
    * @author Generador-Safi
    * @version 1.0
    **/
    public void setCatMunicipioDelegate(    Integer  id){
        if (id == null) {
             this.catMunicipio = null;
        }else {
             this.catMunicipio = new CatMunicipio();
             this.catMunicipio.setId(id);
         }
    }


}

