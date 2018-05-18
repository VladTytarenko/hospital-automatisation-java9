<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <form name="doctor" action="/admin/all_doctors/${doctor.passport}/update" method="POST">
        <p>Surname:</p>
        <input title="Surname" type="text" name="surname" value="${doctor.surname}"/>
        <p>Name:</p>
        <input title="Name" type="text" name="name" value="${doctor.name}"/>
        <p>Patronymic:</p>
        <input title="Patronymic" type="text" name="patronymic" value="${doctor.patronymic}"/>
        <p>Passport:</p>
        <input title="Passport" type="text" name="passport" value="${doctor.passport}"/>
        <p>Password:</p>
        <input title="Password" type="password" name="password" value="${doctor.password}"/>
        <!--<p>Email:</p>-->
        <!--<input title="Email" type="email" name="email"/>-->
        <p>Birthdate:</p>
        <input title="Birthdate" type="date" name="birthdate" value="${doctor.birthdate}" readonly/>
        <p>Specialization:</p>
        <input title="Specialization" type="text" name="specialization" value="${doctor.specialization}"/>
        <p>Experience:</p>
        <input title="Experience" type="number" name="experience" value="${doctor.experience}"/>
        <p>Position:</p>
        <input title="Position" type="text" name="position" value="${doctor.position}"/>
        <p>Degree:</p>
        <input title="Degree" type="text" name="degree" value="${doctor.degree}"/><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>