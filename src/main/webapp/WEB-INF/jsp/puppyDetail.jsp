<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${puppy.name}!!!" />

<%@include file="common/header.jspf"%>

<c:choose>
	<c:when test="${error != null}">
		<h1>Error</h1>
		<p style="color: red;">${error}</p>
	</c:when>
	<c:otherwise>
		<h1>${puppy.name}
			<small>${puppy.gender}</small>
		</h1>
		<p>
			${puppy.name} is a wonderful dog who weighs ${puppy.weight}
			<c:choose>
				<c:when test="${puppy.weight == 1 }">
				lb
				</c:when>
				<c:otherwise>
				lbs
				</c:otherwise>
			</c:choose>
			and is ${puppy.paperTrained ? '' : ' NOT '} paper trained.
		</p>
	</c:otherwise>
</c:choose>

<p>
	<a href="/m3-java-assessment">Click here to return to the list of puppies.</a>
</p>

<%@include file="common/footer.jspf"%>