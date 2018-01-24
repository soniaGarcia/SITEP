package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.IngDecomisoImagenLog;

import sv.gob.mh.sitep.repository.IngDecomisoImagenLogRepository;
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
public class IngDecomisoImagenLogController {
    
    @Autowired
    IngDecomisoImagenLogRepository ingDecomisoImagenLogRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexIngDecomisoImagenLog")
    public ModelAndView indexIngDecomisoImagenLog(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ingDecomisoImagenLog", new IngDecomisoImagenLog());
        mv.setViewName("IngDecomisoImagenLog/IngDecomisoImagenLog.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveIngDecomisoImagenLog", method = RequestMethod.POST)
    public @ResponseBody String saveIngDecomisoImagenLog(@ModelAttribute("IngDecomisoImagenLog") @Validated IngDecomisoImagenLog ingDecomisoImagenLog ) {
         ingDecomisoImagenLogRepository.save(ingDecomisoImagenLog);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteIngDecomisoImagenLog", method = RequestMethod.POST)
    public @ResponseBody String deleteIngDecomisoImagenLog(@ModelAttribute("IngDecomisoImagenLog")  IngDecomisoImagenLog ingDecomisoImagenLog ) {
         ingDecomisoImagenLogRepository.delete(ingDecomisoImagenLog);
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
    @RequestMapping(value = "/gridIngDecomisoImagenLog", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<IngDecomisoImagenLog> gridIngDecomisoImagenLog(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<IngDecomisoImagenLog> list = ingDecomisoImagenLogRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idDecomisoImagenLog") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "archivo") 
            ,JqgridFilter.getField(filters, "nombreArchivo") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "idDecomiso") 
            ,JqgridFilter.getField(filters, "idDecomisoImagen") 
        );

       JqgridResponse<IngDecomisoImagenLog> jqgridIngDecomisoImagenLog = new JqgridResponse<IngDecomisoImagenLog>();
       return jqgridIngDecomisoImagenLog.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportIngDecomisoImagenLog", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportIngDecomisoImagenLog(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idDecomisoImagenLog"); 
        header.add("fModFecha"); 
        header.add("fCreaFechaLog"); 
        header.add("archivo"); 
        header.add("nombreArchivo"); 
        header.add("fCreaFecha"); 
        header.add("sCreaUsuario"); 
        header.add("sModUsuario"); 
        header.add("idDecomiso"); 
        header.add("idDecomisoImagen"); 
        
        LayOutDynamic.buildReport(worksheet, "IngDecomisoImagenLog", header);
        
        List<Object[]> list = ingDecomisoImagenLogRepository.findByFilters(
           JqgridFilter.getField(filters, "idDecomisoImagenLog") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "archivo") 
            ,JqgridFilter.getField(filters, "nombreArchivo") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "idDecomiso") 
            ,JqgridFilter.getField(filters, "idDecomisoImagen") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "IngDecomisoImagenLog.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

