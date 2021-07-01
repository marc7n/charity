<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.jsp"%>

</header>

<section class="login-page">
  <h2>Załóż konto</h2>
  <form:form action="" method="post" modelAttribute="user">

    <div class="form-group">
      <form:input type="text" name="username" placeholder="Nazwa użytkownika" path="username"/>
      <form:errors path="username" cssStyle="color: red; font-size: 12px" element="div" />
    </div>
    <div class="form-group">
      <form:input type="email" name="email" placeholder="Email" path="email"/>
      <form:errors path="email" cssStyle="color: red; font-size: 12px" element="div" />
    </div>
    <div class="form-group">
      <form:input type="password" name="password" placeholder="Hasło" path="password"/>
      <form:errors path="password" cssStyle="color: red; font-size: 12px" element="div" />
    </div>
    <div class="form-group">
      <form:input type="password" name="password2" placeholder="Powtórz hasło"  path="password2"/>
      <form:errors path="password2" cssStyle="color: red; font-size: 12px" element="div" />
    </div>

    <div class="form-group form-group--buttons">
      <a href="/login" class="btn btn--without-border">Zaloguj się</a>
      <form:button class="btn" type="submit">Załóż konto</form:button>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
  </form:form>
</section>

<%@include file="footer.jsp"%>
<script src="<c:url value="resources/js/form.js"/>"></script>