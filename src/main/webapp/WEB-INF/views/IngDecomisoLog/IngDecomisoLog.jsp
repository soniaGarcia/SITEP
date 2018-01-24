<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridIngDecomisoLog" var="urlgridIngDecomisoLog" />
        <c:url value="/exportIngDecomisoLog" var="recordsExportUrlIngDecomisoLog" />
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
                        <h3>IngDecomisoLog
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
                            <jf:grid urlgrid="${urlgridIngDecomisoLog}" 
                                     urlexport="${recordsExportUrlIngDecomisoLog}"
                                     entity="IngDecomisoLog" 
                                     caption="IngDecomisoLog grid"
                                     />
                        </div>
                    </div>
                </div>
            </section>
            <!-- Page footer-->
            <%@include file="/WEB-INF/views/footer.jsp" %>
        </div>

        <!-- Modal-->
        <div id="modalIngDecomisoLog" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formIngDecomisoLog" action="${urlsaveIngDecomisoLog}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID DEL DECOMISO LOG</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idDecomisoLog" name="idDecomisoLog"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">F_MOD_FECHA</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="1"   id="fModFecha" name="fModFecha" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">F_CREA_FECHA_LOG</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="2"   id="fCreaFechaLog" name="fCreaFechaLog" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">NUMERO_OFICIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="30"   id="numeroOficio" name="numeroOficio"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID_EMBALAJE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idEmbalaje" name="idEmbalaje"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID_ESTADO</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idEstado" name="idEstado"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">REFERENCIA</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="6" maxlength="30"   id="referencia" name="referencia"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">S_CREA_USUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="7" maxlength="30"   id="sCreaUsuario" name="sCreaUsuario" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">FECHA_OFICIO</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="8"   id="fechaOficio" name="fechaOficio"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ORDEN_ID_SEDE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="ordenIdSede" name="ordenIdSede"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">JUSTIFICACION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="10" maxlength="300"   id="justificacion" name="justificacion" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">F_CREA_FECHA</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="11"   id="fCreaFecha" name="fCreaFecha" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID_SEDE</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idSede" name="idSede"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID_DECOMISO</label>
                                         <div class="col-lg-10">

                                         <jf:numberbox  precision="10"    id="idDecomiso" name="idDecomiso"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">S_MOD_USUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="14" maxlength="30"   id="sModUsuario" name="sModUsuario" />
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
        

