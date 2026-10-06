<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Personajes de Springfield</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<h1>Personajes de Springfield</h1>

<form action="${pageContext.request.contextPath}/personajes" method="get">
<%--    formulario para hacer busquedas por eso es get y no post--%>

    <fieldset>
        <legend>Filtrar</legend>

        <label>Lugar
            <select name="lugar">
                <option value="">— Todos —</option>
                <c:forEach var="l" items="${lugares}">
                    <option value="${l}" ${l == param.lugar ? 'selected' : ''}>${l}</option>
                </c:forEach>
            </select>
        </label>
<%-- Añadir un filtro por ocupación, que funcione igual que el de lugar.--%>
        <label>Ocupación
            <select name="ocupacion">
                <option value="">— Todos —</option>
                <c:forEach var="l" items="${ocupaciones}">
                    <option value="${o}" ${o == param.ocupacion ? 'selected' : ''}>${o}</option>
                </c:forEach>
            </select>
        </label>

        <label>Edad máxima
            <input type="number" name="edadMax" min="0" value="">
        </label>
    </fieldset>

    <fieldset>
        <legend>Ordenar</legend>

        <label>Ordenar por
            <select name="ordenarPor">
                <option value="nombre" ${param.ordenarPor == 'nombre' ? 'selected' : ''}>Nombre</option>
                <option value="apellido"${param.ordenarPor == 'apellido' ? 'selected' : ''}>Apellido</option>
                <option value="edad"${param.ordenarPor == 'edad' ? 'selected' : ''}>Edad</option>
<%-- MEJORA 2 Añadir "Ordenar por lugar" (y, si empatan, por nombre).--%>
                <option value="lugar"${param.ordenarPor == 'lugar' ? 'selected' : ''}>Lugar</option>
            </select>
        </label>

        <label class="check">
            <input type="checkbox" name="descendente" ${not empty param.descendente ? 'checked' : ''}>
            Descendente
        </label>

        <label class="check">
            <input type="checkbox" name=" soloFamilia" ${not empty param.soloFamilia ? 'checked' : ''}>
            Solo familia Simpson
        </label>

        <label>Mostrar como máximo
            <input type="number" name="limite" min="0" value="${param.value}">
        </label>
    </fieldset>

    <button type="submit">Buscar</button>
    <a href="${pageContext.request.contextPath}/personajes">Limpiar filtros</a>
</form>

    <c:if test="·${not empty error}">
        <p class="error">${error}</p>
    </c:if>
<p class="resumen"><strong>${personajes.size()}</strong> personajes encontrados</p>
<!--pendiente validar si la lista no esta vacia-->
<table>
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Edad</th>
        <th>Ocupación</th>
        <th>Lugar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items = "${personajes}">
        <tr>
            <td>${p.nombreCompleto()}</td>
            <td>${p.edad()}</td>
            <td>${p.ocupacion()}</td>
            <td>${p.lugar()}</td>
        </tr>
    </c:forEach>


    </tbody>
</table>

</body>
</html>