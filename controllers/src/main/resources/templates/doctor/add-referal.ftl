<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <form name="specialization" action="/doctor/${doctor}/all_receptions/${reception}/add_referal" method="POST">
        <#list specialization_list as specialization>
            <div>
                <input type="radio" id="" name="specialization" value="${specialization.id}">
                <label for="specialization">${specialization.specialization}</label>
            </div>
        </#list>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>

</body>
</html>