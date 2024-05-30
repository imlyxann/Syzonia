-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 08 mars 2024 à 17:36
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `syzonia_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `bans`
--

DROP TABLE IF EXISTS `bans`;
CREATE TABLE IF NOT EXISTS `bans` (
  `id` int NOT NULL AUTO_INCREMENT,
  `player_uuid` varchar(255) NOT NULL,
  `end` bigint NOT NULL,
  `reason` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cakewars_kits`
--

DROP TABLE IF EXISTS `cakewars_kits`;
CREATE TABLE IF NOT EXISTS `cakewars_kits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `kit_Ranger` int NOT NULL DEFAULT '0',
  `kit_Gladiator` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cakewars_kits`
--

INSERT INTO `cakewars_kits` (`id`, `uuid_player`, `pseudo_player`, `kit_Ranger`, `kit_Gladiator`) VALUES
(16, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', 'Mixtal', 1, 1),
(15, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', 'Lyxann', 1, 1),
(8, 'd7644929-13db-43ca-b010-f934969534a9', 'Softtyy_', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `cakewars_server`
--

DROP TABLE IF EXISTS `cakewars_server`;
CREATE TABLE IF NOT EXISTS `cakewars_server` (
  `id` int NOT NULL AUTO_INCREMENT,
  `game_type` text NOT NULL,
  `server_name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `Map` varchar(255) NOT NULL,
  `max_player` int NOT NULL,
  `ip` varchar(255) NOT NULL,
  `port` int NOT NULL,
  `maintenance` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `gadgets`
--

DROP TABLE IF EXISTS `gadgets`;
CREATE TABLE IF NOT EXISTS `gadgets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL,
  `gadget` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gadgets`
--

INSERT INTO `gadgets` (`id`, `uuid`, `gadget`) VALUES
(10, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', '1;'),
(12, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', '1;');

-- --------------------------------------------------------

--
-- Structure de la table `hubjump`
--

DROP TABLE IF EXISTS `hubjump`;
CREATE TABLE IF NOT EXISTS `hubjump` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `jumpid` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hubs`
--

DROP TABLE IF EXISTS `hubs`;
CREATE TABLE IF NOT EXISTS `hubs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `server_name` varchar(255) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `port` int NOT NULL,
  `players_value` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=648 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hubs`
--

INSERT INTO `hubs` (`id`, `server_name`, `ip`, `port`, `players_value`) VALUES
(647, 'Lobby1', 'localhost', 31, 0);

-- --------------------------------------------------------

--
-- Structure de la table `lg_server`
--

DROP TABLE IF EXISTS `lg_server`;
CREATE TABLE IF NOT EXISTS `lg_server` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `port` int NOT NULL,
  `all_players` int NOT NULL,
  `max_players` int NOT NULL,
  `server_status` text NOT NULL,
  `Loup_garous` text NOT NULL,
  `Villageois` text NOT NULL,
  `Cupidon` text NOT NULL,
  `Sorciere` text NOT NULL,
  `Voyante` text NOT NULL,
  `Petite_fille` text NOT NULL,
  `Chasseur` text NOT NULL,
  `Maire` text NOT NULL,
  `Deaths` text NOT NULL,
  `Time` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `monture`
--

DROP TABLE IF EXISTS `monture`;
CREATE TABLE IF NOT EXISTS `monture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL,
  `montures` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `monture`
--

INSERT INTO `monture` (`id`, `uuid`, `montures`) VALUES
(48, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', '95;92;90;91;'),
(49, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', '90;92;91;95;');

-- --------------------------------------------------------

--
-- Structure de la table `particule`
--

DROP TABLE IF EXISTS `particule`;
CREATE TABLE IF NOT EXISTS `particule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL,
  `particules` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `particule`
--

INSERT INTO `particule` (`id`, `uuid`, `particules`) VALUES
(28, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', '1;2;3;4;'),
(27, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', '1;2;3;4;');

-- --------------------------------------------------------

--
-- Structure de la table `pet`
--

DROP TABLE IF EXISTS `pet`;
CREATE TABLE IF NOT EXISTS `pet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL,
  `pets` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pet`
--

INSERT INTO `pet` (`id`, `uuid`, `pets`) VALUES
(13, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', '1;2;'),
(14, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', '1;2;');

-- --------------------------------------------------------

--
-- Structure de la table `players`
--

DROP TABLE IF EXISTS `players`;
CREATE TABLE IF NOT EXISTS `players` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `coins` bigint NOT NULL,
  `grade` int NOT NULL,
  `grade_name` varchar(255) NOT NULL,
  `CanseePlayer` tinyint(1) NOT NULL,
  `LastMessageInChat` varchar(255) NOT NULL,
  `rewards_found` tinyint(1) NOT NULL,
  `use_pets` int NOT NULL,
  `use_particules` int NOT NULL,
  `use_mount` int NOT NULL,
  `use_gadget` int NOT NULL,
  `use_chapeaux` int NOT NULL,
  `use_pull` int NOT NULL,
  `use_pantalon` int NOT NULL,
  `use_chaussure` int NOT NULL,
  `HostTicket` double NOT NULL,
  `msg` tinyint(1) NOT NULL,
  `Legend_Symbol` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `players`
--

INSERT INTO `players` (`id`, `uuid_player`, `pseudo_player`, `coins`, `grade`, `grade_name`, `CanseePlayer`, `LastMessageInChat`, `rewards_found`, `use_pets`, `use_particules`, `use_mount`, `use_gadget`, `use_chapeaux`, `use_pull`, `use_pantalon`, `use_chaussure`, `HostTicket`, `msg`, `Legend_Symbol`) VALUES
(43, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', 'Lyxann', 10000000902, 7, '§4Admin', 0, 'wsh', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(45, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', 'Mixtal', 10371, 3, '§3Legend', 0, 'gg', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `players_connection`
--

DROP TABLE IF EXISTS `players_connection`;
CREATE TABLE IF NOT EXISTS `players_connection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `isBungeeConnected` tinyint(1) NOT NULL,
  `isSpigotConnected` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `players_connection`
--

INSERT INTO `players_connection` (`id`, `uuid_player`, `pseudo_player`, `isBungeeConnected`, `isSpigotConnected`) VALUES
(1, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', 'Lyxann', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `players_friends`
--

DROP TABLE IF EXISTS `players_friends`;
CREATE TABLE IF NOT EXISTS `players_friends` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `uuid_friend` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `players_friends`
--

INSERT INTO `players_friends` (`id`, `uuid_player`, `uuid_friend`) VALUES
(36, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', '67f1d1db-7f24-4a99-a275-1728cf1e94e7'),
(35, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', 'ec91c001-6a6d-44bd-b08a-078e25c6a52c');

-- --------------------------------------------------------

--
-- Structure de la table `players_muted`
--

DROP TABLE IF EXISTS `players_muted`;
CREATE TABLE IF NOT EXISTS `players_muted` (
  `#` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `end` bigint NOT NULL,
  `reason` varchar(255) NOT NULL,
  PRIMARY KEY (`#`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `player_friends_allow`
--

DROP TABLE IF EXISTS `player_friends_allow`;
CREATE TABLE IF NOT EXISTS `player_friends_allow` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `friends_allow` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `player_friends_allow`
--

INSERT INTO `player_friends_allow` (`id`, `uuid_player`, `pseudo_player`, `friends_allow`) VALUES
(27, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', 'sacharedstone', 1),
(25, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', 'Mixtal', 0),
(28, 'efb08cfb-e66d-3464-baff-68b9a907df1b', 'Lyxann', 0),
(29, 'd7644929-13db-43ca-b010-f934969534a9', 'Softtyy_', 1);

-- --------------------------------------------------------

--
-- Structure de la table `player_op`
--

DROP TABLE IF EXISTS `player_op`;
CREATE TABLE IF NOT EXISTS `player_op` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `isop` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `player_op`
--

INSERT INTO `player_op` (`id`, `uuid_player`, `pseudo_player`, `isop`) VALUES
(10, 'ec91c001-6a6d-44bd-b08a-078e25c6a52c', 'Mixtal', 0),
(12, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', 'Lyxann', 1);

-- --------------------------------------------------------

--
-- Structure de la table `queue`
--

DROP TABLE IF EXISTS `queue`;
CREATE TABLE IF NOT EXISTS `queue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `player_grade` double NOT NULL,
  `minigame` int NOT NULL,
  `minigame_type` varchar(255) NOT NULL,
  `progress` int NOT NULL,
  `redirectserver` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=152 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `servers`
--

DROP TABLE IF EXISTS `servers`;
CREATE TABLE IF NOT EXISTS `servers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `server_name` varchar(255) NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  `port` int NOT NULL,
  `ip` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT 'RELOAD',
  `players` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `servers`
--

INSERT INTO `servers` (`id`, `server_name`, `status`, `port`, `ip`, `type`, `players`) VALUES
(43, 'Lobby1', 1, 31, 'localhost', 'HUB', '[]'),
(62, 'Lobby2', 0, 32, 'localhost', 'HUB', '[]');

-- --------------------------------------------------------

--
-- Structure de la table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
CREATE TABLE IF NOT EXISTS `tokens` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `expire` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tokens`
--

INSERT INTO `tokens` (`id`, `uuid_player`, `pseudo_player`, `token`, `expire`) VALUES
(11, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', 'Lyxann', '92402b3a-c023-40c5-8536-0f7485579333', 1709546145709);

-- --------------------------------------------------------

--
-- Structure de la table `vetements`
--

DROP TABLE IF EXISTS `vetements`;
CREATE TABLE IF NOT EXISTS `vetements` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL,
  `chapeaux` text,
  `pull` text,
  `pantalon` text,
  `chaussure` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vetements`
--

INSERT INTO `vetements` (`id`, `uuid`, `chapeaux`, `pull`, `pantalon`, `chaussure`) VALUES
(9, '67f1d1db-7f24-4a99-a275-1728cf1e94e7', '1;', '1;', '1;', '1;');

-- --------------------------------------------------------

--
-- Structure de la table `website_account`
--

DROP TABLE IF EXISTS `website_account`;
CREATE TABLE IF NOT EXISTS `website_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) NOT NULL,
  `account_email` varchar(255) NOT NULL,
  `account_password` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `session_id` int NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `uuid_player` varchar(255) NOT NULL,
  `isban` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
