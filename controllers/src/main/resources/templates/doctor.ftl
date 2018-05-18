<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <p>Surname:</p>
    ${doctor.surname}
    <p>Name:</p>
    ${doctor.name}
    <p>Patronymic:</p>
    ${doctor.patronymic}
    <p>Passport:</p>
    ${doctor.passport}
    <#--<p>Email:</p>-->
    <p>Birthdate:</p>
    ${doctor.birthdate}
    <p>Specialization:</p>
    ${doctor.specialization}
    <p>Experience:</p>
    ${doctor.experience}
    <p>Position:</p>
    ${doctor.position}
    <p>Degree:</p>
    ${doctor.degree}

    <a href="/admin/all_doctors">To Doctor List</a>
    <a href="/admin/all_doctors/${doctor.passport}/update">Update information</a>
    <a href="/admin/all_doctors/${doctor.passport}/delete">Delete doctor</a>

</body>
</html>