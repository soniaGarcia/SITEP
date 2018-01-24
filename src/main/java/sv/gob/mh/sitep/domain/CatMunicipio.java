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
import sv.gob.mh.sitep.domain.CatDepartamento;
import sv.gob.mh.sitep.domain.CatSede;

@Entity
@Setter
@Getter
@Table(name = "CAT_MUNICIPIO")
public class CatMunicipio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_CAT_MUNICIPIO")
    @SequenceGenerator(name="SEQ_CAT_MUNICIPIO",sequenceName="SEQ_CAT_MUNICIPIO")
    Integer id;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @NotNull(message ="No puede estar vacio el campo idMunicipio")
    @Column(name = "ID_MUNICIPIO",length =10, nullable = false)
    @JsonView
    String idMunicipio;


    @Column(name = "S_CREA_USUARIO",length =30, nullable = true)
    @JsonView
    String sCreaUsuario;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA", nullable = true)
    @JsonView
    Date fCreaFecha;


    @Column(name = "S_MOD_USUARIO",length =20, nullable = true)
    @JsonView
    String sModUsuario;

    @NotNull(message ="No puede estar vacio el campo descripcion")
    @Column(name = "DESCRIPCION",length =200, nullable = false)
    @JsonView
    String descripcion;


    @ManyToOne(fetch = FetchType.LAZY)
    @Getter(onMethod = @__( @JsonIgnore))
    @JoinColumns({@JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")})
    CatDepartamento catDepartamento;

    @OneToMany(mappedBy = "catMunicipio", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatSede> catSedes;


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


}

