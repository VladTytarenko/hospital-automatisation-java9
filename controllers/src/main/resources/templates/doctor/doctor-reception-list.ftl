<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <#list receptions_list as reception>
        <tr>
            <td><a href="/doctor/${doctor.passport}/all_receptions/${reception.id}">${reception.date}</td>
        </tr>
    </#list>

</body>
</html>