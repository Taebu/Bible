<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<%
request.setCharacterEncoding("UTF-8");
        String className = request.getParameter("classname");
        if(className == null || className.length() == 0)
        {
                %>
                <html>
                <body onLoad='javascript:document.theform.classname.focus()'>
                <h3>JAVA Class/Resource Locating Information</h3>
                <form name='theform' method='POST' action='Jwhich.jsp'>
                Class/resource name specified has extension? <input title="" type='radio' name='has-extension' value='true'>true <input title="" type='radio' name='has-extension' value='false' checked='checked'>false<br>
                Enter name of class/resource to locate: <input title="" type='text' name='classname'><br>
                </form>
                </body>
                </html> 
                <%
                return;
        }

        String save_classname = className;
        String strhasext = request.getParameter("has-extension");
        boolean hasext = false;
        if("true".equalsIgnoreCase(strhasext))
                hasext = true;

        if(!className.startsWith("/"))
                className = "/" + className;
        className = className.replace('.', '/');

        if(!hasext)
                className += ".class";
        else
        {
                int pos = className.lastIndexOf('/');
                if(pos != -1)
                        className = className.substring(0, pos) + '.' + className.substring(pos+1);
        }

        java.net.URL classUrl = getClass().getResource(className);
        %>
        <h3>JAVA Class/Resource Locating Result</h3>
        <%
        if(classUrl == null)
                out.println("Class or resource '<font color=red>" + className + "</font>' <strong>not found</strong>  in CLASSPATH.");
        else
        {
                %>
                <menu>
                <%
                out.println("<li>Class or resource '<font color=red>" + className + "</font>' found in \n'<font color=blue>" + classUrl.getFile() + "</font>'");
                if(className.endsWith(".class"))
                {
                        %>
                        <br/><br><br>
                                         <% 
                        className = save_classname.replace('/', '.');
                        if(className.indexOf(".class") != -1)
                                className = className.substring(0, className.indexOf(".class"));
                        Class cls = Class.forName(className);
                        ClassLoader cl = cls.getClassLoader();
                        if(cl != null)
                        {
                                out.println("<li>" + cls.getName() + " has been loaded by ");
                                out.println(cl.getClass().getName() + " <font color='gray'>" + cl + "</font>");
                        }
                }
                %>
                </menu>
                <%
        }
%>
        
