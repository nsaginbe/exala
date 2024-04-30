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
            padding: 0;
            background-color: #ffebee;
            color: #333;
        }
        .header {
            background-color: #ff5252;
            color: #fff;
            text-align: center;
            padding: 20px;
            margin-bottom: 20px;
            position: relative;
        }
        .header h1 {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            margin: 0;
            font-size: 24px;
        }
        .container {
            max-width: 800px;
            min-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        form {
            text-align: center;
        }
        input[type="text"] {
            padding: 10px;
            width: 60%;
            border-radius: 4px;
            border: 1px solid #ccc;
            margin-right: 10px;
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
        .event {
            background-color: #ffebee;
            padding: 10px;
            margin-top: 20px;
            border-radius: 4px;
            width: 30%;
            display: inline-block;
            margin-right: 2%;
            box-sizing: border-box;
            vertical-align: top;
            transition: transform 0.3s;
            cursor: pointer;
        }
        .event:hover {
            transform: scale(1.1);
        }
        .event a {
            color: #ff5252;
            text-decoration: none;
        }
        .event img {
            width: 100%;
            height: auto;
            display: block;
            margin: 10px auto;
            border-radius: 8px;
        }
        hr {
            border: none;
            border-top: 1px solid #ccc;
            margin-top: 30px;
        }
        .no-events {
            text-align: center;
            color: #777;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>EXALA.COM</h1>
</div>
<div class="container">
    <form action="/" method="get">
        <label for="eventName">Searching by name:</label>
        <input type="text" id="eventName" name="name">
        <input type="submit" value="Search">
    </form>

    <#if events??>
        <#list events as event>
            <div class="event">
                <#if event.images?has_content>
                    <img src="/images/${event.images[0].id}"a alt="${event.name}">
                </#if>
                <strong>${event.name}</strong><br>
                ${event.address} | ${event.date}<br>
                <a href="/event/${event.id}">Details...</a><br>
            </div>
            <#if event_index % 3 == 2 || event_index == events?size - 1>
                <div style="clear:both;"></div>
            </#if>
        </#list>
    </#if>
    <hr>
</div>

<script>
    const eventBlocks = document.querySelectorAll('.event');
    eventBlocks.forEach(block => {
        block.addEventListener('mouseenter', () => {
            block.style.transform = 'scale(1.05)';
        });
        block.addEventListener('mouseleave', () => {
            block.style.transform = 'scale(1)';
        });
    });
</script>
</body>
</html>
