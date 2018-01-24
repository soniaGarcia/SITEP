package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.IngDecomiso;

import sv.gob.mh.sitep.repository.IngDecomisoRepository;
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
public class IngDecomisoController {
    
    @Autowired
    IngDecomisoRepository ingDecomisoRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexIngDecomiso")
    public ModelAndView indexIngDecomiso(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("ingDecomiso", new IngDecomiso());
        mv.setViewName("IngDecomiso/IngDecomiso.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveIngDecomiso", method = RequestMethod.POST)
    public @ResponseBody String saveIngDecomiso(@ModelAttribute("IngDecomiso") @Validated IngDecomiso ingDecomiso ) {
         ingDecomisoRepository.save(ingDecomiso);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteIngDecomiso", method = RequestMethod.POST)
    public @ResponseBody String deleteIngDecomiso(@ModelAttribute("IngDecomiso")  IngDecomiso ingDecomiso ) {
         ingDecomisoRepository.delete(ingDecomiso);
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
    @RequestMapping(value = "/gridIngDecomiso", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<IngDecomiso> gridIngDecomiso(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<IngDecomiso> list = ingDecomisoRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idDecomiso") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "numeroOficio") 
            ,JqgridFilter.getField(filters, "referencia") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "fechaOficio") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catSedeByidSedeDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catEmbalajeDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catEstadoDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catSedeByordenIdSedeDescriptionDelegate") 
        );

       JqgridResponse<IngDecomiso> jqgridIngDecomiso = new JqgridResponse<IngDecomiso>();
       return jqgridIngDecomiso.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportIngDecomiso", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportIngDecomiso(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idDecomiso"); 
        header.add("fModFecha"); 
        header.add("numeroOficio"); 
        header.add("referencia"); 
        header.add("sCreaUsuario"); 
        header.add("fechaOficio"); 
        header.add("justificacion"); 
        header.add("fCreaFecha"); 
        header.add("sModUsuario"); 
        header.add("catSedeByidSedeDescriptionDelegate"); 
        header.add("catEmbalajeDescriptionDelegate"); 
        header.add("catEstadoDescriptionDelegate"); 
        header.add("catSedeByordenIdSedeDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "IngDecomiso", header);
        
        List<Object[]> list = ingDecomisoRepository.findByFilters(
           JqgridFilter.getField(filters, "idDecomiso") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "numeroOficio") 
            ,JqgridFilter.getField(filters, "referencia") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "fechaOficio") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catSedeByidSedeDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catEmbalajeDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catEstadoDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catSedeByordenIdSedeDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "IngDecomiso.xls";
       response.setHeader("Content-Disposition", "inline; filename=" + fileName);
       response.setContentType("application/vnd.ms-excel");
       Writer.write(response, worksheet);
    }
    
    /**
    * Controlador para obtener las llaves padres de la entidad
    * @return List<CboFilter> Devuelve una lista de objeto llena con los id y descripcion del padre
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = {"/cbofilterIngDecomiso"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterIngDecomiso() {
        List<IngDecomiso> list = ingDecomisoRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdDecomiso().toString(), list.get(i).getIdDecomiso().toString()));
        }
        return response;
    }
    
}

