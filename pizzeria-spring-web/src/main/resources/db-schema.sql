CREATE TABLE IF NOT EXISTS `pizza` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Categorie` varchar(255) DEFAULT NULL,
  `Ref` varchar(255) DEFAULT NULL,
  `Nom` varchar(255)  DEFAULT NULL,
  `Prix` decimal(19,2) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_j735cie2j69ie3xqsopc3g75t` (`Ref`)
);