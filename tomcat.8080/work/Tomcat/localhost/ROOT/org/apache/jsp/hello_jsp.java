/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2017-02-10 09:37:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class hello_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/tags/layout.tag", Long.valueOf(1486445745181L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_t_005flayout_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");

    /*String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	out.print(basePath);*/

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\tvar app = angular.module(\"Embedded\",[]);\r\n");
      out.write("\tapp.controller(\"BASE\",baseFunc);\r\n");
      out.write("\t\r\n");
      out.write("\tfunction baseFunc($scope,$http,$location){\r\n");
      out.write("\t\t$scope.Dpost = \"\";\r\n");
      out.write("\t\t$scope.Dput = \"\";\r\n");
      out.write("\t\t$scope.Ddelete = \"\";\r\n");
      out.write("\t\t$scope.Dmail = \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.send_post = function(){\r\n");
      out.write("\t\t\t$http({\r\n");
      out.write("\t\t\t\tmethod:'POST',\r\n");
      out.write("\t\t\t\turl:$location.absUrl(),\r\n");
      out.write("\t\t\t\tdata:$.param({key:\"987\",key2:\"k555\",key3:\"ey99\"}),\r\n");
      out.write("\t\t\t\theaders: {'Content-Type': 'application/x-www-form-urlencoded'}\r\n");
      out.write("\t\t\t}).then(function success(msg){\r\n");
      out.write("\t\t\t\tconsole.log(msg);\r\n");
      out.write("\t\t\t\t$scope.Dpost = {\r\n");
      out.write("\t\t\t\t\tdata:msg.data,\r\n");
      out.write("\t\t\t\t\tmethod:msg.config.method,\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t},function error(err){\r\n");
      out.write("\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.send_put = function(){\r\n");
      out.write("\t\t\t$http({\r\n");
      out.write("\t\t\t\tmethod:'PUT',\r\n");
      out.write("\t\t\t\turl:$location.absUrl(),\r\n");
      out.write("\t\t\t\tdata:$.param({key:\"987\",key2:\"k555\",key3:\"ey99\"}),\r\n");
      out.write("\t\t\t\theaders: {'Content-Type': 'application/x-www-form-urlencoded'}\r\n");
      out.write("\t\t\t}).then(function success(msg){\r\n");
      out.write("\t\t\t\tconsole.log(msg);\r\n");
      out.write("\t\t\t\t$scope.Dput = {\r\n");
      out.write("\t\t\t\t\tdata:msg.data,\r\n");
      out.write("\t\t\t\t\tmethod:msg.config.method,\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t},function error(err){\r\n");
      out.write("\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.send_delete = function(){\r\n");
      out.write("\t\t\t$http({\r\n");
      out.write("\t\t\t\tmethod:'DELETE',\r\n");
      out.write("\t\t\t\turl:$location.absUrl(),\r\n");
      out.write("\t\t\t\tdata:$.param({key:\"987\",key2:\"k555\",key3:\"ey99\"}),\r\n");
      out.write("\t\t\t\theaders: {'Content-Type': 'application/x-www-form-urlencoded'}\r\n");
      out.write("\t\t\t}).then(function success(msg){\r\n");
      out.write("\t\t\t\tconsole.log(msg);\r\n");
      out.write("\t\t\t\t$scope.Ddelete = {\r\n");
      out.write("\t\t\t\t\tdata:msg.data,\r\n");
      out.write("\t\t\t\t\tmethod:msg.config.method,\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t},function error(err){\r\n");
      out.write("\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.send_mail = function(){\r\n");
      out.write("\t\t\t$http({\r\n");
      out.write("\t\t\t\tmethod:'POST',\r\n");
      out.write("\t\t\t\turl:$location.absUrl(),\r\n");
      out.write("\t\t\t\tdata:$.param({key:\"mail\",key2:\"Tomcat Mail\",key3:\"This is test\"}),\r\n");
      out.write("\t\t\t\theaders: {'Content-Type': 'application/x-www-form-urlencoded'}\r\n");
      out.write("\t\t\t}).then(function success(msg){\r\n");
      out.write("\t\t\t\tconsole.log(msg);\r\n");
      out.write("\t\t\t\t$scope.Dmail = {\r\n");
      out.write("\t\t\t\t\tdata:msg.data,\r\n");
      out.write("\t\t\t\t\tmethod:msg.config.method,\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t},function error(err){\r\n");
      out.write("\t\t\t\tconsole.log(err);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tconsole.log(\"999\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_t_005flayout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  t:layout
    org.apache.jsp.tag.web.layout_tag _jspx_th_t_005flayout_005f0 = (new org.apache.jsp.tag.web.layout_tag());
    _jsp_getInstanceManager().newInstance(_jspx_th_t_005flayout_005f0);
    _jspx_th_t_005flayout_005f0.setJspContext(_jspx_page_context);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp0 = new Helper( 0, _jspx_page_context, _jspx_th_t_005flayout_005f0, null);
    // /hello.jsp(3,0) name = header type = null reqTime = true required = false fragment = true deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005flayout_005f0.setHeader(_jspx_temp0);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp1 = new Helper( 1, _jspx_page_context, _jspx_th_t_005flayout_005f0, null);
    // /hello.jsp(3,0) name = script type = null reqTime = true required = false fragment = true deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005flayout_005f0.setScript(_jspx_temp1);
    _jspx_th_t_005flayout_005f0.setJspBody(new Helper( 2, _jspx_page_context, _jspx_th_t_005flayout_005f0, null));
    _jspx_th_t_005flayout_005f0.doTag();
    _jsp_getInstanceManager().destroyInstance(_jspx_th_t_005flayout_005f0);
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, javax.servlet.jsp.JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("<!--header content here-->");
      return false;
    }
    public boolean invoke1( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("<script>\r\n");
      out.write("\t\t\tconsole.log(\"123\");\r\n");
      out.write("\t\t</script>");
      return false;
    }
    public boolean invoke2( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("chat'>Chat</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div ng-controller='BASE'>\r\n");
      out.write("\t\t\t<div class='row'>\r\n");
      out.write("\t\t\t\t<div class='col-md-6'>\r\n");
      out.write("\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ori}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='col-md-6'>\r\n");
      out.write("\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${note}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<h4>From Remote Postgres Data</h4>\r\n");
      out.write("\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dbdata}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br>\r\n");
      out.write("\t\t\t</div><br>\r\n");
      out.write("\t\t\t<div class='row'>\r\n");
      out.write("\t\t\t\t<div class='col-md-3'>\r\n");
      out.write("\t\t\t\t\t<button class='btn' ng-click=\"send_post()\">POST</button><br>\r\n");
      out.write("\t\t\t\t\t{{Dpost}}\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='col-md-3'>\r\n");
      out.write("\t\t\t\t\t<button class='btn' ng-click=\"send_put()\">PUT</button><br>\r\n");
      out.write("\t\t\t\t\t{{Dput}}\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='col-md-3'>\r\n");
      out.write("\t\t\t\t\t<button class='btn' ng-click=\"send_delete()\">DELETE</button><br>\r\n");
      out.write("\t\t\t\t\t{{Ddelete}}\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='col-md-3'>\r\n");
      out.write("\t\t\t\t\t<button class='btn' ng-click=\"send_mail()\">MAIL</button><br>\r\n");
      out.write("\t\t\t\t\t{{Dmail}}\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws javax.servlet.jsp.JspException
    {
      javax.servlet.jsp.JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        Object _jspx_saved_JspContext = this.jspContext.getELContext().getContext(javax.servlet.jsp.JspContext.class);
        this.jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
          case 2:
            invoke2( out );
            break;
        }
        jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,_jspx_saved_JspContext);
      }
      catch( java.lang.Throwable e ) {
        if (e instanceof javax.servlet.jsp.SkipPageException)
            throw (javax.servlet.jsp.SkipPageException) e;
        throw new javax.servlet.jsp.JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
