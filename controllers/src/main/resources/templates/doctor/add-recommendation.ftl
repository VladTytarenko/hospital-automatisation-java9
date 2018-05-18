<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form name="recommendation" action="/doctor/${doctor.passport}/all_receptions/${reception}/add_recommendation" method="POST">
        <input type="number" name="reception" value="${reception}" readonly/>
        <input type="text" name="recommendation"/>
        <input type="submit" value="Ok"/>
    </form>

</body>
</html>