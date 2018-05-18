<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <#list doctor_list as doctor>
        <a href="/patient/${passport}/referals/${doctor.passport}">${doctor.surname} ${doctor.name}</a>
    </#list>

</body>
</html>