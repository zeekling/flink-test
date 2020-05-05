DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `id`       INT(11) UNSIGNED NOT NULL    AUTO_INCREMENT,
  `name`     VARCHAR(25) COLLATE utf8_bin DEFAULT NULL,
  `password` VARCHAR(25) COLLATE utf8_bin DEFAULT NULL,
  `age`      INT(10)                      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

INSERT INTO `Student`
VALUES ('1', 'zhisheng01', '123456', '18'),
  ('2', 'zhisheng02', '123', '17'),
  ('3', 'zhisheng03', '1234', '18'),
  ('4', 'zhisheng04', '12345', '16');
COMMIT;
