<html>
    <head>
        <meta charset="utf-8" >
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <title>Accueil - La Florentina - Pizzéria à Saint-Herblain</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/feuilleDeStylePizzeria.css">
        <style>

            

        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">

                <div id="monCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#monCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#monCarousel" data-slide-to="1"></li>
                        <li data-target="#monCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">

                        <div class="item active">
                            <img src="Images/Carousel/Carousel1.jpg" alt="Pizzeria">
                            <div class="carousel-caption">
                                <h1>La Florentina</h1>
                                <p>L'italie est dans votre pizza !</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="Images/Carousel/Carousel2.jpg" alt="Pizzeria" width="460" height="345">
                            <div class="carousel-caption">
                                <h1>Nos pizzas</h1>
                                <p>Il y en à pour tous les goûts</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="Images/Carousel/Carousel3.jpg" alt="Pizzeria" width="460" height="345">
                            <div class="carousel-caption">
                                <h1>Four à bois</h1>
                                <p>Quoi de mieux qu'un foir à bois pour faire de bonnes pizzas</p>
                            </div>
                        </div>
                    </div>

                    

                    <!-- Flèches de contrôle -->
                    <a class="left carousel-control" href="#monCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Précédent</span>
                    </a>
                    <a class="right carousel-control" href="#monCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Suivant</span>
                    </a>
                </div>
                </div>
                <!-- Début de la barre de navigation -->
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <!-- Barre de navigation pour smartphones -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#maNavBar">
                                <span class="icon-bar"></span>
                                <!-- à compléter -->
                            </button>
                        </div>

                        <!-- Barre de navigation pour ordinateurs -->
                        <div class="collapse navbar-collapse" id="maNavBar">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="Accueil.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Accueil</a></li>
                                <li><a target="_blank" href="https://www.google.fr/maps/place/L'oustalou/@43.6247359,3.4319663,17z/data=!3m1!4b1!4m5!3m4!1s0x12b15d9df207f50d:0x6993f13889a19304!8m2!3d43.624732!4d3.434155"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> La Florentina</a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Notre carte<span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li>
                                           <a href="#" class="btn"><span class="glyphicon glyphicon-download-alt"></span> Télécharger la carte</a>
                                        </li>
                                        <li>
                                            <a href="#" class="btn"><span class="glyphicon glyphicon-eye-open"></span> Voir la carte</a>
                                        </li>
                                        <li role="separator" class="divider"></li>
                                        <li class="dropdown-header"><span class="glyphicon glyphicon-fire" aria-hidden="true"></span> Nos pizzas</li>
                                        <li><a href="#">Marguerita <span class="label label-success">Produit de la semaine</span></a></li>
                                        <li><a href="#">Reine</a></li>
                                        <li><a href="#">La 4 fromages</a></li>
                                        <li class="dropdown-header"><span class="glyphicon glyphicon-fire" aria-hidden="true"></span> Nos salades</li>
                                        <li class="dropdown-header"><span class="glyphicon glyphicon-fire" aria-hidden="true"></span> Rupture</li>
                                        <li class ="disabled"><a href="#">Pomme <span class="label label-danger">Produit indisponible</span></a></li>
                                    </ul>
                                </li>
                                <li><a href="javascript:chargeHTML('ContactezNous')"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Contactez-nous</a></li>
                            </ul>				 
                        </div><!-- /.navbar-collapse -->
                    </div><!-- /.container-fluid -->
                </nav>
            </div>
            <!-- Fin de la barre de navigation -->
            <div id="contenu">
                <div class="jumbotron" style="padding:30px">
                    <h1>Bienvenue sur le site de La Florentina !</h1>
                    <p>Notre amour pour les pizzas se ressent jusque dans vos assiettes.</p>
                    <p>En amoureux ou en famille, notre équipe vous accueil 6 jours/7, du lundi au samedi.</p>
                    <p><a class="btn btn-primary" href="#" role="button">Trop cool ! Je veux réserver !</a></p>
                </div>
                <div class="alert" style="background-color:green">
                    <strong>Félicitation!</strong> Vous avez été choisi pour participer à notre grand jeu "Gagnez un Perrier citron" !
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                </div>
                <!-- Thumbnails -->
                <div class="page-header">
                    <h1>Les pizzas du moment</h1>
                </div>
                <div id="pizzasDuMoment">
                    <!-- à compléter pour gérer le responsive web design -->

                    <div class="col-lg-4 col-md-4 col-xs-4">
                        <div class="thumbnail">
                            <a href="#" class="link tooltip-link" data-toggle="tooltip" data-original-title="Pizza Napolitaine">
                                <img src="">
                            </a>
                            <div class="caption">
                                <h3>Margerita</h3>
                                <p>La margerita est une très bonne pizza</p>
                                <a href="#" class="btn btn-primary">En savoir plus ...   <span class="glyphicon glyphicon-forward"></span></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-xs-4">
                        <div class="thumbnail">
                            <a href="#" class="link tooltip-link" data-toggle="tooltip" data-original-title="Pizza Napolitaine">
                                <img src="Images/Pizzas/Pizza_prune.jpg">
                            </a>
                            <div class="caption">
                                <h3>Prune</h3>
                                <p>La pizza prune est une bonne pizza</p>
                                <a href="#" class="btn btn-primary">En savoir plus ...   <span class="glyphicon glyphicon-forward"></span></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-xs-4">
                        <div class="thumbnail">
                            <a href="#" class="link tooltip-link" data-toggle="tooltip" data-original-title="Pizza Poire">
                                <img src="Images/Pizzas/Pizza_poire.jpg">
                            </a>
                            <div class="caption" >
                                <h3>Poire</h3>
                                <p>La pizza poire est une bonne pizza</p>
                                <a href="#" class="btn btn-primary">En savoir plus ...   <span class="glyphicon glyphicon-forward"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-center">
                    <ul class= "pagination li">
                        <li class = "active"><a href="#">1</a></li>
                        <li ><a href="#">2</a></li>
                        <li ><a href="#">3</a></li>
                    </ul>
                </div>

                <div class="col-lg-8 col-lg-offset-2 col-md-offset-2 /* à compléter */">
                    <!-- Citation -->
                </div>

                <br/><br/>

                <!-- Atouts  -->
                <div id="atouts">                    
                    <!-- à compléter -->
                </div>

            </div>


        <div class="clearfix"></div>

        <!-- Footer -->

        <footer class="footer-pizzeria">

            <div class="footer-left">

                <img src="Images/LogoLaFlorentina.png" />

                <p class="footer-links">
                    <a href="Accueil.html">Accueil</a>
                    ·
                    <a href="LaFlorentina.html">La Florentina</a>
                    ·
                    <a href="javascript:chargeHTML('LaCarteDesProduits')">Notre carte</a>
                    ·
                    <a href="javascript:chargeHTML('ContactezNous.html')">Contactez-nous</a>
                </p>
            </div>

            <div class="footer-center">

                <div>
                    <p><span>Rue Edith Piaf, Immeuble Euptoyou</span> 44800 Saint-Herblain</p>
                </div>

                <div>
                    <p>02 40 99 99 99</p>
                </div>

                <div>
                    <p><a href="contact@la-florentina.com">contact@la-florentina.com</a></p>
                </div>

            </div>

            <div class="footer-right">
                <p class="footer-a-propos">
                    <span>À propos</span>
                    Lorem ipsum dolor sit amet, consectateur adispicing elit. Fusce euismod convallis velit, eu auctor lacus vehicula sit amet.
                </p>
            </div>
        </footer>

        <!-- Fonctions JavaScript -->
        <script>
            $(function() { 
                // Gestion des tooltips des pizzas du moment
                $(".tooltip-link").tooltip({
                    title: "<div style='background-color:white; border: 1px solid black'><img src='http://icons.iconarchive.com/icons/sonya/swarm/256/Pizza-icon.png' style='width:24px;'>Pizza</i></div>", 	
                    html: true, 
                    template : '<div class="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-head"><h2><img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Pizza-icon.png" style="width:24px;"> Info</h2></div><div class="tooltip-inner"></div></div>'
                });
                // 
                $('.pagination li').on('click',function(e) {
                    var tag = $(this);
                    var indice = tag.text();
                    var index = $('.pagination li').index(this);
                    console.log("indice: "+indice);
                    $('.pagination li').siblings('li').removeClass('active');
                    if (!tag.hasClass('active') && (index > 0 && index < 4)) {
                        tag.addClass('active');
                        $("#pizzasDuMoment").load("Pagination" + tag.text() + ".html");
                    }      
                    e.preventDefault();
                });
            });
            function chargeHTML(page) {
                $("#contenu").load(page + ".html");
            }
        </script>
    </body>
</html>