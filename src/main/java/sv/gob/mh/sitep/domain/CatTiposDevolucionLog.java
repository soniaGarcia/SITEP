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
@Table(name = "CAT_TIPOS_DEVOLUCION_LOG")
public class CatTiposDevolucionLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_TIPOS_DEVOLUCION_LOG", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_CAT_TIPOS_DEVOLUCION_LOG")
    @SequenceGenerator(name="SEQ_CAT_TIPOS_DEVOLUCION_LOG",sequenceName="SEQ_CAT_TIPOS_DEVOLUCION_LOG")
    Integer idTiposDevolucionLog;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_MOD_FECHA", nullable = true)
    @JsonView
    Date fModFecha;

    @NotNull(message ="No puede estar vacio el campo idTiposDevolucion")
    @Column(name = "ID_TIPOS_DEVOLUCION", nullable = false)
    @JsonView
    Integer idTiposDevolucion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA_LOG", nullable = true)
    @JsonView
    Date fCreaFechaLog;

    @NotNull(message ="No puede estar vacio el campo idEstado")
    @Column(name = "ID_ESTADO", nullable = false)
    @JsonView
    Integer idEstado;


    @Column(name = "S_CREA_USUARIO",length =30, nullable = true)
    @JsonView
    String sCreaUsuario;

    @NotNull(message ="No puede estar vacio el campo codigo")
    @Column(name = "CODIGO",length =7, nullable = false)
    @JsonView
    String codigo;


    @Column(name = "JUSTIFICACION",length =300, nullable = true)
    @JsonView
    String justificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA", nullable = true)
    @JsonView
    Date fCreaFecha;

    @NotNull(message ="No puede estar vacio el campo tipo")
    @Column(name = "TIPO",length =50, nullable = false)
    @JsonView
    String tipo;


    @Column(name = "S_MOD_USUARIO",length =30, nullable = true)
    @JsonView
    String sModUsuario;




}

