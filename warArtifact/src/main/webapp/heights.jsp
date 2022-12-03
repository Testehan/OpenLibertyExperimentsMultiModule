<html>
<head>
<title>Height Converter</title>
</head>
<body>
    <h1>Height Converter</h1>

    <jsp:useBean id="height" class="com.testehan.openliberty.multimodule.web.HeightsBean"></jsp:useBean>
    <jsp:setProperty name="height" property="heightCm" />
    <jsp:setProperty name="height" property="heightFeet" value="0" />
    <jsp:setProperty name="height" property="heightInches" value="0" />

    <p>
        Height in centimeters:
        <jsp:getProperty name="height" property="heightCm" />
        cm
    </p>

    <br>

    <p>
        Height in feet and inches:
        <jsp:getProperty name="height" property="heightFeet" />
        feet
        <jsp:getProperty name="height" property="heightInches" />
        inches
    </p>

</body>
</html>