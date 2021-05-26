-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 26 mai 2021 à 13:45
-- Version du serveur :  10.4.16-MariaDB
-- Version de PHP : 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `webservice`
--
CREATE DATABASE IF NOT EXISTS `webservice` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `webservice`;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Hardware'),
(2, 'Ordinateurs portables'),
(3, 'Overclocking, Cooling & Modding'),
(4, 'Technologies Mobiles'),
(5, 'Apple'),
(6, 'Video & Son'),
(7, 'Photo numérique'),
(8, 'Jeux video'),
(9, 'Windows & Software');

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `topic_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `post`
--

INSERT INTO `post` (`id`, `content`, `created_at`, `updated_at`, `author_id`, `topic_id`) VALUES
(1, 'Test', '2020-08-21 07:03:52.000000', '2021-05-25 19:09:27.000000', 23, 1),
(2, 'Unde nisi repudiandae et iste dolorum quos consequatur enim dolores eaque dolores minima saepe voluptatem possimus maiores ducimus eos autem.', '2020-11-14 23:45:42.000000', NULL, 40, 1),
(3, 'Incidunt harum est ut nulla rerum est saepe consectetur nemo harum eos eos perspiciatis qui corrupti autem quibusdam.', '2020-09-19 23:40:39.000000', NULL, 43, 1),
(4, 'Deserunt excepturi quos praesentium similique et aut repudiandae non minima deleniti deserunt consectetur et expedita et aut quos.', '2021-12-25 21:51:47.000000', NULL, 38, 2),
(5, 'Est cumque esse exercitationem et quae unde praesentium unde similique rerum illum autem consequatur eligendi.', '2021-08-02 12:27:50.000000', NULL, 36, 3),
(6, 'Molestias porro dolorem quia autem aspernatur qui illo magnam tenetur dolores quia suscipit rerum aliquid nulla dolor nostrum ab.', '2021-05-17 12:31:57.000000', NULL, 32, 3),
(7, 'Fugiat inventore cupiditate doloribus quam non sit et libero accusantium ipsum reprehenderit sint rerum voluptatem id et eum eos facilis.', '2020-07-27 05:40:53.000000', '2021-06-21 07:35:03.000000', 12, 3),
(8, 'Dolorem consequatur totam occaecati ea recusandae reiciendis voluptatum dolorem adipisci qui earum aut quas et eveniet quis vero expedita.', '2021-09-29 16:45:09.000000', NULL, 17, 3),
(9, 'Nihil voluptates omnis magnam aut commodi optio saepe qui delectus harum et in nihil repellat rem cumque consequatur quia eius.', '2021-02-27 11:21:07.000000', NULL, 3, 3),
(10, 'Necessitatibus autem quibusdam neque ab expedita iure sit iste eos at ea minus animi modi magni id.', '2021-07-29 20:17:18.000000', NULL, 18, 4),
(11, 'Praesentium corporis soluta in perspiciatis voluptas odio est est repellat sit hic veritatis consequatur quas molestias ipsam dolor labore dolor.', '2020-02-21 01:21:03.000000', NULL, 25, 4),
(12, 'Saepe sed cum reiciendis maiores est et eius tenetur occaecati cumque ea beatae cupiditate excepturi eos.', '2020-04-21 00:27:35.000000', NULL, 18, 4),
(13, 'Quae fugit aut consequuntur qui voluptatem rerum id eveniet non id ratione voluptatem enim ut maiores ratione distinctio.', '2021-12-19 17:25:12.000000', NULL, 39, 4),
(14, 'Laudantium eius cum atque sint tempora eaque at a qui corrupti sed ut facilis et.', '2020-12-15 01:23:04.000000', NULL, 29, 4),
(15, 'Ut a eveniet qui adipisci ut qui ipsam minima necessitatibus placeat quia id omnis facilis dolorum qui quas quos consectetur.', '2020-02-24 22:20:48.000000', NULL, 26, 4),
(16, 'Odit aut doloremque et mollitia culpa enim eos doloribus quasi et corporis ab molestiae aut officiis enim et accusamus.', '2021-07-27 05:00:37.000000', '2021-07-26 00:32:53.000000', 33, 4),
(17, 'Ipsum sequi voluptatem molestiae dignissimos quia rem molestias ut impedit id modi autem quod earum.', '2020-01-09 02:55:43.000000', NULL, 41, 5),
(18, 'Dolorum praesentium enim est mollitia nam voluptatem in qui provident magni dolorem deserunt architecto sit.', '2020-02-19 18:47:47.000000', '2021-04-14 17:28:12.000000', 8, 5),
(19, 'Qui error reprehenderit quae rem eveniet earum doloribus nam sapiente odio placeat aperiam nulla necessitatibus.', '2020-02-01 10:32:47.000000', '2020-09-26 11:01:09.000000', 17, 6),
(20, 'Ut et qui doloremque quaerat alias perferendis consectetur natus maxime id atque aut quos qui placeat natus quia.', '2021-11-10 06:53:29.000000', NULL, 46, 6),
(21, 'Aspernatur quo similique sapiente amet ut quia praesentium atque quia iure tenetur deserunt id est.', '2021-06-12 22:36:55.000000', NULL, 3, 6),
(22, 'Molestiae et consequuntur quia recusandae adipisci ullam vero omnis mollitia minus quibusdam ea et ipsam enim enim sunt tempore ut.', '2021-07-24 10:23:36.000000', NULL, 32, 6),
(23, 'Reiciendis voluptas nobis perferendis porro nihil voluptas voluptate cupiditate deserunt dolor est dolorum minima commodi suscipit.', '2020-02-15 03:35:10.000000', NULL, 44, 6),
(24, 'Earum adipisci eius eos ut et culpa odit dignissimos maxime quaerat illo necessitatibus nihil quasi placeat autem et saepe.', '2020-03-25 09:59:51.000000', NULL, 30, 6),
(25, 'Quia aut ea ipsam recusandae voluptas et libero necessitatibus aut voluptas aut molestiae voluptatem voluptas soluta voluptas qui facere aliquid.', '2021-07-23 20:30:44.000000', '2020-02-16 12:08:17.000000', 38, 6),
(26, 'Explicabo architecto delectus tempore dolores nulla illo consequatur error ad nobis quasi dolores sapiente beatae voluptatem sunt.', '2020-02-25 04:19:10.000000', NULL, 34, 6),
(27, 'Omnis non ut ab est quo voluptate nihil sit possimus id esse aperiam alias itaque excepturi consequuntur debitis.', '2020-02-16 05:05:44.000000', NULL, 30, 6),
(28, 'Non sit similique error enim rerum autem non adipisci error occaecati reiciendis sed sapiente non odio eos aliquid et alias.', '2021-02-07 10:04:01.000000', NULL, 33, 7),
(29, 'Laboriosam cumque eos asperiores qui dolor ea quasi iusto earum quae consequatur architecto et ad sit.', '2021-11-09 11:22:01.000000', NULL, 25, 7),
(30, 'Repellendus ab vitae voluptas molestiae qui fuga quia veritatis velit error dolore dicta placeat asperiores quibusdam unde quas.', '2021-02-25 04:44:09.000000', NULL, 17, 7),
(31, 'Quis provident in sapiente voluptate vitae fuga rem quia facilis quisquam quibusdam tempore quo quia aut fugiat nemo voluptates rem.', '2020-05-18 19:57:50.000000', '2020-02-25 17:44:14.000000', 30, 7),
(32, 'In at et dolorum natus quia ipsum in debitis aut porro voluptas occaecati iste expedita est nam est quo.', '2020-07-19 22:20:46.000000', NULL, 18, 7),
(33, 'Ratione mollitia labore amet voluptatum molestiae consequatur perspiciatis impedit laboriosam nulla facilis illo adipisci illum.', '2020-11-09 09:29:22.000000', NULL, 3, 7),
(34, 'Fugit possimus eius magnam qui sunt sit maiores esse tenetur laborum distinctio est sed delectus.', '2021-01-30 15:07:15.000000', NULL, 31, 7),
(35, 'Vel enim quos molestias ipsum id occaecati tempora dolorum soluta illo voluptatem veniam quo reprehenderit consequatur.', '2020-10-03 17:51:06.000000', NULL, 49, 8),
(36, 'Quasi enim aut autem distinctio qui tenetur enim eum ipsum ducimus atque accusantium expedita sit officia.', '2020-04-01 11:07:52.000000', NULL, 26, 8),
(37, 'Maiores modi officiis explicabo quibusdam minus quaerat sed ipsum est aut aut totam aut sapiente reiciendis eius assumenda pariatur eum.', '2021-04-12 11:35:35.000000', NULL, 48, 9),
(38, 'Perferendis minima autem rem optio rem impedit ut fugit vitae mollitia eum officiis porro qui rerum voluptate cum quisquam.', '2021-04-09 20:48:17.000000', '2021-04-28 03:08:37.000000', 40, 9),
(39, 'In quibusdam voluptatem maiores et non delectus exercitationem sed dolorem autem inventore ea excepturi qui aut suscipit labore.', '2021-08-27 00:09:25.000000', NULL, 46, 9),
(40, 'Impedit omnis quis alias voluptatem autem ullam alias sint nostrum est odio est adipisci alias quidem est.', '2021-10-19 07:02:35.000000', NULL, 4, 9),
(41, 'Excepturi a aspernatur quisquam ut consequatur omnis pariatur sint eum vel odit et eaque voluptatem voluptatem.', '2020-11-03 06:10:10.000000', NULL, 28, 9),
(42, 'Culpa magnam esse est repellendus et repellat et ut consequatur est blanditiis officiis et qui est quia facere eligendi et.', '2021-10-09 04:47:46.000000', NULL, 41, 9),
(43, 'Omnis aut consectetur sed aut eum minima blanditiis blanditiis veniam nihil quia in numquam in quaerat unde quidem dolore quidem.', '2020-07-01 11:09:57.000000', NULL, 33, 10),
(44, 'Test', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reasons`
--

