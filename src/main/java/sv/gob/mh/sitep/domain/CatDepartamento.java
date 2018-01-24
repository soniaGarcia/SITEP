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
import sv.gob.mh.sitep.domain.CatMunicipio;
import sv.gob.mh.sitep.domain.CatSede;

@Entity
@Setter
@Getter
@Table(name = "CAT_DEPARTAMENTO")
public class CatDepartamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_DEPARTAMENTO",length =10, nullable = false)
    @JsonView
    String idDepartamento;


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

    @NotNull(message ="No puede estar vacio el campo descripcion")
    @Column(name = "DESCRIPCION",length =50, nullable = false)
    @JsonView
    String descripcion;


    @Column(name = "S_CREA_USUARIO",length =20, nullable = true)
    @JsonView
    String sCreaUsuario;


    @Column(name = "S_MOD_USUARIO",length =20, nullable = true)
    @JsonView
    String sModUsuario;


    @OneToMany(mappedBy = "catDepartamento", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatMunicipio> catMunicipios;

    @OneToMany(mappedBy = "catDepartamento", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatSede> catSedes;



}

