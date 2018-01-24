<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridCatSede" var="urlgridCatSede" />
        <c:url value="/exportCatSede" var="recordsExportUrlCatSede" />
    </head>
    <body>
        <div class="wrapper">
            <!-- top navbar-->
            <%@include file="/WEB-INF/views/header.jsp" %>
            <!-- sidebar-->
            <%@include file="/WEB-INF/views/menu.jsp" %>
            <!-- offsidebar-->
            <%@include file="/WEB-INF/views/settings.jsp" %>
            <!-- Main section-->
            <section>
                <!-- Page content-->
                <div class="content-wrapper">
                    <div class="row">
                        <h3>CatSede
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
                            <jf:grid urlgrid="${urlgridCatSede}" 
                                     urlexport="${recordsExportUrlCatSede}"
                                     entity="CatSede" 
                                     caption="CatSede grid"
                                     />
                        </div>
                    </div>
                </div>
            </section>
            <!-- Page footer-->
            <%@include file="/WEB-INF/views/footer.jsp" %>
        </div>

        <!-- Modal-->
        <div id="modalCatSede" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formCatSede" action="${urlsaveCatSede}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">CORRELATIVO DE LA SEDE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idSede" name="idSede"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">F_MOD_FECHA</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="1"   id="fModFecha" name="fModFecha" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DIRECCION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="2" maxlength="300"   id="direccion" name="direccion"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NOMBRE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="300"   id="nombre" name="nombre"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID_ESTADO</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idEstado" name="idEstado"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">CODIGO_SEDE</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="5" maxlength="20"   id="codigoSede" name="codigoSede" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">S_CREA_USUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="6" maxlength="30"   id="sCreaUsuario" name="sCreaUsuario" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">JUSTIFICACION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="7" maxlength="1000"   id="justificacion" name="justificacion"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">F_CREA_FECHA</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="8"   id="fCreaFecha" name="fCreaFecha" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DEPENDENCIA</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="9" maxlength="300"   id="dependencia" name="dependencia" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">CODIGO_SOLICITUD</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="10" maxlength="20"   id="codigoSolicitud" name="codigoSolicitud" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">OBSERVACIONES</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="11" maxlength="300"   id="observaciones" name="observaciones" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">S_MOD_USUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="12" maxlength="30"   id="sModUsuario" name="sModUsuario" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID TIPO DE SEDE A INGRESAR</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/sitep/cbofilterCatTipoSede"   id="catTipoSedeDelegate"  name="catTipoSede.idTipoSede"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID DEL DEPARTAMENTO</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/sitep/cbofilterCatDepartamento"   id="catDepartamentoDelegate"  name="catDepartamento.idDepartamento"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ES LA PK DE LA TABLA CAT_MUNICIPIO</label>
                                         <div class="col-lg-10">

                                             <jf:combobox url="/sitep/cbofilterCatMunicipio"   id="catMunicipioDelegate"  name="catMunicipio.idMunicipio" />
                                         </div>
                                     </div>
 
                                </div>
                                <div class="panel-footer text-right">
                                    <button type="button" data-dismiss="modal" class="btn btn-default">Close</button>
                                    <button type="submit" class="btn btn-">Run validation</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
        

