<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>

<label for="${id}">${label} </label>
<input type="text" id="${id}" name="${id}" value="${'${id}'}" />