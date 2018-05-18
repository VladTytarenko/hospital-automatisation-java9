<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

 <#list recommendations_list as recommendation>
     ${recommendation.recommendation}  ${recommendation.id}<br>
 </#list>

</body>
</html>