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
import sv.gob.mh.sitep.domain.CatSedeLog;
import sv.gob.mh.sitep.domain.CatFuncionario;
import sv.gob.mh.sitep.domain.IngDecomiso;
import sv.gob.mh.sitep.domain.CatEmbalaje;
import sv.gob.mh.sitep.domain.CatTiposDevolucion;

@Entity
@Setter
@Getter
@Table(name = "CAT_ESTADO")
public class CatEstado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_ESTADO", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_CAT_ESTADO")
    @SequenceGenerator(name="SEQ_CAT_ESTADO",sequenceName="SEQ_CAT_ESTADO")
    Integer idEstado;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @NotNull(message ="No puede estar vacio el campo descripcion")
    @Column(name = "DESCRIPCION",length =300, nullable = false)
    @JsonView
    String descripcion;


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


    @OneToMany(mappedBy = "catEstado", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatSedeLog> catSedeLogs;

    @OneToMany(mappedBy = "catEstado", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatFuncionario> catFuncionarios;

    @OneToMany(mappedBy = "catEstado", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<IngDecomiso> ingDecomisos;

    @OneToMany(mappedBy = "catEstado", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatEmbalaje> catEmbalajes;

    @OneToMany(mappedBy = "catEstado", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @Getter(onMethod = @__(@JsonIgnore))
    List<CatTiposDevolucion> catTiposDevolucions;



}

