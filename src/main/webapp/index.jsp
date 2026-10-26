<%-- 
    Document   : index
    Created on : 21 oct 2026, 11:08:42 a.m.
    Author     : LUIS CARLOS LABOTIN ALVAREZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LIBRERIA MINECRAFT</title>
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    <body>

        <section>
            <h2>Agrega encantamiento</h2>
            <form action="libro" method="POST">
                <div>
                    <label>Nombre</label>
                    <input name="nombre" type="text" required />
                </div>
                <div>
                    <label>Precio</label>
                    <input name="precio" type="number" required />
                </div>
                <button type="submit">Mostrar al Steve</button>
            </form>
        </section>

        <section>
            <h2>Encantamientos:</h2>
            <form method="GET" action="libro">
                <button type="submit">Matar Aldeano</button>
            </form>
            <c:if test="${not empty lista}">
                <div class="encanta">
                    <c:forEach var="lib" items="${lista}">
                        <div class="libro">
                            <p>
                                <strong>${lib.name}</strong>
                                <br/>
                                <strong>Precio:</strong> $${lib.precio}
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </section>

    </body>
</html>