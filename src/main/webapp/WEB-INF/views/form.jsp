<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>


<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>

<header class="header--form-page">


    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br/>
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="" method="post" modelAttribute="donation">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:checkbox path="categories" value="${category.id}"/>
                            <span class="checkbox"></span>
                            <div id="category" class="description">${category.name}</div>
                            </span>
                        </label>
                    </div>
                </c:forEach>




                <form:errors path="categories" cssStyle="color: red; font-size: 12px" element="div"/>

                <div class="form-group form-group--buttons">
                    <form:button type="button" id="Button1Next" class="btn next-step">Dalej</form:button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input id="quantity" type="number" name="quantity" step="1" min="1" path="quantity"/>
                    </label>
                    <form:errors path="quantity" cssStyle="color: red; font-size: 12px" element="div"/>
                </div>

                <div class="form-group form-group--buttons">
                    <form:button type="button" id="Button2Prev" class="btn prev-step">Wstecz</form:button>
                    <form:button type="button" id="Button2Next" class="btn next-step">Dalej</form:button>
                </div>
            </div>

            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <c:forEach items="${institutions}" var="institution">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton path="institution" value="${institution.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div id="institution" class="title">${institution.name}</div>
                                <div class="subtitle">${institution.description}</div>
                            </span>
                        </label>
                    </div>
                </c:forEach>
                <form:errors path="institution" cssStyle="color: red; font-size: 12px" element="div"/>

                <div class="form-group form-group--buttons">
                    <form:button type="button" id="Button3Prev" class="btn prev-step">Wstecz</form:button>
                    <form:button type="button" id="Button3Next" class="btn next-step">Dalej</form:button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input id="street" path="street" type="text" name="street"/> </label>
                            <form:errors path="street" cssStyle="color: red; font-size: 12px" element="div"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input id="city" path="city" type="text" name="city"/> </label>
                            <form:errors path="city" cssStyle="color: red; font-size: 12px" element="div"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>Kod pocztowy
                                <form:input id="zipCode" path="zipCode" type="text" name="zipCode"
                                            placeholder="XX(-)XXX" maxlength="6"
                                            oninput="this.value = this.value.replace(/[^-\ \d]/g, '').replace(/(\..*?)\..*/g, '$1');"
                                            onchange="checkZipCodePattern(this);"/>
                            </label>
                            <form:errors path="zipCode" cssStyle="color: red; font-size: 12px" element="div"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu
                                <form:input id="phoneNumber" path="phoneNumber" type="tel" name="phoneNumber"
                                            oninput="this.value = this.value.replace(/[^+\ 0-9]/g, '').replace(/(\..*?)\..*/g, '$1');"
                                            onchange="checkPhoneNrPattern(this);" maxlength="15"/>
                            </label>
                            <form:errors path="phoneNumber" cssStyle="color: red; font-size: 12px" element="div"/>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input id="pickUpDate" path="pickUpDate" type="date" name="pickUpDate"
                                                     onchange="checkDate()"/> </label>
                            <form:errors path="pickUpDate" cssStyle="color: red; font-size: 12px" element="div"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input id="pickUpTime" path="pickUpTime" type="time" name="pickUpTime"
                                                        onchange="checkTime()"/> </label>
                            <form:errors path="pickUpTime" cssStyle="color: red; font-size: 12px" element="div"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea id="pickUpComment" path="pickUpComment" name="pickUpComment"
                                               rows="5"></form:textarea>
                                <form:errors path="pickUpComment" cssStyle="color: red; font-size: 12px" element="div"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <form:button type="button" id="Button4Prev" class="btn prev-step">Wstecz</form:button>
                    <form:button type="button" id="Button4Next" class="btn next-step">Dalej</form:button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                    Ilość: <span id="summQuantity"></span>, zawartość:
                                    <span id="summCategories"></span></span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text">Dla fundacji:
                                    <span id="summInstitutionName"></span></span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="summPickupStreet"></li>
                                <li id="summPickupCity"></li>
                                <li id="summPickupZipCode"></li>
                                <li id="summPhone"></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="summPickupDate"></li>
                                <li id="summPickupTime"></li>
                                <li id="summPickUpComment"></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <form:button type="button" class="btn prev-step">Wstecz</form:button>
                        <%--                    <button type="submit" class="btn">Potwierdzam</button>--%>
                    <form:input type="button" value="Potwierdzam" onclick="this.form.submit()" path=""/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </div>
        </form:form>
    </div>
</section>

<%@include file="footer.jsp" %>
<script src="<c:url value="resources/js/form.js"/>"></script>