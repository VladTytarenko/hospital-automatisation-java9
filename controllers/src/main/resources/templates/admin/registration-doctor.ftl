<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form name="doctor" action="/admin/all_doctors/registration_doctor" method="POST">
        <p>Surname:</p>
        <input title="Surname" type="text" name="surname"/>
        <p>Name:</p>
        <input title="Name" type="text" name="name"/>
        <p>Patronymic:</p>
        <input title="Patronymic" type="text" name="patronymic"/>
        <p>Passport:</p>
        <input title="Passport" type="text" name="passport"/>
        <p>Password:</p>
        <input title="Password" type="password" name="password"/>
        <#--<p>Email:</p>-->
        <#--<input title="Email" type="email" name="email"/>-->
        <p>Birthdate:</p>
        <input title="Birthdate" type="date" name="birthdate"/>
        <p>Specialization:</p>
        <input title="Specialization" type="text" name="specialization"/>
        <p>Experience:</p>
        <input title="Experience" type="number" name="experience"/>
        <p>Position:</p>
        <input title="Position" type="text" name="position"/>
        <p>Degree:</p>
        <input title="Degree" type="text" name="degree"/><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>