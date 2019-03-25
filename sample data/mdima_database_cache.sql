
CREATE TABLE `areas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY(`id`)
)

INSERT INTO `areas` (`id`, `name`, `location_id`) VALUES
(1, 'Karonga Airport', 1),
(2, 'Baka', 1),
(3, 'Bwiba', 1),
(4, 'Old town', 1),
(5, 'Rumphi boma', 2),
(6, 'Bolero', 2),
(7, 'Phwezi', 2),
(8, 'Mbalachanda', 3),
(9, 'Chama', 3),
(10, 'Tumboko', 4),
(11, 'Dwangwa', 4),
(12, 'Area 49', 5),
(13, 'Gulliver', 5),
(14, 'Proper', 5),
(15, 'Dubai', 5),
(16, 'Game shopping Complex', 6),
(17, 'Shoprite', 6),
(18, 'standard bank lilongwe', 6),
(19, 'part of biwi', 6),
(20, 'kawale 1', 6),
(21, 'katelera', 7),
(22, 'Chipoka', 7),
(23, 'Ngodzi', 7),
(24, 'Mua', 7),
(25, 'Mtakataka', 7),
(26, 'Golomati', 7),
(27, 'Mganja', 7),
(28, 'Mtunthama', 8),
(29, 'Kamudzu academy', 8),
(30, 'Zomba peak', 9),
(31, 'Malosa', 9),
(32, 'Sangani', 9),
(33, 'Machinga', 9),
(34, 'Sangani', 9),
(35, 'Angelo goveya', 10),
(36, 'Chiwembe', 10),
(37, 'kanjedza', 10),
(38, 'Bangula', 11),
(39, 'Nsanje boma', 11),
(40, 'Chiromo', 11),
(41, 'Fatima', 11),
(42, 'Marika', 11),
(43, 'Manja', 12),
(44, 'Nkolokosa', 12),
(45, 'Soche East', 12),
(46, 'Chimwankhunda', 12),
(47, 'Zingwangwa', 12);


CREATE TABLE `groups` (
  `area_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(`id`)
)

INSERT INTO `groups` (`area_id`, `name`, `id`) VALUES
(1, '26_FEB_GROUP_A', 1),
(2, '26_FEB_GROUP_A', 2),
(3, '26_FEB_GROUP_A', 4),
(4, '26_FEB_GROUP_A', 5),
(5, '26_FEB_GROUP_A', 6),
(6, '26_FEB_GROUP_A', 7),
(8, '26_FEB_GROUP_A', 8),
(10, '26_FEB_GROUP_A', 9),
(12, '26_FEB_GROUP_A', 10),
(13, '26_FEB_GROUP_A', 11),
(14, '26_FEB_GROUP_A', 12),
(15, '26_FEB_GROUP_A', 13),
(16, '26_FEB_GROUP_A', 14),
(17, '26_FEB_GROUP_A', 15),
(19, '26_FEB_GROUP_A', 16),
(21, '26_FEB_GROUP_A', 17),
(29, '26_FEB_GROUP_A', 18),
(30, '21_FEB_GROUP_A', 19),
(31, '21_FEB_GROUP_A', 20),
(32, '21_FEB_GROUP_A', 21),
(47, '21_FEB_GROUP_A', 22),
(46, '21_FEB_GROUP_A', 23),
(43, '21_FEB_GROUP_A', 24),
(44, '21_FEB_GROUP_A', 25),
(37, '21_FEB_GROUP_A', 26),
(41, '21_FEB_GROUP_A', 27),
(38, '21_FEB_GROUP_A', 28),
(23, '26_FEB_GROUP_A', 29),
(24, '26_FEB_GROUP_A', 30),
(27, '26_FEB_GROUP_A', 31),
(26, '26_FEB_GROUP_A', 32),
(18, '26_FEB_GROUP_A', 33);


CREATE TABLE `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `region_id` int(11) NOT NULL,
  PRIMARY KEY(`id`)
)

INSERT INTO `locations` (`id`, `name`, `region_id`) VALUES
(1, 'Karonga', 1),
(2, 'Bwengu', 1),
(3, 'Kaweche', 1),
(4, 'Chintheche', 1),
(5, 'Area 48', 3),
(6, 'Lilongwe A', 3),
(7, 'Nanjoka', 3),
(8, 'Chinyama', 3),
(9, 'Zomba', 2),
(10, 'Chigumula', 2),
(11, 'Mulambe', 2),
(12, 'Kwacha', 2);


CREATE TABLE `monitored_locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_id` int(11) NOT NULL,
  `is_primary` int(11) NOT NULL,
  PRIMARY KEY(`id`)
)

CREATE TABLE `regions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY(`id`)
)

INSERT INTO `regions` (`id`, `name`) VALUES
(1, 'Northen Region'),
(2, 'Southern Region'),
(3, 'Central Region');

CREATE TABLE `schedules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `starting_time` time NOT NULL,
  `finishing_time` time NOT NULL,
  `group_name` text NOT NULL,
  PRIMARY KEY(`id`)
)
INSERT INTO `schedules` (`id`, `date`, `starting_time`, `finishing_time`, `group_name`) VALUES
(1, '2019-03-20', '15:00:00', '21:00:00', '21_FEB_GROUP_A'),
(2, '2019-03-21', '10:00:00', '16:00:00', '21_FEB_GROUP_A'),
(3, '2019-03-22', '05:00:00', '11:00:00', '21_FEB_GROUP_A'),
(4, '2019-03-23', '15:00:00', '21:00:00', '21_FEB_GROUP_A'),
(5, '2019-03-24', '10:00:00', '16:00:00', '21_FEB_GROUP_A'),
(6, '2019-03-25', '05:00:00', '11:00:00', '21_FEB_GROUP_A'),
(7, '2019-03-26', '15:00:00', '21:00:00', '21_FEB_GROUP_A'),
(8, '2019-03-25', '13:00:00', '23:00:00', '26_FEB_GROUP_A'),
(9, '2019-03-26', '04:00:00', '14:00:00', '26_FEB_GROUP_A');

