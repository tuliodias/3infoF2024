package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.Cidade;
import modelo.DAOCidade;

public final class ListarCidade_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");

DAOCidade  objDAOCidade = new DAOCidade();
List<Cidade> listaCidade = objDAOCidade.listarCidade();


      out.write("\n");
      out.write("\n");
      out.write("<table border=\"1\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>CODIGO</th>\n");
      out.write("            <th>NOME</th>\n");
      out.write("            <th>UF</th>\n");
      out.write("            <th>ALTERAR</th>\n");
      out.write("            <th>EXCLUIR</th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");
 for(Cidade cidade :listaCidade){ 
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( cidade.getCodigoCidade() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cidade.getNomeCidade() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( cidade.getUfCifade() );
      out.write("</td>\n");
      out.write("            <td><a href=\"CadastroCidade.jsp?opcao=alterar&codigoCidade=");
      out.print( cidade.getCodigoCidade() );
      out.write("&nomeCidade=");
      out.print( cidade.getNomeCidade() );
      out.write("&ufCidade=");
      out.print( cidade.getUfCifade() );
      out.write("\">alterar</a> </td>\n");
      out.write("            <td><a href=\"CadastroCidade.jsp?opcao=excluir&codigoCidade=");
      out.print( cidade.getCodigoCidade() );
      out.write("&nomeCidade=");
      out.print( cidade.getNomeCidade() );
      out.write("&ufCidade=");
      out.print( cidade.getUfCifade() );
      out.write("\">excluir</a> </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>");
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
