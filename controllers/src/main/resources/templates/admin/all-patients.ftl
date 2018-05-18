<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
</head>
<body>

    <a href="/admin/all_patients/registration_patients">Registrate new patient</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Passport</th>
            <th>Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <#list patients_list as patient>
                    <tr>
                        <td>${patient.passport}</td>
                        <td><a href="/admin/all_patients/${patient.passport}">${patient.surname + " " + patient.name + " " + patient.patronymic}</td>
                    </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>