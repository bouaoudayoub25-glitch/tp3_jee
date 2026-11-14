<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        <c:choose>
            <c:when test="${empty produit.id}">Nouveau produit</c:when>
            <c:otherwise>Modifier le produit</c:otherwise>
        </c:choose>
    </title>
</head>
<body>

<h1>
    <c:choose>
        <c:when test="${empty produit.id}">Nouveau produit</c:when>
        <c:otherwise>Modifier le produit</c:otherwise>
    </c:choose>
</h1>

<form action="${ctx}/Produits" method="post">

    <%-- Champ caché id : uniquement en modification --%>
    <c:if test="${not empty produit.id}">
        <input type="hidden" name="id" value="<c:out value='${produit.id}'/>">
    </c:if>

    <p>
        <label>Nom :
            <input type="text" name="nom" value="<c:out value='${produit.nom}'/>">
        </label>
        <span style="color:red"><c:out value="${erreurs.nom}"/></span>
    </p>

    <p>
        <label>Description :
            <input type="text" name="description" value="<c:out value='${produit.description}'/>">
        </label>
        <span style="color:red"><c:out value="${erreurs.description}"/></span>
    </p>

    <p>
        <label>Prix :
            <input type="text" name="prix" value="<c:out value='${produit.prix}'/>">
        </label>
        <span style="color:red"><c:out value="${erreurs.prix}"/></span>
    </p>

    <p>
        <label>Stock :
            <input type="text" name="stock" value="<c:out value='${produit.stock}'/>">
        </label>
        <span style="color:red"><c:out value="${erreurs.stock}"/></span>
    </p>

    <button type="submit">Enregistrer</button>
    <a href="${ctx}/Produits">Annuler</a>
</form>

</body>
</html>