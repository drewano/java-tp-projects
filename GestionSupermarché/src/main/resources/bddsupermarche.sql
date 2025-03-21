-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 24 oct. 2024 à 18:36
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
-- Base de données :  `bddsupermarche`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Graph` ()  NO SQL
select nom,dte FROM graphenligne
UNION

Select nomR,dte from rayon,graphenligne
where nomR=nom
and nomR not in (select nom from graphenligne where total=0 group by dte)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `numE` int(10) NOT NULL,
  `prenomE` varchar(20) NOT NULL,
  `age` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`numE`, `prenomE`, `age`) VALUES
(1, 'Olivier', 36),
(2, 'Marie', 21),
(3, 'Benjamin', 36),
(4, 'Christophe', 32),
(5, 'Virginie', 46),
(6, 'Lilou', 19),
(7, 'Noa', 33),
(9, 'Milo', 24),
(10, 'François', 22),
(11, 'Stéphanie', 35),
(12, 'Lucile', 24),
(13, 'Elise', 28),
(14, 'Enzo', 33);

-- --------------------------------------------------------

--
-- Structure de la table `rayon`
--

CREATE TABLE `rayon` (
  `numR` int(11) NOT NULL,
  `nomR` varchar(20) NOT NULL,
  `numSecteur` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rayon`
--

INSERT INTO `rayon` (`numR`, `nomR`, `numSecteur`) VALUES
(1, 'Fromages', 1),
(2, 'Charcuterie', 2),
(3, 'Viande', 2),
(4, 'Légumes', 1),
(5, 'Barbecue', 2),
(6, 'Bijoux', 3),
(7, 'Vêtements', 3),
(8, 'Chaussures', 3),
(9, 'Produits de beauté', 4),
(10, 'Produits ménagers', 4);

-- --------------------------------------------------------

--
-- Structure de la table `secteur`
--

CREATE TABLE `secteur` (
  `numS` int(10) NOT NULL,
  `nomS` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `secteur`
--

INSERT INTO `secteur` (`numS`, `nomS`) VALUES
(1, 'Produits frais'),
(2, 'Viande Poisson'),
(3, 'Mode'),
(4, 'Hygiène');

-- --------------------------------------------------------

--
-- Structure de la table `travailler`
--

CREATE TABLE `travailler` (
  `codeE` int(11) NOT NULL,
  `codeR` int(11) NOT NULL,
  `date` date NOT NULL,
  `temps` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `travailler`
--

INSERT INTO `travailler` (`codeE`, `codeR`, `date`, `temps`) VALUES
(1, 1, '2015-03-11', 4),
(1, 1, '2015-03-23', 5),
(1, 1, '2015-03-27', 3),
(1, 1, '2015-04-08', 4),
(1, 1, '2015-05-01', 4),
(1, 1, '2016-04-26', 6),
(1, 1, '2017-05-22', 3),
(1, 1, '2017-10-28', 2),
(1, 1, '2017-10-29', 7),
(1, 2, '2015-03-11', 7),
(1, 2, '2017-10-26', 2),
(1, 2, '2017-10-29', 1),
(1, 2, '2020-04-06', 4),
(1, 3, '2019-11-11', 8),
(1, 3, '2019-11-12', 4),
(1, 3, '2019-11-20', 4),
(1, 3, '2019-11-22', 9),
(1, 4, '2019-11-12', 3),
(1, 4, '2019-11-13', 6),
(1, 5, '2019-11-12', 9),
(1, 6, '2024-10-24', 3),
(1, 9, '2024-05-31', 4),
(2, 2, '2015-03-27', 6),
(2, 3, '2015-05-03', 7),
(2, 5, '2019-11-12', 3),
(2, 5, '2019-11-13', 8),
(2, 6, '2020-03-22', 6),
(2, 10, '2024-10-25', 8),
(3, 1, '2015-03-10', 6),
(3, 1, '2016-04-27', 6),
(3, 2, '2019-11-12', 6),
(3, 3, '2016-04-27', 3),
(3, 5, '2015-05-03', 4),
(3, 6, '2024-10-24', 3),
(4, 3, '2015-05-01', 7),
(4, 4, '2015-04-23', 4),
(5, 6, '2024-10-24', 2),
(6, 1, '2016-04-26', 4),
(6, 2, '2016-04-26', 3),
(6, 3, '2016-04-26', 7),
(6, 5, '2017-05-23', 2),
(6, 6, '2020-03-02', 4),
(6, 6, '2024-11-08', 2),
(6, 8, '2024-10-24', 3),
(6, 8, '2024-10-29', 8),
(6, 9, '2024-11-08', 3),
(7, 1, '2016-04-26', 6),
(7, 2, '2017-10-29', 2),
(7, 5, '2020-03-30', 9),
(7, 7, '2024-06-20', 2),
(9, 2, '2019-11-12', 6),
(9, 3, '2019-11-12', 5),
(9, 3, '2024-10-24', 2),
(9, 4, '2017-05-22', 3),
(9, 4, '2017-05-23', 4),
(9, 4, '2020-03-23', 4),
(9, 4, '2020-03-24', 7),
(10, 5, '2020-03-07', 2),
(10, 6, '2024-10-26', 2),
(10, 7, '2020-03-05', 3),
(10, 7, '2020-03-09', 5),
(10, 8, '2020-03-06', 7),
(11, 4, '2024-06-21', 6),
(11, 8, '2020-03-04', 46),
(11, 9, '2024-10-25', 8),
(11, 10, '2020-03-05', 5),
(12, 8, '2020-03-04', 6),
(12, 9, '2020-03-05', 2),
(12, 10, '2020-03-06', 5),
(13, 6, '2020-03-04', 8),
(13, 10, '2020-03-07', 3),
(14, 4, '2020-03-03', 7),
(14, 5, '2020-03-04', 5),
(14, 9, '2020-03-05', 5),
(14, 10, '2020-03-06', 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`numE`);

--
-- Index pour la table `rayon`
--
ALTER TABLE `rayon`
  ADD PRIMARY KEY (`numR`),
  ADD KEY `numSecteur` (`numSecteur`);

--
-- Index pour la table `secteur`
--
ALTER TABLE `secteur`
  ADD PRIMARY KEY (`numS`);

--
-- Index pour la table `travailler`
--
ALTER TABLE `travailler`
  ADD PRIMARY KEY (`codeE`,`codeR`,`date`),
  ADD KEY `codeR` (`codeR`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `secteur`
--
ALTER TABLE `secteur`
  MODIFY `numS` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `rayon`
--
ALTER TABLE `rayon`
  ADD CONSTRAINT `rayon_ibfk_1` FOREIGN KEY (`numSecteur`) REFERENCES `secteur` (`numS`);

--
-- Contraintes pour la table `travailler`
--
ALTER TABLE `travailler`
  ADD CONSTRAINT `travailler_ibfk_1` FOREIGN KEY (`codeE`) REFERENCES `employe` (`numE`),
  ADD CONSTRAINT `travailler_ibfk_2` FOREIGN KEY (`codeR`) REFERENCES `rayon` (`numR`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
