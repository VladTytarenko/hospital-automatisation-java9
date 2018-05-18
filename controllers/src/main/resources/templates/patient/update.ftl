<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update</title>
</head>
<body>

    <form name="patient" action="/patient/${patient.passport}/updates" method="POST">
        <p>Surname:</p>
        <input title="Surname" type="text" name="surname" value="${patient.surname}" readonly/>
        <p>Name:</p>
        <input title="Name" type="text" name="name" value="${patient.name}" readonly/>
        <p>Patronymic:</p>
        <input title="Patronymic" type="text" name="patronymic" value="${patient.patronymic}" readonly/>
        <p>Passport:</p>
        <input title="Passport" type="text" name="passport" value="${patient.passport}" readonly/>
        <p>Address:</p>
        <input title="Address" type="text" name="address" value="${patient.address}" readonly/>
        <p>Email:</p>
        <input title="Email" type="email" name="email" value="${patient.email}"/>
        <p>Birthdate:</p>
        <input title="Birthdate" type="date" name="birthdate" value="${patient.birthdate}" readonly/>
        <p>Invalidity:</p>
        <input title="Invalidity" type="text" name="invalidity" value="${patient.invalidity}" readonly/>
        <p>Insurance Company:</p>
        <input title="Insurance-company" type="text" name="insuranceCompany" value="${patient.insuranceCompany}" readonly/>
        <p>Insurance Policy Type:</p>
        <input title="Insurance-policy-type" type="text" name="insuranceType" value="${patient.insuranceType}" readonly/>
        <p>Insurance Policy Number:</p>
        <input title="Insurance-policy-number" type="number" name="insuranceNumber" value="${patient.insuranceNumber}" readonly/>
        <p>Registration date:</p>
        <input title="Registration-date" type="text" name="registrationDate" value="${patient.registrationDate}" readonly/><br>
    </form>
    <a href="/patient/${patient.passport}/telephone">Telephone numbers</a>

</body>
</html>