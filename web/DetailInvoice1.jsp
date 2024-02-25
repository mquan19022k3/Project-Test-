<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <meta charset="ISO-8859-1">
        <title>ADMIN</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>   
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">  
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">  
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css"> 
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">   
        
        <style>
            body {
                margin: 0;
                padding: 0;
            }
        </style>
        
        <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"><link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&amp;display=swap"><link rel="stylesheet" type="text/css" href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb5/3.8.1/compiled.min.css"><link rel="stylesheet" type="text/css" href="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/css/mdb-plugins-gathered.min.css">
        <style>
            body {
                background-color: #fbfbfb;
            }
            @media (min-width: 991.98px) {
                main {
                    padding-left: 240px;
                }
            }

            .sidebar {
                position: fixed;
                top: 0;
                bottom: 0;
                left: 0;
                padding: 58px 0 0; 
                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
                width: 240px;
                z-index: 600;
            }

            @media (max-width: 991.98px) {
                .sidebar {
                    width: 100%;
                }
            }
            .sidebar .active {
                border-radius: 5px;
                box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
            }

            .sidebar-sticky {
                position: relative;
                top: 0;
                height: calc(100vh - 48px);
                padding-top: 0.5rem;
                overflow-x: hidden;
                overflow-y: auto;
            }
        </style>
    </head>
    <body>
        
        <header>
            <jsp:include page="Menu.jsp"></jsp:include>
        </header>
            
            <main>
                <div class="container pt-4">
                    
                    <section class="mb-4">

                    <div class="card">
                        
                        <div class="card-header py-3 row">
                            <div class="col-sm-6">
                                <h5 class="mb-0 text-left" id="">
                                    <strong>Chi Tiết Hóa Đơn</strong>
                                </h5>
                            </div>
                            <div class="col-sm-6">
                                <h5 class="mb-0 text-right" id="">

                                </h5>
                            </div>
                        </div>
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                
                                <table class="table table-hover text-nowrap">
                                    
                                    <thead>
                                        <tr>
                                            <th scope="col">Mã Hóa Đơn</th>
                                            <th scope="col">Tên Sản Phẩm</th>
                                            <th scope="col">Giá</th>
                                            <th scope="col">Số Lượng</th>
                                        </tr>
                                    </thead>

                                    <tbody id="content">
                                        <c:forEach items="${listO}" var="i">
                                            <tr>
                                                <td>${i.invoiceID }</td>
                                                <c:forEach items="${listP}" var="a">
                                                    <c:if test="${i.productID==a.id }">
                                                        <td>${a.title}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <td>${String.format("%.02f",i.price) }</td>
                                                <td>${i.quantity }</td> 
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    
                                </table> 
                            </div>
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                        <tr>
                                            <th scope="col">Mã Hóa Đơn</th>
                                            <th scope="col">Tên Khách Hàng</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Địa Chỉ Giao Hàng</th>
                                            <th scope="col">Số Điện Thoại</th>
                                        </tr>
                                    </thead>

                                    <tbody id="content">
                                        <c:forEach items="${listI}" var="m">
                                            <tr>
                                                <td>${m.invoiceID }</td>
                                                <td>${m.name }</td>
                                                <td>${m.email }</td>
                                                <td>${m.address }</td>
                                                <td>${m.phonenumber }</td> 
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>  
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>   
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>    
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>    
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
        <script src="https://mdbootstrap.com/api/snippets/static/download/MDB5-Free_3.8.1/js/mdb.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <script type="text/javascript" src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"></script>
        <script>
            window.addEventListener("load", function loadAmountCart() {
            $.ajax({
                url: "/assign/loadAmountCart",
                type: "get", 
                data: {

                },
                success: function (responseData) {
                    document.getElementById("amountCart").innerHTML = responseData;
                }
            });
        }, false);
        </script>
    </body>
</html>