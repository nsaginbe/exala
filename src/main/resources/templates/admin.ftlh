<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"],
        input[type="file"] {
            width: calc(100% - 12px);
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #ff5252;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #ff1744;
        }
    </style>
</head>
<body>
<h1>Add New Event</h1>
<form action="/event/create" method="post" enctype="multipart/form-data">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">

    <label for="description">Description:</label>
    <input type="text" id="description" name="description">

    <label for="address">Address:</label>
    <input type="text" id="address" name="address">

    <label for="date">Date:</label>
    <input type="text" id="date" name="date">

    <label for="file">Photo:</label>
    <input type="file" id="file" name="file">

    <input type="submit" value="Add Event">
</form>
</body>
</html>
