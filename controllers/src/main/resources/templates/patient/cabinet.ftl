<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cabinet</title>
</head>
<body>

    Surname:<br>
    ${patient.surname}<br>
    Name:<br>
    ${patient.name}<br>
    Patronymic:<br>
    ${patient.patronymic}<br>
    Passport:<br>
    ${patient.passport}<br>
    Address:<br>
    ${patient.address}<br>
    Email:<br>
    ${patient.email}<br>
    Birthdate:<br>
    ${patient.birthdate}<br>
    Invalidity:<br>
    ${patient.invalidity}<br>


    <a href="/patient/${patient.passport}/recommendations">Recomendations</a>
    <a href="/patient/${patient.passport}/recipes">Recipes</a>
    <a href="/patient/${patient.passport}/referals">Referals</a>
    <a href="/patient/${patient.passport}/receptions">Receptions</a>
    <a href="/patient/${patient.passport}/update">Update</a>

</body>
</html>