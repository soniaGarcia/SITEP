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

@Entity
@Setter
@Getter
@Table(name = "ING_DECOMISO_LOG")
public class IngDecomisoLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_DECOMISO_LOG", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_ING_DECOMISO_LOG")
    @SequenceGenerator(name="SEQ_ING_DECOMISO_LOG",sequenceName="SEQ_ING_DECOMISO_LOG")
    Integer idDecomisoLog;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA_LOG", nullable = true)
    @JsonView
    Date fCreaFechaLog;

    @NotNull(message ="No puede estar vacio el campo numeroOficio")
    @Column(name = "NUMERO_OFICIO",length =30, nullable = false)
    @JsonView
    String numeroOficio;

    @NotNull(message ="No puede estar vacio el campo idEmbalaje")
    @Column(name = "ID_EMBALAJE", nullable = false)
    @JsonView
    Integer idEmbalaje;

    @NotNull(message ="No puede estar vacio el campo idEstado")
    @Column(name = "ID_ESTADO", nullable = false)
    @JsonView
    Integer idEstado;

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

    @NotNull(message ="No puede estar vacio el campo ordenIdSede")
    @Column(name = "ORDEN_ID_SEDE", nullable = false)
    @JsonView
    Integer ordenIdSede;


    @Column(name = "JUSTIFICACION",length =300, nullable = true)
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

    @NotNull(message ="No puede estar vacio el campo idDecomiso")
    @Column(name = "ID_DECOMISO", nullable = false)
    @JsonView
    Integer idDecomiso;


    @Column(name = "S_MOD_USUARIO",length =30, nullable = true)
    @JsonView
    String sModUsuario;




}

