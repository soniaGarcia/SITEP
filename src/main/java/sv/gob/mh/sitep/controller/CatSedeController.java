package sv.gob.mh.sitep.controller;

import java.util.List;
import sv.gob.mh.sitep.common.ObjectUtils;
import sv.gob.mh.sitep.common.JqgridFilter;
import sv.gob.mh.sitep.common.JqgridResponse;
import sv.gob.mh.sitep.domain.CatSede;

import sv.gob.mh.sitep.repository.CatSedeRepository;
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
public class CatSedeController {
    
    @Autowired
    CatSedeRepository catSedeRepository;
    
    /**
    /**
    * Controlador para ingresar a la pantalla index
    * @return ModelAndView con el nombre de la pagina jsp
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping("/indexCatSede")
    public ModelAndView indexCatSede(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("catSede", new CatSede());
        mv.setViewName("CatSede/CatSede.jsp");
        return mv;
    }
    
    /**
    * Controlador para guardar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para guardarlo directamente en la base de datos
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/saveCatSede", method = RequestMethod.POST)
    public @ResponseBody String saveCatSede(@ModelAttribute("CatSede") @Validated CatSede catSede ) {
         catSedeRepository.save(catSede);
         return null;
     }
    
    /**
    * Controlador para eliminar por medio de Ajax
    * @return String pero se le coloca null para indicar que no hubo ningun error
    * @Param Modelo que vendra lleno para eliminarlo directamente en la base de datos, se elimina por medio del @Id
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/deleteCatSede", method = RequestMethod.POST)
    public @ResponseBody String deleteCatSede(@ModelAttribute("CatSede")  CatSede catSede ) {
         catSedeRepository.delete(catSede);
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
    @RequestMapping(value = "/gridCatSede", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody JqgridResponse<CatSede> gridCatSede(
        @RequestParam(value = "filters", required = false) String filters,
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "rows", required = false) Integer rows
    ) {
    
        Page<CatSede> list = catSedeRepository.findByFilters(
            new PageRequest(page - 1, rows)
           ,JqgridFilter.getField(filters, "idSede") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "direccion") 
            ,JqgridFilter.getField(filters, "nombre") 
            ,JqgridFilter.getField(filters, "idEstado") 
            ,JqgridFilter.getField(filters, "codigoSede") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "dependencia") 
            ,JqgridFilter.getField(filters, "codigoSolicitud") 
            ,JqgridFilter.getField(filters, "observaciones") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catTipoSedeDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catDepartamentoDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catMunicipioDescriptionDelegate") 
        );

       JqgridResponse<CatSede> jqgridCatSede = new JqgridResponse<CatSede>();
       return jqgridCatSede.jGridFill(list, page, rows);
    }
    
    /**
    * Controlador para exportar a excel
    * @return void 
    * @Param filters trae las columnas que se utilizaran para filtrar la query
    * @author Generador-Safi
    * @version 1.0
    */
    @RequestMapping(value = "/exportCatSede", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void exportCatSede(
        HttpServletResponse response,@RequestParam(value = "filters", required = false) String filters
    ) {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("libro");
        
        List<String> header = new ArrayList<String>();
        header.add("idSede"); 
        header.add("fModFecha"); 
        header.add("direccion"); 
        header.add("nombre"); 
        header.add("idEstado"); 
        header.add("codigoSede"); 
        header.add("sCreaUsuario"); 
        header.add("justificacion"); 
        header.add("fCreaFecha"); 
        header.add("dependencia"); 
        header.add("codigoSolicitud"); 
        header.add("observaciones"); 
        header.add("sModUsuario"); 
        header.add("catTipoSedeDescriptionDelegate"); 
        header.add("catDepartamentoDescriptionDelegate"); 
        header.add("catMunicipioDescriptionDelegate"); 
        
        LayOutDynamic.buildReport(worksheet, "CatSede", header);
        
        List<Object[]> list = catSedeRepository.findByFilters(
           JqgridFilter.getField(filters, "idSede") 
            ,JqgridFilter.getField(filters, "fModFecha") 
            ,JqgridFilter.getField(filters, "direccion") 
            ,JqgridFilter.getField(filters, "nombre") 
            ,JqgridFilter.getField(filters, "idEstado") 
            ,JqgridFilter.getField(filters, "codigoSede") 
            ,JqgridFilter.getField(filters, "sCreaUsuario") 
            ,JqgridFilter.getField(filters, "justificacion") 
            ,JqgridFilter.getField(filters, "fCreaFecha") 
            ,JqgridFilter.getField(filters, "dependencia") 
            ,JqgridFilter.getField(filters, "codigoSolicitud") 
            ,JqgridFilter.getField(filters, "observaciones") 
            ,JqgridFilter.getField(filters, "sModUsuario") 
            ,JqgridFilter.getField(filters, "catTipoSedeDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catDepartamentoDescriptionDelegate") 
            ,JqgridFilter.getField(filters, "catMunicipioDescriptionDelegate") 
        );
        

       LayOutDynamic.fillReport(worksheet, header.size(),list);
       String fileName = "CatSede.xls";
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
    @RequestMapping(value = {"/cbofilterCatSede"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody List<CboFilter> cbofilterCatSede() {
        List<CatSede> list = catSedeRepository.findAll();
        List<CboFilter> response = new ArrayList<CboFilter>();
        for (int i = 0; i < list.size(); i++) {
            response.add(new CboFilter(list.get(i).getIdSede().toString(), list.get(i).getIdSede().toString()));
        }
        return response;
    }
    
}

