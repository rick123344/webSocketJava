/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.28
 * Generated at: 2017-02-14 02:28:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class chat_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("#main{\r\n");
      out.write("\theight:100%;\r\n");
      out.write("\t//background-color:#dddddd;\r\n");
      out.write("}\r\n");
      out.write(".area{\r\n");
      out.write("\tmin-height:500px;\r\n");
      out.write("\tmax-height:500px;\r\n");
      out.write("\toverflow:auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".blockA{\r\n");
      out.write("\twidth:50%;\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("}\r\n");
      out.write(".blockB{\r\n");
      out.write("\twidth:50%;\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("}\r\n");
      out.write(".blockB>span,.blockA>span{\r\n");
      out.write("\t-moz-border-radius: 15px;\r\n");
      out.write("\tborder-radius: 15px;\r\n");
      out.write("\tfont: 16px Arial, sans-serif;\r\n");
      out.write("\tpadding:8px;\r\n");
      out.write("\tword-break: break-all;\r\n");
      out.write("\tfont-weight:bold;\r\n");
      out.write("}\r\n");
      out.write(".blockB>span{\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tbackground-color:#53f442;\r\n");
      out.write("}\r\n");
      out.write(".blockA>span{\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tbackground-color:#42f1f4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\tvar app = angular.module(\"Embedded\",[]);\r\n");
      out.write("\tapp.controller(\"CHAT\",baseFunc);\r\n");
      out.write("\t\r\n");
      out.write("\tapp.directive(\"compile\",['$compile',function($compile){\r\n");
      out.write("\t\treturn function(scope,element,attrs){\r\n");
      out.write("\t\t\tscope.$watch(\r\n");
      out.write("\t\t\t\tfunction(scope){\r\n");
      out.write("\t\t\t\t\t// watch the 'compile' expression for changes\r\n");
      out.write("\t\t\t\t\treturn scope.$eval(attrs.compile);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tfunction(value){\r\n");
      out.write("\t\t\t\t\t// when the 'compile' expression changes\r\n");
      out.write("\t\t\t\t\t// assign it into the current DOM\r\n");
      out.write("\t\t\t\t\telement.html(value);\r\n");
      out.write("\t\t\t\t\t// compile the new DOM and link it to the current\r\n");
      out.write("\t\t\t\t\t// scope.\r\n");
      out.write("\t\t\t\t\t// NOTE: we only compile .childNodes so that\r\n");
      out.write("\t\t\t\t\t// we don't get into infinite loop compiling ourselves\r\n");
      out.write("\t\t\t\t\t$compile(element.contents())(scope);\r\n");
      out.write("\t\t\t\t},true\r\n");
      out.write("\t\t\t);\r\n");
      out.write("\t\t};\r\n");
      out.write("\t}]);\r\n");
      out.write("\t\r\n");
      out.write("\tfunction baseFunc($scope,$http,$location,$sce,$timeout){\r\n");
      out.write("\t\t$scope.allmsg=[];\r\n");
      out.write("\t\t$scope.newmsg = \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.go = function(e,type){\r\n");
      out.write("\t\t\tif(e.keyCode!='13'&&type=='keycode'){\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif($scope.newmsg!=\"\"){\r\n");
      out.write("\t\t\t\t$scope.postToServer();\r\n");
      out.write("\t\t\t\t$scope.newmsg = \"\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$scope.$watch(\"allmsg\",function(newValue,oldValue){\r\n");
      out.write("\t\t\tvar out=document.getElementById(\"chatmsg\");\r\n");
      out.write("\t\t\tvar isScrolledToBottom = out.scrollHeight - out.clientHeight <= out.scrollTop + 1;\r\n");
      out.write("\t\t\t$timeout(function(){\r\n");
      out.write("\t\t\t\t//get correct scrollHeight must wait for dom is ready ($timeout)\r\n");
      out.write("\t\t\t\tif(isScrolledToBottom)\r\n");
      out.write("\t\t\t\t\tout.scrollTop = out.scrollHeight;\r\n");
      out.write("\t\t\t},0);\r\n");
      out.write("\t\t},true);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar ws = \"wss://\";\r\n");
      out.write("\t\tif(document.location.protocol == \"http:\"){\r\n");
      out.write("\t\t\tws = \"ws://\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar wsUri = ws + document.location.host + \"/ws\";\r\n");
      out.write("\t\t//console.log(wsUri);\r\n");
      out.write("\t\tvar ws = new WebSocket(wsUri);\r\n");
      out.write("\t\tws.onopen = function(){\r\n");
      out.write("\t\t\t//console.log(\"Connected\");\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tws.onmessage = function(message){\r\n");
      out.write("\t\t\t//console.log(message.data);\r\n");
      out.write("\t\t\t$scope.allmsg.push(message.data);\r\n");
      out.write("\t\t\t$scope.$apply();\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$scope.postToServer = function(){\r\n");
      out.write("\t\t\tws.send($scope.newmsg);\r\n");
      out.write("\t\t\t$scope.newmsg = \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$scope.closeConnect = function(){\r\n");
      out.write("\t\t\tws.close();\r\n");
      out.write("\t\t\t//console.log(\"Close Ws\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
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
    // /chat.jsp(3,0) name = header type = null reqTime = true required = false fragment = true deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_t_005flayout_005f0.setHeader(_jspx_temp0);
    javax.servlet.jsp.tagext.JspFragment _jspx_temp1 = new Helper( 1, _jspx_page_context, _jspx_th_t_005flayout_005f0, null);
    // /chat.jsp(3,0) name = script type = null reqTime = true required = false fragment = true deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
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
      out.write("\t\t\t//console.log(\"123\");\r\n");
      out.write("\t\t</script>");
      return false;
    }
    public boolean invoke2( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div ng-controller='CHAT' id='main'>\r\n");
      out.write("\t\t\t<div class='row'>\r\n");
      out.write("\t\t\t\t<div class='col-md-6'>\r\n");
      out.write("\t\t\t\t\t<div class='thumbnail area' id='chatmsg'>\r\n");
      out.write("\t\t\t\t\t\t<ul class='list-unstyled'>\r\n");
      out.write("\t\t\t\t\t\t\t<li ng-repeat=\"message in allmsg track by $index\" compile=\"message\">\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=''>\r\n");
      out.write("\t\t\t\t\t\t<div class='col-md-8'>\r\n");
      out.write("\t\t\t\t\t\t\t<input type='text' class='form-control' ng-model='newmsg' ng-keyup=\"go($event,'keycode')\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<input type='button' class='btn' value='Send' ng-click=\"go($event,'btn')\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='col-md-6'>\r\n");
      out.write("\t\t\t\t\t<div class='thumbnail area'>\r\n");
      out.write("\t\t\t\t\t\t<a href='/page1'>Page1</a>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=''>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<br>This test web base on <b>Tomcat Embed.</b><br>\r\n");
      out.write("\t\t\t\t\t\t\tUsing <b>maven</b> to manage all sources.<br>\r\n");
      out.write("\t\t\t\t\t\t\tAnnotation path (Without web.xml).<br><br>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tIn \"<a href='/page1'>/page1</a>\" , test the UTF-8 encode.<br>\r\n");
      out.write("\t\t\t\t\t\t\t1. \"From Remote Postgres Data\" area datas, they come from Amazan cloud Database base on Postgres.<br>\r\n");
      out.write("\t\t\t\t\t\t\t2. \"POST\" button is ajax post method,<br>\r\n");
      out.write("\t\t\t\t\t\t\t3. \"PUT\" button is ajax put method,<br>\r\n");
      out.write("\t\t\t\t\t\t\t4. \"DELETE\"  button is ajax delete method,<br>\r\n");
      out.write("\t\t\t\t\t\t\t5. \"MAIL\" button is ajax post method and will send a mail to me.<br>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\tIn \"<a href='/chat'>\"/chat</a> , test the socket using tomcat embed websocket.<br>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\tAbove web using jsp template <b>view</b>, servlet <b>controller</b>, and connect <b>model</b><br>\r\n");
      out.write("\t\t\t\t\t\t\tBase AngularJs using, Base socket using, Base taglibs using.\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class='row'>\r\n");
      out.write("\t\t\t\t<div class='col-md-6'>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='col-md-6'>\r\n");
      out.write("\t\t\t\t\t\r\n");
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