CREATE TABLE `reasons` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reasons`
--

INSERT INTO `reasons` (`id`, `name`) VALUES
(1, 'REASON_SPAM'),
(2, 'REASON_RACISM'),
(3, 'REASON_NUDITY'),
(4, 'REASON_OTHER');

-- --------------------------------------------------------

--
-- Structure de la table `report`
--

CREATE TABLE `report` (
  `id` bigint(20) NOT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `reason_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `report`
--

INSERT INTO `report` (`id`, `author_id`, `post_id`, `reason_id`) VALUES
(1, 52, 3, 1),
(2, 2, 3, 2),
(3, 39, 3, 3),
(4, 24, 4, 3),
(5, 45, 4, 2),
(6, 28, 4, 2),
(7, 46, 5, 1),
(8, 17, 5, 1),
(9, 32, 5, 2),
(10, 39, 6, 4),
(11, 34, 6, 4),
(12, 25, 8, 4),
(13, 9, 9, 2),
(14, 24, 9, 3),
(15, 50, 11, 4),
(16, 2, 11, 3),
(17, 44, 11, 1),
(18, 5, 12, 2),
(19, 36, 13, 2),
(20, 32, 13, 1),
(21, 29, 13, 2),
(22, 28, 14, 2),
(23, 41, 16, 1),
(24, 13, 16, 2),
(25, 16, 17, 3),
(26, 37, 17, 3),
(27, 18, 18, 4),
(28, 47, 18, 1),
(29, 15, 18, 3),
(30, 46, 19, 3),
(31, 38, 19, 2),
(32, 42, 20, 2),
(33, 40, 20, 3),
(34, 42, 20, 4),
(35, 47, 21, 3),
(36, 8, 21, 4),
(37, 25, 22, 1),
(38, 46, 22, 2),
(39, 38, 22, 2),
(40, 29, 24, 2),
(41, 35, 25, 2),
(42, 32, 26, 2),
(43, 31, 26, 2),
(44, 45, 28, 4),
(45, 22, 28, 4),
(46, 38, 28, 2),
(47, 19, 29, 1),
(48, 48, 29, 4),
(49, 20, 30, 3),
(50, 12, 30, 3),
(51, 12, 30, 2),
(52, 38, 32, 2),
(53, 35, 33, 4),
(54, 33, 33, 4),
(55, 2, 34, 2),
(56, 3, 37, 3),
(57, 40, 37, 3),
(58, 29, 37, 2),
(59, 16, 38, 3),
(60, 14, 38, 3),
(61, 24, 38, 4),
(62, 51, 41, 3),
(63, 20, 41, 3),
(64, 39, 41, 2),
(65, 7, 42, 4);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ANONYMOUS'),
(2, 'ROLE_USER'),
(3, 'ROLE_MODERATOR'),
(4, 'ROLE_ADMIN'),
(5, 'ROLE_ANONYMOUS');

