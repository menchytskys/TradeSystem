CREATE TABLE `trade_system`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isAdmin` TINYINT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `trade_system`.`goods` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `picture` BLOB NULL,
  `delivery_status` TINYINT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `trade_system`.`purchases` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `trade_system`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `trade_system`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `trade_system`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `trade_system`.`purchases_goods` (
  `purchase_id` INT NULL,
  `good_id` INT NULL,
  INDEX `FK_purchase_p_idx` (`purchase_id` ASC) VISIBLE,
  INDEX `FK_good_p_idx` (`good_id` ASC) VISIBLE,
  CONSTRAINT `FK_purchase_p`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `trade_system`.`purchases` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_good_p`
    FOREIGN KEY (`good_id`)
    REFERENCES `trade_system`.`goods` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
