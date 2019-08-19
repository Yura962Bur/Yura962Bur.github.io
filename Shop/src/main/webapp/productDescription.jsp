
<%@page import="com.nailacademy.shop.service.BasketService"%>
<%@page import="com.nailacademy.shop.entities.TblProduct"%>
<%@page import="com.nailacademy.shop.service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/ourcss.css">         
        <link rel="stylesheet" href="css/productDescription.css">  
        
        <script src="templateJS.js" type="text/javascript"></script>   
        
        <title>Nail-Академиия</title>
    </head>
    <body>
        <% 
        // декларация и инициализаци переменных
        String productId = request.getParameter("productId");
        String isAddToBasket = request.getParameter("addToBasket");
        
        ProductService productService = new ProductService();
        TblProduct product = productService.getByID(Integer.parseInt(productId));
        String productDescription = product.getDescription();
        String productName = product.getProductName();
        String imgUrl = product.getPhotoPath();
        Double cost = product.getCost();
        
        if (isAddToBasket.equals("1")) {
            // ДОБАВИТЬ В КОРЗИНУ 
            BasketService basket = new BasketService();
            basket.addBasketItem(product);
        }

        %>        
        <!-- нарисуем шапку и меню -->
        <script> 
            header(); 
            menu('productList'); 
        </script>
              
        <div class="productDescriptionCard">
                    
            <div class="row">
                <h2> <%=productName%> </h2>
              <div class="leftDescriptionColumn" >    
                <img alt="Фото продукта" style="margin-left:auto; margin-right:auto; display:block;" src=<%=imgUrl%>>
              </div>
                <div class="rightDescriptionColumn">
                    <div class="productDescText">
                        <p>
                            <%=productDescription%>
                      </p>
                      <p>
                          ЦЕНА: <%=cost%>
                      </p>
                    </div>
                </div>
            </div>
            
            <%if (!isAddToBasket.equals("1")){%>
                <!-- выведем кнопку "подробнее" -->
                <form action="productDescription.jsp">
                   <input type="hidden" name="productId" value=<%=productId%>> 
                   <input type="hidden" name="addToBasket" value="1">
                   <button type="submit" class="button">В корзину</button>
               </form>
            <%} else {%>
                <h3>В корзине</h3>
            <%}%>
        </div>        
        
        <!-- подвал -->
        <script>
            footer();
        </script>        
    </body>
</html>
