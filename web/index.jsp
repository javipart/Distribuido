<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistemas Distibuidos</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.css">
    <link rel="stylesheet" type="text/css" href="css/hero.css">
    <script src="js/script.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<section class="hero is-primary is-large header-image">
    <div class="hero-head">
        <header class="nav">
            <div class="container">
                <div class="nav-left">
                    <a class="nav-item" href="index.jsp">
                        <img src="images/up.png" alt="Logo">
                    </a>
                </div>
                <span class="nav-toggle">
            <span></span>
            <span></span>
            <span></span>
            </div>
    </div>
    </header>
    </div>
    <div class="hero-body">
        <div class="container has-text-centered">
            <h1 class="title is-2">
                Sistemas Distribuidos
            </h1>
            <input class="input is-outlined" type="text" onfocus="this.value=''" id="doc" style="width: 150px"
                   placeholder="Documento"
                   onKeypress="if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;"
                   required></input>

            <button class="button is-outlined" onclick="search()">
            <span class="icon">
              <i class="fa fa-search"></i>
            </span>
                <span>
              Consultar
            </span>
            </button>
        </div>
        <br>
        <div class="tile is-ancestor" align="center" style="filter: alpha(opacity=60)";>
            <div class="tile is-parent">
                <div class="container">
                    <table class="table is-outlined">
                        <thead>
                        <tr>
                            <th><abbr title="Documento">Documento</abbr></th>
                            <th><abbr title="Tipo de Documento">Tipo</abbr></th>
                            <th><abbr title="Nombre">Nombre</abbr></th>
                            <th><abbr title="Apellido">Apellido</abbr></th>
                            <th><abbr title="Edad">Edad</abbr></th>
                            <th><abbr title="Sueldo">Sueldo</abbr></th>
                        </tr>
                        </thead>
                        <tbody id="table">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="footer">
    <div class="container">
        <div class="content has-text-centered">
            <p>
                <strong>UPTC</strong>
            </p>
            <p>
                Javier Pardo y Juliana Cano.
            </p>
            <p>
            </p>
        </div>
    </div>
</footer>
</body>
</html>
