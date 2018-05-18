<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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


    <a href="/doctor/${doctor.passport}/all_receptions/${reception.id}/recommendations">Recomendations</a>
    <a href="/doctor/${doctor.passport}/all_receptions/${reception.id}/add_recommendation">Add recomendation</a>
    <a href="/doctor/${doctor.passport}/all_receptions/${reception.id}/add_recipe">Add recipe</a>

</body>
</html>