<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <form name="recipe" action="/doctor/${doctor.passport}/all_receptions/${reception}/add_recipe" method="POST">
        <input type="number" name="reception" value="${reception}" readonly/>
        <input type="text" name="medicament"/>
        <input type="submit" value="Ok"/>
    </form>

</body>
</html>