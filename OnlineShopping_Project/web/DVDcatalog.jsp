<%-- 
    Document   : DVDcatalog
    Created on : Oct 19, 2023, 10:07:13 AM
    Author     : aunchisachanatipkul
--%>

<%@page import="java.util.Enumeration"%>
<%@page import="model.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Products"%>
<%@page import = "controller.CallProductTable"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Catalog</title>
        <link href="css/style.css" rel ="stylesheet" type ="text/css"/>
    </head>
    <body>
        <center>
        
        <h1>DVD Catalog</h1>      
        <form name="AddToCartForm" action="AddToShoppingCart" method="POST">        
            <table border="1" width="30%" cellspacing="1" cellpadding="1" >
                <thead>
                    <tr>
                        <th>DVD names</th>
                        <th>Rating</th>
                        <th>Year</th>
                        <th>Price/Unit</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Products> pdList = CallProductTable.findAllProduct();
                        for(Products pd : pdList){
                    %>
                    <tr>
                        <td>
                            <%= "<input type=\"checkbox\" name=\"CBDVDName\" value=\"" + pd.getMovie() + " \" id = \""+ pd.getMovie() +"\" />"%>
                            <%= pd.getMovie() %>
                        </td>
                        <td>
                            <%= pd.getRating() %>
                        </td>
                        <td>
                            <div style="text-align: center;">
                                <%= pd.getYearcreate() %>
                        </div>
                        </td>
                        <td>
                            <div style="text-align: center;">
                                <%= pd.getPrice() %>
                            </div>
                        </td>
                        <td>
                            <div style="text-align: center;">
                                <%= "<input type=\"text\" name=\"" + pd.getMovie() + "\" value=\"\" size=\"5\" style=\"text-align: center;\" id = \""+ pd.getMovie() +"_Quantity\" />"%>
                            </div>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
     
            <input type="submit" value="Add To Cart" name="BTAddToCart" />
            
        </form>
        </center>
            <% 
                session = request.getSession(); 
                if(!session.isNew()){
                    Enumeration<String> sessionAttrList = session.getAttributeNames();
                    out.println("<script>");
                    while(sessionAttrList.hasMoreElements()){
                        String singleAttr = sessionAttrList.nextElement();
                        if(!singleAttr.contains("WELD_S_HASH")){
                            out.println("document.getElementById(\""+ singleAttr +"\").checked = true");
                            out.println("document.getElementById(\""+ singleAttr +"_Quantity\").value =\"" + session.getAttribute(singleAttr) + "\"" );
                        }
                   } 
                    out.println("</script>");
                }
            %>
    </body>
</html>
