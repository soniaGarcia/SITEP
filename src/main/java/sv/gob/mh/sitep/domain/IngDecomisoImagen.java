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
@Table(name = "ING_DECOMISO_IMAGEN")
public class IngDecomisoImagen implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "ID_DECOMISO_IMAGEN", nullable = false)
    @JsonView
    @GeneratedValue(strategy =GenerationType.AUTO, generator = "SEQ_ING_DECOMISO_IMAGEN")
    @SequenceGenerator(name="SEQ_ING_DECOMISO_IMAGEN",sequenceName="SEQ_ING_DECOMISO_IMAGEN")
    Integer idDecomisoImagen;


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

    @NotNull(message ="No puede estar vacio el campo archivo")
    @Column(name = "ARCHIVO", nullable = false)
    @JsonView
    Byte[] archivo;

    @NotNull(message ="No puede estar vacio el campo nombreArchivo")
    @Column(name = "NOMBRE_ARCHIVO",length =300, nullable = false)
    @JsonView
    String nombreArchivo;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")

    @Column(name = "F_CREA_FECHA", nullable = true)
    @JsonView
    Date fCreaFecha;


    @Column(name = "S_CREA_USUARIO",length =20, nullable = true)
    @JsonView
    String sCreaUsuario;


    @Column(name = "S_MOD_USUARIO",length =20, nullable = true)
    @JsonView
    String sModUsuario;

    @NotNull(message ="No puede estar vacio el campo idDecomiso")
    @Column(name = "ID_DECOMISO", nullable = false)
    @JsonView
    Integer idDecomiso;




}

