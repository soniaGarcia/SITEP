package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.CatTiposDevolucion;

import sv.gob.mh.sitep.repository.CatTiposDevolucionRepository;
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
public class CatTiposDevolucionController {
    
    @Autowired
    CatTiposDevolucionRepository catTiposDevolucionRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexCatTiposDevolucion")
    public ModelAndView indexCatTiposDevolucion(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("catTiposDevolucion", new CatTiposDevolucion());
        mv.setViewName("CatTiposDevolucion/CatTiposDevolucion.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveCatTiposDevolucion", method = RequestMethod.POST)
    public @ResponseBody String saveCatTiposDevolucion(@ModelAttribute("CatTiposDevolucion") @Validated CatTiposDevolucion catTiposDevolucion ) {
         catTiposDevolucionRepository.save(catTiposDevolucion);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteCatTiposDevolucion", method = RequestMethod.POST)
    public @ResponseBody String deleteCatTiposDevolucion(@ModelAttribute("CatTiposDevolucion")  CatTiposDevolucion catTiposDevolucion ) {
         catTiposDevolucionRepository.delete(catTiposDevolucion);
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
    @RequestMapping(value = "/gridCatTiposDevolucion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<CatTiposDevolucion> gridCatTiposDevolucion(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<CatTiposDevolucion> list = catTiposDevolucionRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idTiposDevolucion") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "codigo") 
            ,JqgridFilter.getField(filters, "tipo") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catEstadoDescriptionDelegate") 
        );

       JqgridResponse<CatTiposDevolucion> jqgridCatTiposDevolucion = new JqgridResponse<CatTiposDevolucion>();
       return jqgridCatTiposDevolucion.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportCatTiposDevolucion", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportCatTiposDevolucion(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idTiposDevolucion"); 
        header.add("fModFecha"); 
        header.add("sCreaUsuario"); 
        header.add("justificacion"); 
        header.add("fCreaFecha"); 
        header.add("codigo"); 
        header.add("tipo"); 
        header.add("sModUsuario"); 
        header.add("catEstadoDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "CatTiposDevolucion", header);
        
        List<Object[]> list = catTiposDevolucionRepository.findByFilters(
           JqgridFilter.getField(filters, "idTiposDevolucion") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "codigo") 
            ,JqgridFilter.getField(filters, "tipo") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catEstadoDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "CatTiposDevolucion.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

