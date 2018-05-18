<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <a href="/admin/all_doctors/registration_doctor">Registrate new doctor</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Passport</th>
            <th>Name</th>
            <th>Specialization</th>
        </tr>
        </thead>
        <tbody>
                <#list doctor_list as doctor>
                <tr>
                    <td>${doctor.passport}</td>
                    <td><a href="/admin/all_doctors/${doctor.passport}">${doctor.surname + " " + doctor.name + " " + doctor.patronymic}</td>
                    <td>${doctor.specialization}</td>
                </tr>
                </#list>
        </tbody>
    </table>

</body>
</html>