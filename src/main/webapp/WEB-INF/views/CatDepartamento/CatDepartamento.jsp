<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="/WEB-INF/tlds/jform.tld" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/views/includes.jsp" %>
        <c:url value="/gridCatDepartamento" var="urlgridCatDepartamento" />
        <c:url value="/exportCatDepartamento" var="recordsExportUrlCatDepartamento" />
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
                        <h3>CatDepartamento
                            <small> page</small>
                        </h3>
                        <div class="jqgrid-responsive mb-lg">
                            <jf:grid urlgrid="${urlgridCatDepartamento}" 
                                     urlexport="${recordsExportUrlCatDepartamento}"
                                     entity="CatDepartamento" 
                                     caption="CatDepartamento grid"
                                     />
                        </div>
                    </div>
                </div>
            </section>
            <!-- Page footer-->
            <%@include file="/WEB-INF/views/footer.jsp" %>
        </div>

        <!-- Modal-->
        <div id="modalCatDepartamento" tabindex="-1" role="dialog" aria-labelledby="myModalLabelLarge" aria-hidden="true" class="modal fade">
           <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" data-dismiss="modal" aria-label="Close" class="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 id="myModalLabelLarge" class="modal-title">Person Tittle</h4>
                    </div>

                    <div class="modal-body">
                       <form method="POST" id="formCatDepartamento" action="${urlsaveCatDepartamento}" data-parsley-validate="" novalidate="" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">ID DEL DEPARTAMENTO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="1" maxlength="10"   id="idDepartamento" name="idDepartamento"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">F_MOD_FECHA</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="1"   id="fModFecha" name="fModFecha" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">F_CREA_FECHA</label>
                                         <div class="col-lg-10">

                                         <jf:datetime tabindex="2"   id="fCreaFecha" name="fCreaFecha" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">DESCRIPCION</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="3" maxlength="50"   id="descripcion" name="descripcion"  required="true" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">S_CREA_USUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="4" maxlength="20"   id="sCreaUsuario" name="sCreaUsuario" />
                                         </div>
                                     </div>
 
                                    <div class="form-group">
                                         <label class="col-sm-2 control-label">S_MOD_USUARIO</label>
                                         <div class="col-lg-10">

                                         <jf:textbox  tabindex="5" maxlength="20"   id="sModUsuario" name="sModUsuario" />
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
        

