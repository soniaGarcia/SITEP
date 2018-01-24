package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.CatSedeTelefono;

import sv.gob.mh.sitep.repository.CatSedeTelefonoRepository;
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
public class CatSedeTelefonoController {
    
    @Autowired
    CatSedeTelefonoRepository catSedeTelefonoRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexCatSedeTelefono")
    public ModelAndView indexCatSedeTelefono(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("catSedeTelefono", new CatSedeTelefono());
        mv.setViewName("CatSedeTelefono/CatSedeTelefono.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveCatSedeTelefono", method = RequestMethod.POST)
    public @ResponseBody String saveCatSedeTelefono(@ModelAttribute("CatSedeTelefono") @Validated CatSedeTelefono catSedeTelefono ) {
         catSedeTelefonoRepository.save(catSedeTelefono);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteCatSedeTelefono", method = RequestMethod.POST)
    public @ResponseBody String deleteCatSedeTelefono(@ModelAttribute("CatSedeTelefono")  CatSedeTelefono catSedeTelefono ) {
         catSedeTelefonoRepository.delete(catSedeTelefono);
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
    @RequestMapping(value = "/gridCatSedeTelefono", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<CatSedeTelefono> gridCatSedeTelefono(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<CatSedeTelefono> list = catSedeTelefonoRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idSedeTelefono") 
            ,JqgridFilter.getField(filters, "telefono") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catSedeDescriptionDelegate") 
        );

       JqgridResponse<CatSedeTelefono> jqgridCatSedeTelefono = new JqgridResponse<CatSedeTelefono>();
       return jqgridCatSedeTelefono.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportCatSedeTelefono", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportCatSedeTelefono(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idSedeTelefono"); 
        header.add("telefono"); 
        header.add("fModFecha"); 
        header.add("sCreaUsuario"); 
        header.add("fCreaFecha"); 
        header.add("sModUsuario"); 
        header.add("catSedeDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "CatSedeTelefono", header);
        
        List<Object[]> list = catSedeTelefonoRepository.findByFilters(
           JqgridFilter.getField(filters, "idSedeTelefono") 
            ,JqgridFilter.getField(filters, "telefono") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catSedeDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "CatSedeTelefono.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    
}

