package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.IngDecomisoImagen;

import sv.gob.mh.sitep.repository.IngDecomisoImagenRepository;
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
public class IngDecomisoImagenController {
    
    @Autowired
    IngDecomisoImagenRepository ingDecomisoImagenRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexIngDecomisoImagen")
    public ModelAndView indexIngDecomisoImagen(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ingDecomisoImagen", new IngDecomisoImagen());
        mv.setViewName("IngDecomisoImagen/IngDecomisoImagen.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveIngDecomisoImagen", method = RequestMethod.POST)
    public @ResponseBody String saveIngDecomisoImagen(@ModelAttribute("IngDecomisoImagen") @Validated IngDecomisoImagen ingDecomisoImagen ) {
         ingDecomisoImagenRepository.save(ingDecomisoImagen);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteIngDecomisoImagen", method = RequestMethod.POST)
    public @ResponseBody String deleteIngDecomisoImagen(@ModelAttribute("IngDecomisoImagen")  IngDecomisoImagen ingDecomisoImagen ) {
         ingDecomisoImagenRepository.delete(ingDecomisoImagen);
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
    @RequestMapping(value = "/gridIngDecomisoImagen", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<IngDecomisoImagen> gridIngDecomisoImagen(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<IngDecomisoImagen> list = ingDecomisoImagenRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idDecomisoImagen") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "archivo") 
            ,JqgridFilter.getField(filters, "nombreArchivo") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "idDecomiso") 
        );

       JqgridResponse<IngDecomisoImagen> jqgridIngDecomisoImagen = new JqgridResponse<IngDecomisoImagen>();
       return jqgridIngDecomisoImagen.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportIngDecomisoImagen", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportIngDecomisoImagen(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idDecomisoImagen"); 
        header.add("fModFecha"); 
        header.add("fCreaFechaLog"); 
        header.add("archivo"); 
        header.add("nombreArchivo"); 
        header.add("fCreaFecha"); 
        header.add("sCreaUsuario"); 
        header.add("sModUsuario"); 
        header.add("idDecomiso"); 
        
        LayOutDynamic.buildReport(worksheet, "IngDecomisoImagen", header);
        
        List<Object[]> list = ingDecomisoImagenRepository.findByFilters(
           JqgridFilter.getField(filters, "idDecomisoImagen") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "fCreaFechaLog") 
            ,JqgridFilter.getField(filters, "archivo") 
            ,JqgridFilter.getField(filters, "nombreArchivo") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "idDecomiso") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "IngDecomisoImagen.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

