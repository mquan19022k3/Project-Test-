<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="position: fixed; top: 0; width:100%;  z-index: 100000;">
    <div class="container">
        <a class="navbar-brand" href="home">Men clothes shop</a>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">

                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.acc.user}</a>
                    </li>
                </c:if>

                <li class="nav-item">
                    <a class="nav-link" href="home">Home</a>
                </li> 

                <li class="nav-item">
                    <a class="nav-link" href="shop">Shop</a>
                </li>

                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="EditProfile.jsp">Edit Profile</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc.isSell == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manager1">Manager Product</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="history">History Order</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li> 
                </c:if>

                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login">Login</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="forgotPassword">Forgot Password</a>
                    </li>
                </c:if>
            </ul>

            <a class="btn btn-success btn-sm ml-3" href="managerCart">
                <i class="fa fa-shopping-cart"></i> <span style="font-size: 14px;">Cart</span>
                <b><span id="amountCart" class="badge badge-light" style="color:black; font-size: 12px;">0</span></b>
            </a>

        </div>
    </div>
</nav>
