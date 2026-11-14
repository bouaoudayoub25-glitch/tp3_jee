<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produits</title>
    <style>
        .message    { color: green; }
        .stock-zero { color: red; }
        .inline     { display: inline; }
        table, th, td { border: 1px solid #999; border-collapse: collapse; padding: 4px 8px; }
    </style>
</head>
<body>

    <h1>Catalogue de produits</h1>

    <%-- Message flash (déjà retiré de la session par la servlet) --%>
    <c:if test="${not empty message}">
        <p class="message"><c:out value="${message}"/></p>
    </c:if>

    <p><a href="${ctx}/Produits?action=new">Ajouter un produit</a></p>

    <%-- Liste ou message "aucun produit" --%>
    <c:choose>
        <c:when test="${empty produits}">
            <p>Aucun produit</p>
        </c:when>

        <c:otherwise>
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Prix</th>
                    <th>Stock</th>
                    <th>Actions</th>
                </tr>

                <c:forEach items="${produits}" var="p">
                    <tr>
                        <td><c:out value="${p.nom}"/></td>
                        <td><c:out value="${p.description}"/></td>
                        <td>
                            <fmt:formatNumber value="${p.prix}" minFractionDigits="2" maxFractionDigits="2"/>
                        </td>
                        <td class="${p.stock == 0 ? 'stock-zero' : ''}">${p.stock}</td>
                        <td>
                            <a href="${ctx}/Produits?action=edit&amp;id=${p.id}">Éditer</a>

                            <form action="${ctx}/Produits" method="post" class="inline"
                                  onsubmit="return confirm('Supprimer ce produit ?');">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="${p.id}">
                                <button type="submit">Supprimer</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <p><a href="${ctx}/Dashboard">Retour au tableau de bord</a></p>

</body>
</html>