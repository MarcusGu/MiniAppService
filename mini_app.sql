USE app;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(

	`id` int(11) NOT NULL AUTO_INCREMENT,
    
	`username` varchar(63) NOT NULL,
    
    `password` varchar(63) NOT NULL DEFAULT '',
    
    `gender` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0 : 女  1 : 男',
    
    `birthday` date DEFAULT NULL,
    
    `nickname` varchar(63) NOT NULL DEFAULT '',
    
    `mobile` varchar(20) NOT NULL DEFAULT '',
    
    `email` varchar(63) NOT NULL DEFAULT '',
    
    `address` varchar(100) NOT NULL DEFAULT '',
    
    `avatar` varchar(255) NOT NULL DEFAULT '',
    
    `openid` varchar(63) NOT NULL DEFAULT '',
    
    `session_key` varchar(100) NOT NULL DEFAULT '',
    
    `status` tinyint(3) NOT NULL DEFAULT '0',
    
    `create_time` datetime  DEFAULT NULL,
    
    `update_time` datetime  DEFAULT NULL,
    
    `last_login_time` datetime DEFAULT NULL,
    
    `last_login_ip` varchar(63) NOT NULL DEFAULT '',
    
     PRIMARY KEY (`id`),
     
     UNIQUE KEY `user_name` (`username`)
     
)ENGINE=InnoDB AUTO_INCREMENT=99999 DEFAULT CHARSET=utf8mb4;
