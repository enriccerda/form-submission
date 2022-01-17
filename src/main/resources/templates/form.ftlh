<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>FORM TEST</title>
        <link href="/css/main.css" rel="stylesheet">
    </head>
    <body>
        <img src="https://www.w3schools.com/html/pic_trulli.jpg" alt="Girl in a jacket" width="500" height="600"> 
        <h1>Form Test</h1>
        <#if user?? >
            <h2>Your data:</h2><br>
            Name: ${user.name}<br>
            Surname: ${user.surname}<br>
            Address: ${user.userAddress}<br>
            City: ${user.city}<br>
            Email: ${user.email}<br>
            Message: ${user.message}<br>
            <br/>
            <form>
 				<input type="button" value="Back" onclick="history.back()">
			</form>
        <#else>
            <form action="/form" method="post">
                <div>Name:</div>
                <input type="text" name="name"/>
                <br/>
                <br/>
                <div>Surname:</div>
                <input type="text" name="surname"/>
                <br/>
                <br/>
                <div>User Address:</div>
                <input type="text" name="userAddress"/>
                <br/>
                <br/>
				<div>City:</div>
                <input type="text" name="city"/>
                <br/>
                <br/>
                <div>Email:</div>
                <input type="text" name="email"/>
                <br/>
                <br/>
                <div>Message:</div>
                <textarea rows="2" name="message"></textarea>
                <br/>
                <br/>
                <input type="submit" value="Submit"/>
                <input type="reset" value="Reset"/>
            </form>
        </#if>
        <script src="/js/main.js"></script>
    </body>
</html>