/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.43
 * Generated at: 2017-06-19 05:25:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/E:/3WDA/WD3A5_Project/07_프로젝트%20소스/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/SomebodyPlace/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1489718950646L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/main.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/loginForm.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/place.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/postForm.css?ver=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/joinForm.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/mypage.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/modifyForm.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/orderList.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/cart.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/wishList.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/favorites.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/interestSetting.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/issue.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/placeMain.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/placemanager.css?ver=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/placeAddForm.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/requestList.css?ver=2\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/addBusiness.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/categorySetting.css?ver=4\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/currentBudget.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./resources/css/chatting.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./resources/css/addIssue.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./resources/css/postDefault.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./resources/css/postRequest.css\">\r\n");
      out.write("           \r\n");
      out.write("           \r\n");
      out.write("\t<script src=\"./resources/js/issue.js?ver=5\"></script>   \r\n");
      out.write("\t<script src=\"./resources/js/addIssue.js?ver=6\"></script>   \r\n");
      out.write("    <script src=\"./resources/js/index.js?ver=5\"></script>\r\n");
      out.write("    <script src=\"./resources/js/place.js?ver=1\"></script>\r\n");
      out.write("    <script src=\"./resources/js/postForm.js?ver=29\"></script>\r\n");
      out.write("    <script src=\"./resources/js/mypage.js\"></script>\r\n");
      out.write("    <script src=\"./resources/js/issue.js\"></script>\r\n");
      out.write("    <script src=\"./resources/js/placeMain.js\"></script>\r\n");
      out.write("    <script src=\"./resources/js/placeManager.js\"></script>\r\n");
      out.write("    <script src=\"./resources/js/currentBudget.js\"></script>  \r\n");
      out.write("    <script src=\"./resources/js/sockjs.js\"></script>\r\n");
      out.write("    <script src=\"./resources/js/chatting.js\"></script>\r\n");
      out.write("    <script src=\"./resources/js/placeAddForm.js?ver=2\"></script>\r\n");
      out.write("    <script src=\"./resources/js/categorySetting.js?ver=2\"></script>\r\n");
      out.write("    <script src=\"./resources/js/placeHome.js?ver=3\"></script>\r\n");
      out.write("\t<script src=\"./resources/js/postDefault.js?ver=3\"></script>\r\n");
      out.write("       \r\n");
      out.write("    <title>Somebody Place</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"main\">\r\n");
      out.write("        <div id=\"main_logo\">\r\n");
      out.write("            <img src=\"./resources/img/somebodyplaceLOGO.png\" class=\"index_logo\">\r\n");
      out.write("            <span class=\"main_member\">\r\n");
      out.write("            \t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("  \r\n");
      out.write("                <span class=\"main_joinForm\">회원가입</span>\r\n");
      out.write("                <span class=\"main_myPage\">마이페이지</span>\r\n");
      out.write("                <a href=\"place?member_code=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member_code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&member_email=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member_email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                \t<span class=\"main_myPlaceBtn\">마이플레이스</span>\r\n");
      out.write("                </a> \r\n");
      out.write("                <span class=\"main_PlaceBtn\">플레이스</span>\r\n");
      out.write("            </span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"main_cate\">\r\n");
      out.write("            <div class=\"dropdown\">\r\n");
      out.write("                <span>배달</span>\r\n");
      out.write("                <div class=\"dropdown-content\">\r\n");
      out.write("                    <a href=\"#\">음식</a>\r\n");
      out.write("                    <a href=\"#\">꽃</a>\r\n");
      out.write("                    <a href=\"#\">세탁</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"dropdown\">\r\n");
      out.write("                <span>쇼핑</span>\r\n");
      out.write("                <div class=\"dropdown-content\">\r\n");
      out.write("                    <a href=\"#\">패션</a>\r\n");
      out.write("                    <a href=\"#\">생활</a>\r\n");
      out.write("                    <a href=\"#\">디지털</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"dropdown\">\r\n");
      out.write("                <span>여가</span>\r\n");
      out.write("                <div class=\"dropdown-content\">\r\n");
      out.write("                    <a href=\"#\">미용실</a>\r\n");
      out.write("                    <a href=\"#\">네일</a>\r\n");
      out.write("                    <a href=\"#\">화장품</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"dropdown\">\r\n");
      out.write("                <span>뷰티</span>\r\n");
      out.write("                <div class=\"dropdown-content\">\r\n");
      out.write("                    <a href=\"#\">link1</a>\r\n");
      out.write("                    <a href=\"#\">link2</a>\r\n");
      out.write("                    <a href=\"#\">link3</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"dropdown\">\r\n");
      out.write("        \t\t <span class=\"main_issue\">이슈</span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <!-- 채팅 내용 -->\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    <div class=\"chatDiv\">\r\n");
      out.write("    \t<span class=\"backChat glyphicon glyphicon-chevron-left\"></span>\r\n");
      out.write("    \t<span class=\"closeChat glyphicon glyphicon-remove\"></span>\r\n");
      out.write("\t\t<div class=\"chat_content\">\r\n");
      out.write("\t\t\r\n");
      out.write(" \t\t\t<div class=\"chat_main\">\r\n");
      out.write("\t\t    \t<div class=\"chat_owner\">\r\n");
      out.write("\t\t    \t\t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 님의 대화방 목록 입니다.</h3>\r\n");
      out.write("\t\t    \t</div>\r\n");
      out.write("\t\t    \t<div class=\"chat_rooms\">\t    \t\r\n");
      out.write("\t\t    \t</div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t<div class=\"chat_sub\">\r\n");
      out.write("\t\t    \t<div class=\"chatWrap\">\t\r\n");
      out.write("\t\t\t\t\t<div class=\"chats\" id=\"chats\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<span class=\"chat_more glyphicon glyphicon-plus-sign\"></span>\r\n");
      out.write("\t\t\t\t\t<div class=\"chat_flip\">\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"chat_card\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"chat_menu front\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"./resources/img/chat_addAuto.png\" class=\"chat_menu_img\" id=\"addAuto\" style=\"cursor: pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"./resources/img/chat_exitChat.png\" class=\"chat_menu_img\" id=\"exitChat\" style=\"cursor: pointer;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p style=\"text-align: center; width:400px\">에약어 추가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;대화방 나가기</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"chat_menu back\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t\t<div class=\"comment\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"writeComment\" id=\"writeComment\" name=\"writeComment\" placeholder=\"채팅 입력하세요\" onkeypress=\"enter(event, this.value)\"/>\r\n");
      out.write("\t\t\t\t\t<button class=\"enter\">입력</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div> \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div> \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/index.jsp(63,13) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nickname != null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("         \r\n");
          out.write("        \t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("님 환영합니다. \r\n");
          out.write("        \t    \t<span class=\"main_logoutBtn\">로그아웃</span>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/views/index.jsp(67,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nickname == null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("  \r\n");
          out.write("                \t<span class=\"main_loginBtn\">로그인</span> \r\n");
          out.write("             \t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /WEB-INF/views/index.jsp(116,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cont != null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("         \r\n");
          out.write("        \t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cont}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), out, false);
          out.write("\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      // /WEB-INF/views/index.jsp(123,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nickname!= null && applogin == null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<div class=\"chatImg\">\r\n");
          out.write("\t\t\t<img src=\"./resources/img/chat.png\">\r\n");
          out.write("\t\t\t<span class=\"badge chat_balloons\"></span>\t\t\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t\t\r\n");
          out.write("\t\t<div id=\"code\" class=\"chat_info\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${code}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("\t\t<div id=\"nickname\" class=\"chat_info\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("\t\t<div id=\"sender\"></div>\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }
}
