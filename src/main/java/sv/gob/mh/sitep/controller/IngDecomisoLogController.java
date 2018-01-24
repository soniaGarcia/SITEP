package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.IngDecomisoLog;

import sv.gob.mh.sitep.repository.IngDecomisoLogRepository;
import sv.gob.mh.sitep.poi.LayOutDynamic;
import sv.gob.mh.sitep.poi.Writer;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import sv.gob.mh.sitep.common.CboFilter;
import java.util.Date;

@Controller
@RequestMapping("/")
public class IngDecomisoLogController {
    
    @Autowired
    IngDecomisoLogRepository ingDecomisoLogRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexIngDecomisoLog")
    public ModelAndView indexIngDecomisoLog(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ingDecomisoLog", new IngDecomisoLog());
        mv.setViewName("IngDecomisoLog/IngDecomisoLog.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveIngDecomisoLog", method = RequestMethod.POST)
    public @ResponseBody String saveIngDecomisoLog(@ModelAttribute("IngDecomisoLog") @Validated IngDecomisoLog ingDecomisoLog ) {
         ingDecomisoLogRepository.save(ingDecomisoLog);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteIngDecomisoLog", method = RequestMethod.POST)
    public @ResponseBody String deleteIngDecomisoLog(@ModelAttribute("IngDecomisoLog")  IngDecomisoLog ingDecomisoLog ) {
         ingDecomisoLogRepository.delete(ingDecomisoLog);
         return null;
     }
    
    /**
    * Controlador para obtener la data y devolverla a un jqgrid Paginado por medio de Ajax
    * @return JqgridResponse lleno con la data paginada
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @Param page la pagina actual del jqgrid
    * @Param rows la cantidad de filas a mostrar en la paginacion
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/gridIngDecomisoLog", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<IngDecomisoLog> gridIngDecomisoLog(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<IngDecomisoLog> list = ingDecomisoLogRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idDecomisoLog") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "numeroOficio") 
            ,JqgridFilter.getField(filters, "idEmbalaje") 
            ,JqgridFilter.getField(filters, "idEstado") 
            ,JqgridFilter.getField(filters, "referencia") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "fechaOficio") 
            ,JqgridFilter.getField(filters, "ordenIdSede") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "idSede") 
            ,JqgridFilter.getField(filters, "idDecomiso") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
        );

       JqgridResponse<IngDecomisoLog> jqgridIngDecomisoLog = new JqgridResponse<IngDecomisoLog>();
       return jqgridIngDecomisoLog.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportIngDecomisoLog", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportIngDecomisoLog(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idDecomisoLog"); 
        header.add("fModFecha"); 
        header.add("fCreaFechaLog"); 
        header.add("numeroOficio"); 
        header.add("idEmbalaje"); 
        header.add("idEstado"); 
        header.add("referencia"); 
        header.add("sCreaUsuario"); 
        header.add("fechaOficio"); 
        header.add("ordenIdSede"); 
        header.add("justificacion"); 
        header.add("fCreaFecha"); 
        header.add("idSede"); 
        header.add("idDecomiso"); 
        header.add("sModUsuario"); 
        
        LayOutDynamic.buildReport(worksheet, "IngDecomisoLog", header);
        
        List<Object[]> list = ingDecomisoLogRepository.findByFilters(
           JqgridFilter.getField(filters, "idDecomisoLog") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "numeroOficio") 
            ,JqgridFilter.getField(filters, "idEmbalaje") 
            ,JqgridFilter.getField(filters, "idEstado") 
            ,JqgridFilter.getField(filters, "referencia") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "fechaOficio") 
            ,JqgridFilter.getField(filters, "ordenIdSede") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "idSede") 
            ,JqgridFilter.getField(filters, "idDecomiso") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "IngDecomisoLog.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

