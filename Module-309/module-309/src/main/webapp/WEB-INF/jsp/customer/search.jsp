<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<h1 class="text-center">Customer Search</h1>
<section class="bg-light1 pt-4 pb-4">
<div class="container bg-light1">
    <form action="/customer/search" class="mb-0">
        <div class="row pt-3 justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="firstNameId" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstNameId" name="firstName" value="${search}">
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </div>
    </form>
</div>
</section>

<c:if test="${not empty search}">
    <section class="bg-light2">
        <div class="container">
            <h2 class="text-center pt-5">Customers Found (${customersKey.size()})</h2>

            <table class="table mt-5">
                <tr>
                    <th>Contact Firstname</th>
                    <th>Contact Lastname</th>
                    <th>id</th>
                    <th>Customer Name</th>
                    <th>Edit</th>
                </tr>
                <c:forEach var="customer" items="${customersKey}">
                    <tr>
                        <td>${customer.contactFirstname}</td>
                        <td>${customer.contactLastname}</td>
                        <td>${customer.id}</td>
                        <td>${customer.customerName}</td>
                        <td><a href="/customer/edit/${customer.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>
</c:if>



<jsp:include page="../include/footer.jsp"/>