-- --------------------------------------------------------

--
-- Structure de la table `topic`
--

CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL,
  `locked` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `topic`
--

INSERT INTO `topic` (`id`, `locked`, `title`, `author_id`, `category_id`) VALUES
(1, b'0', 'Chief Group Agent', 7, 9),
(2, b'0', 'Forward Mobility Executif', 14, 2),
(3, b'0', 'Direct Paradigm Consultant', 9, 7),
(4, b'0', 'Customer Accountability Ingenieur', 28, 2),
(5, b'0', 'Future Integration Manager', 47, 8),
(6, b'1', 'Dynamic Applications Consultant', 30, 9),
(7, b'0', 'Legacy Paradigm Producteur', 21, 1),
(8, b'0', 'District Creative Agent', 13, 9),
(9, b'0', 'District Usability Consultant', 41, 5),
(10, b'0', 'District Functionality Manager', 21, 2);

-- --------------------------------------------------------

--
-- Structure de la table `topic_posts`
--

CREATE TABLE `topic_posts` (
  `topic_id` bigint(20) NOT NULL,
  `posts_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `locked` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `locked`, `password`) VALUES
(1, 'admin@test', b'0', '$2a$10$fMhN6lq7g48/U9PKzd.EW.PZ2sjMkv0btLek0UGxQUDRBaeKSR6/u'),
(2, 'anonymous@test', b'0', '$2a$10$HiVVOPitoBYH5hGlhdte8eff59Q5w6cJMewf2Bl5BstL4U6pAOUEO'),
(3, 'hugo.mathieu@gmail.com', b'0', '$2a$10$k1j8akXnV0pnKIbUduDLOO1RVzH7VgjXjw0ieVV9vPrCAdCNWAKFS'),
(4, 'lucie.dumont@gmail.com', b'0', '$2a$10$ZSjrjvMadFLbs.BeosQzeuVcaRIpiOMezZyIQOwmYhD/mqnq3efPa'),
(5, 'yanis.guillaume@yahoo.fr', b'0', '$2a$10$BSRlI5NqmXnQ.7VlzSC5XOC5n8UCuSb1flTOzgOegittRRW4Ab49m'),
(6, 'celia.aubry@yahoo.fr', b'0', '$2a$10$XNBB/lupXthSSTLk4U0Sa.HUkUECyWXcqgLCMJZTfIWtF.SRu9x/C'),
(7, 'alexis.nguyen@yahoo.fr', b'0', '$2a$10$VzYavRWxgboxeqB4fd74A./30S0Upjnk4LIsrZdhI2HoRY/VY.9lW'),
(8, 'clemence.picard@hotmail.fr', b'0', '$2a$10$jTHNE33o99dfPfV31M7j7.cD8lqcpnNgc6eWDZdVdr7e27G155z/u'),
(9, 'leo.martinez@gmail.com', b'0', '$2a$10$pq2hpPb9K/zv/OB7EhZ9Eewnu.PSLjaa7hAOabvpCNsebtj7XR3DG'),
(10, 'victor.bourgeois@gmail.com', b'0', '$2a$10$8vv5KzLGv.2TJmDpU9Elxe244Qqr01Rh2Lm44DQzmtEQj4YbH6x92'),
(11, 'kylian.remy@gmail.com', b'0', '$2a$10$4AHeuoka5syZ.Y4YT37ueO90YV9b2uPQpSONQsUbcSY/wKkYuWIEq'),
(12, 'nathan.fleury@hotmail.fr', b'0', '$2a$10$exT/SS/cE6h8lyyG5BIKlOBWLK0TzpMpbCeaJ/AFXcBRbC0PoPgai'),
(13, 'eva.pierre@hotmail.fr', b'0', '$2a$10$kXCLO0eitkqU7MaZqutCYeu7icmIBZ9xmAJHXaNLWOKZCLs3iXri6'),
(14, 'ines.blanchard@yahoo.fr', b'0', '$2a$10$IS/wcz7HEL1Pku4e30sFsu1GKSlfCMspElDvkp8Bol61Vde8DJ936'),
(15, 'axel.rodriguez@gmail.com', b'0', '$2a$10$DnhJ9k9NCZ2PoIE7PXlVG.bkfqKOCoOwafNPufevsvPOxSUhci7pe'),
(16, 'axel.riviere@gmail.com', b'0', '$2a$10$U2.QhreddEZGAM8hU5y6reSpEdG5so.LDXRqrDQgJ2PsqHXhpUqum'),
(17, 'eva.aubert@yahoo.fr', b'0', '$2a$10$hobVRYKzEqASZQqzGtBvruslpVergNSm3Y3mCWFJ/q2dfAhXVOIvq'),
(18, 'mael.lambert@gmail.com', b'0', '$2a$10$14ngdKDCVNnslatcJ2BIoe8dpg1YUjZBqN0yGTAVkj7JTiq0zSLXu'),
(19, 'lilou.petit@yahoo.fr', b'0', '$2a$10$14MsvgvFKq5PKg4RuWdbmuJtHQ36HBBef30cz6rOt5.Nqp3Vx1UiW'),
(20, 'leo.faure@gmail.com', b'0', '$2a$10$TGrAJb7yzMDiN6PRUkO3J.XbB4tfPUnjlPNLREHHxV1GmErcYPcBu'),
(21, 'mathis.dumas@yahoo.fr', b'0', '$2a$10$At9zjvFN68tLo74/SajLFONxYyj8nAxthmJkPEoL1F8j//sTlyhF6'),
(22, 'lucas.lucas@yahoo.fr', b'0', '$2a$10$Oe1cNQF3ZLAWPO65bVO19eUWWIl5MRa5RLIQImI90ChQGobnfpFzK'),
(23, 'benjamin.dupuy@gmail.com', b'0', '$2a$10$7S3SN26QJZlw0PQiqJuOP.wDQ5snJikAID/kh8WiuPzHpDOG4QMem'),
(24, 'mael.remy@yahoo.fr', b'0', '$2a$10$/JRnKvoklB6XEDAw62Mv1uNwa9YH6lUUw8wOc7eNxRA5Q0vLfq4mS'),
(25, 'alexandre.duval@hotmail.fr', b'0', '$2a$10$Epl.XWZ.Tb3V.tODDRlzDeI/Enr8m71X.7EiAGm7Wbln/NZ.x4guG'),
(26, 'rayan.guyot@hotmail.fr', b'0', '$2a$10$HYvTlLDJeLXxIy9eR7JVSOC4YqlhA1mIraQb.BxufJCFoPBC1.vvS'),
(27, 'kylian.fernandez@hotmail.fr', b'0', '$2a$10$PczXeZvOJTb1OetT9z8qY.CeX2ivzWHQkTv.D1Y66dRGubLDx1woC'),
(28, 'antoine.renaud@yahoo.fr', b'0', '$2a$10$dRXQAKD/IGvukAD1zwqnW.IbQTzL5yyDvYt1olt5Afg4srJrYkzVO'),
(29, 'maxime.paul@hotmail.fr', b'0', '$2a$10$UpfDfOnsfPYGBbId/JzpYuglX3xhvz5/7Jy0uhdIdVM5I0Fjz88wq'),
(30, 'matheo.mercier@hotmail.fr', b'0', '$2a$10$VIGSZ7D5kCHgQS4q4PaZiOGS3CgXdX5Yzq20Vz/sc0Sx3y0QWISVy'),
(31, 'thomas.martinez@hotmail.fr', b'0', '$2a$10$ytjUlD.gIYKYb/sIuXMlHuo04m80f.oeWI0VoWuFwTtYE8eAEm06K'),
(32, 'kylian.brunet@yahoo.fr', b'0', '$2a$10$GgPNELflNhuoT/Rng3MX/uO77sMHr.Gwpo8WbLjpooppLc.i0tUie'),
(33, 'lucas.faure@gmail.com', b'0', '$2a$10$AE22KQKa7UAUzcBLtLZlMeVufxJ45b0N/cVbKymA8AAwI44xYPk7C'),
(34, 'leo.renault@gmail.com', b'0', '$2a$10$MTBokdpS2.GT1vRT/mT8qu8v4p/whJOFHb.z6QVCkUT.9EapQn/.6'),
(35, 'lina.richard@gmail.com', b'0', '$2a$10$/LluNxkAbF6GIk69EKBMxOwcnmDRhBFyb6bF463.D8CBDWjmrdUGm'),
(36, 'clemence.chevalier@hotmail.fr', b'0', '$2a$10$1h2qHfMArehkBFuL10cjXeL4XRn3KeiP/oN7ja1PWfpuO2cJNecM.'),
(37, 'paul.laurent@hotmail.fr', b'0', '$2a$10$c28D1xlKmggfIyXxfRYyS.rstQa1UMDqAo8XrAfBa2sNFxxboC1Ga'),
(38, 'rayan.carpentier@yahoo.fr', b'0', '$2a$10$IQmCwFGt2ORbj4yxzXKYyO6KSOiyq01.RcF/Hl8Nq6RafU1aODw12'),
(39, 'celia.roger@hotmail.fr', b'0', '$2a$10$dDDwjqTmoFmr3RB6GlLm9eFq7je0XrT2CuQZ4cGsy329NUmCQBVTS'),
(40, 'louise.gauthier@gmail.com', b'0', '$2a$10$/Ue.hSXuugKHNIHXVjqELOwB.t7BIxTHD7XZ/9doLN7AUmTfTo.1m'),
(41, 'chloe.garcia@yahoo.fr', b'0', '$2a$10$mmO1X0Ilcv6vZC3ECRUvbOIzj9zJoCa1iIFTrwqCmfL1QxOLwJQ0e'),
(42, 'romane.berger@yahoo.fr', b'0', '$2a$10$YunBeK2YpH/vQqQqXB8rceBVe0uhCRZB4thLnRJuYxDy7T.OFB17O'),
(43, 'adam.robin@gmail.com', b'0', '$2a$10$WdUDL7j.LuvXDFdyaRfC..zU9ncwNbkUU1uZ7gS7eW9hg9C4zHAGe'),
(44, 'jules.lecomte@yahoo.fr', b'0', '$2a$10$X4TZpQhsA1poqzzzJ8WiZOj8d/U0tPuaEbMFJ0c5KnfYxmLJjIKpm'),
(45, 'enzo.charles@hotmail.fr', b'0', '$2a$10$l.dGauNkMj5Te0LjfLNwM.Q.H7yDN1a6lC5t2NnMpVLC9v4sTJ5nC'),
(46, 'louise.dubois@yahoo.fr', b'0', '$2a$10$98srhDbCGcm3cXtkYCiWx.xeXfGzjLZ476RYl1T.USruj/5g7e0ee'),
(47, 'kylian.marchand@gmail.com', b'0', '$2a$10$djiS10VeRLfP8A/rF3AGbufeFusiKfXZvxDb./S2NY6PYw0sUHZA.'),
(48, 'jeanne.paris@hotmail.fr', b'0', '$2a$10$McoOOH6gfVW/kBTQPLmMc.An7QMekjAeTKTvc691LGw96KDnnLMdy'),
(49, 'jules.bourgeois@gmail.com', b'0', '$2a$10$frot8XknJ6VueST7de.jnO63HSlKAWVqooE6YiUubqOv3vMDpx8Mu'),
(50, 'zoe.masson@gmail.com', b'0', '$2a$10$bmKj/fHI62nSAauBPeqHbeThjTMDTz9p/1IbkINHHwwrhN9zpohf.'),
(51, 'benjamin.guillot@gmail.com', b'0', '$2a$10$c7jlDak4XsotLResdIm.Qu2I/3G1jZUrA/cXPIGfj13qOPZtIzvc2'),
(52, 'rayan.moulin@gmail.com', b'0', '$2a$10$cjK7jye2lenOUdvmRlWrce.7hcOo93x4fG5dXsMq1iyIh72pDlc4y');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
(1, 4),
(2, 5),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(9, 3),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 2),
(22, 2),
(23, 2),
(24, 2),
(25, 2),
(26, 2),
(27, 2),
(28, 2),
(29, 2),
(30, 2),
(31, 2),
(32, 2),
(33, 2),
(34, 2),
(35, 2),
(36, 2),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(43, 2),
(44, 2),
(45, 2),
(46, 2),
(47, 2),
(48, 2),
(49, 2),
(50, 2),
(51, 2),
(52, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK12njtf8e0jmyb45lqfpt6ad89` (`author_id`),
  ADD KEY `FKg8ln3nj8tjclai0nuvpw5s5uw` (`topic_id`);

--
-- Index pour la table `reasons`
--
ALTER TABLE `reasons`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqndt9gocxohkjll195argfjha` (`author_id`),
  ADD KEY `FKnuqod1y014fp5bmqjeoffcgqy` (`post_id`),
  ADD KEY `FK8qv45j3ct48ophor3ulymswr5` (`reason_id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK91351a48ok1rkldd36rmpb34g` (`author_id`),
  ADD KEY `FK8n7r9utm8sjpdfstb4wcqd7qj` (`category_id`);

--
-- Index pour la table `topic_posts`
--
ALTER TABLE `topic_posts`
  ADD UNIQUE KEY `UK_s5bd5c2jgcw49x5w4fiqmiagd` (`posts_id`),
  ADD KEY `FKp3croykyaohnl662esakg61yj` (`topic_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- Index pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`roles_id`),
  ADD KEY `FKdbv8tdyltxa1qjmfnj9oboxse` (`roles_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `post`
--
ALTER TABLE `post`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT pour la table `reasons`
--
ALTER TABLE `reasons`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `report`
--
ALTER TABLE `report`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `topic`
--
ALTER TABLE `topic`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK12njtf8e0jmyb45lqfpt6ad89` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKg8ln3nj8tjclai0nuvpw5s5uw` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`);

--
-- Contraintes pour la table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `FK8qv45j3ct48ophor3ulymswr5` FOREIGN KEY (`reason_id`) REFERENCES `reasons` (`id`),
  ADD CONSTRAINT `FKnuqod1y014fp5bmqjeoffcgqy` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  ADD CONSTRAINT `FKqndt9gocxohkjll195argfjha` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `topic`
--
ALTER TABLE `topic`
  ADD CONSTRAINT `FK8n7r9utm8sjpdfstb4wcqd7qj` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FK91351a48ok1rkldd36rmpb34g` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `topic_posts`
--
ALTER TABLE `topic_posts`
  ADD CONSTRAINT `FKitr4seeq9uagrsdo5e13tb8iw` FOREIGN KEY (`posts_id`) REFERENCES `post` (`id`),
  ADD CONSTRAINT `FKp3croykyaohnl662esakg61yj` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKdbv8tdyltxa1qjmfnj9oboxse` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
