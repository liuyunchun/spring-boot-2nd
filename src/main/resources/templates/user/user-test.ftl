<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h1>加入會員</h1>
<form action="/user-insert" method="post">
    帳號<input name="id"/><br/>
    密碼<input name="password"/><br/>
    暱稱<input name="name"/><br/>
    信箱<input name="email"/>
    <button>完成</button>
<#--append create 方法-->
</form>
<h1>修改會員</h1>
<form action="/user-update" method="post">
    帳號<input name="id"/><br/>
    密碼<input name="password"/><br/>
    暱稱<input name="name"/><br/>
    信箱<input name="email"/>
    <button>完成</button>
</form>
<h1>查詢會員</h1>
<form action="/user-find" method="get">
    帳號<input name="id"/>
    <button>完成</button>
</form>
<h1>刪除會員</h1>
<form action="/user-delete" method="get">
    帳號<input name="id"/>
    <button>完成</button>
</form>
<script src="/js/main.js"></script>
</body>
</html>