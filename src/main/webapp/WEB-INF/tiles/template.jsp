<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Despesas</title>
    <link rel="icon" href="data:;base64,iVBORw0KGgo="> <!-- to prevent favicon requests -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script type="text/javascript">

        function dataSistema() {
            if (document.getElementById('checkDate').checked) {
                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth() + 1;
                var yyyy = today.getFullYear();

                if (dd < 10) {
                    dd = '0' + dd
                }

                if (mm < 10) {
                    mm = '0' + mm
                }

                today = yyyy + '-' + mm + '-' + dd;
                document.getElementById('date').value = today;
            } else {
                document.getElementById('date').value = "";
            }
        }

        function textCounter( field, countfield, maxlimit ) {
            if ( field.value.length > maxlimit ) {
                field.value = field.value.substring( 0, maxlimit );
                field.blur();
                field.focus();
                return false;
            } else {
                countfield.value = maxlimit - field.value.length;
            }
        }
    </script>
</head>


<html>
<body>
<br>
<div class="container">
    <fieldset>
        <div class="page">
            <tiles:insertAttribute name="header" />
            <div class="content">
                <tiles:insertAttribute name="body" />
            </div>
            <tiles:insertAttribute name="footer" />
        </div>
</div>
</fieldset>
</body>
</html>