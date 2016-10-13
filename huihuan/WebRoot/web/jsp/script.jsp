<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 0);
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/BootSideMenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/script/common.js"></script>