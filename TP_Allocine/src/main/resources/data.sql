-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 21 oct. 2024 à 15:41
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `allocine`
--

-- --------------------------------------------------------

--
-- Structure de la table `acteur`
--

CREATE TABLE `acteur` (
                          `codeActeur` varchar(10) NOT NULL,
                          `nomActeur` varchar(50) NOT NULL,
                          `imageActeur` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acteur`
--

INSERT INTO `acteur` (`codeActeur`, `nomActeur`, `imageActeur`) VALUES
                                                                    ('10339', 'Imelda Staunton', 'http://fr.web.img3.acsta.net/pictures/17/02/16/16/15/152609.jpg'),
                                                                    ('12559', 'Pierre Richard', 'http://fr.web.img1.acsta.net/pictures/15/10/19/12/04/251025.jpg'),
                                                                    ('180052', 'Vincent Macaigne', 'http://fr.web.img2.acsta.net/pictures/15/12/02/10/54/120415.jpg'),
                                                                    ('181931', 'Anne Dorval', 'http://fr.web.img4.acsta.net/pictures/15/12/08/15/50/030050.jpg'),
                                                                    ('200525', 'Eye Haidara', 'http://fr.web.img1.acsta.net/pictures/17/09/26/14/14/0771838.jpg'),
                                                                    ('21353', 'Brendan Gleeson', 'http://fr.web.img5.acsta.net/pictures/17/06/02/14/16/492240.jpg'),
                                                                    ('21750', 'Jean-Paul Rouve', 'http://fr.web.img6.acsta.net/pictures/19/07/01/11/09/2324040.jpg'),
                                                                    ('22868', 'Jared Leto', 'http://fr.web.img1.acsta.net/pictures/16/02/29/14/37/141208.jpg'),
                                                                    ('246148', 'Ana de Armas', 'http://fr.web.img5.acsta.net/pictures/16/05/17/12/17/360795.jpg'),
                                                                    ('259767', 'Sylvia Hoeks', 'http://fr.web.img1.acsta.net/pictures/18/10/18/11/08/5881516.jpg'),
                                                                    ('29358', 'Hugh Bonneville', 'http://fr.web.img1.acsta.net/pictures/17/06/02/13/41/489098.jpg'),
                                                                    ('472', 'Harrison Ford', 'http://fr.web.img1.acsta.net/pictures/15/10/13/11/06/006332.jpg'),
                                                                    ('5081', 'Karin Viard', 'http://fr.web.img6.acsta.net/pictures/18/05/15/10/37/1332370.jpg'),
                                                                    ('57126', 'Ryan Gosling', 'http://fr.web.img5.acsta.net/pictures/16/05/17/17/28/208580.jpg'),
                                                                    ('6460', 'Thibault de Montalembert', 'http://fr.web.img1.acsta.net/pictures/15/10/14/21/30/080517.jpg'),
                                                                    ('682', 'Jean-Louis Trintignant', 'http://fr.web.img1.acsta.net/pictures/17/01/30/15/42/020676.jpg'),
                                                                    ('798793', 'Sacha Pinault', 'http://fr.web.img3.acsta.net/pictures/17/03/21/17/24/116371.jpg'),
                                                                    ('83617', 'Sally Hawkins', 'http://fr.web.img5.acsta.net/pictures/16/02/09/16/55/102827.jpg'),
                                                                    ('91503', 'Gilles Lellouche', 'http://fr.web.img3.acsta.net/pictures/18/05/14/15/06/4374301.jpg'),
                                                                    ('93932', 'Guillaume Gallienne', 'http://fr.web.img6.acsta.net/pictures/210/078/21007862_20130523125837846.png'),
                                                                    ('947', 'Isabelle Huppert', 'http://fr.web.img3.acsta.net/pictures/17/05/24/15/48/259657.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `cinema`
--

CREATE TABLE `cinema` (
                          `codeCine` varchar(10) NOT NULL,
                          `nomCine` varchar(30) NOT NULL,
                          `adresseCine` varchar(50) NOT NULL,
                          `codePostalCine` varchar(5) NOT NULL,
                          `villeCine` varchar(20) NOT NULL,
                          `latitudeCine` float NOT NULL,
                          `longitudeCine` float NOT NULL,
                          `imageCine` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cinema`
--

INSERT INTO `cinema` (`codeCine`, `nomCine`, `adresseCine`, `codePostalCine`, `villeCine`, `latitudeCine`, `longitudeCine`, `imageCine`) VALUES
                                                                                                                                             ('C0116', 'Gaumont Aquaboulevard', '8-16, rue du Colonel-Pierre-Avia', '75015', 'Paris 15e arrondisse', 48.831, 2.27699, 'http://fr.web.img2.acsta.net/medias/nmedia/18/72/95/12/19465600.jpg'),
                                                                                                                                             ('C0161', 'Gaumont Convention', '27, rue Alain-Chartier', '75015', 'Paris 15e arrondisse', 48.8378, 2.29643, 'http://fr.web.img5.acsta.net/pictures/213/278/21327852_122558364.jpg'),
                                                                                                                                             ('P0120', 'Le Darcy', '8, place Darcy', '21000', 'Dijon', 47.3236, 5.03463, 'http://fr.web.img6.acsta.net/pictures/213/867/21386701_092113892.jpg'),
                                                                                                                                             ('P0121', 'Eldorado', '21, rue Alfred-de-Musset', '21000', 'Dijon', 47.315, 5.04872, 'http://fr.web.img6.acsta.net/medias/nmedia/18/66/19/24/18917823.jpg'),
                                                                                                                                             ('P0122', 'Devosge', '6, rue Devosge', '21000', 'Dijon', 47.3244, 5.0346, 'http://fr.web.img3.acsta.net/pictures/213/198/21319881_17551287.jpg'),
                                                                                                                                             ('P0771', 'Ciné Cap Vert', '1, rue du Cap-Vert', '21800', 'Quetigny', 47.312, 5.09281, 'http://fr.web.img4.acsta.net/medias/nmedia/18/67/98/96/19005764.jpg'),
                                                                                                                                             ('P2788', 'Olympia', '16, avenue du Marechal Foch', '21000', 'Dijon', 47.3236, 5.03007, 'http://fr.web.img5.acsta.net/pictures/213/867/21386705_092412336.jpg'),
                                                                                                                                             ('W7502', 'Pathé Beaugrenelle', '7 rue Linois', '75015', 'Paris 15e arrondisse', 48.8488, 2.28247, 'http://fr.web.img6.acsta.net/pictures//211/170/21117039_094550527.jpg'),
                                                                                                                                             ('W7515', 'Cinéma Chaplin Saint', '6, rue Peclet', '75015', 'Paris 15e arrondisse', 48.8431, 2.29863, 'http://fr.web.img1.acsta.net/pictures//211/108/21110802_143911405.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
                        `codeFilm` varchar(10) NOT NULL,
                        `nomFilm` varchar(100) NOT NULL,
                        `imageFilm` varchar(150) NOT NULL,
                        `genreFilm` varchar(50) NOT NULL,
                        `nbVotes` int(5) NOT NULL,
                        `totalVotes` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`codeFilm`, `nomFilm`, `imageFilm`, `genreFilm`, `nbVotes`, `totalVotes`) VALUES
                                                                                                  ('197686', 'Blade Runner 2049', 'http://fr.web.img4.acsta.net/pictures/17/08/24/15/18/597734.jpg', 'Science fiction', 33, 71),
                                                                                                  ('206775', 'Coco', 'http://fr.web.img2.acsta.net/pictures/17/09/15/12/42/0056825.jpg', 'Animation', 17, 57),
                                                                                                  ('223252', 'Thor : Ragnarok', 'http://fr.web.img3.acsta.net/pictures/17/08/24/17/34/098917.jpg', 'Action', 57, 136),
                                                                                                  ('229351', 'Le Petit Spirou', 'http://fr.web.img4.acsta.net/pictures/17/07/12/10/33/047891.jpg', 'Comédie', 55, 79),
                                                                                                  ('242201', 'Paddington 2', 'http://fr.web.img3.acsta.net/pictures/17/06/29/17/12/486140.jpg', 'Animation', 7, 19),
                                                                                                  ('243975', 'Happy End', 'http://fr.web.img1.acsta.net/pictures/17/05/18/09/22/181477.jpg', 'Drame', 0, 0),
                                                                                                  ('247291', 'Le Sens de la fête', 'http://fr.web.img5.acsta.net/pictures/17/07/12/11/50/570288.jpg', 'Comédie', 2, 7),
                                                                                                  ('248315', 'Confident Royal', 'http://fr.web.img1.acsta.net/pictures/17/05/31/11/13/023056.jpg', 'Biopic', 0, 0),
                                                                                                  ('248712', 'Gauguin - Voyage de Tahiti', 'http://fr.web.img1.acsta.net/pictures/17/07/28/10/01/148014.jpg', 'Biopic', 2, 8),
                                                                                                  ('248752', 'Numéro Une', 'http://fr.web.img1.acsta.net/pictures/17/08/25/14/23/016113.jpg', 'Comédie dramatique', 3, 12),
                                                                                                  ('252872', 'Jalouse', 'http://fr.web.img5.acsta.net/pictures/17/09/21/16/58/3546135.jpg', 'Comedie', 5, 17),
                                                                                                  ('254730', 'Les Grands Esprits', 'http://fr.web.img5.acsta.net/pictures/17/07/17/12/49/199993.jpg', 'Comédie dramatique', 3, 9),
                                                                                                  ('255744', 'Le Corsaire (Bolchoï-Pathé Live)', 'http://fr.web.img3.acsta.net/pictures/17/08/25/14/45/263638.jpg', 'Divers', 6, 18),
                                                                                                  ('256803', 'Les Fourberies de Scapin', 'http://fr.web.img1.acsta.net/pictures/17/08/21/13/17/197159.jpg', 'Divers', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `jouer`
--

CREATE TABLE `jouer` (
                         `numFilm` varchar(10) NOT NULL,
                         `numActeur` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `jouer`
--

INSERT INTO `jouer` (`numFilm`, `numActeur`) VALUES
                                                 ('197686', '10339'),
                                                 ('243975', '10339'),
                                                 ('252872', '10339'),
                                                 ('197686', '12559'),
                                                 ('243975', '12559'),
                                                 ('248315', '12559'),
                                                 ('197686', '180052'),
                                                 ('248752', '180052'),
                                                 ('252872', '180052'),
                                                 ('197686', '181931'),
                                                 ('206775', '200525'),
                                                 ('229351', '21750'),
                                                 ('243975', '21750'),
                                                 ('223252', '22868'),
                                                 ('229351', '22868'),
                                                 ('248315', '22868'),
                                                 ('252872', '22868'),
                                                 ('206775', '246148'),
                                                 ('223252', '246148'),
                                                 ('242201', '246148'),
                                                 ('256803', '246148'),
                                                 ('242201', '259767'),
                                                 ('248752', '259767'),
                                                 ('252872', '259767'),
                                                 ('248315', '29358'),
                                                 ('243975', '472'),
                                                 ('248315', '472'),
                                                 ('256803', '472'),
                                                 ('248712', '5081'),
                                                 ('248712', '682'),
                                                 ('248752', '798793'),
                                                 ('254730', '798793'),
                                                 ('248752', '83617'),
                                                 ('255744', '83617'),
                                                 ('247291', '91503'),
                                                 ('248712', '91503'),
                                                 ('248712', '93932'),
                                                 ('255744', '93932'),
                                                 ('247291', '947'),
                                                 ('254730', '947');

-- --------------------------------------------------------

--
-- Structure de la table `projeter`
--

CREATE TABLE `projeter` (
                            `numCinema` varchar(10) NOT NULL,
                            `numFilm` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projeter`
--

INSERT INTO `projeter` (`numCinema`, `numFilm`) VALUES
                                                    ('C0116', '197686'),
                                                    ('P0771', '197686'),
                                                    ('P2788', '197686'),
                                                    ('C0116', '206775'),
                                                    ('P0120', '206775'),
                                                    ('P0771', '206775'),
                                                    ('P2788', '206775'),
                                                    ('P0120', '223252'),
                                                    ('C0116', '229351'),
                                                    ('P0771', '229351'),
                                                    ('P2788', '229351'),
                                                    ('C0161', '242201'),
                                                    ('P0122', '242201'),
                                                    ('W7515', '242201'),
                                                    ('C0161', '243975'),
                                                    ('P0771', '243975'),
                                                    ('W7502', '247291'),
                                                    ('W7515', '248315'),
                                                    ('C0161', '248712'),
                                                    ('W7502', '248712'),
                                                    ('P0120', '248752'),
                                                    ('W7515', '248752'),
                                                    ('P0120', '252872'),
                                                    ('P0121', '254730'),
                                                    ('P0121', '255744'),
                                                    ('P0122', '256803');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acteur`
--
ALTER TABLE `acteur`
    ADD PRIMARY KEY (`codeActeur`);

--
-- Index pour la table `cinema`
--
ALTER TABLE `cinema`
    ADD PRIMARY KEY (`codeCine`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
    ADD PRIMARY KEY (`codeFilm`);

--
-- Index pour la table `jouer`
--
ALTER TABLE `jouer`
    ADD PRIMARY KEY (`numFilm`,`numActeur`),
  ADD KEY `numActeur` (`numActeur`);

--
-- Index pour la table `projeter`
--
ALTER TABLE `projeter`
    ADD PRIMARY KEY (`numCinema`,`numFilm`),
  ADD KEY `numFilm` (`numFilm`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `jouer`
--
ALTER TABLE `jouer`
    ADD CONSTRAINT `jouer_ibfk_1` FOREIGN KEY (`numActeur`) REFERENCES `acteur` (`codeActeur`),
  ADD CONSTRAINT `jouer_ibfk_2` FOREIGN KEY (`numFilm`) REFERENCES `film` (`codeFilm`);

--
-- Contraintes pour la table `projeter`
--
ALTER TABLE `projeter`
    ADD CONSTRAINT `projeter_ibfk_1` FOREIGN KEY (`numCinema`) REFERENCES `cinema` (`codeCine`),
  ADD CONSTRAINT `projeter_ibfk_2` FOREIGN KEY (`numFilm`) REFERENCES `film` (`codeFilm`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
