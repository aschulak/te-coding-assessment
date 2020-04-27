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
			${puppy.name} is a wonderful dog who weighs ${puppy.weight} ${puppy.weight == 1 ? 'lb' : 'lbs'}			
			and is ${puppy.paperTrained ? '' : ' NOT '} paper trained.
		</p>
	</c:otherwise>
</c:choose>

<p>	
	<!-- Use this for local -->
	<!-- 
	<a href="/m3-java-assessment">Click here to return to the list of puppies.</a>
	-->
	<!-- Use this for Heroku -->
	<a href="/">Click here to return to the list of puppies.</a>
</p>

<%@include file="common/footer.jspf"%>