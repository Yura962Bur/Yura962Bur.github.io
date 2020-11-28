<%@page import="com.nailacademy.shop.entities.TblProduct"%>
<%@page import="com.nailacademy.shop.service.ProductService"%>
<%@page import="com.nailacademy.shop.entities.TblCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.nailacademy.shop.service.CategoryService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--
    Образец врестки брал тут
    https://www.w3schools.com/css/tryit.asp?filename=trycss_website_layout_blog
    
    тут образцы кнопок
    https://www.w3schools.com/CSS/css3_buttons.asp 
    https://www.w3schools.com/CSS/tryit.asp?filename=trycss_buttons_basic 
    
    описание и картинки товара брал отсюда
    http://sagitta-cosm.ru/professionalnye-sredstva-dlya-manikyura-i-pedikyura-sagitta-professional/keratolitiki/ 
    -->   
    
    <head>
        <title>Nail-Академиия</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/ourcss.css"> 
        <link rel="stylesheet" href="css/productList.css">         
        
        <script src="templateJS.js" type="text/javascript"></script>
    </head>
    <body>
        <% 
        // декларация и инициализаци переменных
        String cat = request.getParameter("category");        
        
        CategoryService categoryService = new CategoryService();
        List<TblCategory> categoryList = categoryService.getAll();

        ProductService productService = new ProductService();
        List<TblProduct> productList = null;

        if ( cat!=null) 
            productList = productService.getByCategory(cat); 
            else productList = productService.getAll(); 

        %>

        <script> 
            header(); 
            menu('productList'); 
        </script>        
        
        <div class="row">
            
          <div class="categoryColumn">
            <div class="card">
              <h2>Категория товара</h2>
              <div class="categoryNav">
                  <a href='productList.jsp'>Все</a>
               <% for(TblCategory list: categoryList){ 
                   String catID = Integer.toString(list.getCategoryID());
                   String catItem= "<a href='productList.jsp?category="+catID+"'";
                   if (catID.equals(cat))
                       catItem = catItem + " style='background-color: #555'";
                   catItem = catItem + ">"+ list.getCategoryName()+"</a>";%>              
                    <%=catItem%>
              <%        }%>   
              </div>
            </div>
          </div>
              
              
          <div class="productColumn">
              
            <% 
             int rowNumber=0; 
             for(TblProduct list: productList){
                 if ((rowNumber==0) | (rowNumber % 3 == 0)) { %>
                <!-- "открываем" строку из 3-х продуктов -->
                <div class="productRow">
                <% } %>
                        
                <div class="productCard">
                  <h2><%=list.getProductName()%></h2>
                  Цена: <%=list.getCost()%>                  
                    <div class="productCardImgContainer" >
                      <% String productImg = "<img class='productCardImg' src='" +list.getPhotoPath()+"' alt ='Фото продукта'/>";  %>
                      <%=productImg%>
                    </div>
                    <!-- выведем кнопку "подробнее" -->
                    <form action="productDescription.jsp">
                        <input type="hidden" name="productId" value= <%=list.getProductID()%>> 
                        <input type="hidden" name="addToBasket" value= "0"> 
                        <button type="submit" class="button">Подробнее</button>
                    </form>
                </div>
                
                <%
                rowNumber = rowNumber +1; 
                if ((rowNumber % 3 == 0) | (productList.size()==rowNumber)) { %>
                <!-- "закрываем" строку из 3-х продуктов -->
                </div>                    
                <%}
                // Цикл по продуктам закончен
                } 
            %>
            
          </div>
        </div>
        
        <script>
            footer();
        </script>

    </body>
</html>
