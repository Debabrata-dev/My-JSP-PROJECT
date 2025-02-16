<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="CSS/Style.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="regForm" method="post">
<h1>Registration Form</h1>
<fieldset>
<legend><h3>From</h3></legend>
Name: <input class="field" type="text" name="name1" placeholder="Name"/><br/><br/>
Email: <input class="field1" type="text" name="email" placeholder="Enter Email"/><br/><br/>
Password: <input class="field2" type="password" name="pass1" placeholder="Enter Password"/>

<br/><br/>
Gender: <input type="radio" name="gender1" value="Male"/>Male<input type="radio" name="gender1" value="female">
Female:<br><br/>
City:<select name="city1">
<option>Select City</option>
<option>Los Angeles</option>
<option>Chicago</option>
<option>Houston</option>
<option>Phoenix</option>
<option>melbourne</option>
</select></br></br>
<input  type="submit" value="Register"/>
</fieldset>
</form>
</body>
</html>