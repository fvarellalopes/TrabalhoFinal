package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usuarioscadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/admin/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../img/favicon.ico\">\n");
      out.write("        <title>Cadastro de Usuários</title>        \n");
      out.write("        <link href=\"../css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../css/geral.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"loadData()\">\n");
      out.write("        ");
      out.write("<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <a class=\"navbar-brand\" href=\"#\">Loja</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"collapse navbar-collapse\">\n");
      out.write("          <ul class=\"nav navbar-nav\">\n");
      out.write("            <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Cadastros\n");
      out.write("                    <b class=\"caret\"></b></a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("                    <li><a href=\"produtos.jsp\">Produtos</a></li>\n");
      out.write("                    <li><a href=\"categorias.jsp\">Categorias</a></li>\n");
      out.write("                    <li><a href=\"usuarios.jsp\">Usuários</a></li>\n");
      out.write("                    <li class=\"divider\"></li>\n");
      out.write("                    <li class=\"navbar-header\">Vendas</li>\n");
      out.write("                    <li><a href=\"#clientes\">Clientes</a></li>\n");
      out.write("                    <li><a href=\"#vendas\">Vendas</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li><a href=\"#about\">Sobre</a></li>\n");
      out.write("            <li><a href=\"#contact\">Contato</a></li>\n");
      out.write("          </ul>\n");
      out.write("        </div><!--/.nav-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </div>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-1 col-md-offset-3\">\n");
      out.write("                    <fieldset>\n");
      out.write("                        <form id=\"frm\" name=\"frm\" class=\"well span6\" role=\"form\" method=\"POST\" \n");
      out.write("                              action=\"UsuarioController?acao=salvar\" >\n");
      out.write("                            <legend>Cadastro de Usuários</legend>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"id\">Código</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" readonly id=\"usuarioid\" name=\"usuarioid\" \n");
      out.write("                                       value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"nome\">Nome</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"nome\" name=\"nome\" \n");
      out.write("                                       value=\"\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"login\">Login</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"login\" name=\"login\" \n");
      out.write("                                       value=\"\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\">Email</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" \n");
      out.write("                                       value=\"\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"senha\">Senha</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"senha\" name=\"senha\" \n");
      out.write("                                       value=\"\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"confirmar\">Confirmar Senha</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"senhaconf\" name=\"senhaconf\" \n");
      out.write("                                       value=\"\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"reset\" class=\"btn btn-default\">\n");
      out.write("                                Limpar\n");
      out.write("                            </button>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">\n");
      out.write("                                Salvar\n");
      out.write("                            </button>\n");
      out.write("                            <br /><br />\n");
      out.write("                            <div id=\"divErro\" class=\"alert alert-danger\" style=\"display: none;\"></div>\n");
      out.write("                            <div id=\"divSucesso\" class=\"alert alert-success\" style=\"display: none;\"></div>\n");
      out.write("                    </fieldset>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div><!-- /.container -->\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("        ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-2.0.3.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/bootstrap.js\"></script>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        var form = $('#frm');\n");
      out.write("        //No submit do form salva os dados\n");
      out.write("        form.submit(function() {\n");
      out.write("            //Os dados do forumário fazem comunicação através de Ajax\n");
      out.write("            //Com o servlet de usuários\n");
      out.write("            $.ajax({\n");
      out.write("                type: form.attr('method'),\n");
      out.write("                url: form.attr('action'),\n");
      out.write("                data: form.serialize(),\n");
      out.write("                //Caso a comunicação ocorra com sucesso, a variável data\n");
      out.write("                //possui o retorno do servlet\n");
      out.write("                success: function(data) {\n");
      out.write("                    \n");
      out.write("                    //a variável retorno vai conter as propriedades vindas\n");
      out.write("                    //do UsuarioController na ação Salvar.\n");
      out.write("                    var retorno = $.parseJSON(data);\n");
      out.write("                    $(\"#divErro\").hide(\"fast\");\n");
      out.write("                    $(\"#divSucesso\").hide(\"fast\");\n");
      out.write("                    if (retorno.situacao === \"OK\") {\n");
      out.write("                        $(\"#usuarioid\").attr('value', retorno.id);\n");
      out.write("                        $(\"#divSucesso\").html(retorno.mensagem);\n");
      out.write("                        $(\"#divSucesso\").show(\"slow\");\n");
      out.write("                    } else {\n");
      out.write("                        var msg = \"\";\n");
      out.write("                        $.each(retorno.mensagem, function() {\n");
      out.write("                            $.each(this, function(index, value) {\n");
      out.write("                                msg += value + '<br />';\n");
      out.write("                            });\n");
      out.write("                        });\n");
      out.write("                        $(\"#divErro\").html(msg);\n");
      out.write("                        $(\"#divErro\").show(\"slow\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            return false;\n");
      out.write("        }); //FIM SALVAR\n");
      out.write("\n");
      out.write("        //Carrega dados do usuário\n");
      out.write("        function loadData() {\n");
      out.write("            var id = $(\"#usuarioid\").val();\n");
      out.write("            if (id <= 0) {\n");
      out.write("                caregacombo(0);\n");
      out.write("            } else {\n");
      out.write("                var destino = 'UsuarioController?acao=carregar&usuarioid=' + id;\n");
      out.write("                $.ajax({\n");
      out.write("                    type: 'POST',\n");
      out.write("                    url: destino,\n");
      out.write("                    success: function(data) {\n");
      out.write("                        var json = $.parseJSON(data);\n");
      out.write("                        $(\"#usuarioid\").val(json.usuarioid);\n");
      out.write("                        $(\"#nome\").val(json.nome);\n");
      out.write("                        $(\"#email\").val(json.email);\n");
      out.write("                        $(\"#login\").val(json.login);\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        }//fim loadData\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
