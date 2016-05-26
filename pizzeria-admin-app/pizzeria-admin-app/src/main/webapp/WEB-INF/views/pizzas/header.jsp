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
                            <img src="/pizzeria-admin-app/images/Carousel/Carousel1.jpg" alt="Pizzeria" width="1980" height="500">
                            <div class="carousel-caption">
                                <h1>La Florentina</h1>
                                <p>L'italie est dans votre pizza !</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="/pizzeria-admin-app/images/Carousel/Carousel2.jpg" alt="Pizzeria" width="1980" height="500">
                            <div class="carousel-caption">
                                <h1>Nos pizzas</h1>
                                <p>Il y en à pour tous les goûts</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="/pizzeria-admin-app/images/Carousel/Carousel3.jpg" alt="Pizzeria" width="1980" height="500">
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