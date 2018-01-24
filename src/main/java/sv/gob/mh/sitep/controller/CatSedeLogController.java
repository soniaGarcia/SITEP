package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.CatSedeLog;

import sv.gob.mh.sitep.repository.CatSedeLogRepository;
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
public class CatSedeLogController {
    
    @Autowired
    CatSedeLogRepository catSedeLogRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexCatSedeLog")
    public ModelAndView indexCatSedeLog(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("catSedeLog", new CatSedeLog());
        mv.setViewName("CatSedeLog/CatSedeLog.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveCatSedeLog", method = RequestMethod.POST)
    public @ResponseBody String saveCatSedeLog(@ModelAttribute("CatSedeLog") @Validated CatSedeLog catSedeLog ) {
         catSedeLogRepository.save(catSedeLog);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteCatSedeLog", method = RequestMethod.POST)
    public @ResponseBody String deleteCatSedeLog(@ModelAttribute("CatSedeLog")  CatSedeLog catSedeLog ) {
         catSedeLogRepository.delete(catSedeLog);
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
    @RequestMapping(value = "/gridCatSedeLog", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<CatSedeLog> gridCatSedeLog(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<CatSedeLog> list = catSedeLogRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idSedeLog") 
            ,JqgridFilter.getField(filters, "direccion") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "nombre") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "idDepartamento") 
            ,JqgridFilter.getField(filters, "codigoSede") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "idSede") 
            ,JqgridFilter.getField(filters, "idTipoSede") 
            ,JqgridFilter.getField(filters, "dependencia") 
            ,JqgridFilter.getField(filters, "codigoSolicitud") 
            ,JqgridFilter.getField(filters, "observaciones") 
            ,JqgridFilter.getField(filters, "idMunicipio") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catEstadoDescriptionDelegate") 
        );

       JqgridResponse<CatSedeLog> jqgridCatSedeLog = new JqgridResponse<CatSedeLog>();
       return jqgridCatSedeLog.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportCatSedeLog", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportCatSedeLog(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idSedeLog"); 
        header.add("direccion"); 
        header.add("fModFecha"); 
        header.add("nombre"); 
        header.add("fCreaFechaLog"); 
        header.add("idDepartamento"); 
        header.add("codigoSede"); 
        header.add("sCreaUsuario"); 
        header.add("justificacion"); 
        header.add("fCreaFecha"); 
        header.add("idSede"); 
        header.add("idTipoSede"); 
        header.add("dependencia"); 
        header.add("codigoSolicitud"); 
        header.add("observaciones"); 
        header.add("idMunicipio"); 
        header.add("sModUsuario"); 
        header.add("catEstadoDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "CatSedeLog", header);
        
        List<Object[]> list = catSedeLogRepository.findByFilters(
           JqgridFilter.getField(filters, "idSedeLog") 
            ,JqgridFilter.getField(filters, "direccion") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "nombre") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "idDepartamento") 
            ,JqgridFilter.getField(filters, "codigoSede") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "idSede") 
            ,JqgridFilter.getField(filters, "idTipoSede") 
            ,JqgridFilter.getField(filters, "dependencia") 
            ,JqgridFilter.getField(filters, "codigoSolicitud") 
            ,JqgridFilter.getField(filters, "observaciones") 
            ,JqgridFilter.getField(filters, "idMunicipio") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catEstadoDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "CatSedeLog.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

