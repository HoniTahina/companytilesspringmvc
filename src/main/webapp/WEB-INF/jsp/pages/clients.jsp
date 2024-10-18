<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 04/10/2024
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div>
    <jsp:include page="./welcome.jsp" />
    <div class="container mt-5">
        <div class="row">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Liste des client</h5>
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Tel</th>
                                <th>Address</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${clientList}" var="client">
                                <tr>
                                    <td>${client.firstname}</td>
                                    <td>${client.lastname}</td>
                                    <td>${client.email}</td>
                                    <td type="password">${client.password}</td>
                                    <td>${client.tel}</td>
                                    <td>${client.address}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajout d'un client</h5>
                        <form action="clients" method="post">
                            <div class="mb-3">
                                <label for="firstname" class="form-label">Firstname</label>
                                <input type="text" name="firstname" class="form-control" id="firstname">
                            </div>
                            <div class="mb-3">
                                <label for="lastname" class="form-label">Lastname</label>
                                <input type="text" name="lastname" class="form-control" id="lastname">
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" id="email">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" id="password">
                            </div>
                            <div class="mb-3">
                                <label for="tel" class="form-label">Tel</label>
                                <input type="tel" name="tel" class="form-control" id="tel">
                            </div>
                            <div class="mb-3">
                                <label for="address" class="form-label">Email</label>
                                <input type="text" name="address" class="form-control" id="address">
                            </div>
                            <button type="submit" class="btn btn-primary">Ajouter Client</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
