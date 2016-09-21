CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `email` varchar(255) NOT NULL,
  `no_hp` date NOT NULL,
  `alamat` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4pf6h2ver6d4igrrq6vvo4dbv` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;