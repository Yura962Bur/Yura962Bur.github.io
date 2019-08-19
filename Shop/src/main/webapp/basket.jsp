<%-- 
    Document   : busket
    Created on : Jan 14, 2019, 3:57:02 PM
    Author     : Michael_Buranov
--%>

<%@page import="com.nailacademy.shop.service.OrderDetailService"%>
<%@page import="com.nailacademy.shop.entities.TblOrderDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.nailacademy.shop.service.BasketService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nail-Академиия</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/basket.css">
        <script src="templateJS.js" type="text/javascript"></script>   
    </head>
    <body>
        <% 
            // Если нажали кнопку "Удалить"
            String orderDetailIdDel = request.getParameter("orderDetailIdDel");
            OrderDetailService odService = new OrderDetailService();
            if ( orderDetailIdDel!=null) 
                odService.removeByOrderDetaiId(Integer.parseInt(orderDetailIdDel));
               
            // Если нажали кнопку "Сохранить"
            String orderDetailIdQuantity = request.getParameter("orderDetailIdQuantity");
            String itemQuantityNew = request.getParameter("itemQuantity");
            if ( orderDetailIdQuantity!=null){
                BasketService basket = new BasketService();
                basket.changeBasketItemQuantity(Integer.parseInt(orderDetailIdQuantity), Integer.parseInt(itemQuantityNew));
            }
                
            // Инициализация всего необходимого
            BasketService basketServ = new BasketService();
            List<TblOrderDetails> basketItems = basketServ.getBasketItems();
            
            double totalAmount = 0;
        %>
        <!-- Нарисуем шапку и меню -->
        <script> 
            header(); 
            menu('basket'); 
        </script>  
        
        <!-- Нарисуем заголовок таблицы -->
        <div class="headerrow">
            <div class="itemcolumn"> 
                <div class="headercard" >
                    Товар
                </div>
            </div>
            <div class="pricecolumn">
                <div class="headercard">
                        Цена
                </div>
            </div>
            <div class="countcolumn">
                <div class="headercard">
                    Количество
                </div>
            </div>
            <div class="amountcolumn">
                <div class="headercard">
                        Сумма
                </div>
            </div>
            <div class="delcolumn" >
                <div class="headercard">
                    Управление
                </div>
            </div>
        </div>    

        <% for(TblOrderDetails item: basketItems){ 
            String itemName = item.getProductName(); 
            double itemCost = item.getCost();
            int itemQuantity = item.getQuantity();
            int orderDetailID = item.getOrderDetailsID();
            double itemAmount = item.getAmount();
            
            totalAmount = totalAmount + itemAmount;
        %>
                
                <div class="row">
                    <div class="itemcolumn"> 
                        <div class="card" >
                                <%=itemName%>
                        </div>
                    </div>
                    <div class="pricecolumn">
                        <div class="card">
                                <%=itemCost%>
                        </div>
                    </div>
                    <!-- графа с количествои и кнопкой пересчитать -->
                    <div class="countcolumn">
                        <div class="card" style="text-align: right; padding: 15px 5px 15px 0px;">
                            <form action="basket.jsp">
                                <% 
                                    String HtmlOrderDetailId ="<input type='hidden' name='orderDetailIdQuantity' value='" + orderDetailID + "'>"; 
                                    String HtmlProductCount ="<input type='number' name='itemQuantity' value='" + itemQuantity + "' style='width:45%; '>"; 
                                %>
                                <%=HtmlOrderDetailId%>
                                <%=HtmlProductCount%>
                               <button type="submit" class="button" style="width:50%;">Сохранить</button> 
                           </form>            
                        </div>
                    </div>
                    <div class="amountcolumn">
                        <div class="card">
                                <%=itemAmount%>
                        </div>
                    </div>

                    <div class="delcolumn" >
                        <div class="delcard">
                            <form action="basket.jsp">
                                <% 
                                    String HtmlOrderDetailIdDel ="<input type='hidden' name='orderDetailIdDel' value='" + orderDetailID + "'>"; 
                                %>
                                <%=HtmlOrderDetailIdDel%>
                               <button type="submit" class="button">Удалить</button>
                           </form>            
                        </div>
                    </div>

                </div>                
                
       <%        }%>           
        
        <!-- Нарисуем строку Итого с конопкой "Подтвердить" -->
        <div class="row">
            <div class="card" style="">
                <form action="*">
                    СУММА: <%=totalAmount%> руб
                   <input type="hidden" name="productId" value="1">
                   <button type="submit" class="button" style="float: right;">Подтвердить заказ</button>
               </form>                     
            </div>
        </div>
        
        <script>
            footer();
        </script>              
    </body>
</html>
