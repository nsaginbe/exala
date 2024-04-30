<!DOCTYPE html>
<html lang="en">
<head>
    <title>Exala ma?</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #ffebee;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #ff5252;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        img {
            display: block;
            margin: 0 auto 10px;
            border-radius: 8px;
            max-width: 400px;
        }
        label {
            font-weight: bold;
        }
        hr {
            border: none;
            border-top: 1px solid #ccc;
            margin: 20px 0;
        }
        form {
            text-align: center;
        }
        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #ff5252;
            color: #fff;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #ff1744;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Event Details</h1>
    <#list images as image>
        <img src="/images/${image.id}" alt="Event Image">
    </#list>
    <label>Name:</label> ${event.name}<br>
    <label>Description:</label> ${event.description}<br>
    <label>Address:</label> ${event.address}<br>
    <label>Date:</label> ${event.date}<br>
    <hr>
    <form action="/event/delete/${event.id}" method="post">
        <input type="submit" value="Delete Event">
    </form>
</div>
</body>
</html>
